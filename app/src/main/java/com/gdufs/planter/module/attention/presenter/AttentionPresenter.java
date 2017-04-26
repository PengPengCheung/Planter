package com.gdufs.planter.module.attention.presenter;

import android.text.TextUtils;

import com.gdufs.planter.common.BaseViewDBModel;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.common.PersistenceManager;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attendance.model.AttendanceViewDBModel;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.attention.model.AttentionGoingModel;
import com.gdufs.planter.module.attention.model.AttentionViewDBModel;
import com.gdufs.planter.module.attention.model.AttentionViewModel;
import com.gdufs.planter.module.planter.PlanterDataManager;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.PreferenceHelper;
import com.gdufs.planter.utils.ResultCallback;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/3/20.
 */

public class AttentionPresenter extends ModuleBasePresenter{

    private static final String TAG = AttentionPresenter.class.getSimpleName();

    private static AttentionPresenter mInstance = null;

    private AttentionPresenter(){
        super();
    }

    public static AttentionPresenter getInstance(){
        if(mInstance == null) {
            synchronized (AttentionPresenter.class) {
                if(mInstance == null) {
                    mInstance = new AttentionPresenter();
                }
            }
        }
        return mInstance;
    }

    @Override
    public void notifyViewUpdate(BaseViewModel model) {
        updateAllViews(model);
    }

    @Override
    public List<BaseViewModel> readAllViewModelToList(String courseId) {
        if(courseId != null && !TextUtils.isEmpty(courseId)){
            List<BaseViewModel> modelList = PersistenceManager.getInstance().findViewModelByCustomId(courseId, Resource.MODULE_COURSE_ATTENTION);
            List<BaseViewModel> viewModelList = new LinkedList<>();
            viewModelList.addAll(filterModelList(modelList));
            LogUtil.e(TAG, "list size: " + modelList.size());
            return PersistenceManager.getInstance().sort(viewModelList, false);
        }

        return new LinkedList<>();
    }

    private List<BaseViewModel> filterModelList(List<BaseViewModel> modelList) {
        List<BaseViewModel> viewModelList = new LinkedList<>();
        for(BaseViewModel model : modelList){
            AttentionViewModel viewModel = (AttentionViewModel) model;
            if(viewModel.getmDataFrom() == Resource.DATA_FROM.DATA_FROM_PUSH){
                viewModelList.add(viewModel); // 如果直接对不符合条件的BaseViewModel进行删除，会导致读取和删除线程不安全，java.util.ConcurrentModificationException
            }
        }

        return viewModelList;
    }





    public void sendCurrentAttentionResult(AttentionGoingModel model){
        Map<String, Object> params = constructParams(model);
        NetworkUtil.post(Resource.PlanterURL.ATTENTION_REPORT_URL, params, new ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                LogUtil.e(TAG, "sendAttentionResult Success: " + response);
                Type classTypeData = new TypeToken<DataResponse<AttentionViewModel>>(){}.getType();
                DataResponse<AttentionViewModel> r = JsonUtil.deserialize(response, classTypeData);
                if(r != null){
                    handleModelWhenSuccess(r);
                    notifyPlanterTreeModule(r);
                    responseAllViewIfSuccess(r);
                }
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
//                LogUtil.e(TAG, "sendAttentionResult Exception: " + e.getMessage());
            }
        });
    }

    private void notifyPlanterTreeModule(DataResponse<AttentionViewModel> response) {
        AttentionViewModel model = response.getData();
        PlanterDataManager.getInstance().getDataFromModules(model);
    }

    private void handleModelWhenSuccess(DataResponse<AttentionViewModel> r) {
        AttentionViewModel attentionViewModel = r.getData();

        // 选取具有相同attendanceId的实体
        List<BaseViewDBModel> models = PersistenceManager.getInstance().findViewDBModelByViewModel(attentionViewModel);

        // 根据被点击的AttendanceId修改对应的数据
        for(BaseViewDBModel model:models){
            AttentionViewDBModel viewModel = (AttentionViewDBModel) model;
//            if(viewModel.getAttendanceId() != null && viewModel.getAttendanceId().equals(responseModel.getAttendanceId())){
            if(viewModel.getmDataFrom() == Resource.DATA_FROM.DATA_FROM_PUSH){ // 修改属于教师推送的请求
                viewModel.setmAttentionStatus(attentionViewModel.getmAttentionStatus());

                PersistenceManager.getInstance().updateViewModel(viewModel, Resource.MODULE_COURSE_ATTENTION);
                break;
//                }
            }
        }

        PersistenceManager.getInstance().insertViewModel(attentionViewModel, Resource.MODULE_COURSE_ATTENTION);
    }

    private Map<String, Object> constructParams(AttentionGoingModel model) {
        Map<String, Object> params = new HashMap<>();
        params.put(Resource.KEY.KEY_COURSE_ID, model.getmCourseId());
        params.put(Resource.KEY.KEY_STUDENT_ID, model.getmStudentId());
        LogUtil.e(TAG, "Attention studentId: " + model.getmStudentId());
        params.put(Resource.KEY.KEY_ATTENTION_DURATION, model.getmAttentionDuration());
        params.put(Resource.KEY.KEY_ATTENTION_TYPE, model.getmAttentionType());
        params.put(Resource.KEY.KEY_BONUS_TYPE, model.getmAttentionBonusType());
        params.put(Resource.KEY.KEY_ATTENTION_BONUS_NUM, model.getmAttentionBonusNum());
        params.put(Resource.KEY.KEY_ATTENTION_SCORE, model.getmScore());
        params.put(Resource.KEY.KEY_ATTENTION_STATUS, model.getmAttentionStatus());
        LogUtil.e(TAG, "Attention openClassId: " + model.getmOpenClassId());
        params.put(Resource.KEY.KEY_CLASS_OPEN_ID, model.getmOpenClassId());
        LogUtil.e(TAG, "Attention InsistTime: " + model.getmAttentionInsistTime());
        params.put(Resource.KEY.KEY_ATTENTION_INSIST_TIME, model.getmAttentionInsistTime());
        params.put(Resource.KEY.KEY_ATTENTION_END_TIME, model.getmEndTime());
        params.put(Resource.KEY.KEY_ATTENTION_TIME, model.getmStartTime());

        return params;
    }
}
