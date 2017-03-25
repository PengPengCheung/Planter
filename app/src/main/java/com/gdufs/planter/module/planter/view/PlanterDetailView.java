package com.gdufs.planter.module.planter.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.gdufs.planter.R;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.widget.ItemViewHolder;
import com.gdufs.planter.widget.RecyclerViewAdapter;
import com.gdufs.planter.widget.UniversalListView;

/**
 * Created by peng on 2017/3/24.
 */

public class PlanterDetailView implements ModuleBaseView {

//    private RecyclerView mRecyclerView;
    private Activity mActivity;
    private UniversalListView mListView;
    private LinearLayout mLLTreeDetailBottom;
    private RelativeLayout mRLTreeDetailItem;
//    private RelativeLayout mRLTreeDetailBottomLayout;

    public PlanterDetailView(Activity activity){
        mActivity = activity;
        initViews();
    }

    private void initViews() {
        mListView = new UniversalListView(mActivity, R.id.tree_details_swipe_refresh_widget, R.id.tree_details_recycle_view);
//        mRLTreeDetailBottomLayout = (RelativeLayout) mActivity.findViewById(R.id.tree_details_layout_bottom);
//        mRLTreeDetailBottomLayout.setVisibility(View.GONE);

        mLLTreeDetailBottom = (LinearLayout) mActivity.findViewById(R.id.ll_tree_detail_bottom);
        mLLTreeDetailBottom.setVisibility(View.GONE);

        mRLTreeDetailItem = (RelativeLayout) mLLTreeDetailBottom.findViewById(R.id.ll_tree_details_item_selected);

        mRLTreeDetailItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLLTreeDetailBottom.setVisibility(View.GONE);
                mListView.setVisibility(View.VISIBLE);
            }
        });

        mListView.getAdapter().setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mListView.setVisibility(View.GONE);
                mLLTreeDetailBottom.setVisibility(View.VISIBLE);
            }
        });


        mListView.setItemViewListener(new UniversalListView.ItemViewListener() {
            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.layout_tree_details_item_rank, null);
                PlanterDetailItemView itemView = new PlanterDetailItemView(view, context);
//                setItemListener(itemView);
                return itemView;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder, int pos) {
                PlanterDetailItemView itemView = ((PlanterDetailItemView)holder);
                itemView.setViews();
//                itemView.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(View view, int position) {
//
//                    }
//                });
            }
        });

    }

    private void setItemListener(ItemViewHolder itemView) {
        itemView.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mListView.setVisibility(View.GONE);
                mLLTreeDetailBottom.setVisibility(View.VISIBLE);
            }
        });
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
