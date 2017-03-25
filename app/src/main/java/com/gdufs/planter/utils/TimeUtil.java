package com.gdufs.planter.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by peng on 2017/3/19.
 */
public class TimeUtil {

    public static final String CHN_PATTERN_YMD_HMS = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String CHN_PATTERN_YMD_HM = "yyyy年MM月dd日 HH时mm分";
    public static final String ENG_PATTERN_MS = "mm:ss";

    //"yyyy年MM月dd日 HH时mm分ss秒"
    public static String timeToStr(Date date, String pattern){
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String timeStr = formatter.format(date);
        System.out.println("time: " + timeStr);
        return timeStr;
    }

    //"yyyy年MM月dd日 HH时mm分"
    public static Date strToTime(String timeStr, String pattern){
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        java.util.Date time=null;
        try {
            time= sdf.parse(timeStr);
            return time;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Date();
    }
}
