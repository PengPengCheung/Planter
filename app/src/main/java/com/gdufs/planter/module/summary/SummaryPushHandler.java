package com.gdufs.planter.module.summary;

import android.content.Context;

import com.gdufs.planter.common.BasePushHandler;
import com.gdufs.planter.common.MsgEvent;
import com.gdufs.planter.common.PersistenceManager;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.summary.model.SummaryViewModel;
import com.gdufs.planter.module.summary.presenter.SummaryPresenter;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.ObjectWriter;

/**
 * Created by peng on 2017/3/20.
 */

public class SummaryPushHandler implements BasePushHandler {

    private static final String TAG = SummaryPushHandler.class.getSimpleName();

    private static SummaryPushHandler mInstance = null;

    private SummaryPushHandler(){}

    public static SummaryPushHandler getInstance(){
        if(mInstance == null){
            synchronized (SummaryPushHandler.class){
                if(mInstance == null){
                    mInstance = new SummaryPushHandler();
                }
            }
        }

        return mInstance;
    }


    @Override
    public void handlePush(Context context, MsgEvent event) {
        String jsonStr = (String) event.obj;
        SummaryViewModel model = JsonUtil.deserialize(jsonStr, SummaryViewModel.class);
        writeObjectToFile(model);
        LogUtil.e(TAG, "writeToFile");
        SummaryPresenter.getInstance().notifyViewUpdate(model);
    }

    private void writeObjectToFile(SummaryViewModel model) {
        PersistenceManager.getInstance().insertViewModel(model, model.getmModuleId());
//        ObjectWriter.write(model, Resource.MODULE_COURSE_SUMMARY_NAME);
    }
}
