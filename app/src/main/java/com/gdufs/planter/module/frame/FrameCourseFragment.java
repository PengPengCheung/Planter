package com.gdufs.planter.module.frame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.course.view.CourseView;
import com.gdufs.planter.module.frame.adapter.ViewPagerAdapter;

/**
 * Created by peng on 2017/3/14.
 */

public class FrameCourseFragment extends Fragment {

    CourseView mCourseView;

    public static FrameCourseFragment newInstance(int type) {
        FrameCourseFragment fragment = new FrameCourseFragment();
        Bundle args = new Bundle();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_course, null);
        mCourseView = new CourseView(view, this);

        return view;
    }
}
