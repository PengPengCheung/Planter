package com.gdufs.planter.module.attention;

import android.content.Context;

import com.gdufs.planter.common.BasePushHandler;
import com.gdufs.planter.common.MsgEvent;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attention.model.AttentionViewModel;
import com.gdufs.planter.module.attention.presenter.AttentionPresenter;
import com.gdufs.planter.module.push.PushHandler;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.ObjectWriter;

/**
 * Created by peng on 2017/3/20.
 */

public class AttentionPushHandler implements BasePushHandler {

    private static AttentionPushHandler mInstance = null;

    private AttentionPushHandler(){}

    public static AttentionPushHandler getInstance(){
        if(mInstance == null) {
            synchronized (AttentionPushHandler.class) {
                if(mInstance == null) {
                    mInstance = new AttentionPushHandler();
                }
            }
        }

        return mInstance;
    }

    @Override
    public void handlePush(Context context, MsgEvent event) {
        String jsonStr = (String) event.obj;
        AttentionViewModel model = JsonUtil.deserialize(jsonStr, AttentionViewModel.class);
        writeModelToFile(model);
        AttentionPresenter.getInstance().notifyViewUpdate(model);
    }

    private void writeModelToFile(AttentionViewModel model) {
        ObjectWriter.write(model, Resource.MODULE_COURSE_ATTENTION_NAME);

    }
}
