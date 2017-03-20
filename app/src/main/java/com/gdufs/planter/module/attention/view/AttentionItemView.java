package com.gdufs.planter.module.attention.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.attention.model.AttentionViewModel;
import com.gdufs.planter.widget.ItemViewHolder;

/**
 * Created by peng on 2017/3/15.
 */

public class AttentionItemView extends ItemViewHolder {

    private TextView mTVAttentionDate;
    private TextView mTVAttentionDuration;
    private TextView mTVAttentionCount;
    private TextView mTVAttentionBonusNum;
    private TextView mTVAttentionTipsPrefix;

    private Context mContext;

    public AttentionItemView(View itemView, Context context) {
        super(itemView);
        mContext = context;
    }

    @Override
    public void findViews(View itemView) {
        mTVAttentionDate = (TextView) itemView.findViewById(R.id.tv_course_item_date);
        mTVAttentionCount = (TextView) itemView.findViewById(R.id.tv_attention_item_focus_count);
        mTVAttentionDuration = (TextView) itemView.findViewById(R.id.tv_attention_item_limit_time);
        mTVAttentionBonusNum = (TextView) itemView.findViewById(R.id.tv_attention_item_bonus_num);
        mTVAttentionTipsPrefix = (TextView) itemView.findViewById(R.id.tv_attention_item_tips_prefix);
    }

    public void setViews(AttentionViewModel model){
        if(model == null){
            return;
        }

        mTVAttentionDate.setText(model.getmAttentionTime());
        mTVAttentionDuration.setText(model.getmAttentionDuration());

        String notFormatStr = mContext.getResources().getString(R.string.course_attention_item_attention_count);
        String formatStr = String.format(notFormatStr, model.getmAttentionFocusCount(), model.getmAttentionLostFocusCount());
        mTVAttentionCount.setText(formatStr);

        int status = model.getmAttentionStatus();
        int bonus = model.getmAttentionBonusNum();
        String str = mContext.getResources().getString(R.string.course_attendance_item_bonus_num);
        String bonusStr = String.format(str, bonus);
        switch (status) {
            case Resource.ATTENTION.ATTENTION_STATUS_SUCCESS:{
                mTVAttentionTipsPrefix.setText(R.string.bonus_signal_plus);
                mTVAttentionBonusNum.setText(bonusStr);
            }
            break;
            case Resource.ATTENTION.ATTENTION_STATUS_FAIL:{
                mTVAttentionTipsPrefix.setText(R.string.bonus_signal_minus);
                String bs = String.format(str, -bonus);
                mTVAttentionBonusNum.setText(bs);
            }
            break;
            case Resource.ATTENTION.ATTENTION_STATUS_NOT_PAY_ATTENTION:{
                mTVAttentionTipsPrefix.setText(R.string.bonus_signal_can_score);
                mTVAttentionBonusNum.setText(bonusStr);
            }
            break;
            case Resource.ATTENTION.ATTENTION_STATUS_NOT_IN_TIME:{
                mTVAttentionTipsPrefix.setText(R.string.bonus_signal_can_score);
                mTVAttentionBonusNum.setText(bonusStr);
            }
            break;
        }

    }
}
