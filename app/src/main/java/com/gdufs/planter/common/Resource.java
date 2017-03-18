package com.gdufs.planter.common;

/**
 * Created by peng on 2017/3/13.
 */

public class Resource {

    public static class PlanterURL{
        //http://192.168.1.74:8080
        private static String HOST_URL = "http://192.168.191.6:8080";
        private static String WEB_URL = HOST_URL + "/web";
        private static String MOBILE_URL = HOST_URL + "/mob";
        public static String JSON_TEST_URL = HOST_URL + "/json";
        public static String ATTENDANCE_CODE_URL = MOBILE_URL + "/attendance/StudentCheck";
    }

    public static class KEY{
        public static final String KEY_TEACHER_ID = "t_id";
        public static final String KEY_STUDENT_ID = "s_id";
        public static final String KEY_COURSE_ID  = "c_id";

        //Attendance，考勤模块
        public static final String KEY_ATTENDANCE_CODE = "attendance_code";
        public static final String KEY_ATTENDANCE_STATUS = "attendance_status";
        public static final String KEY_ATTENDANCE_BONUS_NUM = "attendance_bonus_num";
    }

    public static class ATTENDANCE{
        public static final int ATTENDANCE_STATUS_SUCCESS = 1;
        public static final int ATTENDANCE_STATUS_FAIL = -2;
        public static final int ATTENDANCE_STATUS_ALREADY_CHECK_SUCCESS = 0;
        public static final int ATTENDANCE_STATUS_NOT_IN_TIME = -1;
        public static final int ATTENDANCE_STATUS_CODE_ERROR = -3;
        public static final int ATTENDANCE_STATUS_DEFAULT = -100;
    }


    public static String JPUSH_ALIAS = "Planter";


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
