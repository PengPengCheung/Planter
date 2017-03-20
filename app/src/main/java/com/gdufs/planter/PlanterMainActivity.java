package com.gdufs.planter;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import com.gdufs.planter.common.MsgEvent;
import com.gdufs.planter.module.frame.view.FrameView;
import com.gdufs.planter.module.push.PushHandler;
import com.gdufs.planter.utils.LogUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by peng on 2017/3/18.
 */

public class PlanterMainActivity extends LaunchBaseActivity {

    private FrameView mFrameView;
//    private PushHandler mPushHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initOthers();
    }

    private void initOthers(){
//        mPushHandler = new PushHandler(getApplicationContext());
    }

    private void initViews(){
        mFrameView = new FrameView(this);
        mFrameView.init();
    }


    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventRecieved(MsgEvent event){
        Log.e("ppp", "onMessage: " + event.getMsg() + "obj: " + event.obj);
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
