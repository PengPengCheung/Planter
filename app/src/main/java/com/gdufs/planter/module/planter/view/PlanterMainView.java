package com.gdufs.planter.module.planter.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.gdufs.planter.PlanterDetailActivity;
import com.gdufs.planter.R;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.planter.PlanterDataManager;
import com.gdufs.planter.module.planter.PlanterViewSignal;
import com.gdufs.planter.module.planter.presenter.PlanterMainPresenter;
import com.gdufs.planter.module.planter.model.PlanterViewModel;
import com.gdufs.planter.widget.LoadingDialog;
import com.gdufs.planter.widget.MaterialDialog;
import com.gdufs.planter.widget.RecyclerViewAdapter;
import com.gdufs.planter.widget.UniversalListView;

import java.util.List;

/**
 * Created by peng on 2017/3/24.
 */

public class PlanterMainView implements ModuleBaseView{

    private UniversalListView mListView;

    private MaterialDialog mDialog;

    private Activity mActivity;

    private LoadingDialog mLoadingDialog;

    public PlanterMainView(Activity activity, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mActivity = activity;
        mListView = new UniversalListView(mActivity, inflater, container, savedInstanceState);

        initParams();
        setListeners();
        initDialog();
    }

    private void initDialog() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.layout_dialog_view_submit_course_code, null);
        final EditText editCourseCodeInput = (EditText) view.findViewById(R.id.edit_course_code_input);

        mDialog = new MaterialDialog(mActivity)
                .setTitle("填写课程码")
                .setContentView(view)
                .setPositiveButton("提交",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String courseCode = editCourseCodeInput.getText().toString().trim();
                                if(!TextUtils.isEmpty(courseCode)){
                                    sendCourseCode(courseCode);
                                } else {
                                    Toast.makeText(mActivity, "请输入课程码", Toast.LENGTH_SHORT).show();
                                }

                                editCourseCodeInput.setText("");
                            }
                        });
        mDialog.setCanceledOnTouchOutside(true);

        mLoadingDialog = new LoadingDialog(mActivity);
    }

    private void setItemViewListener(PlanterMainItemView itemView, final PlanterViewModel model){
        if(itemView != null){
            itemView.setChildViewListener(new OnChildViewActionListener() {
                @Override
                public void onAction(int planterAction) {
                    switch (planterAction){
                        case PlanterViewSignal.MAIN_ITEM_PLANT:{
                            PlanterMainPresenter.getInstance().plant(model);
                        }
                        break;
                        case PlanterViewSignal.MAIN_ITEM_JUMP_TO_DETAIL_ACTIVITY:{
                            Intent intent = new Intent(mActivity, PlanterDetailActivity.class);
                            intent.putExtra(Resource.KEY.KEY_COURSE_ID, model.getmCourseId());
                            mActivity.startActivity(intent);
                        }
                        break;
                    }


                }
            });
        }
    }

    private void setListeners(){
        mListView.getAdapter().setIsShowFooter(true);
        mListView.setItemViewListener(new UniversalListView.ItemViewListener() {
            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.fragment_planter_item, null);
                PlanterMainItemView itemView = new PlanterMainItemView(view, context);
                return itemView;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder, int pos) {
                PlanterMainItemView itemView = (PlanterMainItemView) holder;
                List<PlanterViewModel> modelList = mListView.getAdapter().getData();
                if(modelList != null && pos < modelList.size()){
                    PlanterViewModel model = modelList.get(pos);
                    itemView.setViews(model, pos, mListView.getAdapter().getItemCount());
                    setItemViewListener(itemView, model);
                }

            }
        });


        mListView.getAdapter().setFooterViewListener(new RecyclerViewAdapter.OnFooterViewListener() {
            @Override
            public RecyclerView.ViewHolder onCreateFooterViewHolder(Context context, View view) {
                PlanterMainFooterView footerView = new PlanterMainFooterView(view, context);
                footerView.setOnChildViewActionListener(new OnChildViewActionListener() {
                    @Override
                    public void onAction(int planterAction) {
                        showDialog();
                    }
                });
                return footerView;
            }
        });

        mListView.getAdapter().setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Intent intent = new Intent(mActivity, PlanterDetailActivity.class);
//                mActivity.startActivity(intent);
            }
        });
    }

    public void showLoadingDialog(){
        if(mLoadingDialog != null){
            mLoadingDialog.show();
        }
    }

    public void dismissLoadingDialog(){
        if(mLoadingDialog != null){
            mLoadingDialog.dismiss();
        }
    }

    private void sendCourseCode(String courseCode){
        showLoadingDialog();
        PlanterMainPresenter.getInstance().sendCourseCode(courseCode, mActivity);
    }

    private void initParams(){
        PlanterMainPresenter.getInstance().registerView(this);
        PlanterDataManager.getInstance().registerPresenter(PlanterMainPresenter.getInstance());
        mListView.showProgress(false);
        mListView.getAdapter().setFooterViewRes(R.layout.widget_layout_footer_planter_main);
        mListView.getAdapter().clearData();
        mListView.getAdapter().addData(readModelDataList());
    }

    public View getUniversalListView(){
       return mListView.getUniversalListView();
    }


    public void showDialog(){
        if(mDialog != null){
            mDialog.show();
        }
    }

    public void dismissDialog(){
        if(mDialog != null){
            mDialog.dismiss();
        }
    }

    private List<BaseViewModel> readModelDataList(){
        return PlanterMainPresenter.getInstance().readAllViewModelToList(Resource.MODULE_PLANTER_NAME);
    }

    @Override
    public void update(BaseViewModel model) {
        dismissDialog();
        dismissLoadingDialog();
        if(mListView != null){
            mListView.getAdapter().clearData();
            mListView.getAdapter().addData(readModelDataList());
        }
    }

    @Override
    public void onResponseSuccess(DataResponse response) {
        update((PlanterViewModel)response.getData());

    }

    @Override
    public void onResponseFailure(Exception e) {
        dismissDialog();
        dismissLoadingDialog();
        Toast.makeText(mActivity, "已添加该课程", Toast.LENGTH_SHORT).show();

    }
}
