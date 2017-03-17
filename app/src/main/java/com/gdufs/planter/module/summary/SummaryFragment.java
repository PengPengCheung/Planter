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
import com.gdufs.planter.widget.UniversalListView;

/**
 * Created by peng on 2017/3/15.
 */

public class SummaryFragment extends Fragment {

    UniversalListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mListView = new UniversalListView(getActivity(), inflater, container, savedInstanceState);
        mListView.setItemViewListener(new UniversalListView.ItemViewListener() {
            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.fragment_course_summary_item, null);
                return new SummaryItemView(view, context);
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder) {

            }
        });
        return mListView.getUniversalListView();
    }
}
