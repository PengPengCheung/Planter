package com.gdufs.planter.module.group.view;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.gdufs.planter.R;

/**
 * Created by peng on 2017/3/17.
 */

public class GroupView {

    private Activity mActivity;

    private Button mBtnAddMember;
    private LinearLayout mLLMembersInput;
    private EditText mEditMemberInput;
    private RelativeLayout mRLGroupItem;


    public GroupView(Activity activity, View view){
        mActivity = activity;
        init(view);
        setViews();
    }

    private void init(View view){
        mBtnAddMember = (Button) view.findViewById(R.id.btn_group_item_add_member);
        mLLMembersInput = (LinearLayout) view.findViewById(R.id.ll_group_members_input);
        mEditMemberInput = (EditText) view.findViewById(R.id.edit_member_name_input);
        mRLGroupItem = (RelativeLayout) view.findViewById(R.id.rl_group_item);
    }

    private void setViews(){
        mBtnAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ppp", "btn add");
                EditText editText = new EditText(mActivity);
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mEditMemberInput.getLayoutParams();
                params.width = mEditMemberInput.getWidth();
                params.height = mEditMemberInput.getHeight();
                params.bottomMargin = 16;
                editText.setLayoutParams(params);
                editText.setBackgroundResource(R.drawable.shape_edittext);
                mLLMembersInput.addView(editText);
//                mRLGroupItem.requestLayout();
//                mRLGroupItem.invalidate();
            }
        });
    }
}
