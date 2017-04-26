package com.gdufs.planter.module.resource.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.gdufs.planter.R;
import com.gdufs.planter.module.resource.model.ResourceViewModel;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.TimeUtil;
import com.gdufs.planter.widget.ItemViewHolder;

import java.util.Date;

/**
 * Created by peng on 2017/3/27.
 */

public class FrameResourceItemView extends ItemViewHolder {

    private String TAG = FrameResourceItemView.class.getSimpleName();

    private Context mContext;

    private ImageView mIVResourceDownload;
    private ImageView mIVResourceIcon;
    private TextView mTVResourceName;
    private TextView mTVResourceUploadTime;
    private TextView mTVDownloadCount;
    private TextView mTVLikeCount;

    private OnDownloadListener mDownloadListener;
    private ResourceViewModel resourceViewModel;


    public FrameResourceItemView(Context context, View view){
        super(view);
        mContext = context;
        initViews();
        setListeners();
    }

    private void initViews() {
//        mIVResourceIcon.setImageDrawable(getResourceIconDrawable(R.color.colorGreen, "R"));
    }

    public void setOnDownloadListener(OnDownloadListener l){
        mDownloadListener = l;
    }


    @Override
    public void findViews(View itemView) {
        mIVResourceDownload = (ImageView) itemView.findViewById(R.id.iv_resource_download);
        mIVResourceIcon = (ImageView) itemView.findViewById(R.id.iv_resource_item_file);
        mTVResourceName = (TextView) itemView.findViewById(R.id.tv_resource_name);
        mTVResourceUploadTime = (TextView) itemView.findViewById(R.id.tv_resource_upload_time);
        mTVDownloadCount = (TextView) itemView.findViewById(R.id.tv_resource_download_count);
        mTVLikeCount = (TextView) itemView.findViewById(R.id.tv_resource_like_count);


    }

    public void setViews(ResourceViewModel viewModel){
        resourceViewModel = viewModel;
        String resourceName = viewModel.getmResourceName();
        mTVResourceName.setText(resourceName);
        String firstStr = resourceName.substring(0, 1);
        LogUtil.e(TAG, "firstChar: " + firstStr);
        mIVResourceIcon.setImageDrawable(getResourceIconDrawable(R.color.colorGreen, firstStr));
        String dateStr = viewModel.getmResourceUploadDate();
        Date date = TimeUtil.strToTime(dateStr, TimeUtil.ENG_PATTERN_YMD_HMS);
        String dStr = TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD);
        mTVResourceUploadTime.setText(dStr);

        String downloadCountStr = mContext.getResources().getString(R.string.resource_item_download);
        String formatDownloadCountStr = String.format(downloadCountStr, viewModel.getmDownloadCount());
        mTVDownloadCount.setText(formatDownloadCountStr);

        String likeCountStr = mContext.getResources().getString(R.string.resource_item_like);
        String formatLikeCountStr = String.format(likeCountStr, viewModel.getmLikeCount());
        mTVLikeCount.setText(formatLikeCountStr);

    }

    private TextDrawable getResourceIconDrawable(int colorRes, String showLetters){
        int color = mContext.getResources().getColor(colorRes);
        TextDrawable drawable = TextDrawable.builder()
                .beginConfig()
                .withBorder(4) /* thickness in px */
                .endConfig()
                .buildRoundRect(showLetters, color, 10);

        return drawable;
    }

    private void setListeners(){
        mIVResourceDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mDownloadListener != null){
                    if(resourceViewModel != null){
                        String resourceId = resourceViewModel.getmResourceId();
                        String resourceName = resourceViewModel.getmResourceName();
                        LogUtil.e(TAG, "resourceId: " + resourceId + "resourceName: " + resourceName);
                        mDownloadListener.download(resourceId, resourceName);
                    }
                }
            }
        });
    }

    public interface OnDownloadListener{
        void download(String id, String fileName);
    }
}
