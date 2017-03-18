package com.gdufs.planter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.interaction.view.ClassInteractionView;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.ResultCallback;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.jpush.android.api.JPushInterface;
import me.drakeet.materialdialog.MaterialDialog;

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
                    String push = bundle.getString("from");
                    Log.e("ppp", "Title : " + title + "  " + "Content : " + content + "from: " + push);
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
