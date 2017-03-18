package com.gdufs.planter.module.group.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.planter.R;
import com.gdufs.planter.module.group.view.GroupView;

/**
 * Created by peng on 2017/3/17.
 */

public class GroupFragment extends Fragment {

    private GroupView mGroupView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_group_item, null);
        mGroupView = new GroupView(getActivity(), view);
        return view;
    }
}
