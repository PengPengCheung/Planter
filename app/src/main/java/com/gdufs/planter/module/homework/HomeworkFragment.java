package com.gdufs.planter.module.homework;

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
 * Created by peng on 2017/3/14.
 */

public class HomeworkFragment extends Fragment {

    UniversalListView mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.widget_recycler_view, null);
        mView = new UniversalListView(getActivity(), view);
        mView.setItemViewListener(new UniversalListView.ItemViewListener() {

            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.fragment_course_homework_item, null);
                return new HomeworkItemView(view, context);
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder) {

            }
        });

        return mView.getUniversalListView();
    }
}
