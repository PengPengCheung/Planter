package com.gdufs.planter.common;

import android.graphics.PorterDuff;

import com.gdufs.planter.PlanterApplication;
import com.gdufs.planter.gen.AttendanceViewDBModelDao;
import com.gdufs.planter.gen.AttentionViewDBModelDao;
import com.gdufs.planter.gen.GroupPushModelDao;
import com.gdufs.planter.gen.HomeworkViewDBModelDao;
import com.gdufs.planter.gen.PlanterDetailViewDBModelDao;
import com.gdufs.planter.gen.PlanterViewDBModelDao;
import com.gdufs.planter.gen.SummaryViewDBModelDao;
import com.gdufs.planter.module.attendance.model.AttendanceViewDBModel;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.attention.model.AttentionViewDBModel;
import com.gdufs.planter.module.attention.model.AttentionViewModel;
import com.gdufs.planter.module.group.model.GroupPushModel;
import com.gdufs.planter.module.group.model.GroupPushViewModel;
import com.gdufs.planter.module.homework.model.HomeworkViewDBModel;
import com.gdufs.planter.module.homework.model.HomeworkViewModel;
import com.gdufs.planter.module.planter.model.PlanterDetailViewDBModel;
import com.gdufs.planter.module.planter.model.PlanterViewDBModel;
import com.gdufs.planter.module.planter.model.PlanterViewModel;
import com.gdufs.planter.module.summary.model.SummaryViewDBModel;
import com.gdufs.planter.module.summary.model.SummaryViewModel;
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

    private AttentionViewDBModelDao mAttentionDAO;

    private PlanterViewDBModelDao mPlanterDAO;

    private PlanterDetailViewDBModelDao mPlanterDetailDAO;

    private SummaryViewDBModelDao mSummaryDAO;

    private HomeworkViewDBModelDao mHomeworkDAO;

    private GroupPushModelDao mGroupDAO;

    private PersistenceManager(){
        initDAO();
    }

    private void initDAO(){
        mAttendanceDAO = PlanterApplication.getInstances().getDaoSession().getAttendanceViewDBModelDao();
        mAttentionDAO = PlanterApplication.getInstances().getDaoSession().getAttentionViewDBModelDao();
        mPlanterDAO = PlanterApplication.getInstances().getDaoSession().getPlanterViewDBModelDao();
        mPlanterDetailDAO = PlanterApplication.getInstances().getDaoSession().getPlanterDetailViewDBModelDao();
        mSummaryDAO = PlanterApplication.getInstances().getDaoSession().getSummaryViewDBModelDao();
        mHomeworkDAO = PlanterApplication.getInstances().getDaoSession().getHomeworkViewDBModelDao();
        mGroupDAO = PlanterApplication.getInstances().getDaoSession().getGroupPushModelDao();
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
                mAttentionDAO.save((AttentionViewDBModel) model);
            }
            break;
            case Resource.MODULE_FRAME_PLANTER:{
                PlanterViewDBModel viewModel = (PlanterViewDBModel) model;
                mPlanterDAO.save(viewModel);
            }
            break;
            case Resource.MODULE_COURSE_SUMMARY:{
                SummaryViewDBModel dbModel = (SummaryViewDBModel) model;
                mSummaryDAO.save(dbModel);

            }
            break;
            case Resource.MODULE_COURSE_HOMEWORK:{
                HomeworkViewDBModel dbModel = (HomeworkViewDBModel) model;
                mHomeworkDAO.save(dbModel);
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
                mAttentionDAO.save(ModelConverter.convertAttentionViewModelToDBModel(viewModel));
//                mAttentionDAO.insert(viewModel);
            }
            break;
            case Resource.MODULE_FRAME_PLANTER:{
                PlanterViewModel viewModel = (PlanterViewModel) model;
                mPlanterDAO.save(ModelConverter.convertPlanterViewModelToDBModel(viewModel));
            }
            break;
            case Resource.MODULE_COURSE_SUMMARY:{
                SummaryViewModel viewModel = (SummaryViewModel) model;
                mSummaryDAO.save(ModelConverter.convertSummaryViewModelToDBModel(viewModel));
            }
            break;
            case Resource.MODULE_COURSE_HOMEWORK:{
                HomeworkViewModel viewModel = (HomeworkViewModel) model;
                mHomeworkDAO.save(ModelConverter.convertHomeworkViewModelToDBModel(viewModel));
            }
            break;
            case Resource.MODULE_COURSE_GROUP:{
                GroupPushViewModel viewModel = (GroupPushViewModel) model;
                mGroupDAO.save(ModelConverter.convertToGroupDBModel(viewModel));
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
                AttentionViewDBModel viewModel = (AttentionViewDBModel) model;
                mAttentionDAO.update(viewModel);
            }
            break;
            case Resource.MODULE_FRAME_PLANTER:{
                PlanterViewDBModel dbModel = (PlanterViewDBModel) model;
                mPlanterDAO.update(dbModel);
            }
            break;
            case Resource.MODULE_COURSE_SUMMARY:{
                SummaryViewDBModel dbModel = (SummaryViewDBModel) model;
                mSummaryDAO.update(dbModel);
            }
            break;
            case Resource.MODULE_COURSE_HOMEWORK:{
                HomeworkViewDBModel dbModel = (HomeworkViewDBModel) model;
                mHomeworkDAO.update(dbModel);
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
                } else if(lhs instanceof SummaryViewModel){
                    leftDateStr = ((SummaryViewModel) lhs).getmSummaryRequestTime();
                }

                if(rhs instanceof AttendanceViewModel){
                    rightDateStr = ((AttendanceViewModel) rhs).getmAttendanceTime();
                } else if(rhs instanceof AttentionViewModel){
                    rightDateStr = ((AttentionViewModel) rhs).getmAttentionTime();
                } else if(rhs instanceof SummaryViewModel){
                    rightDateStr = ((SummaryViewModel) rhs).getmSummaryRequestTime();
                }

                long result = 0;

                if(leftDateStr != null && rightDateStr != null){
                    Date leftDate = TimeUtil.strToTime(leftDateStr, TimeUtil.ENG_PATTERN_YMD_HMS);
                    Date rightDate = TimeUtil.strToTime(rightDateStr, TimeUtil.ENG_PATTERN_YMD_HMS);

                    if(isMinToMax){
                        // 按时间顺序从小到大排列，越接近当前的时间的在后面
                        result = leftDate.getTime() - rightDate.getTime();
                    } else {
                        // 越接近当前时间的在前面
                        result = rightDate.getTime() - leftDate.getTime();
                    }
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
                AttentionViewDBModel dbModel = mAttentionDAO.load(id);
                model = ModelConverter.convertAttentionDBModelToViewModel(dbModel);
//                model = mAttentionDAO.load(id);
            }
            break;
        }

        return model;
    }


    public List<BaseViewModel> findViewModelByCustomId(String id, int moduleId){
        List<BaseViewModel> list = new LinkedList<>();
        switch (moduleId){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                QueryBuilder<AttendanceViewDBModel> qb = mAttendanceDAO.queryBuilder().where(AttendanceViewDBModelDao.Properties.MCourseId.eq(id));
                if(qb != null){
                    List<AttendanceViewDBModel> dbModelList = qb.list();
                    for(AttendanceViewDBModel model : dbModelList){
                        list.add(ModelConverter.convertAttendanceDBModelToViewModel(model));
                    }
                }


            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
                QueryBuilder<AttentionViewDBModel> qb = mAttentionDAO.queryBuilder().where(AttentionViewDBModelDao.Properties.MCourseId.eq(id));
                List<AttentionViewDBModel> dbModelList = qb.list();
                for(AttentionViewDBModel model : dbModelList){
                    list.add(ModelConverter.convertAttentionDBModelToViewModel(model));
                }
            }
            break;
            case Resource.MODULE_COURSE_SUMMARY:{
                QueryBuilder<SummaryViewDBModel> qb = mSummaryDAO.queryBuilder().where(SummaryViewDBModelDao.Properties.MCourseId.eq(id));
                List<SummaryViewDBModel> dbModelList = qb.list();
                for(SummaryViewDBModel model : dbModelList){
                    list.add(ModelConverter.convertSummaryViewDBModelToViewModel(model));
                }
            }
            break;
            case Resource.MODULE_COURSE_HOMEWORK:{
                QueryBuilder<HomeworkViewDBModel> qb = mHomeworkDAO.queryBuilder().where(HomeworkViewDBModelDao.Properties.MCourseId.eq(id));
                List<HomeworkViewDBModel> dbModelList = qb.list();
                for(HomeworkViewDBModel model:dbModelList){
                    list.add(ModelConverter.convertHomeworkDBModelToViewModel(model));
                }
            }
            break;

            case Resource.MODULE_COURSE_GROUP:{
                QueryBuilder<GroupPushModel> qb = mGroupDAO.queryBuilder().where(GroupPushModelDao.Properties.MCourseId.eq(id));
                List<GroupPushModel> groupPushModelList = qb.list();
                for(GroupPushModel model: groupPushModelList){
                    list.add(ModelConverter.convertToGroupViewModel(model));
                }
            }
            break;
        }

        return list;
    }


    public List<BaseViewDBModel> findViewDBModelByCustomId(String id, int moduleId){
        List<BaseViewDBModel> list = new LinkedList<>();
        switch (moduleId){
            case Resource.MODULE_PLANTER_DETAIL:{
                QueryBuilder<PlanterDetailViewDBModel> qb = mPlanterDetailDAO.queryBuilder().where(PlanterDetailViewDBModelDao.Properties.MCourseId.eq(id));
                list.addAll(qb.list());
            }
            break;
            case Resource.MODULE_COURSE_SUMMARY:{
                QueryBuilder<SummaryViewDBModel> qb = mSummaryDAO.queryBuilder().where(SummaryViewDBModelDao.Properties.MCourseId.eq(id));
                list.addAll(qb.list());
            }
            break;
            case Resource.MODULE_COURSE_HOMEWORK:{
                QueryBuilder<HomeworkViewDBModel> qb = mHomeworkDAO.queryBuilder().where(HomeworkViewDBModelDao.Properties.MCourseId.eq(id));
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
                QueryBuilder<AttendanceViewDBModel> qb = mAttendanceDAO.queryBuilder().where(AttendanceViewDBModelDao.Properties.AttendanceId.eq(attendanceViewModel.getAttendanceId()));
                list.addAll(qb.list());
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
                AttentionViewModel attentionViewModel = (AttentionViewModel) viewModel;
                QueryBuilder<AttentionViewDBModel> qb = mAttentionDAO.queryBuilder().where(AttentionViewDBModelDao.Properties.MAttentionId.eq(attentionViewModel.getmAttentionId()));
                list.addAll(qb.list());
            }
            break;
            case Resource.MODULE_COURSE_SUMMARY:{
                SummaryViewModel summaryViewModel = (SummaryViewModel) viewModel;
                QueryBuilder<SummaryViewDBModel> qb = mSummaryDAO.queryBuilder().where(SummaryViewDBModelDao.Properties.MSummaryId.eq(summaryViewModel.getmSummaryId()));
                list.addAll(qb.list());
            }
            break;
            case Resource.MODULE_COURSE_HOMEWORK:{
                HomeworkViewModel homeworkViewDBModel = (HomeworkViewModel) viewModel;
                QueryBuilder<HomeworkViewDBModel> qb = mHomeworkDAO.queryBuilder().where(HomeworkViewDBModelDao.Properties.MHomeworkId.eq(homeworkViewDBModel.getmHomeworkId()));
                list.addAll(qb.list());
            }
            break;
            case Resource.MODULE_FRAME_PLANTER:{
                // 寻找课程id相同的
//                PlanterViewModel planterViewModel = (PlanterViewModel) viewModel;
                QueryBuilder<PlanterViewDBModel> qb = mPlanterDAO.queryBuilder().where(PlanterViewDBModelDao.Properties.MCourseId.eq(viewModel.getmCourseId()));
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
//                modelList.addAll(mAttentionDAO.loadAll());
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
