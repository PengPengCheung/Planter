package com.gdufs.planter.module.homework;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.widget.ItemViewHolder;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by peng on 2017/3/14.
 */

public class HomeworkItemView extends ItemViewHolder {

    private Context mContext;
    private Button mBtnHomeworkDetail;

    @Override
    public void findViews(View itemView) {
        mBtnHomeworkDetail = (Button) itemView.findViewById(R.id.btn_course_homework_item_detail);

        mBtnHomeworkDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog();
            }
        });
    }

    MaterialDialog materialDialog;
    private void createDialog() {
        materialDialog = new MaterialDialog(mContext)
                .setTitle("作业标题作业标题作业标题作业标题作业标题作业标题作业标题作业标题作业标题")
                .setMessage(Resource.TEST_LONG_TEXT)
                .setPositiveButton("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        materialDialog.dismiss();
                    }
                });
//                .setNegativeButton("取消", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        materialDialog.dismiss();
//                    }
//                });

        materialDialog.show();
    }

    public HomeworkItemView(View itemView, Context context) {
        super(itemView);
        mContext = context;
    }

}