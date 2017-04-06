package com.gdufs.planter.common;

import com.gdufs.planter.PlanterApplication;
import com.gdufs.planter.gen.AttendanceViewDBModelDao;
import com.gdufs.planter.gen.AttentionViewModelDao;
import com.gdufs.planter.module.attendance.model.AttendanceViewDBModel;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.attention.model.AttentionViewModel;
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

    private PersistenceManager(){
        initDAO();
    }

    private void initDAO(){
        mAttendanceDAO = PlanterApplication.getInstances().getDaoSession().getAttendanceViewDBModelDao();
        mAttentionDAO = PlanterApplication.getInstances().getDaoSession().getAttentionViewModelDao();
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

    public void insertViewModel(BaseViewModel model, int moduleId){
        switch (moduleId){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                AttendanceViewModel viewModel = (AttendanceViewModel) model;

                mAttendanceDAO.save(convertAttendanceViewModelToDBModel(viewModel));
//                mAttendanceDAO.insert(viewModel);
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
                AttentionViewModel viewModel = (AttentionViewModel) model;
                mAttentionDAO.insert(viewModel);
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
                model = convertAttendanceDBModelToViewModel(dbModel);
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
                model = mAttentionDAO.load(id);
            }
            break;
        }

        return model;
    }

    private AttendanceViewDBModel convertAttendanceViewModelToDBModel(AttendanceViewModel viewModel){
        AttendanceViewDBModel dbModel = new AttendanceViewDBModel();
        dbModel.setmDataFrom(viewModel.getmDataFrom());
        dbModel.setmModuleId(viewModel.getmModuleId());
        dbModel.setmStudentId(viewModel.getmStudentId());
        dbModel.setmTeacherId(viewModel.getmTeacherId());
        dbModel.setmCourseId(viewModel.getmCourseId());
        dbModel.setmActionId(viewModel.getmActionId());
        dbModel.setAttendanceId(viewModel.getAttendanceId());
        dbModel.setmAttendanceStatus(viewModel.getmAttendanceStatus());
        dbModel.setmAttendanceBonusNum(viewModel.getmAttendanceBonusNum());
        dbModel.setmAbsenceCount(viewModel.getmAbsenceCount());
        dbModel.setmAttendanceCount(viewModel.getmAttendanceCount());
        dbModel.setmAttendanceCode(viewModel.getmAttendanceCode());
        dbModel.setmAttendanceTime(viewModel.getmAttendanceTime());
        dbModel.setmAttendanceValidDuration(viewModel.getmAttendanceValidDuration());

        return dbModel;
    }

    private AttendanceViewModel convertAttendanceDBModelToViewModel(AttendanceViewDBModel dbModel){
        AttendanceViewModel viewModel = new AttendanceViewModel();
        viewModel.setmDataFrom(dbModel.getmDataFrom());
        viewModel.setmModuleId(dbModel.getmModuleId());
        viewModel.setmStudentId(dbModel.getmStudentId());
        viewModel.setmTeacherId(dbModel.getmTeacherId());
        viewModel.setmCourseId(dbModel.getmCourseId());
        viewModel.setmActionId(dbModel.getmActionId());
        viewModel.setAttendanceId(dbModel.getAttendanceId());
        viewModel.setmAttendanceStatus(dbModel.getmAttendanceStatus());
        viewModel.setmAttendanceBonusNum(dbModel.getmAttendanceBonusNum());
        viewModel.setmAbsenceCount(dbModel.getmAbsenceCount());
        viewModel.setmAttendanceCount(dbModel.getmAttendanceCount());
        viewModel.setmAttendanceCode(dbModel.getmAttendanceCode());
        viewModel.setmAttendanceTime(dbModel.getmAttendanceTime());
        viewModel.setmAttendanceValidDuration(dbModel.getmAttendanceValidDuration());

        return viewModel;


//        AttendanceViewModel viewModel = new AttendanceViewModel();
//        Method[] viewModelMethods = viewModel.getClass().getMethods();
//        Method[] dbModelMethods = dbModel.getClass().getMethods();
//        for(Method method:viewModelMethods){
//            String methodName = method.getName();
//            if(methodName.startsWith("set")){
//
//            }
//        }
    }

//    public BaseViewDBModel convertViewModelToDBModel(){
//
//    }

    public BaseViewModel convertDBModelToViewModel(BaseViewDBModel dbModel){
        BaseViewModel viewModel = null;
        if(dbModel instanceof AttendanceViewDBModel){
            AttendanceViewDBModel attendanceDBModel = (AttendanceViewDBModel) dbModel;
            viewModel = convertAttendanceDBModelToViewModel(attendanceDBModel);
        }

        return viewModel;
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
        }

        return list;
    }

    public List<BaseViewModel> findAllViewModel(int moduleId){
        List<BaseViewModel> modelList = new LinkedList<>();
        switch (moduleId){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                List<AttendanceViewDBModel> models = mAttendanceDAO.loadAll();
                for(AttendanceViewDBModel dbModel : models){
                    AttendanceViewModel viewModel = convertAttendanceDBModelToViewModel(dbModel);
                    modelList.add(viewModel);
                }
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
                modelList.addAll(mAttentionDAO.loadAll());
            }
            break;
        }

        return modelList;
    }

}
