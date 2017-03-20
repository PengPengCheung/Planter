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
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.summary.SummaryItemView;
import com.gdufs.planter.module.summary.model.SummaryViewModel;
import com.gdufs.planter.module.summary.presenter.SummaryPresenter;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.widget.UniversalListView;

/**
 * Created by peng on 2017/3/20.
 */

public class SummaryView implements ModuleBaseView{

    private static final String TAG = SummaryView.class.getSimpleName();

    UniversalListView mListView;

    public SummaryView(Activity activity){
        View view = LayoutInflater.from(activity).inflate(R.layout.widget_recycler_view, null);
        mListView = new UniversalListView(activity, view);
        initParams();
        setListeners();

    }

    private void setListeners(){
        mListView.setItemViewListener(new UniversalListView.ItemViewListener() {
            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.fragment_course_summary_item, null);
                SummaryItemView itemView = new SummaryItemView(view, context);
                setItemViewListener(itemView);
                return itemView;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder, int pos) {
                SummaryViewModel model = (SummaryViewModel) mListView.getAdapter().getData().get(pos);
                ((SummaryItemView) holder).setViews(model);
            }
        });


    }

    private void initParams(){
        SummaryPresenter.getInstance().registerView(this);
        mListView.getAdapter().addData(SummaryPresenter.getInstance().readAllViewModelToList(Resource.MODULE_COURSE_SUMMARY_NAME));
    }

    public View getUniversalView(){
        return mListView.getUniversalListView();
    }

    @Override
    public void update(BaseViewModel model) {
        SummaryViewModel model1 = (SummaryViewModel) model;
        LogUtil.e(TAG, "summary bonus: " + model1.getmSummaryBonusNum());
        mListView.getAdapter().addData(model);
    }

    @Override
    public void onResponseSuccess(DataResponse response) {

    }

    @Override
    public void onResponseFailure(Exception e) {

    }

    public void setItemViewListener(SummaryItemView itemView) {
        itemView.setOnSendSummaryListener(new SummaryItemView.OnSendSummaryListener() {
            @Override
            public void sendSummary(String summary) {
                SummaryPresenter.getInstance().sendSummary(summary);
            }
        });
    }
}
