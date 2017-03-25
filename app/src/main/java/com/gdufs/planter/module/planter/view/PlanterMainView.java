package com.gdufs.planter.module.planter.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.planter.PlanterDetailActivity;
import com.gdufs.planter.R;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.planter.presenter.PlanterMainPresenter;
import com.gdufs.planter.module.planter.model.PlanterViewModel;
import com.gdufs.planter.widget.RecyclerViewAdapter;
import com.gdufs.planter.widget.UniversalListView;

import java.util.List;

/**
 * Created by peng on 2017/3/24.
 */

public class PlanterMainView implements ModuleBaseView{

    private UniversalListView mListView;

    private Activity mActivity;

    public PlanterMainView(Activity activity, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mActivity = activity;
        mListView = new UniversalListView(mActivity, inflater, container, savedInstanceState);
        initParams();
        setListeners();

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
                }

            }
        });


        mListView.getAdapter().setFooterViewListener(new RecyclerViewAdapter.OnFooterViewListener() {
            @Override
            public RecyclerView.ViewHolder onCreateFooterViewHolder(Context context, View view) {
                PlanterMainFooterView footerView = new PlanterMainFooterView(view, context);
                return footerView;
            }
        });

        mListView.getAdapter().setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(mActivity, PlanterDetailActivity.class);
                mActivity.startActivity(intent);
//                getActivity().finish();
            }
        });
    }

    private void initParams(){
        PlanterMainPresenter.getInstance().registerView(this);
        mListView.showProgress(false);
        mListView.getAdapter().setFooterViewRes(R.layout.widget_layout_footer_planter_main);
        mListView.getAdapter().addData(PlanterMainPresenter.getInstance().readAllViewModelToList(Resource.MODULE_PLANTER_NAME));
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
