package com.gdufs.planter.module.attendance.presenter;

import android.util.Log;
import android.widget.Toast;

import com.gdufs.planter.common.AttendanceBaseView;
import com.gdufs.planter.common.BaseView;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.model.AttendanceInfo;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.ResultCallback;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng on 2017/3/18.
 */

public class AttendancePresenter {

    private int status = Resource.ATTENDANCE.ATTENDANCE_STATUS_DEFAULT;
    private BaseView mView;

    public AttendancePresenter(BaseView view){
        mView = view;
    }

    public void sendAttendanceCode(String inputCode){


        if(inputCode != null) {
            if(inputCode.length() < 6 || inputCode.length() > 6) {
                status = Resource.ATTENDANCE.ATTENDANCE_STATUS_CODE_ERROR;
                if(mView != null){
                    ((AttendanceBaseView)mView).onReceiveAttendanceStatus(status);
                    return;
                }
            }
            Map<String, Object> params = new HashMap<String, Object>();
            params.put(Resource.KEY.KEY_ATTENDANCE_CODE, inputCode);
            NetworkUtil.post(Resource.PlanterURL.ATTENDANCE_CODE_URL, params, new ResultCallback<String>() {
                @Override
                public void onSuccess(String response) {

                    Log.i("-----------response",response);
                    Type classTypeData = new TypeToken<DataResponse<AttendanceInfo>>(){}.getType();
                    //解析数据
                    Log.i("-----------data",classTypeData.toString());
                    DataResponse<AttendanceInfo> r = JsonUtil.deserialize(response, classTypeData);
                    Log.i("-----------dataApiAudio","" + r.getData().getmAttendanceStatus());

                    if(mView != null){
                        mView.onResponseSuccess(r);
                    }


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
                    if(mView != null) {
                        mView.onResponseFailure(e);
                    }
                }
            });
        }
    }

}
