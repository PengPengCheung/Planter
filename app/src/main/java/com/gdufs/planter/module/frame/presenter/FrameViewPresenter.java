package com.gdufs.planter.module.frame.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attendance.presenter.AttendancePresenter;
import com.gdufs.planter.module.attention.presenter.AttentionPresenter;
import com.gdufs.planter.module.frame.model.CourseInfoModel;
import com.gdufs.planter.module.frame.model.CourseListViewModel;
import com.gdufs.planter.module.group.presenter.GroupPresenter;
import com.gdufs.planter.module.homework.presenter.HomeworkPresenter;
import com.gdufs.planter.module.interaction.presenter.InteractionPresenter;
import com.gdufs.planter.module.resource.presenter.ResourcePresenter;
import com.gdufs.planter.module.summary.presenter.SummaryPresenter;
import com.gdufs.planter.utils.CommonUtil;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.PreferenceHelper;
import com.gdufs.planter.utils.ResultCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/3/25.
 */

public class FrameViewPresenter extends ModuleBasePresenter {

    private static final String TAG = FrameViewPresenter.class.getSimpleName();

    private Context mContext;

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

    public void setContext(Context context){
        mContext = context;
    }

    @Override
    public void notifyViewUpdate(BaseViewModel model) {
        updateAllViews(model);
    }


    public void setCurrentCourse(String courseId, String courseName, Context context){
        PreferenceHelper.getInstance(context).putString(Resource.KEY.KEY_COURSE_ID, courseId);
        PreferenceHelper.getInstance(context).putString(Resource.KEY.KEY_COURSE_NAME, courseName);
        notifyModulesUpdate(context);
    }

    public String getCurrentCourseId(Context context){
        return CommonUtil.getCurrentSelectedCourseId(context);
    }

    public String getCurrentCourseName(Context context){
        return CommonUtil.getCurrentSelectedCourseName(context);
    }

    private void notifyModulesUpdate(Context context) {
        AttendancePresenter.getInstance().notifyViewUpdate(new BaseViewModel());
        AttentionPresenter.getInstance().notifyViewUpdate(new BaseViewModel());
        InteractionPresenter.getInstance().notifyViewUpdate(new BaseViewModel());
        SummaryPresenter.getInstance().notifyViewUpdate(new BaseViewModel());
        HomeworkPresenter.getInstance().notifyViewUpdate(new BaseViewModel());
        GroupPresenter.getInstance().updateGroupView();

        String courseId = PreferenceHelper.getInstance(context).getString(Resource.KEY.KEY_COURSE_ID, "");
        String studentId = "";
        ResourcePresenter.getInstance().requestResourceList(courseId, studentId);
    }

    private void addCourseIntoTitleList(){

    }


    public List<CourseInfoModel> getCourseInfoList(){
        String jsonCourse = PreferenceHelper.getInstance(mContext).getString(Resource.KEY.KEY_COURSE_ID, "");
        CourseListViewModel courseListViewModel = null;
//        if(jsonCourse == null || TextUtils.isEmpty(jsonCourse)){
////            courseListViewModel = new CourseListViewModel();
//            return null;
//        }

        if(jsonCourse != null && !TextUtils.isEmpty(jsonCourse)){
            courseListViewModel = JsonUtil.deserialize(jsonCourse, CourseListViewModel.class);
            if(courseListViewModel != null){
                return courseListViewModel.getmCourseInfoModelList();
            }
        }

        return null;

    }

    public void addCourseInfo(String courseId, String courseName){
        CourseInfoModel model = new CourseInfoModel();
        model.setmCourseId(courseId);
        model.setmCourseName(courseName);
        CourseListViewModel courseListViewModel = null;
        String jsonCourse = PreferenceHelper.getInstance(mContext).getString(Resource.KEY.KEY_COURSE_ID, "");
        if(jsonCourse == null || TextUtils.isEmpty(jsonCourse)){
            courseListViewModel = new CourseListViewModel();

        }

        if(jsonCourse != null && !TextUtils.isEmpty(jsonCourse)){
            courseListViewModel = JsonUtil.deserialize(jsonCourse, CourseListViewModel.class);
        }

        if(courseListViewModel != null){
            courseListViewModel.addCourseInfo(model);
        }

        storeIntoPreference(courseListViewModel);

    }

    private void storeIntoPreference(CourseListViewModel model){
        String jsonStr = JsonUtil.serialize(model);
        PreferenceHelper.getInstance(mContext).putString(Resource.KEY.KEY_COURSE_ID, jsonStr);
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
