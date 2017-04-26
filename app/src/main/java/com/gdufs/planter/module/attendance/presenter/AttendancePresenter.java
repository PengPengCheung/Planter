package com.gdufs.planter.module.attendance.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.gdufs.planter.common.BaseViewDBModel;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.common.BaseView;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.PersistenceManager;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.model.AttendanceInfo;
import com.gdufs.planter.module.attendance.model.AttendanceViewDBModel;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.interaction.view.ClassInteractionView;
import com.gdufs.planter.module.planter.PlanterDataManager;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.ObjectWriter;
import com.gdufs.planter.utils.PreferenceHelper;
import com.gdufs.planter.utils.ResultCallback;
import com.gdufs.planter.utils.TimeUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/3/18.
 */

public class AttendancePresenter extends ModuleBasePresenter{

    private static final String TAG = AttendancePresenter.class.getSimpleName();
    private int status = Resource.ATTENDANCE.ATTENDANCE_STATUS_DEFAULT;
//    private List<ModuleBaseView> mViewList;
//    private BaseView mView;
    private static AttendancePresenter mInstance = null;

    private AttendancePresenter(){
        super();
//        mViewList = new ArrayList<>();
    }

    @Override
    public void notifyViewUpdate(BaseViewModel model) {
        updateAllViews(model);
    }

    public static AttendancePresenter getInstance(){
        if(mInstance == null) {
            synchronized (AttendancePresenter.class) {
                if(mInstance == null) {
                    mInstance = new AttendancePresenter();
                }
            }
        }
        return mInstance;
    }

//    public void addView(ModuleBaseView view){
//        mViewList.add(view);
//    }

    private void handleModelWhenSuccess(DataResponse<AttendanceViewModel> response){
        AttendanceViewModel responseModel = response.getData();
//        List<BaseViewModel> models = PersistenceManager.getInstance().findAllViewModel(Resource.MODULE_COURSE_ATTENDANCE);

        // 选取具有相同attendanceId的实体
        List<BaseViewDBModel> models = PersistenceManager.getInstance().findViewDBModelByViewModel(responseModel);

        // 根据被点击的AttendanceId修改对应的数据
        for(BaseViewDBModel model:models){
            AttendanceViewDBModel viewModel = (AttendanceViewDBModel) model;
//            if(viewModel.getAttendanceId() != null && viewModel.getAttendanceId().equals(responseModel.getAttendanceId())){
                if(viewModel.getmDataFrom() == Resource.DATA_FROM.DATA_FROM_PUSH){ // 修改属于教师推送的请求
                    viewModel.setmAttendanceStatus(responseModel.getmAttendanceStatus());

                    PersistenceManager.getInstance().updateViewModel(viewModel, Resource.MODULE_COURSE_ATTENDANCE);
                    break;
//                }
            }
        }

        PersistenceManager.getInstance().insertViewModel(responseModel, Resource.MODULE_COURSE_ATTENDANCE);

    }

    private Map<String, Object> constructRequestParams(AttendanceViewModel model, Context context){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(Resource.KEY.KEY_ATTENDANCE_CODE, model.getmAttendanceCode());
        params.put(Resource.KEY.KEY_ATTENDANCE_ID, model.getAttendanceId());
//        String studentId = model.getmStudentId();
        String studentId = PreferenceHelper.getInstance(context).getString(Resource.KEY.KEY_STUDENT_ID, "");
        LogUtil.e(TAG, "studentId: " + studentId);
        params.put(Resource.KEY.KEY_STUDENT_ID, studentId);
        params.put(Resource.KEY.KEY_COURSE_ID, model.getmCourseId());
        LogUtil.e(TAG, "openClassId: " + model.getmOpenClassId());
        params.put(Resource.KEY.KEY_CLASS_OPEN_ID, model.getmOpenClassId());
        Date date = new Date();
        String timeStr = TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_HMS);
        params.put(Resource.KEY.KEY_ATTENDANCE_TIME, timeStr);

