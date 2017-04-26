package com.gdufs.planter.module.group.presenter;

import android.content.Context;

import com.gdufs.planter.common.BaseViewModel;
import com.gdufs.planter.common.ModelConverter;
import com.gdufs.planter.common.ModuleBasePresenter;
import com.gdufs.planter.common.PersistenceManager;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.group.model.GroupPushModel;
import com.gdufs.planter.module.group.model.GroupPushViewModel;
import com.gdufs.planter.module.group.view.GroupView;
import com.gdufs.planter.utils.LogUtil;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.PreferenceHelper;
import com.gdufs.planter.utils.ResultCallback;
import com.gdufs.planter.utils.TimeUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 2017/4/25.
 */

public class GroupPresenter {

    private static final String TAG = GroupPresenter.class.getSimpleName();

    private static GroupPresenter mInstance = null;

    private GroupView mGroupView;


    private GroupPresenter(){

    }

    public static GroupPresenter getInstance(){
        if(mInstance == null){
            synchronized (GroupPresenter.class){
                if(mInstance == null){
                    mInstance = new GroupPresenter();
                }
            }
        }

        return mInstance;
    }

    public void registerView(GroupView groupView){
        mGroupView = groupView;
    }

    public GroupPushViewModel readViewModel(Context context){
        String courseId = PreferenceHelper.getInstance(context).getString(Resource.KEY.KEY_COURSE_ID, "");
        List<BaseViewModel> viewModelList = PersistenceManager.getInstance().findViewModelByCustomId(courseId, Resource.MODULE_COURSE_GROUP);
        if(viewModelList != null && viewModelList.size() > 0){
            LogUtil.e(TAG, "groupViewModel size: " + viewModelList.size());
            GroupPushViewModel groupPushViewModel = (GroupPushViewModel) viewModelList.get(0);
            LogUtil.e(TAG, "GroupPushViewModel is not null. " + groupPushViewModel.getmTeacherGroupOpenId());
            return groupPushViewModel;
        }

        return null;
    }

    public void handleOpenGroupPushNotification(){
//        GroupPushViewModel viewModel = ModelConverter.convertToGroupViewModel(groupPushModel);
        updateGroupView();
    }


    public void updateGroupView(){
        if(mGroupView != null){
            mGroupView.update(new BaseViewModel());
        }
    }


    public void sendGroupInfo(List<String> memberList, String leaderName, String groupName, String teacherGroupOpenId){
        Map<String, Object> params = constructGroupParams(memberList, leaderName, groupName, teacherGroupOpenId);
        NetworkUtil.post(Resource.PlanterURL.GROUP_INFO_SEND_URL, params, new ResultCallback<String>() {

            @Override
            public void onSuccess(String response) {
                LogUtil.e(TAG, "group send response: " + response);
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
            }
        });

    }

    private Map<String, Object> constructGroupParams(List<String> memberList, String leaderName, String groupName, String groupOpenTeacherId){
        Map<String, Object> params = new HashMap<>();
        params.put(Resource.KEY.KEY_TEACHER_OPEN_GROUP_ID, groupOpenTeacherId);
        params.put(Resource.KEY.KEY_GROUP_LEADER_NAME, leaderName);
        params.put(Resource.KEY.KEY_GROUP_MEMBERS, memberList);
        params.put(Resource.KEY.KEY_GROUP_NAME, groupName);
        Date date = new Date();
        String timeStr = TimeUtil.timeToStr(date, TimeUtil.ENG_PATTERN_YMD_HMS);
        params.put(Resource.KEY.KEY_GROUP_OPEN_TIME, timeStr);

        return params;
    }



}
