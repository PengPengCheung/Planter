package com.gdufs.planter.module.frame;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.planter.R;
import com.gdufs.planter.module.frame.view.FrameResourceHolder;
import com.gdufs.planter.widget.UniversalListView;

/**
 * Created by peng on 2017/3/15.
 */

public class FrameResourceFragment extends Fragment {

    UniversalListView mListView;

    public static FrameResourceFragment newInstance(int type) {
        FrameResourceFragment fragment = new FrameResourceFragment();
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
//        View view = inflater.inflate(R.layout.fragment_tab_view, null);
//        CourseView courseView = new CourseView(view, this);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.widget_recycler_view, null);
        mListView = new UniversalListView(getActivity(), view);
        mListView.setItemViewListener(new UniversalListView.ItemViewListener() {
            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.fragment_resource_item, null);
                return new FrameResourceHolder(view);
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder, int pos) {

            }
        });

        return mListView.getUniversalListView();
    }
}
