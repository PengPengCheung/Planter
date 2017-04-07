package com.gdufs.planter.module.planter.view;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.planter.model.PlanterDetailViewDBModel;
import com.gdufs.planter.utils.LogUtil;

/**
 * Created by peng on 2017/4/7.
 */

public class PlanterDetailHeadView {

    private String TAG = PlanterDetailHeadView.class.getSimpleName();

    private Activity mActivity;

    private TextView mTVHeadRank;
    private TextView mTVTreeStatus;
    private TextView mTVTitle;
    private TextView mTVEvaluation;
    private TextView mTVUsedWater;
    private TextView mTVUsedSunshine;
    private TextView mTVUsedSoil;
    private TextView mTVNeedWater;
    private TextView mTVNeedSunshine;
    private TextView mTVNeedSoil;
    private TextView mTVElementTips;
    private ImageView mIVTree;

    public PlanterDetailHeadView(Activity activity){
        mActivity = activity;
        findViews();
    }

    private void findViews() {
        mTVHeadRank = (TextView) mActivity.findViewById(R.id.tv_planter_detail_head_rank);
        mTVEvaluation = (TextView) mActivity.findViewById(R.id.tv_planter_detail_evaluation);
        mTVTitle = (TextView) mActivity.findViewById(R.id.tv_planter_detail_title);
        mTVUsedSunshine = (TextView) mActivity.findViewById(R.id.tv_planter_detail_used_sunshine);
        mTVUsedWater = (TextView) mActivity.findViewById(R.id.tv_planter_detail_used_water);
        mTVUsedSoil = (TextView) mActivity.findViewById(R.id.tv_planter_detail_used_soil);
        mTVNeedSunshine = (TextView) mActivity.findViewById(R.id.tv_planter_detail_need_sunshine);
        mTVNeedWater = (TextView) mActivity.findViewById(R.id.tv_planter_detail_need_water);
        mTVNeedSoil = (TextView) mActivity.findViewById(R.id.tv_planter_detail_need_soil);
        mIVTree = (ImageView) mActivity.findViewById(R.id.img_tree_status);
        mTVTreeStatus = (TextView) mActivity.findViewById(R.id.tv_planter_detail_tree_status);
        mTVElementTips = (TextView) mActivity.findViewById(R.id.tv_tree_lack);
    }


    public void updateViews(PlanterDetailViewDBModel model){
        if(model == null){
            LogUtil.e(TAG, "PlanterDetailViewDBModel == null");
            return;
        }

        updateHeadView(model);
        updateDetailsView(model);
    }

    private void updateHeadView(PlanterDetailViewDBModel model) {

    }

    private void setNeedElementsView(int nextStatus, PlanterDetailViewDBModel model){
        int totalSunshineNum = 0;
        int totalWaterNum = 0;
        int totalSoilNum = 0;
        switch (nextStatus){
            case Resource.TREE_STATUS.TREE_SEED:{
                totalSunshineNum = 0;
                totalWaterNum = 0;
                totalSoilNum = 0;
            }
            break;
            case Resource.TREE_STATUS.TREE_SEEDLING:{
                totalSunshineNum = Resource.TREE.SEEDLING.SEEDLING_TOTAL_SUNSHINE;
                totalWaterNum = Resource.TREE.SEEDLING.SEEDLING_TOTAL_WATER;
                totalSoilNum = Resource.TREE.SEEDLING.SEEDLING_TOTAL_SOIL;
            }
            break;
            case Resource.TREE_STATUS.TREE_SEEDLING_MATURE:{
                totalSunshineNum = Resource.TREE.SEEDLING_MATURE.SEEDLING_MATURE_TOTAL_SUNSHINE;
                totalWaterNum = Resource.TREE.SEEDLING_MATURE.SEEDLING_MATURE_TOTAL_WATER;
                totalSoilNum = Resource.TREE.SEEDLING_MATURE.SEEDLING_MATURE_TOTAL_SOIL;
            }
            break;
            case Resource.TREE_STATUS.TREE_DEVELOPMENT:{
                totalSunshineNum = Resource.TREE.TREE_DEVELOPMENT.TREE_DEVELOPMENT_TOTAL_SUNSHINE;
                totalWaterNum = Resource.TREE.TREE_DEVELOPMENT.TREE_DEVELOPMENT_TOTAL_WATER;
                totalSoilNum = Resource.TREE.TREE_DEVELOPMENT.TREE_DEVELOPMENT_TOTAL_SOIL;
            }
            break;
            case Resource.TREE_STATUS.TREE_MATURE:{
                totalSunshineNum = Resource.TREE.TREE_MATURE.TREE_MATURE_TOTAL_SUNSHINE;
                totalWaterNum = Resource.TREE.TREE_MATURE.TREE_MATURE_TOTAL_WATER;
                totalSoilNum = Resource.TREE.TREE_MATURE.TREE_MATURE_TOTAL_SOIL;
            }
            break;
            case Resource.TREE_STATUS.TREE_FINAL:{
                totalSunshineNum = Resource.TREE.TREE_FINAL.TREE_FINAL_TOTAL_SUNSHINE;
                totalWaterNum = Resource.TREE.TREE_FINAL.TREE_FINAL_TOTAL_WATER;
                totalSoilNum = Resource.TREE.TREE_FINAL.TREE_FINAL_TOTAL_SOIL;
            }
            break;
            case Resource.TREE_STATUS.TREE_MORE_THAN_FINAL:{
                totalSunshineNum = Resource.TREE.TREE_FINAL.TREE_FINAL_TOTAL_SUNSHINE;
                totalWaterNum = Resource.TREE.TREE_FINAL.TREE_FINAL_TOTAL_WATER;
                totalSoilNum = Resource.TREE.TREE_FINAL.TREE_FINAL_TOTAL_SOIL;
            }
            break;
        }

        int needSunShineNum = totalSunshineNum - model.getmPlanterSunshineUsed();
        int needWaterNum = totalWaterNum - model.getmPlanterWaterUsed();
        int needSoilNum = totalSoilNum - model.getmPlanterSoilUsed();

        if(needSunShineNum < 0){
            needSunShineNum = 0;
        }

        if(needWaterNum < 0){
            needWaterNum = 0;
        }

        if(needSoilNum < 0){
            needSoilNum = 0;
        }

        String needSunShineNumStr = formatElementNumStr(needSunShineNum);
        String needWaterNumStr = formatElementNumStr(needWaterNum);
        String needSoilNumStr = formatElementNumStr(needSoilNum);

        mTVNeedSunshine.setText(needSunShineNumStr);
        mTVNeedWater.setText(needWaterNumStr);
        mTVNeedSoil.setText(needSoilNumStr);

    }

