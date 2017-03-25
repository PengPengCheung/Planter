package com.gdufs.planter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gdufs.planter.module.planter.view.PlanterDetailView;

/**
 * Created by peng on 2017/3/21.
 */

public class PlanterDetailActivity extends AppCompatActivity {

    private PlanterDetailView mDetailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planter_score_details);
        initView();
    }

    private void initView() {
        mDetailView = new PlanterDetailView(this);
    }
}
