package com.gdufs.planter.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.planter.R;

/**
 * Created by peng on 2017/3/14.
 */

public class UniversalListView {

    private int mLayoutResId = R.layout.widget_recycler_view;

    private Activity mActivity;
    private View mView;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshWidget;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private LinearLayoutManager mLayoutManager;
    private ItemViewListener mItemViewListener;

    private boolean isPull = true; // 下拉刷新为true，上拉加载为false

    public UniversalListView(Activity activity, LayoutInflater inflater, ViewGroup container, Bundle savedInstancedState){
        mActivity = activity;
        mView = inflater.inflate(mLayoutResId, container, false);
        init(mView);
    }

    public void setItemViewListener(ItemViewListener l){
        mItemViewListener = l;
    }

//    public UniversalListView(Activity context){
//        init(context);
//    }
//
//    private void init(Activity activity){
//
//    }

    private void refresh(){

    }

    public View getUniversalListView(){
        return mView;
    }

    private void init(View view){
        mSwipeRefreshWidget = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
        mSwipeRefreshWidget.setColorSchemeResources(R.color.primary,
                R.color.primary_dark, R.color.primary_light,
                R.color.accent);
        mSwipeRefreshWidget.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });//实现onRefresh方法，进行刷新

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(mActivity);
        mRecyclerView.setLayoutManager(mLayoutManager);//为RecyclerView指定布局管理对象


        mRecyclerView.setItemAnimator(new DefaultItemAnimator());//设置动画

        mRecyclerView.addItemDecoration(new DividerItemDecoration(
                mActivity, DividerItemDecoration.VERTICAL_LIST));

        if(mRecyclerViewAdapter == null){
            mRecyclerViewAdapter = new RecyclerViewAdapter(mActivity);
        }

        mRecyclerViewAdapter.setOnItemViewListener(new RecyclerViewAdapter.OnItemViewListener() {
            @Override
            public RecyclerView.ViewHolder onCreateItemViewHolder(Context context) {

                ItemViewHolder viewHolder = null;
                if(mItemViewListener != null){
                    viewHolder = (ItemViewHolder) mItemViewListener.createItemViewHolder(context);
                }
//                View v = LayoutInflater.from(context).inflate(R.layout.fragment_course_attendance_item, null);
//                ItemViewHolder viewHolder = new ItemViewHolder(v);
                return viewHolder;
//                return null;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder) {
                if(mItemViewListener != null){
                    mItemViewListener.setItemViewContent(holder);
                }
//            ((ItemViewHolder) holder).tvTitle.setText(audio.getAudioTitle());
//            ((ItemViewHolder)holder).tvDesc.setText(audio.getAudioDate());
//            ImageLoaderUtils.display(mContext, ((ItemViewHolder)holder).ivAudioImg, audio.getAudioImageUrl());
            }
        });
        mRecyclerViewAdapter.setOnItemClickListener(mOnItemClickListener);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        //设置上拉加载的监听器
        mRecyclerView.addOnScrollListener(mOnScrollListener);
    }

    private RecyclerViewAdapter.OnItemClickListener mOnItemClickListener = new RecyclerViewAdapter.OnItemClickListener() {

        @Override
        public void onItemClick(View view, int position) {
//            ((MainActivity) getActivity()).setPlayingAudio(mData.get(position), position);
        }
    };

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {

        private int lastVisibleItem;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE
                    && lastVisibleItem + 1 == mRecyclerViewAdapter.getItemCount()
                    && mRecyclerViewAdapter.isShowFooter()) {
                //加载更多
//                mPresenter.loadAudioList("123", mType);
                isPull = false;
            }
        }
    };

    public interface ItemViewListener {
        RecyclerView.ViewHolder createItemViewHolder(Context context);
        void setItemViewContent(RecyclerView.ViewHolder holder);
    }
}
