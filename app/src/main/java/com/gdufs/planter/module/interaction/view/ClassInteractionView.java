package com.gdufs.planter.module.interaction.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.gdufs.planter.R;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.model.AttendanceInfo;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.attendance.presenter.AttendancePresenter;
import com.gdufs.planter.module.attendance.widget.AttendanceCodeDialog;
import com.gdufs.planter.module.attention.model.AttentionViewModel;
import com.gdufs.planter.module.attention.presenter.AttentionPresenter;
import com.gdufs.planter.module.interaction.presenter.InteractionPresenter;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.widget.UniversalListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng on 2017/3/17.
 */

public class ClassInteractionView implements ModuleBaseView {

//    AttendancePresenter mAttendancePresenter;
    UniversalListView mListView;
//    List<InteractionItemView> mItemViewList;
    private AttendanceCodeDialog mDialog;

    private Activity mActivity;

    private int pos = 0;

    public ClassInteractionView(Activity activity){
        mActivity = activity;
        mListView = new UniversalListView(mActivity, R.id.swipe_refresh_widget_interaction, R.id.recycle_view_interaction);
        init();
        initViews();
    }

    private void init(){
        InteractionPresenter.getInstance().registerView(this);
        AttendancePresenter.getInstance().registerView(this);
        AttentionPresenter.getInstance().registerView(this);
        List<BaseViewModel> list = InteractionPresenter.getInstance().readAllViewModelToList(Resource.MODULE_COURSE_INTERACTION_NAME);
        LogUtil.e("InteractionView", "list size = " + list.size());
        if(list != null && list.size() > 0){

            mListView.getAdapter().addData(list);
        }
    }

//    public void addViewData(AttendanceViewModel model){
//        mListView.getAdapter().addData(model);
//        View view = LayoutInflater.from(mActivity).inflate(R.layout.layout_interaction_item, null);
//        InteractionItemView itemView = new InteractionItemView(view, mActivity);
//        itemView.setViews(Resource.MODULE_COURSE_ATTENDANCE);
//        mItemViewList.add(itemView);
//    }

//    public void addListViewData(List<AttendanceViewModel> modelList){
//        mListView.getAdapter().addData(modelList);
//        if(modelList != null){
//            for(int i=0;i<modelList.size();i++){
//                View view = LayoutInflater.from(mActivity).inflate(R.layout.layout_interaction_item, null);
//                InteractionItemView itemView = new InteractionItemView(view, mActivity);
//                itemView.setViews(Resource.MODULE_COURSE_ATTENDANCE);
//                mItemViewList.add(itemView);
//            }
//        }
//    }



    private void initViews(){

        mDialog = new AttendanceCodeDialog(mActivity);


        mListView.setItemViewListener(new UniversalListView.ItemViewListener() {
            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                final View view = LayoutInflater.from(context).inflate(R.layout.layout_interaction_item, null);
                final InteractionItemView mItemView = new InteractionItemView(view, mActivity);
                mItemView.setAttendanceListener(new InteractionItemView.OnRequestClickListener() {
                    @Override
                    public void onRequestClick() {
                        pos = mItemView.getAdapterPosition();
                        List<BaseViewModel> list = mListView.getAdapter().getData();
                        if(list != null && !list.isEmpty()){
                            BaseViewModel model = list.get(pos);
                            int module = model.getmModuleId();
                            switch (module){
                                case Resource.MODULE_COURSE_ATTENDANCE:{
                                    AttendanceViewModel viewModel = (AttendanceViewModel) model;
                                    int status = viewModel.getmAttendanceStatus();
                                    if(status == Resource.ATTENDANCE.ATTENDANCE_STATUS_DEFAULT){
                                        showDialog();
                                        return;
                                    }
                                    showTipsByStatus(status, viewModel.getmAttendanceBonusNum());
                                }
                                break;
                                case Resource.MODULE_COURSE_ATTENTION:{

                                }
                                break;
                            }
                        }

                    }
                });

//                mItemViewList.add(mItemView);
                return mItemView;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder, int pos) {
                List<BaseViewModel> modelList = mListView.getAdapter().getData();
                if(modelList != null && pos < modelList.size()){
                    ((InteractionItemView)holder).setViews(modelList.get(pos));
                }
            }
        });


