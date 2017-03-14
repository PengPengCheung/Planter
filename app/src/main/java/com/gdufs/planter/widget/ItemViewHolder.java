package com.gdufs.planter.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by peng on 2017/3/14.
 */

public abstract class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//
//        public TextView tvTitle;
//        public TextView tvDesc;
//        public ImageView ivAudioImg;
//
//

    private RecyclerViewAdapter.OnItemClickListener mOnItemClickListener;


    public abstract void findViews();

    public ItemViewHolder(View itemView) {
        super(itemView);
//            tvTitle = (TextView) itemView.findViewById(R.id.tv_audio_title);
//            tvDesc = (TextView) itemView.findViewById(R.id.tv_audio_desc);
//            ivAudioImg = (ImageView) itemView.findViewById(R.id.iv_audio_img);
        itemView.setOnClickListener(this);
        findViews();
    }

    public void setOnItemClickListener(RecyclerViewAdapter.OnItemClickListener l){
        mOnItemClickListener = l;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
//            Toast.makeText(mContext, "click", Toast.LENGTH_SHORT).show();
        //之所以不像ListView那样设置onItemClickListener监听器，是因为recyclerview不提供这样的接口。。
        //所以只能用这样的方法模拟实现onItemClick接口方法了
        if(mOnItemClickListener!=null){
            mOnItemClickListener.onItemClick(v, this.getPosition());
        }
    }
}
