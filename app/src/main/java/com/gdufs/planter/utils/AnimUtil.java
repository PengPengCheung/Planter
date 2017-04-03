package com.gdufs.planter.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

import com.gdufs.planter.R;

/**
 * Created by peng on 2017/4/3.
 */

public class AnimUtil {


    public static void setLinearRotateAnim(View view, int animRes){

    }

    public static void setLinearRotationAnimByGivenDuration(final View view, int animRes, long duration){
        Animation operatingAnim = AnimationUtils.loadAnimation(view.getContext(), animRes);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        operatingAnim.setDuration(duration);
//        view.setAnimation(operatingAnim);
        operatingAnim.setFillAfter(true);
        operatingAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                LogUtil.e("AnimUtil", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                LogUtil.e("AnimUtil", "onAnimationEnd");
                view.clearAnimation();
//                animation.reset();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                LogUtil.e("AnimUtil", "onAnimationRepeat");
            }
        });
        view.startAnimation(operatingAnim);
//        operatingAnim.start();

    }

    public static void stopAnim(View view){
        Animation animation = view.getAnimation();
        LogUtil.e("AnimUtil", "stopAnim animation: " + (animation!=null));
        if(animation != null){
            animation.cancel();
        }
    }
}
