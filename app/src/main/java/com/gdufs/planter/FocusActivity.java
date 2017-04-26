package com.gdufs.planter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdufs.planter.common.MsgEvent;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attention.model.AttentionGoingModel;
import com.gdufs.planter.module.attention.model.AttentionViewModel;
import com.gdufs.planter.utils.AnimUtil;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.PreferenceHelper;
import com.gdufs.planter.utils.TimeUtil;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by peng on 2017/4/3.
 */

public class FocusActivity extends AppCompatActivity {

    private static final String TAG = FocusActivity.class.getSimpleName();

    private static int COUNT_DOWN_TIME = 60 * 1000;
    private int usedTime = -1;
    private int mStudentScore = -1;
    private String startTime = null;
    private String endTime = null;

    private CountDownTimer mTimer;
    private TextView mTVCountDown;
    private ImageView mIVFocusing;
    private EditText mEditScore;
    private PowerManager.WakeLock mWakeLock;
    PowerManager pm;
    private boolean isCountDownFinished = true;

    private AttentionViewModel model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_keeping);
        handleIntent();
        initViews();

        init();
    }

    private void handleIntent() {
        Intent intent = getIntent();
        if(intent != null){
            model = (AttentionViewModel) intent.getSerializableExtra(Resource.MODULE_COURSE_ATTENTION_NAME);
//            String duration = intent.getStringExtra(Resource.KEY.KEY_ATTENTION_DURATION);
            LogUtil.e(TAG, "AttentionViewModel");
            if(model != null){
                String duration = model.getmAttentionDuration();
                LogUtil.e(TAG, "duration: " + duration);
                COUNT_DOWN_TIME = TimeUtil.durationStrToMilliSeconds(duration);
            }
        }
    }

    private void initViews() {
        mTVCountDown = (TextView) findViewById(R.id.tv_focus_time_clock);
        mIVFocusing = (ImageView) findViewById(R.id.iv_focus_waiting);
        mEditScore = (EditText) findViewById(R.id.edit_attention_score);
        AnimUtil.setLinearRotationAnimByGivenDuration(mIVFocusing, R.anim.focus_wait_rotate_anim, COUNT_DOWN_TIME);
    }

    private void init() {


        initScreen();
        mTimer = new CountDownTimer(COUNT_DOWN_TIME, TimeUtil.ONE_SECOND_MILLIS) {
            @Override
            public void onTick(long millisUntilFinished) {
                int leftTime = (int)millisUntilFinished;
                usedTime = COUNT_DOWN_TIME - leftTime;
                String timeStr = TimeUtil.getTimeText(leftTime);
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

        startTime = TimeUtil.getCurrentTimeInENGFormat();
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
        if(isCountDownFinished){
            focusSuccess();
        }
        unInit();
        super.onDestroy();
    }

    private void focusSuccess(){
        endTime = TimeUtil.getCurrentTimeInENGFormat();
        AttentionGoingModel goingModel = constructAttentionGoingModel(Resource.ATTENTION.ATTENTION_STATUS_SUCCESS, COUNT_DOWN_TIME, mStudentScore);
        postEvent(goingModel);
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

    private AttentionGoingModel constructAttentionGoingModel(int status, int usedTime, int studentScore){
        LogUtil.e(TAG, "Attention constructAttentionGoingModel: status = " + status + ", usedTime = " + usedTime + ", studentScore = " + studentScore);
        AttentionGoingModel attentionGoingModel = new AttentionGoingModel();
        attentionGoingModel.setmAttentionStatus(status);
        attentionGoingModel.setmAttentionInsistTime(usedTime);
        attentionGoingModel.setmScore(studentScore);

        String studentId = PreferenceHelper.getInstance(this).getString(Resource.KEY.KEY_STUDENT_ID, "");
        attentionGoingModel.setmStudentId(studentId);
        String courseId = PreferenceHelper.getInstance(this).getString(Resource.KEY.KEY_COURSE_ID, "");
        attentionGoingModel.setmCourseId(courseId);
        attentionGoingModel.setmModuleId(Resource.MODULE_COURSE_ATTENTION);
        attentionGoingModel.setmAttentionBonusType(Resource.BONUS_TYPE.BONUS_WATER);
        attentionGoingModel.setmStartTime(startTime);
        attentionGoingModel.setmEndTime(endTime);
        if(status == Resource.ATTENTION.ATTENTION_STATUS_SUCCESS){
            attentionGoingModel.setmAttentionBonusNum(Resource.BONUS_NUM.ATTENTION_BONUS_NUM);
        } else {
            attentionGoingModel.setmAttentionBonusNum(-Resource.BONUS_NUM.ATTENTION_BONUS_NUM);
        }

        LogUtil.e(TAG, "AttentionViewModel is null ? ");
        if(model != null){
            LogUtil.e(TAG, "AttentionViewModel not null");
            attentionGoingModel.setmAttentionType(model.getmAttentionType());
            attentionGoingModel.setmAttentionDuration(model.getmAttentionDuration());
            attentionGoingModel.setmOpenClassId(model.getmOpenClassId());
        }

        return attentionGoingModel;
    }

    private void focusFail(){
        LogUtil.e(TAG, "focusFail");
        LogUtil.e(TAG, "focusFail 2");
        mTimer.cancel();
        AnimUtil.stopAnim(mIVFocusing);

        endTime = TimeUtil.getCurrentTimeInENGFormat();

        AttentionGoingModel attentionGoingModel = constructAttentionGoingModel(Resource.ATTENTION.ATTENTION_STATUS_FAIL, usedTime, mStudentScore);

        postEvent(attentionGoingModel);

        finish();


//        if(model != null){
//            model.setAttention
//        }
    }

    private void postEvent(AttentionGoingModel attentionGoingModel){
        MsgEvent event = new MsgEvent("AttentionEnd");
        event.what = Resource.EVENTBUS_TYPE.EVENTBUS_TYPE_FROM_ATTENTION;
        event.obj = attentionGoingModel;
        EventBus.getDefault().postSticky(event);
    }

    private void focusContinue(){
        LogUtil.e(TAG, "focusContinue");
    }


}
