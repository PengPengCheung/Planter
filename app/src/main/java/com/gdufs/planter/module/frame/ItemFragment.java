package com.gdufs.planter.module.frame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.planter.R;
import com.gdufs.planter.module.course.view.CourseView;
import com.gdufs.planter.module.frame.adapter.ViewPagerAdapter;

/**
 * Created by peng on 2017/3/13.
 */

public class ItemFragment extends Fragment {


    public static ItemFragment newInstance(int type) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_view, null);
//        CourseView courseView = new CourseView(view, this);

        return view;
    }


}
