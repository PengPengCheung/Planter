package com.gdufs.planter.module.homework;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.planter.R;
import com.gdufs.planter.module.homework.view.HomeworkItemView;
import com.gdufs.planter.module.homework.view.HomeworkView;
import com.gdufs.planter.widget.UniversalListView;

/**
 * Created by peng on 2017/3/14.
 */

public class HomeworkFragment extends Fragment {

    HomeworkView mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.widget_recycler_view, null);
        mView = new HomeworkView(getActivity(), view);

        return mView.getUniversalListView();
    }
}