        return params;
    }

    private void notifyPlanterTreeModule(DataResponse<AttendanceViewModel> response){
        AttendanceViewModel model = response.getData();
        PlanterDataManager.getInstance().getDataFromModules(model);
    }

    public void sendAttendanceCode(AttendanceViewModel model, Context context){
        String inputCode = model.getmAttendanceCode();
        if(inputCode != null) {
            if(inputCode.length() < 6 || inputCode.length() > 6) {
                status = Resource.ATTENDANCE.ATTENDANCE_STATUS_CODE_ERROR;
                for(int i=0;i<getViewList().size();i++) {
                    BaseView view = getViewList().get(i);
                    if(view != null && view instanceof ClassInteractionView){
                        ((ClassInteractionView)view).onReceiveAttendanceStatus(status);
                        return;
                    }
                }
            }

            Map<String, Object> params = constructRequestParams(model, context);

            NetworkUtil.post(Resource.PlanterURL.ATTENDANCE_CODE_URL, params, new ResultCallback<String>() {
                @Override
                public void onSuccess(String response) {

//                    ParseUtil<AttendanceInfo> parser = new ParseUtil<>();
//                    DataResponse<AttendanceInfo> r = parser.parseToObj(response);

                    Type classTypeData = new TypeToken<DataResponse<AttendanceViewModel>>(){}.getType();
                    //解析数据
                    DataResponse<AttendanceViewModel> r = JsonUtil.deserialize(response, classTypeData);


                    if(r != null){
                        handleModelWhenSuccess(r);
                        notifyPlanterTreeModule(r);
                        responseAllViewIfSuccess(r);
                    }

//                    if(mView != null){
//                        mView.onResponseSuccess(r);
//                    }


//                    Log.e("ppp", "response: " + response);
//                    JSONObject jsonObject = null;
//                    try {
//                        jsonObject  = new JSONObject(response);
//                        status = Integer.valueOf(jsonObject.getString(Resource.KEY.KEY_ATTENDANCE_STATUS));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }

                }

                @Override
                public void onFailure(Exception e) {
                    Log.e("ppp", "attendance fail.");
                    responseAllViewIfFailure(e);
//                    if(mView != null) {
//                        mView.onResponseFailure(e);
//                    }
                }
            });
        }
    }


    @Override
    public List<BaseViewModel> readAllViewModelToList(String courseId) {
        if(courseId != null && !TextUtils.isEmpty(courseId)){
            List<BaseViewModel> modelList = PersistenceManager.getInstance().findViewModelByCustomId(courseId, Resource.MODULE_COURSE_ATTENDANCE);
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
            AttendanceViewModel viewModel = (AttendanceViewModel) model;
            if(viewModel.getmDataFrom() == Resource.DATA_FROM.DATA_FROM_PUSH){
                viewModelList.add(viewModel); // 如果直接对不符合条件的BaseViewModel进行删除，会导致读取和删除线程不安全，java.util.ConcurrentModificationException
            }
        }

        return viewModelList;
    }

    public void requestMoreAttendanceInfo(){
        responseAllViewIfSuccess(new DataResponse(200, ""));
    }

//    private void responseAllViewIfSuccess(DataResponse response){
//        for(int i=0;i<mViewList.size();i++){
//            BaseView view = mViewList.get(i);
//            if(view != null) {
//                view.onResponseSuccess(response);
//            }
//        }
//    }

//    private void responseAllViewIfFailure(Exception e){
//        for(int i=0;i<mViewList.size();i++){
//            BaseView view = mViewList.get(i);
//            if(view != null) {
//                view.onResponseFailure(e);
//            }
//        }
//    }

//    public void notifyViewUpdate(AttendanceViewModel model){
//        updateAllViews(model);
//    }

//    public List<AttendanceViewModel> readAllViewModelToList(){
//        List<AttendanceViewModel> list = ObjectWriter.readAll(Resource.MODULE_COURSE_ATTENDANCE_NAME);
//        LogUtil.e("ppp", "model list size = " + list.size());
//        for(int i=0;i<list.size();i++){
//            LogUtil.e("ppp", "model = " + list.get(i).getmAbsenceCount());
//        }
//        return list;
//    }

//    private void updateAllViews(AttendanceViewModel model){
//        LogUtil.e(TAG, "updateAllViews 1");
//        if(mViewList != null) {
//            LogUtil.e(TAG, "updateAllViews 2, viewList size = " + mViewList.size());
//            for(int i=0;i<mViewList.size();i++){
//                ModuleBaseView view = mViewList.get(i);
//                LogUtil.e(TAG, "updateAllViews 3");
//                if(view != null) {
//                    LogUtil.e(TAG, "updateAllViews 4");
//                    view.update(model);
//                }
//            }
//        }
//    }

}
