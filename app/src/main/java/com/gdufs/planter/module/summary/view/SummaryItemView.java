package com.gdufs.planter.module.summary.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.summary.model.SummaryViewModel;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.widget.ItemViewHolder;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by peng on 2017/3/15.
 */

public class SummaryItemView extends ItemViewHolder {

    private static final String TAG = SummaryItemView.class.getSimpleName();

    private Button mBtnSummaryOpenEdit;
    MaterialDialog materialDialog;
    private TextView mTVSummaryTime;
    private TextView mTVSummaryTipsPrefix;
    private TextView mTVSummaryBonusNum;
    private TextView mTVSummaryTipsUnder;
    private TextView mTVSummaryTipsBottom;

    private OnSendSummaryListener mListener;

    private Context mContext;

    public SummaryItemView(View itemView, Context context) {
        super(itemView);
        mContext = context;
    }

    public void setOnSendSummaryListener(OnSendSummaryListener l){
        mListener = l;
    }

    @Override
    public void findViews(View itemView) {
        mBtnSummaryOpenEdit = (Button) itemView.findViewById(R.id.btn_course_summary_item_open_to_edit);
        mTVSummaryTime = (TextView) itemView.findViewById(R.id.tv_summary_item_date);
        mTVSummaryTipsPrefix = (TextView) itemView.findViewById(R.id.tv_summary_item_tips_prefix);
        mTVSummaryBonusNum = (TextView) itemView.findViewById(R.id.tv_summary_item_bonus_num);
        mTVSummaryTipsUnder = (TextView) itemView.findViewById(R.id.tv_summary_tips_under);
        mTVSummaryTipsBottom = (TextView) itemView.findViewById(R.id.tv_course_summary_item_send_summary);

        setListeners();
    }

    private void setListeners(){
        mBtnSummaryOpenEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDialog.show();
            }
        });
    }


    public void setViews(SummaryViewModel model){
        createDialog();
        mTVSummaryTime.setText(model.getmSummaryRequestTime());

        int status = model.getmSummaryStatus();
        int bonus = model.getmSummaryBonusNum();
        LogUtil.e(TAG, "status: " + status + ", bonus: " + bonus);
        String bonusStr = mContext.getResources().getString(R.string.course_attendance_item_bonus_num);
        String bonusFormatStr = String.format(bonusStr, bonus);
        mTVSummaryBonusNum.setText(bonusFormatStr);
        switch (status){
            case Resource.SUMMARY.SUMMARY_SEND_SUCCESS:{
                setSendSuccessView();
            }
            break;
            case Resource.SUMMARY.SUMMARY_CHECKING:{
                setCheckingView();

            }
            break;
            case Resource.SUMMARY.SUMMARY_WAIT_FOR_SENDING:{
                setDefaultView();
            }
            break;
        }

    }

    private void setDefaultView(){
        mTVSummaryTipsPrefix.setText(R.string.bonus_signal_can_score);
        mTVSummaryTipsUnder.setText(R.string.course_summary_item_tips);
        mBtnSummaryOpenEdit.setText(R.string.course_summary_item_open_to_edit);
        mTVSummaryTipsBottom.setText(R.string.course_summary_item_edit_tips);
    }

    private void setSendSuccessView(){
        mTVSummaryTipsPrefix.setText(R.string.bonus_signal_plus);
        mTVSummaryTipsUnder.setText(R.string.course_summary_item_send_success);
        mBtnSummaryOpenEdit.setText(R.string.course_summary_item_summary_details);
        mTVSummaryTipsBottom.setText(R.string.course_summary_item_thanks);
    }

    private void setCheckingView(){
        mTVSummaryTipsPrefix.setText(R.string.bonus_signal_can_score);
        mTVSummaryTipsUnder.setText(R.string.course_summary_item_validating);
        mBtnSummaryOpenEdit.setText(R.string.course_summary_item_summary_details);
        mTVSummaryTipsBottom.setText(R.string.course_summary_item_thanks);
    }

    private void createDialog() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_dialog_input, null);
        final EditText editText = (EditText) view.findViewById(R.id.edit_summary_item_input);
        materialDialog = new MaterialDialog(mContext)
                .setTitle("反馈")
                .setContentView(view)
                .setPositiveButton("发送", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String summary = editText.getText().toString().trim();

                        if(TextUtils.isEmpty(summary)){
                            Toast.makeText(mContext, "发送的反馈不能为空！", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if(mListener != null){
                            mListener.sendSummary(summary);
                        }

                        editText.setText("");
                        materialDialog.dismiss();
//                        setCheckingView();
                    }
                })
                .setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText.setText("");
                        materialDialog.dismiss();
                    }
                });
    }

    public interface OnSendSummaryListener{
        void sendSummary(String summary);
    }
}
