package com.gdufs.planter.module.planter;

import com.gdufs.planter.common.BaseViewDBModel;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.PersistenceManager;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.planter.model.PlanterDetailViewDBModel;
import com.gdufs.planter.module.planter.model.PlanterViewDBModel;
import com.gdufs.planter.module.planter.model.PlanterViewModel;
import com.gdufs.planter.utils.CommonUtil;
import com.gdufs.planter.utils.LogUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by peng on 2017/4/6.
 */

public class PlanterDataManager {

    private static final String TAG = PlanterDataManager.class.getSimpleName();

    private List<ModuleBasePresenter> mPresenterList;

    private static PlanterDataManager mInstance = null;

    private PlanterDataManager(){
        mPresenterList = new LinkedList<>();
    }

    public static PlanterDataManager getInstance(){
        if(mInstance == null){
            synchronized (PlanterDataManager.class){
                if(mInstance == null){
                    mInstance = new PlanterDataManager();
                }
            }
        }

        return mInstance;
    }

    public void registerPresenter(ModuleBasePresenter presenter){
        if(mPresenterList != null){
            mPresenterList.add(presenter);
        }
    }

    public void unInit(){
        unregisterAllViews();
        mPresenterList = null;
    }

    public void unregisterAllViews(){
        if(mPresenterList != null){
            mPresenterList.clear();
        }
    }

    public void unregisterPresenter(ModuleBasePresenter presenter){
        if(mPresenterList != null && !mPresenterList.isEmpty()){
            mPresenterList.remove(presenter);
        }
    }

    public void notifyUpdate(String courseId){
        if(mPresenterList != null){
            for(ModuleBasePresenter presenter:mPresenterList){
                presenter.notifyBonusUpdate(courseId);
            }
        }
    }

    public void plantTree(PlanterViewModel viewModel){

        List<BaseViewDBModel> modelList = PersistenceManager.getInstance().findViewDBModelByViewModel(viewModel);
        if(modelList != null && modelList.size() == 1){
            for(BaseViewDBModel model:modelList){
                PlanterViewDBModel dbModel = (PlanterViewDBModel) model;
                int waterNum = dbModel.getmPlanterWater();
                int sunshineNum = dbModel.getmPlanterSunshine();
                int soilNum = dbModel.getmPlanterSoil();
                int minNum = CommonUtil.getMinimumNum(waterNum, sunshineNum, soilNum);
                dbModel.setmPlanterWater(waterNum - minNum);
                dbModel.setmPlanterSunshine(sunshineNum - minNum);
                dbModel.setmPlanterSoil(soilNum - minNum);

                changePercentageByStatus(dbModel, minNum);

                PersistenceManager.getInstance().updateViewModel(dbModel, Resource.MODULE_FRAME_PLANTER);

                LogUtil.e(TAG, "viewModel percentage: " + dbModel.getmPlanterPercent());
            }
        }

        notifyUpdate(viewModel.getmCourseId());

    }

    private void changePercentageByStatus(PlanterViewDBModel dbModel, int usedNum) {
        List<BaseViewDBModel> detailViewDBModel = PersistenceManager.getInstance().findViewDBModelByCustomId(dbModel.getmCourseId(), Resource.MODULE_PLANTER_DETAIL);
        for(BaseViewDBModel model:detailViewDBModel){
            PlanterDetailViewDBModel planterDetailViewDBModel = (PlanterDetailViewDBModel) model;
            int usedSunshine = planterDetailViewDBModel.getmPlanterSunshineUsed();
            int usedWater = planterDetailViewDBModel.getmPlanterWaterUsed();
            int usedSoil = planterDetailViewDBModel.getmPlanterSoilUsed();
            planterDetailViewDBModel.setmPlanterSunshineUsed(usedSunshine + usedNum);
            planterDetailViewDBModel.setmPlanterWaterUsed(usedWater + usedNum);
            planterDetailViewDBModel.setmPlanterSoilUsed(usedSoil + usedNum);

            changeTreeStatusByUsedElements(planterDetailViewDBModel, dbModel);

            PersistenceManager.getInstance().updateViewModel(planterDetailViewDBModel, Resource.MODULE_PLANTER_DETAIL);
        }
    }