    private int getLackElement(PlanterDetailViewDBModel model){
        int water = model.getmPlanterWaterUsed();
        int sun = model.getmPlanterSunshineUsed();
        int soil = model.getmPlanterSoilUsed();

        int minElement = Resource.BONUS_TYPE.BONUS_WATER;
        int min = water;

        if(sun < min){
            min = sun;
            minElement = Resource.BONUS_TYPE.BONUS_SUNSHINE;
        }

        if(soil < min){
            min = soil;
            minElement = Resource.BONUS_TYPE.BONUS_SOIL;
        }

        LogUtil.e(TAG, "minNum: " + min + ", minElement: " + minElement);

        return minElement;
    }

    private void setLackElementTipsView(PlanterDetailViewDBModel model){
        int lackElement = getLackElement(model);
        switch (lackElement) {
            case Resource.BONUS_TYPE.BONUS_SUNSHINE:{
                mTVElementTips.setText(R.string.planter_detail_sunshine_not_enough);
            }
            break;
            case Resource.BONUS_TYPE.BONUS_SOIL:{
                mTVElementTips.setText(R.string.planter_detail_soil_not_enough);
            }
            break;
            case Resource.BONUS_TYPE.BONUS_WATER:{
                mTVElementTips.setText(R.string.planter_detail_water_not_enough);
            }
            break;

        }
    }

    private void setTreeStatusView(PlanterDetailViewDBModel model){
        int status = model.getmPlanterStatus();
        switch (status) {
            case Resource.TREE_STATUS.TREE_SEED:{
                mIVTree.setImageResource(R.drawable.seed);
                mTVTreeStatus.setText(R.string.planter_seed);
            }
            break;
            case Resource.TREE_STATUS.TREE_SEEDLING:{
                mIVTree.setImageResource(R.drawable.seedling);
                mTVTreeStatus.setText(R.string.planter_seedling);
            }
            break;
            case Resource.TREE_STATUS.TREE_SEEDLING_MATURE:{
                mIVTree.setImageResource(R.drawable.seedling_mature);
                mTVTreeStatus.setText(R.string.planter_seedling_mature);
            }
            break;
            case Resource.TREE_STATUS.TREE_DEVELOPMENT:{
                mIVTree.setImageResource(R.drawable.development);
                mTVTreeStatus.setText(R.string.planter_development);
            }
            break;
            case Resource.TREE_STATUS.TREE_MATURE:{
                mIVTree.setImageResource(R.drawable.mature);
                mTVTreeStatus.setText(R.string.planter_mature);
            }
            break;
            case Resource.TREE_STATUS.TREE_FINAL:{
                mIVTree.setImageResource(R.drawable.tree_final);
                mTVTreeStatus.setText(R.string.planter_final);
            }
            break;

        }
    }

