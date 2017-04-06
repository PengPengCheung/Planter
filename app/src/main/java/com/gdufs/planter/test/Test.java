package com.gdufs.planter.test;

import com.gdufs.planter.PlanterApplication;
import com.gdufs.planter.utils.TimeUtil;

/**
 * Created by peng on 2017/4/3.
 */

public class Test {

    public static void main(String[] args){

        String timeStr = TimeUtil.getTimeFromMillisecond(100000);
        System.out.println(timeStr);
    }


}
