package com.gdufs.planter.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdufs.planter.R;
import com.gdufs.planter.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng on 2017/3/14.
 */

public class RecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = RecyclerViewAdapter.class.getSimpleName();

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;
    private Context mContext;
    private List<T> mDataList;
    private Class mClass;
    private boolean mShowFooter = false;
    private int mFooterViewRes = R.layout.widget_recycler_view_footer;
    private OnItemClickListener mOnItemClickListener;
    private OnItemViewListener mOnItemViewListener;
    private OnFooterViewListener mOnFooterViewListener;

    public void setClass(Class t){
        mClass = t;
    }

    public RecyclerViewAdapter(Context context) {
        this.mContext = context;
        mDataList = new ArrayList<>();
    }

    public void addData(List<T> data){
        mDataList.addAll(data);
        notifyDataSetChanged();
        LogUtil.e(TAG, "addDataList");
    }

    public void clearData(){
        mDataList.clear();
    }

    public List<T> getData(){
        LogUtil.e(TAG, "getDataList");
        return mDataList;
    }

    public void addData(T data){
        mDataList.add(data);
        notifyDataSetChanged();
    }

    public void addData(int pos, T data){
        mDataList.add(pos, data);
        notifyDataSetChanged();
    }

    public void setFooterViewRes(int resId){
        mFooterViewRes = resId;
    }

    public void setIsShowFooter(boolean showFooter){
        this.mShowFooter = showFooter;
    }

    public boolean isShowFooter(){
        return this.mShowFooter;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;
    }

    public void setOnItemViewListener(OnItemViewListener l){
        mOnItemViewListener = l;
    }

    @Override
    public int getItemViewType(int position) {
        if (!mShowFooter) {
            return TYPE_ITEM;
        }
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //for test
//        RecyclerView.ViewHolder viewHolder = mOnItemViewListener.onCreateItemViewHolder(mContext);
//        ((ItemViewHolder)viewHolder).setOnItemClickListener(mOnItemClickListener);
//        return viewHolder;


        if(viewType == TYPE_ITEM){
//            View v = LayoutInflater.from(mContext).inflate(R.layout.fragment_item_list_audio, null);
//            ItemViewHolder viewHolder = new ItemViewHolder(v);
            RecyclerView.ViewHolder viewHolder = mOnItemViewListener.onCreateItemViewHolder(mContext);
            ((ItemViewHolder)viewHolder).setOnItemClickListener(mOnItemClickListener);
            return viewHolder;
        }else{
            View view = LayoutInflater.from(mContext).inflate(mFooterViewRes, null);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            FooterViewHolder footerViewHolder = null;
            if(mOnFooterViewListener != null){
                footerViewHolder = (FooterViewHolder) mOnFooterViewListener.onCreateFooterViewHolder(mContext, view);
            } else {
                footerViewHolder = new FooterViewHolder(view);
            }
            return footerViewHolder;
        }
    }

    public void setFooterViewListener(OnFooterViewListener l){
        mOnFooterViewListener = l;
    }

    /**
     * 所谓绑定viewholder实际上就是将data中的数据取出并设置到对应的控件上
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if(holder instanceof ItemViewHolder){//因为这个类中存在FooterViewHolder 和 ItemViewHolder，所以要判断这个holder所属的类是哪个
        if(ItemViewHolder.class.isInstance(holder)){
            if(mOnItemViewListener != null) {
                mOnItemViewListener.setItemViewContent(holder, position);
            }

        }
    }
//
//
    /**
     * 因为加上了脚部Footer，所以此处的操作不能像ListView那样直接返回data.size()
     * 要做一些判断，以判断返回的是Footer的布局还是Item的布局
     *
     * 通过这个方法控制item的数量
     *
     * @return RecyelerView中item的数量
     */
    @Override
    public int getItemCount() {

//        return 10;
        int type;
        if(mShowFooter){
            type = TYPE_FOOTER;
        }else{
            type = TYPE_ITEM;
        }

        if(mDataList == null){
            return type;
        }
        return mDataList.size() + type;
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemViewListener{
        RecyclerView.ViewHolder onCreateItemViewHolder(Context context);
        void setItemViewContent(RecyclerView.ViewHolder holder, int pos);
    }

    public interface OnFooterViewListener{
        RecyclerView.ViewHolder onCreateFooterViewHolder(Context context, View view);
    }
}
