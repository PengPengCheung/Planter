package com.gdufs.planter.module.summary;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.gdufs.planter.R;
import com.gdufs.planter.widget.ItemViewHolder;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by peng on 2017/3/15.
 */

public class SummaryItemView extends ItemViewHolder {

    private Button mBtnSummaryOpenEdit;
    private Context mContext;

    public SummaryItemView(View itemView, Context context) {
        super(itemView);
        mContext = context;
    }

    @Override
    public void findViews(View itemView) {
        mBtnSummaryOpenEdit = (Button) itemView.findViewById(R.id.btn_course_summary_item_open_to_edit);

        mBtnSummaryOpenEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog();
            }
        });
    }

    MaterialDialog materialDialog;
    private void createDialog() {
        materialDialog = new MaterialDialog(mContext)
                .setTitle("反馈")
                .setContentView(R.layout.layout_item_dialog_input)
                .setPositiveButton("发送", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        materialDialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        materialDialog.dismiss();
                    }
                });

        materialDialog.show();
    }
}
