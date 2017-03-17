package com.gdufs.planter.common;

/**
 * Created by peng on 2017/3/13.
 */

public class Resource {

    public static class PlanterURL{
        //http://192.168.1.74:8080
        public static String HOST_URL = "http://172.17.198.7:8080"; //
        public static String JSON_TEST_URL = HOST_URL + "/json";
        public static String ATTENDANCE_CODE_URL = HOST_URL + "/attendance";
    }



    public String TYPE = "type";
    public static int MODULE_FRAME_PLANTER = 0;
    public static int MODULE_FRAME_NOTIFICATION = 1;
    public static int MODULE_FRAME_RESOURCE = 2;

    public static final int MODULE_COURSE_ATTENDANCE = 3;
    public static final int MODULE_COURSE_ATTENTION = 4;
    public static final int MODULE_COURSE_SUMMARY = 5;
    public static final int MODULE_COURSE_HOMEWORK = 6;
    public static final int MODULE_COURSE_GROUP = 7;
    public static final int MODULE_COURSE_OTHERS = 8;

    public static final String TEST_LONG_TEXT = "This is a dialog without title. This is a dialog without title. This is a dialog without title. " +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            "This is a dialog without title. This is a dialog without title." +
            " ";
}
