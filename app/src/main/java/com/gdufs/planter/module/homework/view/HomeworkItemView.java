package com.gdufs.planter.module.homework.view;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.homework.model.HomeworkViewModel;
import com.gdufs.planter.widget.ItemViewHolder;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by peng on 2017/3/14.
 */

public class HomeworkItemView extends ItemViewHolder {

    private Context mContext;
    private Button mBtnHomeworkDetail;
    private TextView mTVHomeworkItemDate;
    private LinearLayout mLLHomeworkDDL;
    private LinearLayout mLLHomeworkSubmit;
    private LinearLayout mLLHomeworkScoreAndRank;

    private String mHomeworkTitle;
    private String mHomeworkContent;

    private MaterialDialog materialDialog;

    // ddl
    private TextView mTVHomeworkDDL;

    // score and rank
    private TextView mTVHomeworkScore;
    private TextView mTVHomeworkRank;
    private TextView mTVHomeworkBonusNum;

    public HomeworkItemView(View itemView, Context context) {
        super(itemView);
        mContext = context;
    }

    @Override
    public void findViews(View itemView) {
        mBtnHomeworkDetail = (Button) itemView.findViewById(R.id.btn_course_homework_item_detail);
        mTVHomeworkItemDate = (TextView) itemView.findViewById(R.id.tv_course_homework_item_date);
        mLLHomeworkDDL = (LinearLayout) itemView.findViewById(R.id.ll_course_homework_item_wait_for_submit);
        mLLHomeworkSubmit = (LinearLayout) itemView.findViewById(R.id.ll_homework_submit_success);
        mLLHomeworkScoreAndRank = (LinearLayout) itemView.findViewById(R.id.ll_homework_score_and_rank);
        mTVHomeworkDDL = (TextView) itemView.findViewById(R.id.tv_homework_item_ddl);
        mTVHomeworkScore = (TextView) itemView.findViewById(R.id.tv_homework_item_score);
        mTVHomeworkRank = (TextView) itemView.findViewById(R.id.tv_homework_item_rank);
        mTVHomeworkBonusNum = (TextView) itemView.findViewById(R.id.tv_homework_item_bonus_num);

        setListeners();
    }

    private void setListeners() {
        mBtnHomeworkDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(materialDialog != null){
                    materialDialog.show();
                }
            }
        });
    }

    public void setViews(HomeworkViewModel model){



        mHomeworkTitle = model.getmHomeworkTitle();
        mHomeworkContent = model.getmHomeworkContent();

        createDialog();

        int status = model.getmHomeworkStatus();
        setViewsByStatus(model, status);
    }

    private void setViewsByStatus(HomeworkViewModel model, int status){
        switch (status){
            case Resource.HOMEWORK.HOMEWORK_PUBLISHED:{
                mLLHomeworkScoreAndRank.setVisibility(View.GONE);
                mLLHomeworkSubmit.setVisibility(View.GONE);
                mLLHomeworkDDL.setVisibility(View.VISIBLE);
                String ddl = model.getmHomeworkSubmitDDL();
                mTVHomeworkDDL.setText(ddl);
                mTVHomeworkDDL.setTextColor(mContext.getResources().getColor(R.color.colorRed));

                String dateStr = model.getmHomeworkPublishTime();
                mTVHomeworkItemDate.setText(dateStr);

            }
            break;
            case Resource.HOMEWORK.HOMEWORK_SUBMIT_SUCCESS:{
                mLLHomeworkScoreAndRank.setVisibility(View.GONE);
                mLLHomeworkSubmit.setVisibility(View.VISIBLE);
                mLLHomeworkDDL.setVisibility(View.GONE);
                String dateStr = model.getmHomeworkItemCurrentTime();
                mTVHomeworkItemDate.setText(dateStr);
            }
            break;
            case Resource.HOMEWORK.HOMEWORK_SCORED:{
                mLLHomeworkScoreAndRank.setVisibility(View.VISIBLE);
                mLLHomeworkSubmit.setVisibility(View.GONE);
                mLLHomeworkDDL.setVisibility(View.GONE);

                String dateStr = model.getmHomeworkItemCurrentTime();
                mTVHomeworkItemDate.setText(dateStr);

                String notFormatScore = mContext.getResources().getString(R.string.course_homework_item_score);
                String formatScore = String.format(notFormatScore, model.getmHomeworkScore());
                mTVHomeworkScore.setText(formatScore);

                String notFormatRank = mContext.getResources().getString(R.string.course_homework_item_rank);
                String formatRank = String.format(notFormatRank, model.getmHomeworkRank());
                mTVHomeworkRank.setText(formatRank);

                String notFormatBonusNum = mContext.getResources().getString(R.string.course_homework_item_bonus_num);
                String formatBonusNum = String.format(notFormatBonusNum, model.getmHomeworkBonusNum());
                mTVHomeworkBonusNum.setText(formatBonusNum);
            }
            break;
        }
    }

    private void createDialog() {
        materialDialog = new MaterialDialog(mContext)
                .setTitle(mHomeworkTitle)
                .setMessage(mHomeworkContent)
                .setPositiveButton("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        materialDialog.dismiss();
                    }
                });
    }

}
