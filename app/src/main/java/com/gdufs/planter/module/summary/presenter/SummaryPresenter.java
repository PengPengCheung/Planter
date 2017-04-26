package com.gdufs.planter.module.summary.presenter;

import android.app.Activity;
import android.content.Context;

import com.gdufs.planter.common.BaseViewDBModel;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.PersistenceManager;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.planter.PlanterDataManager;
import com.gdufs.planter.module.summary.model.SummaryViewDBModel;
import com.gdufs.planter.module.summary.model.SummaryViewModel;
import com.gdufs.planter.utils.CommonUtil;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.PreferenceHelper;
import com.gdufs.planter.utils.ResultCallback;
import com.gdufs.planter.utils.TimeUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/3/20.
 */

public class SummaryPresenter extends ModuleBasePresenter {

    private static final String TAG = SummaryPresenter.class.getSimpleName();

    private static SummaryPresenter mInstance = null;

    private SummaryViewModel mViewModel;

    private SummaryPresenter(){
        super();
    }

    public static SummaryPresenter getInstance(){
        if(mInstance == null){
            synchronized (SummaryPresenter.class){
                if(mInstance == null){
                    mInstance = new SummaryPresenter();
                }
            }
        }

        return mInstance;
    }

    private void updateDBModel(DataResponse<SummaryViewModel> response){
        SummaryViewModel viewModel = response.getData();
        String courseId = viewModel.getmCourseId();

        SummaryViewDBModel dbModel = getUsingSummaryViewDBModel(courseId, viewModel.getmSummaryId());
        if(dbModel != null){
            int status = viewModel.getmSummaryStatus();
            LogUtil.e(TAG, "status: " + status);
            dbModel.setmSummaryStatus(status);
            PersistenceManager.getInstance().updateViewModel(dbModel, Resource.MODULE_COURSE_SUMMARY);
        }


//        List<BaseViewModel> modelList = PersistenceManager.getInstance().findViewModelByCustomId(courseId, Resource.MODULE_COURSE_SUMMARY);
//        for(BaseViewModel model:modelList){
//            SummaryViewModel summaryViewModel = (SummaryViewModel) model;
//            if(summaryViewModel.getmSummaryId().equals(viewModel.getmSummaryId())){
//                summaryViewModel.setmSummaryStatus(viewModel.getmSummaryStatus());
//
//
//            }
//        }
    }


    private SummaryViewDBModel getUsingSummaryViewDBModel(String courseId, String summaryId){
        List<BaseViewDBModel> modelList = PersistenceManager.getInstance().findViewDBModelByCustomId(courseId, Resource.MODULE_COURSE_SUMMARY);
        for(BaseViewDBModel model:modelList){
            SummaryViewDBModel summaryViewModel = (SummaryViewDBModel) model;
            if(summaryViewModel.getmSummaryId().equals(summaryId)){
                return summaryViewModel;
            }
        }

        return null;
    }

    private void storeSummaryContent(String summary, String summaryId, Context context){
        String courseId = CommonUtil.getCurrentSelectedCourseId(context);
        SummaryViewDBModel viewModel = getUsingSummaryViewDBModel(courseId, summaryId);
        if(viewModel != null){
            viewModel.setmSummaryContent(summary);
            PersistenceManager.getInstance().updateViewModel(viewModel, Resource.MODULE_COURSE_SUMMARY);
        }
    }

    private void notifyPlanterTreeModule(DataResponse r){
        SummaryViewModel viewModel = (SummaryViewModel) r.getData();
        PlanterDataManager.getInstance().getDataFromModules(viewModel);
    }

    public void sendSummary(String summary, String summaryId, Activity activity){
        LogUtil.e(TAG, "summaryId: " + summaryId + ", courseId: " + CommonUtil.getCurrentSelectedCourseId(activity));
        storeSummaryContent(summary, summaryId, activity);
        // summaryId: 865cb2d6-24b6-45f6-ad6f-c6648a180589, courseId: 0a564996-a618-45d7-bf4c-20e60a457185

        Map<String, Object> params = constructParams(summary, summaryId, activity);

        NetworkUtil.post(Resource.PlanterURL.SUMMARY_SEND_URL, params, new ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                // "c_id":"0a564996-a618-45d7-bf4c-20e60a457185"  "summary_id":"865cb2d6-24b6-45f6-ad6f-c6648a180589"
                LogUtil.e(TAG, "Summary Success" + response);
//                responseAllViewIfSuccess(response);
                Type classTypeData = new TypeToken<DataResponse<SummaryViewModel>>(){}.getType();
                DataResponse<SummaryViewModel> r = JsonUtil.deserialize(response, classTypeData);
                if(r != null){
                    updateDBModel(r);
                    notifyPlanterTreeModule(r);
                    updateAllViews(r.getData());
                }

            }

            @Override
            public void onFailure(Exception e) {
                LogUtil.e(TAG, "Summary Fail");
                e.printStackTrace();
            }
        });
    }

    private Map<String, Object> constructParams(String summary, String summaryId, Activity activity){
        Map<String, Object> params = new HashMap<>();
        params.put(Resource.KEY.KEY_SUMMARY_CONTENT, summary);
        String stuId = PreferenceHelper.getInstance(activity).getString(Resource.KEY.KEY_STUDENT_ID, "");
        params.put(Resource.KEY.KEY_STUDENT_ID, stuId);
        params.put(Resource.KEY.KEY_SUMMARY_ID, summaryId);
        LogUtil.e(TAG, "mViewModel");

        params.put(Resource.KEY.KEY_COURSE_ID, CommonUtil.getCurrentSelectedCourseId(activity));
//        if(mViewModel != null){
//            LogUtil.e(TAG, "mViewModel != null");
//            String courseId = mViewModel.getmCourseId();
//            LogUtil.e(TAG, "mViewModel != null, courseId: " + courseId);
//            params.put(Resource.KEY.KEY_COURSE_ID, courseId);
//        }
        Date date = new Date();
        params.put(Resource.KEY.KEY_SUMMARY_SEND_TIME, TimeUtil.timeToStr(date, TimeUtil.CHN_PATTERN_YMD_HM));

        return params;
    }

    @Override
    public void notifyViewUpdate(BaseViewModel model) {
//        mViewModel = (SummaryViewModel) model;
        updateAllViews(model);
    }

    @Override
    public List<BaseViewModel> readAllViewModelToList(String courseId) {
        return PersistenceManager.getInstance().findViewModelByCustomId(courseId, Resource.MODULE_COURSE_SUMMARY);
    }
}