    private int computePercentage(int usedNum, int totalNum){
        LogUtil.e(TAG, "usedNum: " + usedNum + ", totalNum: " + totalNum);
        int percentage = (int)((((float) usedNum / (float) totalNum)) * 100);
        LogUtil.e(TAG, "computePercentage: " + percentage);
        if(percentage < 0){
            percentage = 0;
        }

        if(percentage > 100){
            percentage = 100;
        }

        return percentage;
    }

    private void changeTreeStatusByUsedElements(PlanterDetailViewDBModel planterDetailViewDBModel, PlanterViewDBModel mainViewModel) {
        int currentStatus = planterDetailViewDBModel.getmPlanterStatus();
        int sunshineUsedNum = planterDetailViewDBModel.getmPlanterSunshineUsed();
        int waterUsedNum = planterDetailViewDBModel.getmPlanterWaterUsed();
        int soilUsedNum = planterDetailViewDBModel.getmPlanterSoilUsed();

        int totalUsedNum = sunshineUsedNum + waterUsedNum + soilUsedNum;

        int percentage = mainViewModel.getmPlanterPercent();

        LogUtil.e(TAG, "before compute percentage: " + percentage + ", currentStatus: " + currentStatus + ", totalUsedNum: " + totalUsedNum);

        if(totalUsedNum >= Resource.TREE.SEED.SEED_TOTAL_ELEM_NUM && totalUsedNum < Resource.TREE.SEEDLING.SEEDLING_TOTAL_ELEM_NUM){

            percentage = computePercentage(totalUsedNum, Resource.TREE.SEEDLING.SEEDLING_TOTAL_ELEM_NUM);
            currentStatus = Resource.TREE_STATUS.TREE_SEED;

        } else if(totalUsedNum >= Resource.TREE.SEEDLING.SEEDLING_TOTAL_ELEM_NUM && totalUsedNum < Resource.TREE.SEEDLING_MATURE.SEEDLING_MATURE_TOTAL_ELEM_NUM){

            percentage = computePercentage(totalUsedNum, Resource.TREE.SEEDLING_MATURE.SEEDLING_MATURE_TOTAL_ELEM_NUM);
            currentStatus = Resource.TREE_STATUS.TREE_SEEDLING;

        } else if(totalUsedNum >= Resource.TREE.SEEDLING_MATURE.SEEDLING_MATURE_TOTAL_ELEM_NUM && totalUsedNum < Resource.TREE.TREE_DEVELOPMENT.TREE_DEVELOPMENT_TOTAL_ELEM_NUM){

            percentage = computePercentage(totalUsedNum, Resource.TREE.TREE_DEVELOPMENT.TREE_DEVELOPMENT_TOTAL_ELEM_NUM);
            currentStatus = Resource.TREE_STATUS.TREE_SEEDLING_MATURE;

        } else if(totalUsedNum >= Resource.TREE.TREE_DEVELOPMENT.TREE_DEVELOPMENT_TOTAL_ELEM_NUM && totalUsedNum < Resource.TREE.TREE_MATURE.TREE_MATURE_TOTAL_ELEM_NUM){

            percentage = computePercentage(totalUsedNum, Resource.TREE.TREE_MATURE.TREE_MATURE_TOTAL_ELEM_NUM);
            currentStatus = Resource.TREE_STATUS.TREE_DEVELOPMENT;

        } else if(totalUsedNum >= Resource.TREE.TREE_MATURE.TREE_MATURE_TOTAL_ELEM_NUM && totalUsedNum < Resource.TREE.TREE_FINAL.TREE_FINAL_TOTAL_ELEM_NUM){

            percentage = computePercentage(totalUsedNum, Resource.TREE.TREE_FINAL.TREE_FINAL_TOTAL_ELEM_NUM);
            currentStatus = Resource.TREE_STATUS.TREE_MATURE;

        } else if(totalUsedNum >= Resource.TREE.TREE_FINAL.TREE_FINAL_TOTAL_ELEM_NUM){

            percentage = computePercentage(totalUsedNum, Resource.TREE.TREE_FINAL.TREE_FINAL_TOTAL_ELEM_NUM);
            currentStatus = Resource.TREE_STATUS.TREE_FINAL;

        }

        LogUtil.e(TAG, "after compute percentage: " + percentage + ", currentStatus: " + currentStatus);

        planterDetailViewDBModel.setmPlanterStatus(currentStatus);
        mainViewModel.setmPlanterStatus(currentStatus);
        mainViewModel.setmPlanterPercent(percentage);

    }


