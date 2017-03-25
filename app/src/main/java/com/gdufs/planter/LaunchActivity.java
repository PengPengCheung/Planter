package com.gdufs.planter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gdufs.planter.common.Resource;

/**
 * Created by peng on 2017/3/23.
 */

public class LaunchActivity extends AppCompatActivity {

    private EditText mEditName;
    private EditText mEditNum;
    private EditText mEditPassword;
    private EditText mEditCourseCode;
    private Button mBtnSignUp;
    private String mName;
    private String mNum;
    private String mPassword;
    private String mCourseCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        initView();
        setListeners();
    }

    private void initView() {
        mEditName = (EditText) findViewById(R.id.edit_launch_name);
        mEditNum  = (EditText) findViewById(R.id.edit_launch_id);
        mEditPassword = (EditText) findViewById(R.id.edit_launch_password);
        mEditCourseCode = (EditText) findViewById(R.id.edit_launch_course_code);
        mBtnSignUp = (Button) findViewById(R.id.btn_launch_sign_up);

    }

    private void setListeners(){
        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mName = mEditName.getText().toString().trim();
                mNum = mEditNum.getText().toString().trim();
                mPassword = mEditPassword.getText().toString().trim();
                mCourseCode = mEditCourseCode.getText().toString().trim();

                if(TextUtils.isEmpty(mName)){
                    Toast.makeText(LaunchActivity.this, "请输入真实姓名", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(mNum)){
                    Toast.makeText(LaunchActivity.this, "请输入学号", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(mPassword)){
                    Toast.makeText(LaunchActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(mCourseCode)){
                    Toast.makeText(LaunchActivity.this, "课程码不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }

                mEditName.setText("");
                mEditNum.setText("");
                mEditCourseCode.setText("");
                mEditPassword.setText("");

                Bundle bundle = new Bundle();
                bundle.putString(Resource.KEY.KEY_STU_NUMBER, mNum);
                bundle.putString(Resource.KEY.KEY_STU_NAME, mName);
                bundle.putString(Resource.KEY.KEY_STU_PASSWORD, mPassword);
                bundle.putString(Resource.KEY.KEY_STU_COURSE_CODE, mCourseCode);
                Intent intent = new Intent(LaunchActivity.this, PlanterMainActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                LaunchActivity.this.finish();
            }
        });
    }
}