    private void setNeedElementViewByStatus(PlanterDetailViewDBModel model){
        int status = model.getmPlanterStatus();
        switch (status) {
            case Resource.TREE_STATUS.TREE_SEED:{
                setNeedElementsView(Resource.TREE_STATUS.TREE_SEEDLING, model);
            }
            break;
            case Resource.TREE_STATUS.TREE_SEEDLING:{
                setNeedElementsView(Resource.TREE_STATUS.TREE_SEEDLING_MATURE, model);
            }
            break;
            case Resource.TREE_STATUS.TREE_SEEDLING_MATURE:{
                setNeedElementsView(Resource.TREE_STATUS.TREE_DEVELOPMENT, model);
            }
            break;
            case Resource.TREE_STATUS.TREE_DEVELOPMENT:{
                setNeedElementsView(Resource.TREE_STATUS.TREE_MATURE, model);
            }
            break;
            case Resource.TREE_STATUS.TREE_MATURE:{
                setNeedElementsView(Resource.TREE_STATUS.TREE_FINAL, model);
            }
            break;
            case Resource.TREE_STATUS.TREE_FINAL:{
                setNeedElementsView(Resource.TREE_STATUS.TREE_MORE_THAN_FINAL, model);
            }
            break;

        }
    }

    private void updateDetailsView(PlanterDetailViewDBModel model) {

        setUsedElementView(model);
        setLackElementTipsView(model);
        setTreeStatusView(model);
        setNeedElementViewByStatus(model);



//        int status = model.getmPlanterStatus();
//        switch (status) {
//            case Resource.TREE_STATUS.TREE_SEED:{
//                mIVTree.setImageResource(R.drawable.seed);
//                mTVTreeStatus.setText(R.string.planter_seed);
//
//                setNeedElementsView(Resource.TREE_STATUS.TREE_SEEDLING, model);
//
//
////                int needSunShineNum = Resource.TREE.SEEDLING.SEEDLING_TOTAL_SUNSHINE - model.getmPlanterSunshineUsed();
////                int needWaterNum = Resource.TREE.SEEDLING.SEEDLING_TOTAL_WATER - model.getmPlanterWaterUsed();
////                int needSoilNum = Resource.TREE.SEEDLING.SEEDLING_TOTAL_SOIL - model.getmPlanterSoilUsed();
////
////                String needSunShineNumStr = formatElementNumStr(needSunShineNum);
////                String needWaterNumStr = formatElementNumStr(needWaterNum);
////                String needSoilNumStr = formatElementNumStr(needSoilNum);
////
////                mTVNeedSunshine.setText(needSunShineNumStr);
////                mTVNeedWater.setText(needWaterNumStr);
////                mTVNeedSoil.setText(needSoilNumStr);
//
//
////                setNeedElementView(model);
//            }
//            break;
//            case Resource.TREE_STATUS.TREE_SEEDLING:{
//                mIVTree.setImageResource(R.drawable.seedling);
//                mTVTreeStatus.setText(R.string.planter_seedling);
//
//                setNeedElementsView(Resource.TREE_STATUS.TREE_SEEDLING_MATURE, model);
//            }
//            break;
//            case Resource.TREE_STATUS.TREE_SEEDLING_MATURE:{
//                mIVTree.setImageResource(R.drawable.seedling_mature);
//                mTVTreeStatus.setText(R.string.planter_seedling_mature);
//
//                setNeedElementsView(Resource.TREE_STATUS.TREE_DEVELOPMENT, model);
//            }
//            break;
//            case Resource.TREE_STATUS.TREE_DEVELOPMENT:{
//                mIVTree.setImageResource(R.drawable.development);
//                mTVTreeStatus.setText(R.string.planter_development);
//
//                setNeedElementsView(Resource.TREE_STATUS.TREE_MATURE, model);
//            }
//            break;
//            case Resource.TREE_STATUS.TREE_MATURE:{
//                mIVTree.setImageResource(R.drawable.mature);
//                mTVTreeStatus.setText(R.string.planter_mature);
//
//                setNeedElementsView(Resource.TREE_STATUS.TREE_FINAL, model);
//            }
//            break;
//            case Resource.TREE_STATUS.TREE_FINAL:{
//                mIVTree.setImageResource(R.drawable.tree_final);
//                mTVTreeStatus.setText(R.string.planter_final);
//
//                setNeedElementsView(Resource.TREE_STATUS.TREE_MORE_THAN_FINAL, model);
//            }
//            break;
//
//        }
    }


    private void setUsedElementView(PlanterDetailViewDBModel model) {
        String sunshineNum = formatElementNumStr(model.getmPlanterSunshineUsed());
        mTVUsedSunshine.setText(sunshineNum);

        String waterNum = formatElementNumStr(model.getmPlanterWaterUsed());
        mTVUsedWater.setText(waterNum);

        String soilNum = formatElementNumStr(model.getmPlanterSoilUsed());
        mTVUsedSoil.setText(soilNum);
    }

    private String formatElementNumStr(int num){
        String notFormatStr = mActivity.getResources().getString(R.string.planter_detail_used_element);
        String formatStr = String.format(notFormatStr, num);
        return formatStr;
    }




}
