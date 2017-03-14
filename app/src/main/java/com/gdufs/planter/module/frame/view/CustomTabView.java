package com.gdufs.planter.module.frame.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdufs.planter.R;


/**
 * Created by peng on 2017/3/13.
 */

public class CustomTabView extends FrameLayout{

    private View mTabView;
    private ImageView mIVIcon;
    private TextView mTVDescription;

    public CustomTabView(Context context) {
        super(context);
        init(context);
    }

    public CustomTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        mTabView = LayoutInflater.from(context).inflate(R.layout.layout_tab_custom, null);
        mIVIcon = (ImageView) mTabView.findViewById(R.id.iv_frame_icon);
        mTVDescription = (TextView) mTabView.findViewById(R.id.tv_frame_description);
//        mTabView.setClickable(true);
    }

    public View getTabView(){
        return mTabView;
    }


    public void setImageView(int resId){
        if(mIVIcon != null){
            mIVIcon.setImageResource(resId);
        }
    }

    public void setText(int resId){
        if(mTVDescription != null){
            mTVDescription.setText(resId);
        }
    }

    public void setText(String resId){
        if(mTVDescription != null){
            mTVDescription.setText(resId);
        }
    }

}
