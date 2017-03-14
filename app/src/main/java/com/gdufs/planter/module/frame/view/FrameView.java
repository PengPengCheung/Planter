package com.gdufs.planter.module.frame.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.frame.FrameCourseFragment;
import com.gdufs.planter.module.frame.ItemFragment;
import com.gdufs.planter.module.frame.adapter.ViewPagerAdapter;

/**
 * Created by peng on 2017/3/13.
 */

public class FrameView {


    private int[] mIconResourceList = {R.drawable.selector_planter, R.drawable.selector_notification, R.drawable.selector_resource};
    private int[] mTextList = {R.string.frame_planter, R.string.frame_course_notification, R.string.frame_resource};

    private TabLayout mTabLayout;
    private AppCompatActivity mActivity;
    private ViewPager mViewPager;


    public FrameView(AppCompatActivity activity){
        mActivity = activity;
    }


    public void init(){
        mTabLayout = (TabLayout) mActivity.findViewById(R.id.tablayout_type);
        mViewPager = (ViewPager) mActivity.findViewById(R.id.viewpager_content);

        for(int i=0;i<mIconResourceList.length;i++){
//            CustomTabView tabView = new CustomTabView(mActivity);
//            View tabView = mActivity.getLayoutInflater().inflate(R.layout.layout_tab_custom, null);
//            TextView tv = (TextView) tabView.findViewById(R.id.tv_frame_description);
//            ImageView iv = (ImageView) tabView.findViewById(R.id.iv_frame_icon);
//            tv.setText(mTextList[i]);
//            iv.setImageResource(mIconResourceList[i]);
//            tabView.setImageView(mIconResourceList[i]);
//            tabView.setText(mTextList[i]);
//            tabView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.e("TAB", "click");
//                    mViewPager.setCurrentItem(mTabLayout.getSelectedTabPosition());
//                }
//            });
            mTabLayout.setTabTextColors(Color.parseColor("#9B9B9B"), Color.parseColor("#159b6f"));
//            mTabLayout.addTab(mTabLayout.newTab().setCustomView(tabView));
            mTabLayout.addTab(mTabLayout.newTab().setText(mTextList[i]).setIcon(mIconResourceList[i]));
        }

        adaptViewPager(mViewPager);
//        setTabLayoutCanClick(true);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
//        mTabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                setCustomViewStyle(tab, mIconResourceList[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//        mTabLayout.setupWithViewPager(mViewPager); // 实现自定义的TABView不能使用这个方法，而需要用到上面两句代码才能实现联动

//        mTabLayout.setClickable(true);
//        setTabLayoutCanClick(true);
//        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                mViewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
    }

    private void setCustomViewStyle(TabLayout.Tab tab, int imageResId){
        tab.setIcon(imageResId);
    }

    private void adaptViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(mActivity.getSupportFragmentManager());
        viewPagerAdapter.addFragment(ItemFragment.newInstance(Resource.MODULE_FRAME_PLANTER), mActivity.getString(R.string.frame_planter));
        viewPagerAdapter.addFragment(FrameCourseFragment.newInstance(Resource.MODULE_FRAME_NOTIFICATION), mActivity.getString(R.string.frame_course_notification));
        viewPagerAdapter.addFragment(ItemFragment.newInstance(Resource.MODULE_FRAME_RESOURCE), mActivity.getString(R.string.frame_resource));
        viewPager.setAdapter(viewPagerAdapter);
    }

    public void setTabLayoutCanClick(boolean canClick){
        int size = mTabLayout.getChildCount();
        for(int i=0;i<size;i++){
            final TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if(tab != null){
                tab.getCustomView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tab.select();
                        mViewPager.setCurrentItem(mTabLayout.getSelectedTabPosition());
                    }
                });
            }
        }



//        LinearLayout tabStrip= (LinearLayout) mTabLayout.getChildAt(0);
//        for (int i = 0; i < tabStrip.getChildCount(); i++) {
//            View tabView = tabStrip.getChildAt(i);
//            if(tabView !=null){
//                tabView.setClickable(canClick);
//            }
//        }
    }


}
