package com.gdufs.planter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.interaction.view.ClassInteractionView;
import com.gdufs.planter.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by peng on 2017/3/17.
 */

public class ClassInteractionActivity extends AppCompatActivity {

    ClassInteractionView mInteractionView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction);

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
                    AttendanceViewModel model = JsonUtil.deserialize(msg, AttendanceViewModel.class);
//                    List<AttendanceViewModel> list = new ArrayList<>();
//                    list.add(model);
                    mInteractionView.addViewData(model);
                    if(mInteractionView != null) {
                        mInteractionView.showDialog();
                    }
                }
            }
        }
    }



    private void init(){
        mInteractionView = new ClassInteractionView(this);
    }
}
