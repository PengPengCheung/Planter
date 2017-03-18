package com.gdufs.planter.module.attendance.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gdufs.planter.R;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by peng on 2017/3/18.
 */

public class AttendanceCodeDialog {

    private MaterialDialog mMaterialDialog;
    private EditText editCodeInput;
    private String inputCode;
    private Activity mActivity;
    private OnAttendanceCodeSubmitListener mListener;

    public AttendanceCodeDialog(Activity activity){
        mActivity = activity;
        View view = initDialogView();
        initCustomDialog(view, mActivity);
    }

    public void setOnAttendanceCodeSubmitListener(OnAttendanceCodeSubmitListener l){
        mListener = l;
    }

    private void initCustomDialog(View view, Context context){
        mMaterialDialog = new MaterialDialog(context).setContentView(view);
//        mMaterialDialog.setCanceledOnTouchOutside(true);
    }

    private View initDialogView(){
        View view = LayoutInflater.from(mActivity).inflate(R.layout.layout_dialog_postive, null);
        Button btnAttendanceCodeSubmit = (Button) view.findViewById(R.id.btn_dialog_positive);
        Button btnCancel = (Button) view.findViewById(R.id.btn_dialog_negative);
        editCodeInput = (EditText) view.findViewById(R.id.ed_attendance_code_input);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mMaterialDialog != null){
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

                if(mListener != null) {
                    mListener.submit(inputCode);
                }
            }
        });

        return view;
    }

    public void show(){
        if(mMaterialDialog != null){
            editCodeInput.setText("");
            mMaterialDialog.show();
        }
    }

    public void dismiss(){
        if(mMaterialDialog != null){
            mMaterialDialog.dismiss();
        }
    }

    public interface OnAttendanceCodeSubmitListener {
        void submit(String code);
//        void cancel();
    }

}
