package com.gdufs.planter.module.push;

import android.content.Context;

import com.gdufs.planter.common.MsgEvent;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attendance.AttendancePushHandler;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.attention.AttentionPushHandler;
import com.gdufs.planter.module.homework.HomeworkPushHandler;
import com.gdufs.planter.module.summary.SummaryPushHandler;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.PreferenceHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng on 2017/3/19.
 */

public class PushHandler {

//    private Context mContext;

    private static PushHandler mInstance = null;

    private PushHandler(){
//        mContext = context;
    }

    public static PushHandler getInstance(){
        if(mInstance == null) {
            synchronized (PushHandler.class){
                if(mInstance == null) {
                    mInstance = new PushHandler();
                }
            }
        }

        return mInstance;
    }

    public void handlePush(Context context, MsgEvent event){
        LogUtil.e("push", "enter handlePush");
        int moduleId = getModuleIdFromEvent(event);
        switch (moduleId) {
            case Resource.MODULE_COURSE_ATTENDANCE:{
                AttendancePushHandler.getInstance().handlePush(context, event);
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
                AttentionPushHandler.getInstance().handlePush(context, event);
            }
            break;
            case Resource.MODULE_COURSE_SUMMARY:{
                SummaryPushHandler.getInstance().handlePush(context, event);
            }
            break;
            case Resource.MODULE_COURSE_HOMEWORK:{
                HomeworkPushHandler.getInstance().handlePush(context, event);
            }
            break;
        }
//        switch (event.what){
//            case Resource.MODULE_COURSE_ATTENDANCE:{
////                handleAttendanceEvent(event, context);
//                LogUtil.e("push", "MODULE_COURSE_ATTENDANCE FileName: " + context.getFilesDir() + " " + "attendance");
//                String jsonMsg = (String) event.obj;
//                AttendanceViewModel model = JsonUtil.deserialize(jsonMsg, AttendanceViewModel.class);
//                ObjectWriter.write(context, model, "attendance");
//                AttendanceViewModel model2 = (AttendanceViewModel) ObjectWriter.read(context, "attendance");
//                LogUtil.e("push", "model2 : " + model2);
//                if(model2 != null){
//                    LogUtil.e("push", model2.getmAttendanceTime());
//                }
//            }
//            break;
//        }
    }

    private int getModuleIdFromEvent(MsgEvent event){
        String jsonStr = (String) event.obj;
        Map<String, Object> map = JsonUtil.deserialize(jsonStr, HashMap.class);
        double moduleId = -1;
        if(map != null){
           moduleId = (Double) map.get(Resource.KEY.KEY_MODULE_ID);
        }
        LogUtil.e("PushHandler", "moduleId = " + moduleId);
        return (int) moduleId;
    }

    private void handleAttendanceEvent(MsgEvent event, Context context){
        String jsonStr = (String) event.obj;
        LogUtil.e("push", "jsonStr : " + jsonStr);
        PreferenceHelper.getInstance(context).putString(Resource.MODULE_COURSE_ATTENDANCE_NAME, jsonStr);
        String modelStr = PreferenceHelper.getInstance(context).getString(Resource.MODULE_COURSE_ATTENDANCE_NAME, "");
        LogUtil.e("push", "modelStr : " + modelStr);
        AttendanceViewModel model = JsonUtil.deserialize(modelStr, AttendanceViewModel.class);
        LogUtil.e("push", "model : " + model);
        if(model != null) {
            LogUtil.e("push", model.getmAttendanceTime());
        }
    }

//    public Object getObject(Context context){
//        SharedPreferences mPreference = context.getSharedPreferences("share", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = mPreference.edit();
//        editor.
//    }
}
