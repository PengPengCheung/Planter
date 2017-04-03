package com.gdufs.planter.module.frame.view;

import android.database.DataSetObserver;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.gdufs.planter.R;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.frame.FrameCourseFragment;
import com.gdufs.planter.module.frame.FramePlanterFragment;
import com.gdufs.planter.module.frame.FrameResourceFragment;
import com.gdufs.planter.module.frame.ItemFragment;
import com.gdufs.planter.module.frame.adapter.ViewPagerAdapter;
import com.gdufs.planter.module.frame.presenter.FrameViewPresenter;
import com.gdufs.planter.module.planter.model.PlanterViewModel;
import com.gdufs.planter.utils.LogUtil;

import java.util.LinkedList;

/**
 * Created by peng on 2017/3/13.
 */

public class FrameView implements ModuleBaseView{


    private int[] mIconResourceList = {R.drawable.selector_planter, R.drawable.selector_notification, R.drawable.selector_resource};
    private int[] mTextList = {R.string.frame_planter, R.string.frame_course_notification, R.string.frame_resource};

    private TabLayout mTabLayout;
    private AppCompatActivity mActivity;
    private ViewPager mViewPager;
    private Spinner mSpinner;


    public FrameView(AppCompatActivity activity){
        mActivity = activity;
    }


    public void init(){
        mTabLayout = (TabLayout) mActivity.findViewById(R.id.tablayout_type);
        mViewPager = (ViewPager) mActivity.findViewById(R.id.viewpager_content);
        mSpinner = (Spinner) mActivity.findViewById(R.id.sp_title_bar);

        initParams();
        initTitleBar();
        initViewPagerAndTabLayout();
    }

    private void initParams(){
        FrameViewPresenter.getInstance().registerView(this);
    }

    private void initViewPagerAndTabLayout(){
        for(int i=0;i<mIconResourceList.length;i++){
            mTabLayout.setTabTextColors(Color.parseColor("#9B9B9B"), Color.parseColor("#159b6f"));
            mTabLayout.addTab(mTabLayout.newTab().setText(mTextList[i]).setIcon(mIconResourceList[i]));
        }

        adaptViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
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
    }

    private LinkedList<String> getSpinnerData(){
        String[] arrs = mActivity.getResources().getStringArray(R.array.spingarr);
        LinkedList<String> linkedList = new LinkedList<>();
        for(int i=0;i<arrs.length;i++){
            linkedList.add(arrs[i]);
        }
        return linkedList;
//        return new LinkedList<>();
    }

    private void initTitleBar(){
        // 建立数据源
        final LinkedList<String> mItems = getSpinnerData();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(mActivity, android.R.layout.simple_spinner_item, mItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mActivity, mItems.get(position), Toast.LENGTH_SHORT).show();
                FrameViewPresenter.getInstance().getStudentCourseInfoFromServer(mItems.get(position), mActivity);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setCustomViewStyle(TabLayout.Tab tab, int imageResId){
        tab.setIcon(imageResId);
    }

    private void adaptViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(mActivity.getSupportFragmentManager());
        viewPagerAdapter.addFragment(FramePlanterFragment.newInstance(Resource.MODULE_FRAME_PLANTER), mActivity.getString(R.string.frame_planter));
        viewPagerAdapter.addFragment(FrameCourseFragment.newInstance(Resource.MODULE_FRAME_NOTIFICATION), mActivity.getString(R.string.frame_course_notification));
        viewPagerAdapter.addFragment(FrameResourceFragment.newInstance(Resource.MODULE_FRAME_RESOURCE), mActivity.getString(R.string.frame_resource));
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(2);
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


    @Override
    public void update(BaseViewModel model) {
        if(mSpinner == null){
            LogUtil.e("ppppp", "spinner null");
            return;
        }
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) mSpinner.getAdapter();
        PlanterViewModel viewModel = (PlanterViewModel) model;
        String courseName = viewModel.getmCourseName();
        LogUtil.e("pppppp", "courseName: " + courseName);
        adapter.add(courseName);
        int pos = adapter.getPosition(courseName);
        mSpinner.setSelection(pos, true);
    }

    @Override
    public void onResponseSuccess(DataResponse response) {

    }

    @Override
    public void onResponseFailure(Exception e) {

    }
}
