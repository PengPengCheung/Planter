package com.gdufs.planter.module.frame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gdufs.planter.PlanterDetailActivity;
import com.gdufs.planter.R;
import com.gdufs.planter.common.Resource;
import com.gdufs.planter.module.course.view.CourseView;
import com.gdufs.planter.module.frame.adapter.ViewPagerAdapter;
import com.gdufs.planter.utils.NetworkUtil;
import com.gdufs.planter.utils.ResultCallback;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by peng on 2017/3/13.
 */

public class ItemFragment extends Fragment {


    public static ItemFragment newInstance(int type) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_view, null);
        initDialog();
        initImg(view);
        handleDialogShow();

        Button button = (Button) view.findViewById(R.id.btn_test_dialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PlanterDetailActivity.class);
                startActivity(intent);
//                mMaterialDialog.show();
            }
        });
//        CourseView courseView = new CourseView(view, this);

        return view;
    }

    private void initImg(View view){
        ImageView imageView = (ImageView) view.findViewById(R.id.img_test);
        Glide.with(getActivity()).load(Resource.PlanterURL.TEST_IMG_URL).into(imageView);
    }

    private void handleDialogShow(){
        Intent intent = getActivity().getIntent();
        if(intent != null) {
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                if("push".equals(bundle.getString("from"))){
                    Log.e("ppp", "LaunchBaseActivity");
                    mMaterialDialog.show();
                    Toast.makeText(getActivity(), "from push", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    MaterialDialog mMaterialDialog;
    String inputCode;

    private void initDialog(){
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_dialog_postive, null);
        Button btnAttendanceCodeSubmit = (Button) view.findViewById(R.id.btn_dialog_positive);
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
        btnAttendanceCodeSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(null != editCodeInput.getText()){
                    inputCode = editCodeInput.getText().toString();
                }

                if(inputCode != null) {
                    if(inputCode.length() < 6 || inputCode.length() > 6) {
                        Toast.makeText(ItemFragment.this.getActivity(), "只能填写6位考勤码！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("attendance", inputCode);
                    JSONObject json;
                    NetworkUtil.post(Resource.PlanterURL.ATTENDANCE_CODE_URL, params, new ResultCallback<String>() {
                        @Override
                        public void onSuccess(String response) {
                            Log.e("ppp", "response: " + response);
                        }

                        @Override
                        public void onFailure(Exception e) {
                            Log.e("ppp", "attendance fail.");
                        }
                    });
                }

                if(mMaterialDialog != null){
                    mMaterialDialog.dismiss();
                }
            }
        });
       mMaterialDialog = new MaterialDialog(getActivity())
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
