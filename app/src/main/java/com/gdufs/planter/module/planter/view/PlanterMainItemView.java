package com.gdufs.planter.module.planter.view;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gdufs.planter.PlanterDetailActivity;
import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.planter.PlanterViewSignal;
import com.gdufs.planter.module.planter.model.PlanterViewModel;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.widget.ItemViewHolder;
import com.race604.drawable.wave.WaveDrawable;

/**
 * Created by peng on 2017/3/24.
 */

public class PlanterMainItemView extends ItemViewHolder {

    private static final String TAG = PlanterMainItemView.class.getSimpleName();

    private LinearLayout mLLPlanterItemContent;
    private ImageView mIVPlanterEnterDetail;
    private TextView mTVTreeStatus;
    private TextView mTVCourseType;
    private TextView mTVWaterHadNum;
    private TextView mTVSunHadNum;
    private TextView mTVSoilHadNum;
    private TextView mTVCourseTime;
    private TextView mTVTreePercentage;
    private ImageView mIVTreeStatus;
    private ImageView mIVPlanterTool;

    private Context mContext;

    private OnChildViewActionListener mListener;

    public PlanterMainItemView(View itemView, Context context) {
        super(itemView);
        mContext = context;
    }

    public void setChildViewListener(OnChildViewActionListener l){
        mListener = l;
    }

    public void setViews(PlanterViewModel model, int pos, int listSize) {
        if(model == null){
            return;
        }

        mLLPlanterItemContent.setVisibility(View.VISIBLE);

        setStyleByStatus(model);
        setCourseInfo(model);
        setElements(model);
        setPercentage(model);

    }

    private void setCourseInfo(PlanterViewModel model){
        mTVCourseType.setText(model.getmCourseName());
        mTVCourseTime.setText(model.getmCourseTime());
    }

    private void setElements(PlanterViewModel model){
        String notFormatStr = mContext.getResources().getString(R.string.planter_have_element);

        String formatStrWater = String.format(notFormatStr, model.getmPlanterWater());
        mTVWaterHadNum.setText(formatStrWater);

        String formatStrSun = String.format(notFormatStr, model.getmPlanterSunshine());
        mTVSunHadNum.setText(formatStrSun);

        String formatStrSoil = String.format(notFormatStr, model.getmPlanterSoil());
        mTVSoilHadNum.setText(formatStrSoil);
    }

    private void setPercentage(PlanterViewModel model){
        int percentage = model.getmPlanterPercent();
        mTVTreePercentage.setText(percentage + "%");
    }

    @Override
    public void findViews(View itemView) {
        mLLPlanterItemContent = (LinearLayout) itemView.findViewById(R.id.ll_planter_item_content);
        mTVTreeStatus = (TextView) itemView.findViewById(R.id.tv_planter_item_type);
        mTVCourseType = (TextView) itemView.findViewById(R.id.tv_planter_course_type);
        mTVCourseTime = (TextView) itemView.findViewById(R.id.tv_planter_course_time);
        mTVWaterHadNum = (TextView) itemView.findViewById(R.id.tv_planter_item_water_num);
        mTVSunHadNum = (TextView) itemView.findViewById(R.id.tv_planter_item_sun_num);
        mTVSoilHadNum = (TextView) itemView.findViewById(R.id.tv_planter_item_soil_num);
        mTVTreePercentage = (TextView) itemView.findViewById(R.id.tv_planter_item_percentage);
        mIVTreeStatus = (ImageView) itemView.findViewById(R.id.img_planter_item_type);
        mIVPlanterEnterDetail = (ImageView) itemView.findViewById(R.id.img_planter_enter_detail);
        mIVPlanterTool = (ImageView) itemView.findViewById(R.id.iv_planter_item_used);

        setListeners();
    }

    private void setListeners(){
        mIVPlanterEnterDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    mListener.onAction(PlanterViewSignal.MAIN_ITEM_JUMP_TO_DETAIL_ACTIVITY);
                }

            }
        });

        mIVPlanterTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    mListener.onAction(PlanterViewSignal.MAIN_ITEM_PLANT);
                }
            }
        });
    }

    private void setImageWaveDrawable(ImageView iv, int drawableRes, int level){
        WaveDrawable waveDrawable = new WaveDrawable(mContext, drawableRes);
        iv.setImageDrawable(waveDrawable);
        waveDrawable.setWaveAmplitude(5);
        waveDrawable.setIndeterminate(false);
        waveDrawable.setLevel(level);
    }

    public void setStyleByStatus(PlanterViewModel model) {
        int percent = model.getmPlanterPercent();
        int status = model.getmPlanterStatus();
        switch (status){
            case Resource.TREE_STATUS.TREE_SEED:{
                mTVTreeStatus.setText(R.string.planter_seed);
                setImageWaveDrawable(mIVTreeStatus, R.drawable.seed, percent * 100);
//                mIVTreeStatus.setImageResource(R.drawable.seed);
            }
            break;
            case Resource.TREE_STATUS.TREE_SEEDLING:{
                mTVTreeStatus.setText(R.string.planter_seedling);
                setImageWaveDrawable(mIVTreeStatus, R.drawable.seedling, percent * 100);
//                mIVTreeStatus.setImageResource(R.drawable.seedling);
            }
            break;
            case Resource.TREE_STATUS.TREE_SEEDLING_MATURE:{
                mTVTreeStatus.setText(R.string.planter_seedling_mature);
                setImageWaveDrawable(mIVTreeStatus, R.drawable.seedling_mature, percent * 100);
//                mIVTreeStatus.setImageResource(R.drawable.seedling_mature);
            }
            break;
            case Resource.TREE_STATUS.TREE_DEVELOPMENT:{
                mTVTreeStatus.setText(R.string.planter_development);
                setImageWaveDrawable(mIVTreeStatus, R.drawable.development, percent * 100);
//                mIVTreeStatus.setImageResource(R.drawable.development);
            }
            break;
            case Resource.TREE_STATUS.TREE_MATURE:{
                mTVTreeStatus.setText(R.string.planter_mature);
                setImageWaveDrawable(mIVTreeStatus, R.drawable.mature, percent * 100);
//                mIVTreeStatus.setImageResource(R.drawable.mature);
            }
            break;
            case Resource.TREE_STATUS.TREE_FINAL:{
                mTVTreeStatus.setText(R.string.planter_final);
                setImageWaveDrawable(mIVTreeStatus, R.drawable.tree_final, percent * 100);
//                mIVTreeStatus.setImageResource(R.drawable.tree_final);
            }
            break;
        }

    }
}
