package com.gdufs.planter.module.frame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.planter.PlanterDetailActivity;
import com.gdufs.planter.R;
import com.gdufs.planter.module.planter.view.PlanterMainItemView;
import com.gdufs.planter.module.planter.view.PlanterMainView;
import com.gdufs.planter.widget.RecyclerViewAdapter;
import com.gdufs.planter.widget.UniversalListView;

/**
 * Created by peng on 2017/3/24.
 */

public class FramePlanterFragment extends Fragment {

    PlanterMainView mView;


    public static FramePlanterFragment newInstance(int type) {
        FramePlanterFragment fragment = new FramePlanterFragment();
        Bundle args = new Bundle();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = new PlanterMainView(getActivity(), inflater, container, savedInstanceState);

        return mView.getUniversalListView();
    }
}
