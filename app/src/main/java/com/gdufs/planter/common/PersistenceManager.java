package com.gdufs.planter.common;

import com.gdufs.planter.PlanterApplication;
import com.gdufs.planter.gen.AttendanceViewDBModelDao;
import com.gdufs.planter.gen.AttentionViewModelDao;
import com.gdufs.planter.gen.PlanterDetailViewDBModelDao;
import com.gdufs.planter.gen.PlanterViewDBModelDao;
import com.gdufs.planter.module.attendance.model.AttendanceViewDBModel;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.attention.model.AttentionViewModel;
import com.gdufs.planter.module.planter.model.PlanterDetailViewDBModel;
import com.gdufs.planter.module.planter.model.PlanterViewDBModel;
import com.gdufs.planter.module.planter.model.PlanterViewModel;
import com.gdufs.planter.utils.TimeUtil;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by peng on 2017/4/5.
 */

public class PersistenceManager {

    private static PersistenceManager mInstance = null;

    private AttendanceViewDBModelDao mAttendanceDAO;

    private AttentionViewModelDao mAttentionDAO;

    private PlanterViewDBModelDao mPlanterDAO;

    private PlanterDetailViewDBModelDao mPlanterDetailDAO;

    private PersistenceManager(){
        initDAO();
    }

    private void initDAO(){
        mAttendanceDAO = PlanterApplication.getInstances().getDaoSession().getAttendanceViewDBModelDao();
        mAttentionDAO = PlanterApplication.getInstances().getDaoSession().getAttentionViewModelDao();
        mPlanterDAO = PlanterApplication.getInstances().getDaoSession().getPlanterViewDBModelDao();
        mPlanterDetailDAO = PlanterApplication.getInstances().getDaoSession().getPlanterDetailViewDBModelDao();
    }

    public static PersistenceManager getInstance(){
        if(mInstance == null){
            synchronized (PersistenceManager.class){
                if(mInstance == null){
                    mInstance = new PersistenceManager();
                }
            }
        }

        return mInstance;
    }

    public void insertViewDBModel(BaseViewDBModel model, int moduleId){
        switch (moduleId){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                mAttendanceDAO.save((AttendanceViewDBModel) model);
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
//                AttentionViewModel viewModel = (AttentionViewModel) model;
//                mAttentionDAO.insert(viewModel);
            }
            break;
            case Resource.MODULE_FRAME_PLANTER:{
                PlanterViewDBModel viewModel = (PlanterViewDBModel) model;
                mPlanterDAO.save(viewModel);
            }
            break;
            case Resource.MODULE_PLANTER_DETAIL:{
                PlanterDetailViewDBModel dbModel = (PlanterDetailViewDBModel) model;
                mPlanterDetailDAO.save(dbModel);
            }
            break;
        }
    }

    public void insertViewModel(BaseViewModel model, int moduleId){
        switch (moduleId){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                AttendanceViewModel viewModel = (AttendanceViewModel) model;

                mAttendanceDAO.save(ModelConverter.convertAttendanceViewModelToDBModel(viewModel));
//                mAttendanceDAO.insert(viewModel);
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
                AttentionViewModel viewModel = (AttentionViewModel) model;
                mAttentionDAO.insert(viewModel);
            }
            break;
            case Resource.MODULE_FRAME_PLANTER:{
                PlanterViewModel viewModel = (PlanterViewModel) model;
                mPlanterDAO.save(ModelConverter.convertPlanterViewModelToDBModel(viewModel));
            }
            break;
            case Resource.MODULE_PLANTER_DETAIL:{

            }
            break;
        }
    }

    public void updateViewModel(BaseViewDBModel model, int moduleId){
        switch (moduleId){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                AttendanceViewDBModel viewModel = (AttendanceViewDBModel) model;
                mAttendanceDAO.update(viewModel);
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
//                AttentionViewModel viewModel = (AttentionViewModel) model;
//                mAttentionDAO.update(viewModel);
            }
            break;
            case Resource.MODULE_FRAME_PLANTER:{
                PlanterViewDBModel dbModel = (PlanterViewDBModel) model;
                mPlanterDAO.update(dbModel);
            }
            break;
            case Resource.MODULE_PLANTER_DETAIL:{
                PlanterDetailViewDBModel dbModel = (PlanterDetailViewDBModel) model;
                mPlanterDetailDAO.update(dbModel);
            }
            break;
        }
    }

    public List<BaseViewModel> sort(List<BaseViewModel> list, final boolean isMinToMax){
        int size = list.size();
        BaseViewModel[] models = new BaseViewModel[size];
        for(int i=0;i<size;i++){
            models[i] = new BaseViewModel();
            models[i] = list.get(i);
        }

        Arrays.sort(models, new Comparator<BaseViewModel>() {

            @Override
            public int compare(BaseViewModel lhs, BaseViewModel rhs) {
//                return (int) (lhs.getId() - rhs.getId());
                String leftDateStr = null;
                String rightDateStr = null;
                if(lhs instanceof AttendanceViewModel){
                    leftDateStr = ((AttendanceViewModel) lhs).getmAttendanceTime();
                } else if(lhs instanceof AttentionViewModel){
                    leftDateStr = ((AttentionViewModel)lhs).getmAttentionTime();
                }

                if(rhs instanceof AttendanceViewModel){
                    rightDateStr = ((AttendanceViewModel) rhs).getmAttendanceTime();
                } else if(lhs instanceof AttentionViewModel){
                    rightDateStr = ((AttentionViewModel) rhs).getmAttentionTime();
                }

                Date leftDate = TimeUtil.strToTime(leftDateStr, TimeUtil.CHN_PATTERN_YMD_HM);
                Date rightDate = TimeUtil.strToTime(rightDateStr, TimeUtil.CHN_PATTERN_YMD_HM);

                long result = 0;

                if(isMinToMax){
                    // 按时间顺序从小到大排列，越接近当前的时间的在后面
                    result = leftDate.getTime() - rightDate.getTime();
                } else {
                    // 越接近当前时间的在前面
                    result = rightDate.getTime() - leftDate.getTime();
                }

                return (int) result;
            }
        });

        List<BaseViewModel> modelList = new LinkedList<>();

        for(int i=0;i<models.length;i++){
            modelList.add(models[i]);
        }

        return modelList;
    }

    public BaseViewModel findViewModelByLongId(int moduleId, Long id){
        BaseViewModel model = null;
        switch (moduleId){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                AttendanceViewDBModel dbModel = mAttendanceDAO.load(id);
                model = ModelConverter.convertAttendanceDBModelToViewModel(dbModel);
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
                model = mAttentionDAO.load(id);
            }
            break;
        }

        return model;
    }





