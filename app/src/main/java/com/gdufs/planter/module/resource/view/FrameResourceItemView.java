package com.gdufs.planter.module.resource.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.gdufs.planter.R;
import com.gdufs.planter.widget.ItemViewHolder;

/**
 * Created by peng on 2017/3/27.
 */

public class FrameResourceItemView extends ItemViewHolder {

    private Context mContext;

    private ImageView mIVResourceDownload;

    private OnDownloadListener mDownloadListener;


    public FrameResourceItemView(Context context, View view){
        super(view);
        mContext = context;
    }

    public void setOnDownloadListener(OnDownloadListener l){
        mDownloadListener = l;
    }


    @Override
    public void findViews(View itemView) {
        mIVResourceDownload = (ImageView) itemView.findViewById(R.id.iv_resource_download);

        setListeners();
    }

    private void setListeners(){
        mIVResourceDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mDownloadListener != null){
                    mDownloadListener.download();
                }
            }
        });
    }

    public interface OnDownloadListener{
        void download();
    }
}
