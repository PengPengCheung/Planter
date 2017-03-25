package com.gdufs.planter.module.planter.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.ResultCallback;
import com.gdufs.planter.widget.FooterViewHolder;
import com.gdufs.planter.widget.ItemViewHolder;

import java.util.HashMap;
import java.util.Map;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by peng on 2017/3/25.
 */

public class PlanterMainFooterView extends FooterViewHolder {

    private static final String TAG = PlanterMainFooterView.class.getSimpleName();

    private ImageView mIVCourseAdd;
    private MaterialDialog mDialog;

    private Context mActivity;

    public PlanterMainFooterView(View itemView, Context activity) {
        super(itemView);
        mActivity = activity;
        findViews(itemView);
        setViews();
    }

    private void findViews(View itemView) {
        mIVCourseAdd = (ImageView) itemView.findViewById(R.id.img_course_add);
    }

    private void setViews(){
        initDialog();
        mIVCourseAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mDialog != null){
                    mDialog.show();
                }
            }
        });
    }

    private void initDialog() {

        View view = LayoutInflater.from(mActivity).inflate(R.layout.layout_dialog_view_submit_course_code, null);
        final EditText editCourseCodeInput = (EditText) view.findViewById(R.id.edit_course_code_input);

        mDialog = new MaterialDialog(mActivity)
                .setTitle("填写课程码")
                .setContentView(view)
                .setPositiveButton("提交",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String courseCode = editCourseCodeInput.getText().toString().trim();
                                if(!TextUtils.isEmpty(courseCode)){
                                    sendCourseCode(courseCode);
                                } else {
                                    Toast.makeText(mActivity, "请输入课程码", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
        mDialog.setCanceledOnTouchOutside(true);
    }

    private void sendCourseCode(String courseCode){
        Map<String, Object> params = new HashMap<>();
        params.put(Resource.KEY.KEY_STU_COURSE_CODE, courseCode);
//        params.put(Resource.KEY.KEY_STUDENT_ID, );
        NetworkUtil.post(Resource.PlanterURL.PLANTER_ADD_COURSE, params, new ResultCallback<String>() {

            @Override
            public void onSuccess(String response) {
                LogUtil.e(TAG, "courseCode response" + response);
                mDialog.dismiss();
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
                mDialog.dismiss();
            }
        });
    }

}
