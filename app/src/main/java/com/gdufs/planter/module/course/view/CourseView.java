package com.gdufs.planter.module.course.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.course.fragment.CourseFragment;
import com.gdufs.planter.module.frame.adapter.ViewPagerAdapter;

/**
 * Created by peng on 2017/3/14.
 */

public class CourseView {

    private ViewPagerAdapter mAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private static int[] TYPE_LIST = {Resource.MODULE_COURSE_ATTENDANCE, Resource.MODULE_COURSE_ATTENTION, Resource.MODULE_COURSE_SUMMARY, Resource.MODULE_COURSE_HOMEWORK, Resource.MODULE_COURSE_GROUP, Resource.MODULE_COURSE_OTHERS};
    private static int[] STRING_LIST = {R.string.course_attendance, R.string.course_attention, R.string.course_summary, R.string.course_homework, R.string.course_group, R.string.course_others};
    private Fragment mParent;

    private void initAdapter(ViewPager viewPager, int[] typeList, int[] strList){
        mAdapter = new ViewPagerAdapter(mParent.getChildFragmentManager());
        for(int i=0;i<typeList.length;i++){
            mAdapter.addFragment(CourseFragment.newInstance(typeList[i]), mParent.getString(strList[i]));
        }
        viewPager.setAdapter(mAdapter);
    }

    public CourseView(View view, Fragment parent){
        mParent = parent;
        init(view);
    }

    private void init(View view){
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager_course_function);
        mTabLayout = (TabLayout) view.findViewById(R.id.tablayout_course_function);
        initAdapter(mViewPager, TYPE_LIST, STRING_LIST);
        for(int i=0;i<STRING_LIST.length;i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(STRING_LIST[i]));
        }
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