    public boolean storeNewCourse(PlanterViewModel viewModel){
        PlanterDetailViewDBModel dbModel = initPlanterDetailModel(viewModel);
        PersistenceManager.getInstance().insertViewModel(viewModel, Resource.MODULE_FRAME_PLANTER);
        PersistenceManager.getInstance().insertViewDBModel(dbModel, Resource.MODULE_PLANTER_DETAIL);
        return true;
    }

    private PlanterDetailViewDBModel initPlanterDetailModel(PlanterViewModel mainViewModel) {
        PlanterDetailViewDBModel dbModel = new PlanterDetailViewDBModel();
        dbModel.setmCourseId(mainViewModel.getmCourseId());
        dbModel.setmModuleId(Resource.MODULE_PLANTER_DETAIL);
        dbModel.setmDataFrom(mainViewModel.getmDataFrom());
        dbModel.setmTeacherId(mainViewModel.getmTeacherId());
        dbModel.setmStudentId(mainViewModel.getmStudentId());
        dbModel.setmPlanterRank(0);
        dbModel.setmPlanterStatus(Resource.TREE_STATUS.TREE_SEED);
        dbModel.setmPlanterSunshineUsed(0);
        dbModel.setmPlanterWaterUsed(0);
        dbModel.setmPlanterSoilUsed(0);
        dbModel.setmPlanterTitle("暂无称号");
        dbModel.setmPlanterEvaluation(Resource.EVALUATION.EVAL_GOOD);

        return dbModel;
    }


    public List<BaseViewModel> readAllPlanterViewModel(){
        return PersistenceManager.getInstance().findAllViewModel(Resource.MODULE_FRAME_PLANTER);
    }

    private void addBonus(PlanterViewDBModel planterViewModel, BaseViewModel viewModel){
        int moduleId = viewModel.getmModuleId();
        switch (moduleId){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                AttendanceViewModel attendanceViewModel = (AttendanceViewModel) viewModel;
                int type = attendanceViewModel.getmAttendanceBonusType();
                int bonusNum = attendanceViewModel.getmAttendanceBonusNum();
//                changeBonusNumByBonusType(bonusNum, type, planterViewModel);

                //for test
                changeBonusNumByBonusType(100, Resource.BONUS_TYPE.BONUS_WATER, planterViewModel);
                changeBonusNumByBonusType(100, Resource.BONUS_TYPE.BONUS_SUNSHINE, planterViewModel);
                changeBonusNumByBonusType(100, Resource.BONUS_TYPE.BONUS_SOIL, planterViewModel);
            }
            break;
        }
    }

    private void changeBonusNumByBonusType(int bonusNum, int bonusType, PlanterViewDBModel planterViewModel){
        switch (bonusType){
            case Resource.BONUS_TYPE.BONUS_SUNSHINE:{
                int sunshineNum = planterViewModel.getmPlanterSunshine() + bonusNum;
                planterViewModel.setmPlanterSunshine(sunshineNum);
            }
            break;
            case Resource.BONUS_TYPE.BONUS_SOIL:{
                int soilNum = planterViewModel.getmPlanterSoil() + bonusNum;
                planterViewModel.setmPlanterSoil(soilNum);
            }
            break;
            case Resource.BONUS_TYPE.BONUS_WATER:{
                int waterNum = planterViewModel.getmPlanterWater() + bonusNum;
                planterViewModel.setmPlanterWater(waterNum);
            }
            break;
        }
    }

    // 从各个模块中获取奖惩数据
    public void getDataFromModules(BaseViewModel viewModel){
        List<BaseViewDBModel> viewModelList = PersistenceManager.getInstance().findAllViewDBModel(Resource.MODULE_FRAME_PLANTER);
        for(BaseViewDBModel model : viewModelList){
            PlanterViewDBModel dbModel = (PlanterViewDBModel) model;
            if(dbModel.getmCourseId().equals(viewModel.getmCourseId())){
                addBonus(dbModel, viewModel);
                LogUtil.e(TAG, "Sunshine: " + dbModel.getmPlanterSunshine() + ", Water: " + dbModel.getmPlanterWater() + ", Soil: " + dbModel.getmPlanterSoil());
                PersistenceManager.getInstance().updateViewModel(dbModel, Resource.MODULE_FRAME_PLANTER);
            }
        }

        notifyUpdate(viewModel.getmCourseId());
    }

}
