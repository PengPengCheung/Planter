package com.gdufs.planter.module.homework;

import android.content.Context;

import com.gdufs.planter.common.BasePushHandler;
import com.gdufs.planter.common.MsgEvent;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.homework.mode.HomeworkViewModel;
import com.gdufs.planter.module.homework.presenter.HomeworkPresenter;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.ObjectWriter;

/**
 * Created by peng on 2017/3/21.
 */

public class HomeworkPushHandler implements BasePushHandler {

    private static HomeworkPushHandler mInstance = null;

    private HomeworkPushHandler(){}

    public static HomeworkPushHandler getInstance(){
        if(mInstance == null){
            synchronized (HomeworkPushHandler.class){
                if(mInstance == null){
                    mInstance = new HomeworkPushHandler();
                }
            }
        }

        return mInstance;
    }

    @Override
    public void handlePush(Context context, MsgEvent event) {
        String jsonStr = (String) event.obj;
        HomeworkViewModel model = JsonUtil.deserialize(jsonStr, HomeworkViewModel.class);
        writeObjToFile(model);
        HomeworkPresenter.getInstance().notifyViewUpdate(model);
    }

    private void writeObjToFile(HomeworkViewModel model) {
        ObjectWriter.write(model, Resource.MODULE_COURSE_HOMEWORK_NAME);
    }
}
