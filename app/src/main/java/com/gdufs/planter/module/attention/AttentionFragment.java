package com.gdufs.planter.module.attention;

import android.content.Context;
import android.os.Bundle;
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

public class AttentionFragment extends Fragment {

    UniversalListView mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = new UniversalListView(getActivity(), inflater, container, savedInstanceState);
        mView.setItemViewListener(new UniversalListView.ItemViewListener() {

            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.fragment_course_attention_item, null);
                return new AttentionHolder(view);
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder) {

            }
        });

        return mView.getUniversalListView();
    }
}
