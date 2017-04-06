package com.gdufs.planter.module.attendance.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.planter.R;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.attendance.presenter.AttendancePresenter;
import com.gdufs.planter.widget.UniversalListView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by peng on 2017/3/16.
 * 针对于考勤这个Fragment的View，负责管理这个Fragment所包含的各种子View，以免Fragment类中包含太多视图处理方面的逻辑
 *
 */

public class AttendanceView implements ModuleBaseView {

    private UniversalListView mView;
    private Activity mActivity;


    public AttendanceView(Activity activity, LayoutInflater inflater, ViewGroup container, Bundle savedInstancedState){
        mActivity = activity;
        mView = new UniversalListView(activity, inflater, container, savedInstancedState);
        initParams();
        setListeners();
    }

    private void setListeners(){
        mView.setItemViewListener(new UniversalListView.ItemViewListener() {

            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.fragment_course_attendance_item, null);
                AttendanceItemView mItemView = new AttendanceItemView(view, context);
                return mItemView;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder, int pos) {
                AttendanceViewModel model = (AttendanceViewModel) mView.getAdapter().getData().get(pos);
                ((AttendanceItemView)holder).setViews(model);
            }
        });

        mView.setRefreshListener(new UniversalListView.OnUniversalListViewRefreshListener() {
            @Override
            public void refresh() {
                showProgress(true);
                AttendancePresenter.getInstance().requestMoreAttendanceInfo();
            }
        });
    }

    private void initParams(){
        List<BaseViewModel> mModelList = new LinkedList<>();
        AttendancePresenter.getInstance().registerView(this);
        mModelList.addAll(getViewModelDataList());
        mView.getAdapter().clearData();
        mView.getAdapter().addData(mModelList);
    }

    public View getUniversalListView(){
        return mView.getUniversalListView();
    }


    private List<BaseViewModel> getViewModelDataList(){
        return AttendancePresenter.getInstance().readAllViewModelToList(Resource.MODULE_COURSE_ATTENDANCE_NAME);
    }

    @Override
    public void update(BaseViewModel model) {
//        AttendanceViewModel m = (AttendanceViewModel) model;
//        mView.getAdapter().addData(0, m);

        mView.getAdapter().clearData();
        mView.getAdapter().addData(getViewModelDataList());
    }

    private void showProgress(boolean show){
        mView.showProgress(show);
        mView.getAdapter().clearData();
        mView.getAdapter().addData(getViewModelDataList());
    }

    @Override
    public void onResponseSuccess(DataResponse response) {
        showProgress(false);

    }

    @Override
    public void onResponseFailure(Exception e) {
        showProgress(false);
    }
}