//    public BaseViewDBModel convertViewModelToDBModel(){
//
//    }

    public BaseViewModel convertDBModelToViewModel(BaseViewDBModel dbModel){
        BaseViewModel viewModel = null;
        if(dbModel instanceof AttendanceViewDBModel){
            AttendanceViewDBModel attendanceDBModel = (AttendanceViewDBModel) dbModel;
            viewModel = ModelConverter.convertAttendanceDBModelToViewModel(attendanceDBModel);
        }

        return viewModel;
    }

    public List<BaseViewDBModel> findViewDBModelByCustomId(String id, int moduleId){
        List<BaseViewDBModel> list = new LinkedList<>();
        switch (moduleId){
            case Resource.MODULE_PLANTER_DETAIL:{
                QueryBuilder<PlanterDetailViewDBModel> qb = mPlanterDetailDAO.queryBuilder().where(PlanterDetailViewDBModelDao.Properties.MCourseId.eq(id));
                list.addAll(qb.list());
            }
            break;
        }

        return list;
    }

    public List<BaseViewDBModel> findViewDBModelByViewModel(BaseViewModel viewModel){
        int moduleId = viewModel.getmModuleId();
        List<BaseViewDBModel> list = new LinkedList<>();
        switch (moduleId){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                AttendanceViewModel attendanceViewModel = (AttendanceViewModel) viewModel;
                QueryBuilder qb = mAttendanceDAO.queryBuilder().where(AttendanceViewDBModelDao.Properties.AttendanceId.eq(attendanceViewModel.getAttendanceId()));
                list.addAll(qb.list());
            }
            break;
            case Resource.MODULE_FRAME_PLANTER:{
                // 寻找课程id相同的
//                PlanterViewModel planterViewModel = (PlanterViewModel) viewModel;
                QueryBuilder qb = mPlanterDAO.queryBuilder().where(PlanterViewDBModelDao.Properties.MCourseId.eq(viewModel.getmCourseId()));
                list.addAll(qb.list());
            }
            break;
        }

        return list;
    }

    public List<BaseViewDBModel> findAllViewDBModel(int moduleId){
        List<BaseViewDBModel> modelList = new LinkedList<>();
        switch (moduleId){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                List<AttendanceViewDBModel> models = mAttendanceDAO.loadAll();
                modelList.addAll(models);
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
//                modelList.addAll(mAttentionDAO.loadAll());
            }
            break;
            case Resource.MODULE_FRAME_PLANTER:{
                List<PlanterViewDBModel> models = mPlanterDAO.loadAll();
                modelList.addAll(models);
            }
            break;
        }

        return modelList;
    }

    public List<BaseViewModel> findAllViewModel(int moduleId){
        List<BaseViewModel> modelList = new LinkedList<>();
        switch (moduleId){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                List<AttendanceViewDBModel> models = mAttendanceDAO.loadAll();
                for(AttendanceViewDBModel dbModel : models){
                    AttendanceViewModel viewModel = ModelConverter.convertAttendanceDBModelToViewModel(dbModel);
                    modelList.add(viewModel);
                }
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
                modelList.addAll(mAttentionDAO.loadAll());
            }
            break;
            case Resource.MODULE_FRAME_PLANTER:{
                List<PlanterViewDBModel> models = mPlanterDAO.loadAll();
                for(PlanterViewDBModel model : models){
                    PlanterViewModel viewModel = ModelConverter.convertPlanterViewDBModelToViewModel(model);
                    modelList.add(viewModel);
                }
            }
            break;
        }

        return modelList;
    }

}
