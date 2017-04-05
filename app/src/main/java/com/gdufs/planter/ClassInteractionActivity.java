package com.gdufs.planter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.attention.model.AttentionViewModel;
import com.gdufs.planter.module.interaction.presenter.InteractionPresenter;
import com.gdufs.planter.module.interaction.view.ClassInteractionView;
import com.gdufs.planter.module.push.PushResponseModel;
import com.gdufs.planter.utils.JsonUtil;
import com.gdufs.planter.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by peng on 2017/3/17.
 */

public class ClassInteractionActivity extends AppCompatActivity {

    private static final String TAG = ClassInteractionActivity.class.getSimpleName();

    ClassInteractionView mInteractionView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction);
        LogUtil.e(TAG, "onCreate");
        init();
        handleIntent();
    }

    private void handleIntent(){
        Intent intent = getIntent();
        if (null != intent) {
            Bundle bundle = intent.getExtras();
            if(bundle != null) {
                if("push".equals(bundle.getString("from"))){
                    String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
                    String content = bundle.getString(JPushInterface.EXTRA_ALERT);
                    String msg = bundle.getString(JPushInterface.EXTRA_MESSAGE);
                    String push = bundle.getString("from");
                    Log.e("ppp", "msg: " + msg + " " + "Title : " + title + "  " + "Content : " + content + "from: " + push);


//                    InteractionPresenter.getInstance().acceptPushData(msg);

//                    AttendanceViewModel model = JsonUtil.deserialize(msg, AttendanceViewModel.class);
//                    mInteractionView.addViewData(model);
//                    if(mInteractionView != null) {
//                        mInteractionView.showDialog();
//                    }
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.e(TAG, "onResume");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtil.e(TAG, "onNewIntent");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.e(TAG, "onRestart");
    }

    private void init(){
        mInteractionView = new ClassInteractionView(this);
    }
}
