package com.gdufs.planter.module.interaction.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.gdufs.planter.R;
import com.gdufs.planter.widget.UniversalListView;

/**
 * Created by peng on 2017/3/17.
 */

public class ClassInteractionView {

    UniversalListView mListView;
    InteractionItemView mItemView;

    private Activity mActivity;

    public ClassInteractionView(Activity activity){
        mActivity = activity;
        initViews();

    }

    private void initViews(){
        mListView = new UniversalListView(mActivity, R.id.swipe_refresh_widget_interaction, R.id.recycle_view_interaction);
        mListView.setItemViewListener(new UniversalListView.ItemViewListener() {
            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.layout_interaction_item, null);
                mItemView = new InteractionItemView(view);
                return mItemView;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder) {
                ((InteractionItemView)holder).setViews();
            }
        });
    }
}