        mDialog.setOnAttendanceCodeSubmitListener(new AttendanceCodeDialog.OnAttendanceCodeSubmitListener() {

            @Override
            public void submit(String code) {

                AttendancePresenter.getInstance().sendAttendanceCode(code);

//                if(mAttendancePresenter != null){
//                    mAttendancePresenter.sendAttendanceCode(code);
//                }
            }

        });
    }

    public void showDialog(){
        if(mDialog != null){
            mDialog.show();
        }
    }

    public void dismissDialog(){
        if(mDialog != null) {
            mDialog.dismiss();
        }
    }

    private void showViewIfCheckSuccess(int bonusNum){
//        Log.e("ppp", "showViewIfCheckSuccess pos= " + pos + " list size = " + mItemViewList.size());
//        if(pos == 0){
//            mItemViewList.get(mItemViewList.size() - 1).showResponseView(bonusNum, Resource.MODULE_COURSE_ATTENDANCE);
//        } else {
//            mItemViewList.get(pos).showResponseView(bonusNum, Resource.MODULE_COURSE_ATTENDANCE);
//        }

    }

    private void showTipsByStatus(int status, int bonusNum){
        switch (status) {
            case Resource.ATTENDANCE.ATTENDANCE_STATUS_SUCCESS:{
                Toast.makeText(mActivity, "考勤成功！", Toast.LENGTH_SHORT).show();
                dismissDialog();
                showViewIfCheckSuccess(bonusNum);
            }
            break;
            case Resource.ATTENDANCE.ATTENDANCE_STATUS_FAIL:{
                Toast.makeText(mActivity, "考勤失败！", Toast.LENGTH_SHORT).show();
                dismissDialog();
            }
            break;
            case Resource.ATTENDANCE.ATTENDANCE_STATUS_NOT_IN_TIME:{
                Toast.makeText(mActivity, "不在考勤时间内！", Toast.LENGTH_SHORT).show();
            }
            break;
            case Resource.ATTENDANCE.ATTENDANCE_STATUS_ALREADY_CHECK_SUCCESS:{
                Toast.makeText(mActivity, "已经考勤！", Toast.LENGTH_SHORT).show();
            }
            break;
            case Resource.ATTENDANCE.ATTENDANCE_STATUS_CODE_ERROR:{
                Toast.makeText(mActivity, "考勤码只能是6位！", Toast.LENGTH_SHORT).show();
            }
            break;
            default:
//                Toast.makeText(mActivity, "系统异常！", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    public void onResponseSuccess(DataResponse response) {
        if(response != null) {
            BaseViewModel model = (BaseViewModel) response.getData();

            update(model);
//            AttendanceInfo info = (AttendanceInfo) response.getData();
//            if(info != null) {
//                int status = info.getmAttendanceStatus();
//                Log.e("ppp", "status: " + status);
//                int bonus = info.getmAttendanceBonusNum();
//                showTipsByStatus(status, bonus);
//            }
        }

    }

    @Override
    public void onResponseFailure(Exception exception) {

    }

    public void onReceiveAttendanceStatus(int status) {
        showTipsByStatus(status, 0);
    }

    private void modifyViewListData(List<BaseViewModel> list, BaseViewModel model, int pos){
        int module = model.getmModuleId();
        switch (module){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                AttendanceViewModel viewModel = (AttendanceViewModel) model;
                if(viewModel.getmAttendanceStatus() == Resource.ATTENDANCE.ATTENDANCE_STATUS_SUCCESS){
                    ((AttendanceViewModel) list.get(pos)).setmAttendanceStatus(Resource.ATTENDANCE.ATTENDANCE_STATUS_ALREADY_CHECK_SUCCESS);
                } else {
                    ((AttendanceViewModel) list.get(pos)).setmAttendanceStatus(viewModel.getmAttendanceStatus());
                }



//                ((AttendanceViewModel)list.get(pos)).setmAttendanceStatus(viewModel.getmAttendanceStatus());
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{}break;
        }
    }

    @Override
    public void update(BaseViewModel model) {
        dismissDialog();
        if(model == null){
            return;
        }



        int moduleId = model.getmModuleId();
        switch (moduleId){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                AttendanceViewModel viewModel = (AttendanceViewModel) model;
                InteractionPresenter.getInstance().modifyData(pos, viewModel);
                InteractionPresenter.getInstance().addDataToFile(viewModel);
                modifyViewListData(mListView.getAdapter().getData(), viewModel, pos);
                mListView.getAdapter().addData(viewModel);
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
                AttentionViewModel viewModel = (AttentionViewModel) model;
                mListView.getAdapter().addData(viewModel);
            }
            break;
        }

    }
}
