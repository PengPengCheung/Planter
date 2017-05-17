package com.gdufs.planter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.MsgEvent;
import com.gdufs.planter.common.PersistenceManager;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.model.AttendanceInfo;
import com.gdufs.planter.module.frame.presenter.FrameViewPresenter;
import com.gdufs.planter.module.frame.view.FrameView;
import com.gdufs.planter.module.planter.model.PlanterViewModel;
import com.gdufs.planter.module.planter.presenter.PlanterMainPresenter;
import com.gdufs.planter.module.push.PushHandler;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.ObjectWriter;
import com.gdufs.planter.utils.PreferenceHelper;
import com.gdufs.planter.utils.ResultCallback;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/3/18.
 */

public class PlanterMainActivity extends LaunchBaseActivity {

    private static String TAG = PlanterMainActivity.class.getSimpleName();

    private FrameView mFrameView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initOthers();
    }

    private void initOthers(){
        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        if(bundle != null){
            Map<String, Object> map = new HashMap<>();
            map.put(Resource.KEY.KEY_STU_NUMBER, bundle.getString(Resource.KEY.KEY_STU_NUMBER));
            map.put(Resource.KEY.KEY_STU_NAME, bundle.getString(Resource.KEY.KEY_STU_NAME));
            map.put(Resource.KEY.KEY_STU_PASSWORD, bundle.getString(Resource.KEY.KEY_STU_PASSWORD));
            map.put(Resource.KEY.KEY_STU_COURSE_CODE, bundle.getString(Resource.KEY.KEY_STU_COURSE_CODE));
            NetworkUtil.post(Resource.PlanterURL.SIGN_UP_URL, map, new ResultCallback<String>() {
                @Override
                public void onSuccess(String response) {
                    LogUtil.e(TAG, "Main Response: " + response);

                    Type classTypeData = new TypeToken<DataResponse<PlanterViewModel>>(){}.getType();
                    //解析数据
                    DataResponse<PlanterViewModel> responseData = JsonUtil.deserialize(response, classTypeData);
                    int code = responseData.getError_code();
                    if(code == Resource.SIGN_UP_AND_LOGIN.STATUS_COURSE_CODE_VALIDATE_SUCCESS){
                        PlanterViewModel model = responseData.getData();
                        PreferenceHelper.getInstance(PlanterMainActivity.this).putString(Resource.KEY.KEY_STU_NAME, bundle.getString(Resource.KEY.KEY_STU_NAME));
                        PreferenceHelper.getInstance(PlanterMainActivity.this).putString(Resource.KEY.KEY_STU_PASSWORD, bundle.getString(Resource.KEY.KEY_STU_PASSWORD));
                        writeObjectToFile(model);
                        storeIntoPrefer(model);
                        notifyUpdateView(model);
                        LogUtil.e(TAG, "load course tree success");
                    } else if(code == Resource.SIGN_UP_AND_LOGIN.STATUS_COURSE_CODE_UNAVAILABLE){
                        Toast.makeText(PlanterMainActivity.this, responseData.getReason(), Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private void notifyUpdateView(PlanterViewModel model) {
        FrameViewPresenter.getInstance().notifyViewUpdate(model);
        PlanterMainPresenter.getInstance().notifyViewUpdate(model);
    }

    private void writeObjectToFile(PlanterViewModel model){
//        ObjectWriter.write(model, Resource.MODULE_PLANTER_NAME);
        PersistenceManager.getInstance().insertViewModel(model, Resource.MODULE_FRAME_PLANTER);
    }

    private void storeIntoPrefer(BaseViewModel model) {
        if(model == null){
            return;
        }

        PreferenceHelper.getInstance(this).putString(Resource.KEY.KEY_STUDENT_ID, model.getmStudentId());
        PlanterViewModel viewModel = (PlanterViewModel) model;
        LogUtil.e(TAG, "before store model Name.");
        if(TextUtils.isEmpty(viewModel.getmCourseName())){
            LogUtil.e(TAG, "store course Name");
            PreferenceHelper.getInstance(this).putString(viewModel.getmCourseName(), viewModel.getmCourseId());
        }


//        List<BaseViewModel> modelList = JsonUtil.deserialize(json, );
//        PreferenceHelper.getInstance(this).putString(Resource.KEY.KEY_STU_NUMBER, bundle.getString(Resource.KEY.KEY_STU_NUMBER));
//        PreferenceHelper.getInstance(this).putString(Resource.KEY.KEY_STU_NAME, bundle.getString(Resource.KEY.KEY_STU_NAME));
//        PreferenceHelper.getInstance(this).putString(Resource.KEY.KEY_STU_PASSWORD, bundle.getString(Resource.KEY.KEY_STU_PASSWORD));
//        PreferenceHelper.getInstance(this).putString(Resource.KEY.KEY_STU_COURSE_CODE, bundle.getString(Resource.KEY.KEY_STU_COURSE_CODE));
    }

    private void initViews(){
        mFrameView = new FrameView(this);
        mFrameView.init();
    }


    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventRecieved(MsgEvent event){
        Log.e("ppp", "onMessage: " + event.getMsg() + "obj: " + event.obj);
        if(event.what == Resource.EVENTBUS_TYPE.EVENTBUS_TYPE_FROM_ATTENTION){
            EventBus.getDefault().removeStickyEvent(event);
            return;
        }
        PushHandler.getInstance().handlePush(getApplicationContext(), event);
        EventBus.getDefault().removeStickyEvent(event);
//        if(mPushHandler != null) {
//            mPushHandler.handlePush(event);
//        }
    }

    @Override
    protected void onStop() {
        LogUtil.e("ppp", "onDestroy");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        LogUtil.e("ppp", "onDestroy");
        super.onDestroy();
    }
}
