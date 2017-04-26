package com.gdufs.planter.module.interaction.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.gdufs.planter.FocusActivity;
import com.gdufs.planter.R;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attendance.model.AttendanceViewModel;
import com.gdufs.planter.module.attendance.presenter.AttendancePresenter;
import com.gdufs.planter.module.attendance.widget.AttendanceCodeDialog;
import com.gdufs.planter.module.attention.model.AttentionViewModel;
import com.gdufs.planter.module.attention.presenter.AttentionPresenter;
import com.gdufs.planter.module.interaction.presenter.InteractionPresenter;
import com.gdufs.planter.utils.CommonUtil;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.widget.UniversalListView;

import java.util.List;

/**
 * Created by peng on 2017/3/17.
 */

public class ClassInteractionView implements ModuleBaseView {

    private UniversalListView mListView;
    private AttendanceCodeDialog mDialog;

    private static final String TAG = ClassInteractionView.class.getSimpleName();

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
        List<BaseViewModel> list = getViewModelListFromDB();
        LogUtil.e("InteractionView", "list size = " + list.size());
        if(list != null && list.size() > 0){
            mListView.getAdapter().clearData();
            mListView.getAdapter().addData(list);
        }
    }

    private void onAttendanceItemClick(BaseViewModel model){
        AttendanceViewModel viewModel = (AttendanceViewModel) model;
        int status = viewModel.getmAttendanceStatus();
        if(status == Resource.ATTENDANCE.ATTENDANCE_STATUS_DEFAULT){
            showDialog();
            return;
        }
        showAttendanceTipsByStatus(status, viewModel.getmAttendanceBonusNum());
    }

    private void onAttentionItemClick(BaseViewModel model){
        AttentionViewModel viewModel = (AttentionViewModel) model;
        int status = viewModel.getmAttentionStatus();
        if(status == Resource.ATTENTION.ATTENTION_STATUS_DEFAULT){
            AttentionViewModel attentionViewModel = (AttentionViewModel) model;
            Intent intent = new Intent(mActivity, FocusActivity.class);
            intent.putExtra(Resource.MODULE_COURSE_ATTENTION_NAME, attentionViewModel);
            LogUtil.e(TAG, "onAttentionItemClick");
            mActivity.startActivity(intent);
            return;
        }

        showAttentionTipsByStatus(status);

    }

    private void showAttentionTipsByStatus(int status) {
        switch (status){
            case Resource.ATTENTION.ATTENTION_STATUS_SUCCESS:{
                Toast.makeText(mActivity, "该专注已成功！", Toast.LENGTH_SHORT).show();
            }
            break;
            case Resource.ATTENTION.ATTENTION_STATUS_FAIL:{
                Toast.makeText(mActivity, "该专注已失败", Toast.LENGTH_SHORT).show();
            }
            break;
            case Resource.ATTENTION.ATTENTION_STATUS_NOT_IN_TIME:{
                Toast.makeText(mActivity, "不在专注时间", Toast.LENGTH_SHORT).show();
            }
            break;
            case Resource.ATTENTION.ATTENTION_STATUS_NOT_PAY_ATTENTION:{
                Toast.makeText(mActivity, "未参与本次专注", Toast.LENGTH_SHORT).show();
            }
            break;
            case Resource.ATTENTION.ATTENTION_STATUS_DEFAULT:{
            }
            break;

        }
    }


    private void initViews(){

        mDialog = new AttendanceCodeDialog(mActivity);


        mListView.setItemViewListener(new UniversalListView.ItemViewListener() {
            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                final View view = LayoutInflater.from(context).inflate(R.layout.layout_interaction_item, null);
                final InteractionItemView mItemView = new InteractionItemView(view, mActivity);
                mItemView.setOnRequestClickListener(new InteractionItemView.OnRequestClickListener() {
                    @Override
                    public void onRequestClick() {
                        pos = mItemView.getAdapterPosition();
                        List<BaseViewModel> list = mListView.getAdapter().getData();
                        if(list != null && !list.isEmpty()){
                            BaseViewModel model = list.get(pos);
                            int module = model.getmModuleId();
                            switch (module){
                                case Resource.MODULE_COURSE_ATTENDANCE:{
                                    onAttendanceItemClick(model);
                                }
                                break;
                                case Resource.MODULE_COURSE_ATTENTION:{
                                    AttentionViewModel viewModel = (AttentionViewModel) model;
                                    LogUtil.e(TAG, "viewModel AttentionType: " + viewModel.getmAttentionType());
                                    onAttentionItemClick(model);
                                }
                                break;
                            }
                        }

                    }
                });
                return mItemView;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder, int pos) {
                List<BaseViewModel> modelList = mListView.getAdapter().getData();
                LogUtil.e(TAG, "setItemViewCount: list not null? " + (modelList != null));
                LogUtil.e(TAG, "setItemViewCount: list size: " + modelList.size() + ", pos: " + pos);
                if(modelList != null && pos < modelList.size()){
                    ((InteractionItemView)holder).setViews(modelList.get(pos));
                }
            }
        });

        mListView.scrollToBottom();


        mDialog.setOnAttendanceCodeSubmitListener(new AttendanceCodeDialog.OnAttendanceCodeSubmitListener() {

            @Override
            public void submit(String code) {
                AttendanceViewModel model = (AttendanceViewModel) mListView.getAdapter().getData().get(pos);
                AttendancePresenter.getInstance().sendAttendanceCode(model, mActivity);
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

    private void showAttendanceTipsByStatus(int status, int bonusNum){
        switch (status) {
            case Resource.ATTENDANCE.ATTENDANCE_STATUS_SUCCESS:{
                Toast.makeText(mActivity, "已经考勤！", Toast.LENGTH_SHORT).show();
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
            dismissDialog();
            update(model);
        }

    }

    @Override
    public void onResponseFailure(Exception exception) {

    }

    public void onReceiveAttendanceStatus(int status) {
        showAttendanceTipsByStatus(status, 0);
    }

    private List<BaseViewModel> getViewModelListFromDB(){
        return InteractionPresenter.getInstance().readAllViewModelToList(CommonUtil.getCurrentSelectedCourseId(mActivity));
    }

    @Override
    public void update(BaseViewModel model) {
        if(mListView != null){
            mListView.getAdapter().clearData();
            mListView.getAdapter().addData(getViewModelListFromDB());
        }

    }
}
