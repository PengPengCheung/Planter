package com.gdufs.planter.module.course.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.planter.R;
import com.gdufs.planter.module.course.view.AttendanceItemView;
import com.gdufs.planter.widget.RecyclerViewAdapter;
import com.gdufs.planter.widget.UniversalListView;

/**
 * Created by peng on 2017/3/15.
 */

public class AttendanceFragment extends Fragment {

    UniversalListView mView;
    AttendanceItemView mItemView;


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
                View view = LayoutInflater.from(context).inflate(R.layout.fragment_course_attendance_item, null);
                mItemView = new AttendanceItemView(view, context);
                initItemListeners();
                return mItemView;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder) {
                ((AttendanceItemView)holder).setViews();
            }
        });

        return mView.getUniversalListView();
    }

    private void initItemListeners(){

    }
}
