package com.gdufs.planter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gdufs.planter.module.interaction.view.ClassInteractionView;

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
    }

    private void init(){
        mInteractionView = new ClassInteractionView(this);
    }
}
