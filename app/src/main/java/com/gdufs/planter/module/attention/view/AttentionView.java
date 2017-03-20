package com.gdufs.planter.module.attention.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.planter.R;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attention.model.AttentionViewModel;
import com.gdufs.planter.module.attention.presenter.AttentionPresenter;
import com.gdufs.planter.widget.UniversalListView;

/**
 * Created by peng on 2017/3/20.
 */

public class AttentionView implements ModuleBaseView{

    UniversalListView mView;

    public AttentionView(Activity activity, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mView = new UniversalListView(activity, inflater, container, savedInstanceState);
        initParams();
        setListeners();
    }

    public View getUniversalListView(){
        return mView.getUniversalListView();
    }

    public void setListeners(){
        mView.setItemViewListener(new UniversalListView.ItemViewListener() {

            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.fragment_course_attention_item, null);
                AttentionItemView itemView = new AttentionItemView(view, context);
                return itemView;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder, int pos) {
                AttentionViewModel model = (AttentionViewModel) mView.getAdapter().getData().get(pos);
                ((AttentionItemView) holder).setViews(model);
            }
        });
    }

    public void initParams(){
        AttentionPresenter.getInstance().registerView(this);
        mView.getAdapter().addData(AttentionPresenter.getInstance().readAllViewModelToList(Resource.MODULE_COURSE_ATTENTION_NAME));
    }

    @Override
    public void notifyUpdate(BaseViewModel model) {
        mView.getAdapter().addData(model);
    }

    @Override
    public void onResponseSuccess(DataResponse response) {

    }

    @Override
    public void onResponseFailure(Exception e) {

    }
}
