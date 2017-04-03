package com.gdufs.planter.module.resource.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.gdufs.planter.R;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.module.resource.presenter.ResourcePresenter;
import com.gdufs.planter.widget.UniversalListView;

/**
 * Created by peng on 2017/3/27.
 */

public class FrameResourceView implements ModuleBaseView {

    private UniversalListView mListView;
    private Activity mActivity;

    public FrameResourceView(Activity activity, View view){
        mActivity = activity;
        initViews(view);
        setListeners();
    }

    private void setListeners(){
        mListView.setItemViewListener(new UniversalListView.ItemViewListener() {
            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.fragment_resource_item, null);
                FrameResourceItemView itemView = new FrameResourceItemView(context, view);
                setItemViewListeners(itemView);
                return itemView;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder, int pos) {

            }
        });
    }

    private void setItemViewListeners(FrameResourceItemView itemView){
        itemView.setOnDownloadListener(new FrameResourceItemView.OnDownloadListener() {
            @Override
            public void download() {
                ResourcePresenter.getInstance().downloadFile();
            }
        });
    }

    private void initViews(View view){
        mListView = new UniversalListView(mActivity, view);

    }

    public View getUniversalListView(){
        return mListView.getUniversalListView();
    }

    @Override
    public void update(BaseViewModel model) {

    }

    @Override
    public void onResponseSuccess(DataResponse response) {

    }

    @Override
    public void onResponseFailure(Exception e) {

    }
}
