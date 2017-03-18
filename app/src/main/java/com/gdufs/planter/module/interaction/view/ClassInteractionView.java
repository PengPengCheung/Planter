package com.gdufs.planter.module.interaction.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gdufs.planter.PushOpenTestActivity;
import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.ResultCallback;
import com.gdufs.planter.widget.UniversalListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by peng on 2017/3/17.
 */

public class ClassInteractionView {

    UniversalListView mListView;
    InteractionItemView mItemView;

    private Activity mActivity;

    private String inputCode;
    private MaterialDialog mMaterialDialog;

    public ClassInteractionView(Activity activity){
        mActivity = activity;
        initViews();

    }

    private void initViews(){
        mListView = new UniversalListView(mActivity, R.id.swipe_refresh_widget_interaction, R.id.recycle_view_interaction);
        mListView.setItemViewListener(new UniversalListView.ItemViewListener() {
            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.layout_interaction_item, null);
                mItemView = new InteractionItemView(view);
                return mItemView;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder) {
                ((InteractionItemView)holder).setViews();
            }
        });
        initDialog();
    }

    public void showDialog(){
        if(mMaterialDialog != null){
            mMaterialDialog.show();
        }
    }

    private void initDialog(){
        View view = LayoutInflater.from(mActivity).inflate(R.layout.layout_dialog_postive, null);
        Button btnAttendanceCodeSubmit = (Button) view.findViewById(R.id.btn_dialog_positive);
        Button btnCancel = (Button) view.findViewById(R.id.btn_dialog_negative);
        final EditText editCodeInput = (EditText) view.findViewById(R.id.ed_attendance_code_input);
//        editCodeInput.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(null != editCodeInput.getText()){
//                    inputCode = editCodeInput.getText().toString();
//                }
//
//            }
//        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mMaterialDialog != null){
                    editCodeInput.setText("");
                    mMaterialDialog.dismiss();
                }
            }
        });

        btnAttendanceCodeSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(null != editCodeInput.getText()){
                    inputCode = editCodeInput.getText().toString();
                }

                if(inputCode != null) {
                    if(inputCode.length() < 6 || inputCode.length() > 6) {
                        Toast.makeText(mActivity, "只能填写6位考勤码！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put(Resource.KEY.KEY_ATTENDANCE_CODE, inputCode);
                    NetworkUtil.post(Resource.PlanterURL.ATTENDANCE_CODE_URL, params, new ResultCallback<String>() {
                        @Override
                        public void onSuccess(String response) {
                            Log.e("ppp", "response: " + response);
                            JSONObject jsonObject = null;
                            try {
                                jsonObject  = new JSONObject(response);
                                int status = jsonObject.getInt(Resource.KEY.KEY_ATTENDANCE_STATUS);
                                switch (status) {
                                    case Resource.ATTENDANCE.ATTENDANCE_STATUS_SUCCESS:{
                                        Toast.makeText(mActivity, "考勤成功！", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                    case Resource.ATTENDANCE.ATTENDANCE_STATUS_FAIL:{
                                        Toast.makeText(mActivity, "考勤失败！", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                    case Resource.ATTENDANCE.ATTENDANCE_STATUS_NOT_IN_TIME:{
                                        Toast.makeText(mActivity, "不在考勤时间！", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                    case Resource.ATTENDANCE.ATTENDANCE_STATUS_ALREADY_CHECK_SUCCESS:{
                                        Toast.makeText(mActivity, "已经考勤！", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                    default:
                                        Toast.makeText(mActivity, "系统异常！", Toast.LENGTH_SHORT).show();
                                        break;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onFailure(Exception e) {
                            Log.e("ppp", "attendance fail.");
                        }
                    });
                }

                if(mMaterialDialog != null){
                    editCodeInput.setText("");
                    mMaterialDialog.dismiss();
                }
            }
        });
        mMaterialDialog = new MaterialDialog(mActivity)
//                .setTitle("填写考勤码")
//                .setMessage(Resource.TEST_LONG_TEXT)
                .setContentView(view);
//                .setPositiveButton("OK", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        mMaterialDialog.dismiss();
//                    }
//                });
//                .setNegativeButton("CANCEL", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        mMaterialDialog.dismiss();
//                    }
//                });



//// You can change the message anytime. before show
//        mMaterialDialog.setTitle("提示");
//        mMaterialDialog.show();
//// You can change the message anytime. after show
//        mMaterialDialog.setMessage("你好，世界~");
    }
}
