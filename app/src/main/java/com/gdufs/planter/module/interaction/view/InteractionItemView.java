package com.gdufs.planter.module.interaction.view;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daasuu.bl.BubbleLayout;
import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.widget.ItemViewHolder;

/**
 * Created by peng on 2017/3/17.
 */

public class InteractionItemView extends ItemViewHolder {

    private BubbleLayout mBLRequest;
    private RelativeLayout mRLStuResponse;
    private TextView mTVBonusSignal;
    private TextView mTVBonusNum;
    private TextView mTVTypeInteractionNotification;
    private TextView mTVNotification;
    private TextView mTVTimeLimit;

    private OnRequestClickListener mListener;
    private Context mContext;

    public InteractionItemView(View itemView, Context context) {
        super(itemView);
        mContext = context;
        initViewListeners();
    }

    public void setAttendanceListener(OnRequestClickListener l){
        mListener = l;
    }


    @Override
    public void findViews(View itemView) {
        mBLRequest = (BubbleLayout) itemView.findViewById(R.id.bl_teacher_request);
        mRLStuResponse = (RelativeLayout) itemView.findViewById(R.id.rl_student_response);
        mTVBonusSignal = (TextView) itemView.findViewById(R.id.tv_interaction_bonus_signal);
        mTVBonusNum = (TextView) itemView.findViewById(R.id.tv_interaction_bonus_num);
        mTVTypeInteractionNotification = (TextView) itemView.findViewById(R.id.tv_interaction_type);
        mTVNotification = (TextView) itemView.findViewById(R.id.tv_interaction_notification);
        mTVTimeLimit = (TextView) itemView.findViewById(R.id.tv_interaction_limit);
    }

    public void setViews(int type){
        switch (type){
            case Resource.MODULE_COURSE_ATTENDANCE:{
                String formatStr = getFormatStr(R.string.interaction_notification, "考勤");
                mTVNotification.setText(formatStr);
                String str = getFormatStr(R.string.interaction_type_and_limit, 5, "限时");
                mTVTimeLimit.setText(str);
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{

            }
            break;
        }
    }

    public void setStuResponseViewVisible(int visible){
        if(mRLStuResponse != null) {
            mRLStuResponse.setVisibility(visible);
        }
    }

    public void initViewListeners(){
        mBLRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null) {
                    mListener.onRequestClick();
                }
            }
        });
    }

    public void showResponseView(int bonusNum, int type){
        if(bonusNum == 0){
            return;
        }

        setModuleTypeView(type);
        setBonusView(bonusNum);

        mRLStuResponse.setVisibility(View.VISIBLE);
    }

    private String getFormatStr(int strResId, Object... params){
        String str =  mContext.getResources().getString(strResId);
        String s = String.format(str, params);
        return s;
    }

    private void setModuleTypeView(int moduleId){
        Log.e("ppp", "setModuleView");
        switch (moduleId) {
            case Resource.MODULE_COURSE_ATTENDANCE:{
                String resultStr = mContext.getResources().getString(R.string.interaction_result);
                String s = String.format(resultStr, "考勤");
                mTVTypeInteractionNotification.setText(s);
            }
            break;
            case Resource.MODULE_COURSE_ATTENTION:{
                String resultStr = mContext.getResources().getString(R.string.interaction_result);
                String s = String.format(resultStr, "专注");
                mTVTypeInteractionNotification.setText(s);
            }
            break;
        }
    }

    private void setBonusView(int bonusNum){
        Log.e("ppp", "setBonusView");
        String bonus = mContext.getResources().getString(R.string.interaction_bonus_num);
        if(bonusNum < 0) {
            mTVBonusSignal.setText(R.string.bonus_signal_minus);
            int num = -bonusNum;
            String bonusStr = String.format(bonus, num);
            mTVBonusNum.setText(bonusStr);
        } else if(bonusNum > 0){
            mTVBonusSignal.setText(R.string.bonus_signal_plus);
            String bonusStr = String.format(bonus, bonusNum);
            mTVBonusNum.setText(bonusStr);
        }
    }

    public interface OnRequestClickListener {
        void onRequestClick();
    }
}
