package com.gdufs.planter.module.group.view;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gdufs.planter.R;
import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.DataResponse;
import com.gdufs.planter.common.ModuleBaseView;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.group.model.GroupPushViewModel;
import com.gdufs.planter.module.group.presenter.GroupPresenter;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.PreferenceHelper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by peng on 2017/3/17.
 */

public class GroupView implements ModuleBaseView{

    private static final String TAG = GroupView.class.getSimpleName();

    private Activity mActivity;

    private Button mBtnAddMember;
    private LinearLayout mLLMembersInput;
    private EditText mEditMemberInput;
    private TextView mTVGroupPublishTime;

    private List<EditText> mEditTextList;
    private RelativeLayout mRLGroupSubmit;
    private EditText mEditGroupLeader;
    private EditText mEditGroupName;

    private RelativeLayout mRLGroupItem;

    private int mGroupMin = 0;
    private int mGroupMax = 0;
    private int mCurrentMemberAddNum = 0;


    public GroupView(Activity activity, View view){
        mActivity = activity;
        init(view);
        initParams();
        setViews();
    }

    public View getGroupView(){
        return mRLGroupItem;
    }

    private void initParams() {
        GroupPresenter.getInstance().registerView(this);
        mEditTextList = new LinkedList<>();
        mEditTextList.add(mEditMemberInput);
    }


    private void init(View view){
        mRLGroupItem = (RelativeLayout) view.findViewById(R.id.rl_group_item);

        mBtnAddMember = (Button) view.findViewById(R.id.btn_group_item_add_member);
        mLLMembersInput = (LinearLayout) view.findViewById(R.id.ll_group_members_input);
        mEditMemberInput = (EditText) view.findViewById(R.id.edit_member_name_input);
        mTVGroupPublishTime = (TextView) mRLGroupItem.findViewById(R.id.tv_group_item_date);
        mRLGroupSubmit = (RelativeLayout) view.findViewById(R.id.rl_course_item_submit);
        mEditGroupLeader = (EditText) view.findViewById(R.id.edit_group_leader_name);
        mEditGroupName = (EditText) view.findViewById(R.id.edit_group_name);

//        mRLGroupItem.setVisibility(View.GONE);
    }

    private void setViews(){
        mBtnAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ppp", "btn add");
                if(mCurrentMemberAddNum >= mGroupMax - 1){
                    Toast.makeText(mActivity, "组员人数已达到上限", Toast.LENGTH_SHORT).show();
                    return;
                }



                if(mCurrentMemberAddNum < mGroupMax - 1){
                    newEditText();
                    mCurrentMemberAddNum++;
                }
            }
        });


        mRLGroupSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentMemberAddNum >= mGroupMin - 1 && mCurrentMemberAddNum <= mGroupMax - 1){
                    String groupName = getGroupName();
                    String groupLeaderName = getGroupLeaderName();
                    List<String> groupMemberList = getMemberNameList();
                    String teacherGroupId = PreferenceHelper.getInstance(mActivity).getString(Resource.KEY.KEY_TEACHER_OPEN_GROUP_ID, "");
                    LogUtil.e(TAG, "teacherGroupId: " + teacherGroupId);
                    GroupPresenter.getInstance().sendGroupInfo(groupMemberList, groupLeaderName, groupName, teacherGroupId);
                } else {
                    Toast.makeText(mActivity, "组员人数不符合要求！", Toast.LENGTH_SHORT).show();
                }

            }
        });

        update(new BaseViewModel());

    }

    private String getGroupLeaderName(){
        if(mEditGroupLeader != null){
            String groupLeaderName = mEditGroupLeader.getText().toString().trim();
            return groupLeaderName;
        }
        return "";
    }

    private String getGroupName(){
        if(mEditGroupName != null){
            String groupName = mEditGroupName.getText().toString().trim();
            return groupName;
        }

        return "";
    }

    private List<String> getMemberNameList(){
        if(mEditTextList != null && mEditTextList.size() > 0){
            List<String> memberNameList = new LinkedList<String>();
            for(EditText editText : mEditTextList){
                String memberName = editText.getText().toString().trim();
                memberNameList.add(memberName);
            }


            return memberNameList;
        }

        return new LinkedList<>();
    }

    private EditText newEditText(){
        EditText editText = new EditText(mActivity);
        mLLMembersInput.setVisibility(View.VISIBLE);
        mEditMemberInput.setVisibility(View.VISIBLE);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mEditMemberInput.getLayoutParams();
        params.width = mEditMemberInput.getWidth();
        params.height = 80;//mEditMemberInput.getHeight();
        params.bottomMargin = 16;
        editText.setPadding(15, 15, 15, 15);
        editText.setLayoutParams(params);
        editText.setBackgroundResource(R.drawable.shape_edittext);
//                editText.setBackgroundColor(mActivity.getResources().getColor(R.color.colorRed));
        editText.setTextColor(mActivity.getResources().getColor(R.color.colorBlack));
        editText.setTextSize(15);
        editText.setHint("请输入组员id");
//        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText.setSingleLine(true);
        editText.setHintTextColor(mActivity.getResources().getColor(R.color.colorGrey));
        mLLMembersInput.addView(editText);
        if(mEditTextList != null) {
            mEditTextList.add(editText);
        }
        return editText;
    }


    private GroupPushViewModel readViewModel(){
        GroupPushViewModel groupPushViewModel = GroupPresenter.getInstance().readViewModel(mActivity);
        return groupPushViewModel;
    }

    public void setAlreadyOpenGroupView(){

    }


    @Override
    public void update(BaseViewModel model) {
        if(model != null){
            GroupPushViewModel viewModel = readViewModel();
            updateViews(viewModel);
        }
    }

    private void updateViews(GroupPushViewModel viewModel){
        if(viewModel != null){
            mRLGroupItem.setVisibility(View.VISIBLE);
            String teacherGroupOpenId = viewModel.getmTeacherGroupOpenId();
            LogUtil.e(TAG, "teacherGroupOpenId: " + teacherGroupOpenId);
            PreferenceHelper.getInstance(mActivity).putString(Resource.KEY.KEY_TEACHER_OPEN_GROUP_ID, teacherGroupOpenId);
            LogUtil.e(TAG, "publishOpenTime: " + viewModel.getmGroupOpenTime());
            mTVGroupPublishTime.setText(viewModel.getmGroupOpenTime());
            setGroupLimit(viewModel.getmGroupLimit());
            LogUtil.e(TAG, "groupLimits min: " + mGroupMin + ", max: " + mGroupMax);
            if(mGroupMin > 1){
                for(int i=1;i < mGroupMin;i++){
//                    newEditText();
                    LogUtil.e(TAG, "groupNum: " + i);
                }
//                mCurrentMemberAddNum = mGroupMin;
            }
        } else {
            mRLGroupItem.setVisibility(View.GONE);
        }
    }

    private void setGroupLimit(String groupLimit){
        String[] groupLimits = groupLimit.split(",");
//        List<Integer> groupLimitList = new LinkedList<>();
        if(groupLimits.length == 2){
            int min = Integer.parseInt(groupLimits[0]);
            int max = Integer.parseInt(groupLimits[1]);
            mGroupMin = min;
            mGroupMax = max;
//            groupLimitList.add(min);
//            groupLimitList.add(max);
        }

//        return groupLimitList;
    }

    @Override
    public void onResponseSuccess(DataResponse response) {

    }

    @Override
    public void onResponseFailure(Exception e) {

    }
}
