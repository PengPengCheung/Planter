package com.gdufs.planter.module.interaction.presenter;

import android.util.Log;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.PersistenceManager;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.attention.model.AttentionViewModel;
import com.gdufs.planter.module.push.PushResponseModel;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.ObjectWriter;
import com.gdufs.planter.utils.TimeUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by peng on 2017/4/3.
 */

public class InteractionPresenter extends ModuleBasePresenter{

    private static final String TAG = InteractionPresenter.class.getSimpleName();

    private static InteractionPresenter mInstance = null;

    private InteractionPresenter(){}



    public static InteractionPresenter getInstance(){
        if(mInstance == null){
            synchronized (InteractionPresenter.class){
                if(mInstance == null){
                    mInstance = new InteractionPresenter();
                }
            }
        }

        return mInstance;
    }



    @Override
    public List<BaseViewModel> readAllViewModelToList(String moduleFileName) {
        List<BaseViewModel> modelList = PersistenceManager.getInstance().findAllViewModel(Resource.MODULE_COURSE_ATTENDANCE);
        List<BaseViewModel> sortList = PersistenceManager.getInstance().sort(modelList, true);
        for(int i=0;i<sortList.size();i++){
            BaseViewModel model = sortList.get(i);
            LogUtil.e(TAG, ((AttendanceViewModel) model).getmAttendanceTime());
        }
        return sortList;
    }

    @Override
    public void notifyViewUpdate(BaseViewModel model) {
        updateAllViews(model);
    }


    public void modifyData(int pos, BaseViewModel model){
        int module = model.getmModuleId();
        switch (module){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                AttendanceViewModel viewModel = (AttendanceViewModel) model;
                if(viewModel.getmAttendanceStatus() == Resource.ATTENDANCE.ATTENDANCE_STATUS_SUCCESS){
                    List<BaseViewModel> modelList = readAllViewModelToList(Resource.MODULE_COURSE_INTERACTION_NAME);
                    ((AttendanceViewModel) modelList.get(pos)).setmAttendanceStatus(Resource.ATTENDANCE.ATTENDANCE_STATUS_ALREADY_CHECK_SUCCESS);

                } else {
                    List<BaseViewModel> modelList = readAllViewModelToList(Resource.MODULE_COURSE_INTERACTION_NAME);
                    ((AttendanceViewModel) modelList.get(pos)).setmAttendanceStatus(viewModel.getmAttendanceStatus());
                }
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{}break;
        }
    }

    public void addDataToFile(BaseViewModel model){
        PersistenceManager.getInstance().insertViewModel(model, model.getmModuleId());
//        ObjectWriter.write(model, Resource.MODULE_COURSE_INTERACTION_NAME);
    }

//    public void acceptPushData(String msg) {
//        PushResponseModel pushModel = deserializeMsgToPushRspModel(msg);
//        BaseViewModel viewModel = getViewModelFromPushModel(pushModel);
//        writeObjToFile(viewModel);
//
//    }

    public void writeObjToFile(BaseViewModel model){
        ObjectWriter.write(model, Resource.MODULE_COURSE_INTERACTION_NAME);
    }

    private PushResponseModel deserializeMsgToPushRspModel(String msg){
        PushResponseModel pushModel = JsonUtil.deserialize(msg, PushResponseModel.class);
        return pushModel;
    }

    private BaseViewModel getViewModelFromPushModel(PushResponseModel pushModel){
        int module = pushModel.getmModuleId();
        BaseViewModel model = null;
        switch (module){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                model = (AttendanceViewModel) pushModel.getData();
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
                model = (AttentionViewModel) pushModel.getData();
            }
            break;
        }

        return model;
    }
}
