package com.gdufs.planter.module.group;

import android.content.Context;

import com.gdufs.planter.common.BasePushHandler;
import com.gdufs.planter.common.MsgEvent;
import com.gdufs.planter.common.PersistenceManager;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.group.model.GroupPushModel;
import com.gdufs.planter.module.group.model.GroupPushViewModel;
import com.gdufs.planter.module.group.presenter.GroupPresenter;
import com.gdufs.planter.utils.JsonUtil;

/**
 * Created by peng on 2017/4/25.
 */

public class GroupPushHandler implements BasePushHandler {


    private static GroupPushHandler mInstance = null;

    public static GroupPushHandler getmInstance(){
        if(mInstance == null){
            synchronized (GroupPushHandler.class){
                if(mInstance == null){
                    mInstance = new GroupPushHandler();
                }
            }
        }

        return mInstance;
    }



    @Override
    public void handlePush(Context context, MsgEvent event) {
        String pushModelStr = (String) event.obj;
        GroupPushViewModel pushModel = JsonUtil.deserialize(pushModelStr, GroupPushViewModel.class);
        int pushType = pushModel.getmPushType();
        switch (pushType){
            case Resource.GROUP.GROUP_TYPE_OPEN_GROUP_NOTIFICATION:{
                writeObjectToDB(pushModel);
                GroupPresenter.getInstance().handleOpenGroupPushNotification();
            }
            break;
            case Resource.GROUP.GROUP_TYPE_STUDENT_OPEN_GROUP_ALREADY:{

            }
            break;
        }

    }

    private void writeObjectToDB(GroupPushViewModel pushModel) {
        PersistenceManager.getInstance().insertViewModel(pushModel, pushModel.getmModuleId());
    }
}
