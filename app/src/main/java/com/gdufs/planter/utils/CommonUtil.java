package com.gdufs.planter.utils;

/**
 * Created by peng on 2017/4/7.
 */

public class CommonUtil {

    public static int getMinimumNum(int x, int y, int z){
        int min = x;
        if(y < min){
            min = y;
        }

        if(z < min){
            min = z;
        }

        return min;
    }
}
