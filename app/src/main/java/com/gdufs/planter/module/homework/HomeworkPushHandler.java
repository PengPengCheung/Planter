package com.gdufs.planter.module.homework;

import android.content.Context;

import com.gdufs.planter.common.BasePushHandler;
import com.gdufs.planter.common.BaseViewDBModel;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.MsgEvent;
import com.gdufs.planter.common.PersistenceManager;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.homework.model.HomeworkViewDBModel;
import com.gdufs.planter.module.homework.model.HomeworkViewModel;
import com.gdufs.planter.module.homework.presenter.HomeworkPresenter;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.ObjectWriter;

import java.util.List;

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
        List<BaseViewDBModel> dbModelList = PersistenceManager.getInstance().findViewDBModelByCustomId(model.getmCourseId(), Resource.MODULE_COURSE_HOMEWORK);

        if(dbModelList != null && dbModelList.size() == 0){
            PersistenceManager.getInstance().insertViewModel(model, Resource.MODULE_COURSE_HOMEWORK);
            return;
        }

        if(dbModelList != null && dbModelList.size() > 0){
            for(BaseViewDBModel dbModel : dbModelList){
                HomeworkViewDBModel homeworkViewDBModel = (HomeworkViewDBModel) dbModel;
                if(homeworkViewDBModel.getmHomeworkId().equals(model.getmHomeworkId())){
                    changeInfo(homeworkViewDBModel, model);
                    PersistenceManager.getInstance().updateViewModel(homeworkViewDBModel, Resource.MODULE_COURSE_HOMEWORK);
                    return;
                }
            }
        }

        PersistenceManager.getInstance().insertViewModel(model, Resource.MODULE_COURSE_HOMEWORK);
    }

    // 对不同状态下的作业信息进行修改，避免状态之间的值乱传
    private void changeInfo(HomeworkViewDBModel homeworkViewDBModel, HomeworkViewModel model) {
        int status = model.getmHomeworkStatus();
        switch (status){
            case Resource.HOMEWORK.HOMEWORK_PUBLISHED:{
                homeworkViewDBModel.setmHomeworkSubmitDDL(model.getmHomeworkSubmitDDL());
                homeworkViewDBModel.setmHomeworkPublishTime(model.getmHomeworkPublishTime());
                homeworkViewDBModel.setmHomeworkTitle(model.getmHomeworkTitle());
                homeworkViewDBModel.setmHomeworkContent(model.getmHomeworkContent());
            }
            break;
            case Resource.HOMEWORK.HOMEWORK_SUBMIT_SUCCESS:{
                homeworkViewDBModel.setmHomeworkItemCurrentTime(model.getmHomeworkItemCurrentTime());
            }
            break;
            case Resource.HOMEWORK.HOMEWORK_SCORED:{
                homeworkViewDBModel.setmHomeworkScore(model.getmHomeworkScore());
                homeworkViewDBModel.setmHomeworkRank(model.getmHomeworkRank());
                homeworkViewDBModel.setmHomeworkBonusNum(model.getmHomeworkBonusNum());
            }
            break;
        }

        homeworkViewDBModel.setmHomeworkStatus(status);
    }
}
