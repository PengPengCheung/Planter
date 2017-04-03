package com.gdufs.planter;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdufs.planter.utils.AnimUtil;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.TimeUtil;

/**
 * Created by peng on 2017/4/3.
 */

public class FocusActivity extends AppCompatActivity {

    private static final String TAG = FocusActivity.class.getSimpleName();

    private static int COUNT_DOWN_TIME = 60 * 1000;

    private CountDownTimer mTimer;
    private TextView mTVCountDown;
    private ImageView mIVFocusing;
    private PowerManager.WakeLock mWakeLock;
    PowerManager pm;
    private boolean isCountDownFinished = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_keeping);
        initViews();

        init();
    }

    private void initViews() {
        mTVCountDown = (TextView) findViewById(R.id.tv_focus_time_clock);
        mIVFocusing = (ImageView) findViewById(R.id.iv_focus_waiting);

        AnimUtil.setLinearRotationAnimByGivenDuration(mIVFocusing, R.anim.focus_wait_rotate_anim, COUNT_DOWN_TIME);
    }

    private void init() {
        initScreen();
        mTimer = new CountDownTimer(COUNT_DOWN_TIME, TimeUtil.ONE_SECOND_MILLIS) {
            @Override
            public void onTick(long millisUntilFinished) {

                String timeStr = TimeUtil.getTimeText((int)millisUntilFinished);
                LogUtil.e(TAG, timeStr);
                mTVCountDown.setText(timeStr);
            }

            @Override
            public void onFinish() {
                LogUtil.e(TAG, "finish");
                isCountDownFinished = true;
                finish();
            }
        };
        isCountDownFinished = false;
        mTimer.start();
    }

    private void initScreen(){
        pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, TAG);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWakeLock.acquire();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(pm.isScreenOn()){
            if(!isCountDownFinished){
                focusFail();
            }
        } else {
            focusContinue();
        }

        if(mWakeLock != null && mWakeLock.isHeld()){
            mWakeLock.release();
        }
    }

    @Override
    protected void onDestroy() {
        unInit();
        super.onDestroy();
    }

    private void unInit(){
        if(mTimer != null){
            mTimer.cancel();
        }

        if(mWakeLock != null){
            if(mWakeLock.isHeld()){
                mWakeLock.release();
            }
        }

        AnimUtil.stopAnim(mIVFocusing);
    }

    private void focusFail(){
        LogUtil.e(TAG, "focusFail");
        mTimer.cancel();
        AnimUtil.stopAnim(mIVFocusing);
    }

    private void focusContinue(){
        LogUtil.e(TAG, "focusContinue");
    }
}
