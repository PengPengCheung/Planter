package com.gdufs.planter.module.summary.presenter;

import android.app.Activity;
import android.content.Context;
import android.util.TimeUtils;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.summary.model.SummaryViewModel;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.ObjectWriter;
import com.gdufs.planter.utils.PreferenceHelper;
import com.gdufs.planter.utils.ResultCallback;
import com.gdufs.planter.utils.TimeUtil;

import java.util.Date;
import java.util.HashMap;
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

    public void sendSummary(String summary, Activity activity){

        Map<String, Object> params = constructParams(summary, activity);

        NetworkUtil.post(Resource.PlanterURL.SUMMARY_SEND_URL, params, new ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                LogUtil.e(TAG, "Summary Success" + response);
            }

            @Override
            public void onFailure(Exception e) {
                LogUtil.e(TAG, "Summary Fail");
                e.printStackTrace();
            }
        });
    }

    private Map<String, Object> constructParams(String summary, Activity activity){
        Map<String, Object> params = new HashMap<>();
        params.put(Resource.KEY.KEY_SUMMARY_CONTENT, summary);
        String stuId = PreferenceHelper.getInstance(activity).getString(Resource.KEY.KEY_STUDENT_ID, "");
        params.put(Resource.KEY.KEY_STUDENT_ID, stuId);
        LogUtil.e(TAG, "mViewModel");

        params.put(Resource.KEY.KEY_COURSE_ID, "111111");
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
        mViewModel = (SummaryViewModel) model;
        updateAllViews(model);
    }
}
