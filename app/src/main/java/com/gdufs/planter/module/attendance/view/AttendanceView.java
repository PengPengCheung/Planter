package com.gdufs.planter.module.attendance.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.planter.R;
import com.gdufs.planter.widget.UniversalListView;

/**
 * Created by peng on 2017/3/16.
 * 针对于考勤这个Fragment的View，负责管理这个Fragment所包含的各种子View，以免Fragment类中包含太多视图处理方面的逻辑
 *
 */

public class AttendanceView {

    private UniversalListView mView;
    private AttendanceItemView mItemView;

    private Activity mActivity;


    public AttendanceView(Activity activity, LayoutInflater inflater, ViewGroup container, Bundle savedInstancedState){
        mActivity = activity;
        mView = new UniversalListView(activity, inflater, container, savedInstancedState);

        mView.setItemViewListener(new UniversalListView.ItemViewListener() {

            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.fragment_course_attendance_item, null);
                mItemView = new AttendanceItemView(view, context);
//                initItemListeners();
                return mItemView;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder) {
                ((AttendanceItemView)holder).setViews();
            }
        });
    }

    public View getUniversalListView(){
        return mView.getUniversalListView();
    }
}
