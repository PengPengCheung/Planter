package com.gdufs.planter.module.frame.view;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;

import com.gdufs.planter.R;

/**
 * Created by peng on 2017/3/13.
 */

public class FrameView {


    private int[] mIconResourceList = {R.drawable.planter_light, R.drawable.notification_light, R.drawable.resource_light};
    private int[] mTextList = {R.string.frame_planter, R.string.frame_course_notification, R.string.frame_resource};

    private TabLayout mTabLayout;
    private Activity mActivity;


    public FrameView(Activity activity){
        mActivity = activity;
    }


    public void init(){
        mTabLayout = (TabLayout) mActivity.findViewById(R.id.tablayout_type);
        for(int i=0;i<mIconResourceList.length;i++){
            CustomTabView tabView = new CustomTabView(mActivity);
            tabView.setImageView(mIconResourceList[i]);
            tabView.setText(mTextList[i]);
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(tabView));
        }

    }


}
