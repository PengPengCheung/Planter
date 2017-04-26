package com.gdufs.planter.module.summary.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.gdufs.planter.R;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.module.summary.model.SummaryViewModel;
import com.gdufs.planter.module.summary.presenter.SummaryPresenter;
import com.gdufs.planter.utils.CommonUtil;
import com.gdufs.planter.widget.LoadingDialog;
import com.gdufs.planter.widget.UniversalListView;

import java.util.List;

/**
 * Created by peng on 2017/3/20.
 */

public class SummaryView implements ModuleBaseView{

    private static final String TAG = SummaryView.class.getSimpleName();

    UniversalListView mListView;
    Activity mActivity;
    private LoadingDialog mLoadingDialog;

    public SummaryView(Activity activity){
        mActivity = activity;
        View view = LayoutInflater.from(activity).inflate(R.layout.widget_recycler_view, null);
        mListView = new UniversalListView(activity, view);
        mLoadingDialog = new LoadingDialog(mActivity);
        initParams();
        setListeners();

    }

    private void setListeners(){
        mListView.setItemViewListener(new UniversalListView.ItemViewListener() {
            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.fragment_course_summary_item, null);
                SummaryItemView itemView = new SummaryItemView(view, context);
                return itemView;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder, int pos) {
                int size = mListView.getAdapter().getData().size();
                if(pos >= size){
                    return;
                }

                SummaryViewModel model = (SummaryViewModel) mListView.getAdapter().getData().get(pos);
                SummaryItemView itemView = (SummaryItemView) holder;
                itemView.setViews(model);
                setItemViewListener(itemView, pos);
            }
        });


    }

    private void initParams(){
        SummaryPresenter.getInstance().registerView(this);
        if(mListView != null){
            mListView.getAdapter().clearData();
            mListView.getAdapter().addData(getViewModelDataList());
        }
    }

    public View getUniversalView(){
        return mListView.getUniversalListView();
    }

    private List<BaseViewModel> getViewModelDataList(){
        return SummaryPresenter.getInstance().readAllViewModelToList(CommonUtil.getCurrentSelectedCourseId(mActivity));
    }

    @Override
    public void update(BaseViewModel model) {
        dismissLoadingDialog();
        if(mListView != null){
            mListView.getAdapter().clearData();
            mListView.getAdapter().addData(getViewModelDataList());
        }


//        SummaryViewModel model1 = (SummaryViewModel) model;
//        LogUtil.e(TAG, "summary bonus: " + model1.getmSummaryBonusNum());
//        mListView.getAdapter().addData(model);
    }

    private void dismissLoadingDialog(){
        if(mLoadingDialog != null){
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public void onResponseSuccess(DataResponse response) {
//        dismissLoadingDialog();
        update(new BaseViewModel());

    }

    @Override
    public void onResponseFailure(Exception e) {

    }

    public void setItemViewListener(SummaryItemView itemView, int pos) {
        // 默认只能填写最新的反馈
//        if(pos != 0){
        if(mListView == null || itemView == null){
            return;
        }

        final SummaryViewModel viewModel = (SummaryViewModel) mListView.getAdapter().getData().get(pos);
            itemView.setOnSendSummaryListener(new SummaryItemView.OnSendSummaryListener() {
                @Override
                public void sendSummary(String summary) {
                    if(mLoadingDialog != null){
                        mLoadingDialog.show();
                    }
                    SummaryPresenter.getInstance().sendSummary(summary, viewModel.getmSummaryId(), mActivity);
                }
            });
//        }

    }
}
