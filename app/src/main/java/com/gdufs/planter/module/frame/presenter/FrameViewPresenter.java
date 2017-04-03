package com.gdufs.planter.module.frame.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.PreferenceHelper;
import com.gdufs.planter.utils.ResultCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng on 2017/3/25.
 */

public class FrameViewPresenter extends ModuleBasePresenter {

    private static final String TAG = FrameViewPresenter.class.getSimpleName();

    private static FrameViewPresenter mInstance = null;

    private FrameViewPresenter(){}

    public static FrameViewPresenter getInstance(){
        if(mInstance == null){
            synchronized (FrameViewPresenter.class){
                if(mInstance == null){
                    mInstance = new FrameViewPresenter();
                }
            }
        }

        return mInstance;
    }

    @Override
    public void notifyViewUpdate(BaseViewModel model) {
        updateAllViews(model);
    }


    public void getStudentCourseInfoFromServer(String courseName, Context context){
        if(courseName == null || TextUtils.isEmpty(courseName)){
            return;
        }

        String courseId = PreferenceHelper.getInstance(context).getString(courseName, "");
        LogUtil.e(TAG, "courseId = " + courseId);
        String studentId = PreferenceHelper.getInstance(context).getString(Resource.KEY.KEY_STUDENT_ID, "");

        if(TextUtils.isEmpty(courseId) || TextUtils.isEmpty(studentId)){
            LogUtil.e(TAG, "courseId = " + courseId + ", studentId = " + studentId);
            return;
        }

        Map<String, Object> params = constructParams(studentId, courseId);

        NetworkUtil.post(Resource.PlanterURL.COURSE_SELECT_URL, params, new ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                LogUtil.e(TAG, "course Select = " + response);

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    private Map<String, Object> constructParams(String studentId, String courseId){
        Map<String, Object> map = new HashMap<>();
        map.put(Resource.KEY.KEY_STUDENT_ID, studentId);
        map.put(Resource.KEY.KEY_COURSE_ID, courseId);
        return map;
    }

}
