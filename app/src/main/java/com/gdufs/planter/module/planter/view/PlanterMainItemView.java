package com.gdufs.planter.module.planter.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.planter.model.PlanterViewModel;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.ResultCallback;
import com.gdufs.planter.widget.ItemViewHolder;

import java.util.HashMap;
import java.util.Map;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by peng on 2017/3/24.
 */

public class PlanterMainItemView extends ItemViewHolder {

    private static final String TAG = PlanterMainItemView.class.getSimpleName();

    private LinearLayout mLLPlanterItemContent;
    private TextView mTVTreeStatus;
    private TextView mTVCourseType;
    private TextView mTVWaterHadNum;
    private TextView mTVSunHadNum;
    private TextView mTVSoilHadNum;
    private TextView mTVCourseTime;
    private TextView mTVTreePercentage;
    private ImageView mIVTreestatus;

    private Context mContext;

    public PlanterMainItemView(View itemView, Context context) {
        super(itemView);
        mContext = context;
    }

    public void setViews(PlanterViewModel model, int pos, int listSize) {
        if(model == null){
            return;
        }

        mLLPlanterItemContent.setVisibility(View.VISIBLE);
        int status = model.getmPlanterStatus();
        setStyleByStatus(status);

        mTVCourseType.setText(model.getmCourseName());
        mTVCourseTime.setText(model.getmCourseTime());
        setElements(model);
        mTVTreePercentage.setText(model.getmPlanterPercent() + "%");



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
        mIVTreestatus = (ImageView) itemView.findViewById(R.id.img_planter_item_type);
    }


    public void setStyleByStatus(int status) {
        switch (status){
            case Resource.TREE_STATUS.TREE_SEED:{
                mTVTreeStatus.setText(R.string.planter_seed);
                mIVTreestatus.setImageResource(R.drawable.seed);
            }
            break;
            case Resource.TREE_STATUS.TREE_SEEDLING:{
                mTVTreeStatus.setText(R.string.planter_seedling);
                mIVTreestatus.setImageResource(R.drawable.seedling);
            }
            break;
            case Resource.TREE_STATUS.TREE_SEEDLING_MATURE:{
                mTVTreeStatus.setText(R.string.planter_seedling_mature);
                mIVTreestatus.setImageResource(R.drawable.seedling_mature);
            }
            break;
            case Resource.TREE_STATUS.TREE_DEVELOPMENT:{
                mTVTreeStatus.setText(R.string.planter_development);
                mIVTreestatus.setImageResource(R.drawable.development);
            }
            break;
            case Resource.TREE_STATUS.TREE_MATURE:{
                mTVTreeStatus.setText(R.string.planter_mature);
                mIVTreestatus.setImageResource(R.drawable.mature);
            }
            break;
        }

    }
}
