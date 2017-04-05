package com.gdufs.planter.module.attendance.presenter;

import android.util.Log;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.common.BaseView;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.model.AttendanceInfo;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.interaction.view.ClassInteractionView;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.ObjectWriter;
import com.gdufs.planter.utils.ResultCallback;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
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

    public void sendAttendanceCode(String inputCode){
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
            Map<String, Object> params = new HashMap<String, Object>();
            params.put(Resource.KEY.KEY_ATTENDANCE_CODE, inputCode);
            NetworkUtil.post(Resource.PlanterURL.ATTENDANCE_CODE_URL, params, new ResultCallback<String>() {
                @Override
                public void onSuccess(String response) {

//                    ParseUtil<AttendanceInfo> parser = new ParseUtil<>();
//                    DataResponse<AttendanceInfo> r = parser.parseToObj(response);

                    Log.i("-----------response",response);
                    Type classTypeData = new TypeToken<DataResponse<AttendanceViewModel>>(){}.getType();
                    //解析数据
                    Log.i("-----------data",classTypeData.toString());
                    DataResponse<AttendanceViewModel> r = JsonUtil.deserialize(response, classTypeData);
                    Log.i("-----------dataApiAudio","" + r.getData().getmAttendanceStatus());


                    responseAllViewIfSuccess(r);
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
