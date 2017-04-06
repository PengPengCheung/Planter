package com.gdufs.planter.module.interaction;

import android.content.Context;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.MsgEvent;
import com.gdufs.planter.common.PersistenceManager;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.attention.model.AttentionViewModel;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.ObjectWriter;

/**
 * Created by peng on 2017/4/3.
 */

public class InteractionPushHandler {

    private static InteractionPushHandler mInstance = null;

    private InteractionPushHandler(){}

    public static InteractionPushHandler getInstance(){
        if(mInstance == null){
            synchronized (InteractionPushHandler.class){
                if(mInstance == null){
                    mInstance = new InteractionPushHandler();
                }
            }
        }

        return mInstance;
    }

    public void handlePush(Context context, MsgEvent event, int module){
        String jsonStr = (String) event.obj;
        switch (module){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                AttendanceViewModel attendanceViewModel = JsonUtil.deserialize(jsonStr, AttendanceViewModel.class);
                writeDataToDisk(attendanceViewModel);
//                ObjectWriter.write(attendanceViewModel, Resource.MODULE_COURSE_INTERACTION_NAME);
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
                AttentionViewModel attentionViewModel = JsonUtil.deserialize(jsonStr, AttentionViewModel.class);
                writeDataToDisk(attentionViewModel);
//                ObjectWriter.write(attentionViewModel, Resource.MODULE_COURSE_INTERACTION_NAME);
            }
            break;
        }
    }

    private void writeDataToDisk(BaseViewModel model){
//        PersistenceManager.getInstance().insertViewModel(model, model.getmModuleId());
    }

}
