package com.gdufs.planter.module.attendance;

import android.content.Context;

import com.gdufs.planter.common.MsgEvent;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.attendance.presenter.AttendancePresenter;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.ObjectWriter;
import com.gdufs.planter.utils.ResultCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng on 2017/3/19.
 */

public class AttendancePushHandler {

    private static AttendancePushHandler mInstance = null;

    private AttendancePushHandler(){}

    public static AttendancePushHandler getInstance(){
        if(mInstance == null) {
            synchronized (AttendancePushHandler.class) {
                if(mInstance == null) {
                    mInstance = new AttendancePushHandler();
                }
            }
        }

        return mInstance;
    }

    public void handlePush(Context context, MsgEvent event){
        String jsonStr = (String) event.obj;
        AttendanceViewModel model = JsonUtil.deserialize(jsonStr, AttendanceViewModel.class);
        requestAttendanceAndAbsenceCount(model);
        writeModelToFile(context, model);
        AttendancePresenter.getInstance().notifyViewUpdate(model);
    }

    private void requestAttendanceAndAbsenceCount(AttendanceViewModel model) {
        String studentId = getStudentId();
        Map<String, Object> params = new HashMap<>();
        params.put(Resource.KEY.KEY_TEACHER_ID, model.getmTeacherId());
        params.put(Resource.KEY.KEY_COURSE_ID, model.getmCourseId());
        params.put(Resource.KEY.KEY_STUDENT_ID, studentId);
        NetworkUtil.post(Resource.PlanterURL.ATTENDANCE_CODE_URL, params, new ResultCallback() {
            @Override
            public void onSuccess(Object response) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    private String getStudentId() {
        return "";
    }

    private void writeModelToFile(Context context, AttendanceViewModel model){
        ObjectWriter.write(model, Resource.MODULE_COURSE_ATTENDANCE_NAME);
        AttendanceViewModel model2 = (AttendanceViewModel) ObjectWriter.read(context, Resource.MODULE_COURSE_ATTENDANCE_NAME);
        LogUtil.e("push", "model2 : " + model2);
    }
}
