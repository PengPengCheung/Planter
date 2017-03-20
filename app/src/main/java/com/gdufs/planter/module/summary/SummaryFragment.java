package com.gdufs.planter.module.summary;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.planter.R;
import com.gdufs.planter.module.summary.view.SummaryView;
import com.gdufs.planter.widget.UniversalListView;

/**
 * Created by peng on 2017/3/15.
 */

public class SummaryFragment extends Fragment {

    private SummaryView mSummaryView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mSummaryView = new SummaryView(getActivity());
        return mSummaryView.getUniversalView();
    }
}
