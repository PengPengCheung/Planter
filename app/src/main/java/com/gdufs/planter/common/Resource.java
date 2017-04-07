package com.gdufs.planter.common;

/**
 * Created by peng on 2017/3/13.
 */

public class Resource {

    private static final boolean DEBUG = true;

    public static class DBInfo{
        public static final String SCHEMA_NAME = (DEBUG ? "PlanterDev" : "PlanterRelease");
    }

    public static class PlanterURL{
        //http://192.168.1.74:8080
        //192.168.235.55
        private static String HOST_URL = (DEBUG ? "http://192.168.191.3:8080" : "http://releaseURL:port");
        private static String WEB_URL = HOST_URL + "/web";
        private static String MOBILE_URL = HOST_URL + "/mob";
        public static String JSON_TEST_URL = HOST_URL + "/json";

        // Title Select
        public static String COURSE_SELECT_URL = MOBILE_URL + "/course/courseSelect";

        //Launch
        public static String SIGN_UP_URL = MOBILE_URL + "/signup";

        //Planter
        public static String PLANTER_ADD_COURSE = MOBILE_URL + "/addCourse";

        //attendance
        public static String ATTENDANCE_CODE_URL = MOBILE_URL + "/attendance/StudentCheck";
        public static String ATTENDANCE_INFO_GET_URL = MOBILE_URL + "/attendance/AttendanceInfoGet";

        public static String SUMMARY_SEND_URL = MOBILE_URL + "/summary/summaryReceive";
        public static String TEST_IMG_URL = HOST_URL + "/FileUpload/fileDownload_servlet";

        public static String FILE_DOWNLOAD_URL = HOST_URL + "/FileUpload/fileDownload_servlet";

//        public static String FILE_DOWNLOAD_TEST_URL = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491212363&di=c1296bb549fc0e036263555f01d54022&imgtype=jpg&er=1&src=http%3A%2F%2Fimages.17173.com%2F2013%2Fnews%2F2013%2F06%2F03%2Fgxy0603ra12s.jpg";

        public static String FILE_DOWNLOAD_TEST_URL = "http://pic.58pic.com/58pic/13/86/80/95h58PIC5jK_1024.jpg";
    }

    public static class KEY{

        // 启动页注册登录等
        public static final String KEY_STU_NAME = "student_name";
        public static final String KEY_STU_NUMBER = "student_id"; // 学生学号，不同于数据库里的记录id
        public static final String KEY_STU_PASSWORD = "student_password";
        public static final String KEY_STU_COURSE_CODE = "student_course_code";

        public static final String KEY_DATA_GET_METHOD = "data_get_from";

        public static final String KEY_BONUS_TYPE = "bonus_type";

        public static final String KEY_MODULE_ID = "module_id";
        public static final String KEY_ACTION_ID = "action_id";

        public static final String KEY_TEACHER_ID = "t_id";
        public static final String KEY_STUDENT_ID = "s_id"; // 数据库里的记录id
        public static final String KEY_COURSE_ID  = "c_id";

        //Course 相关信息
        public static final String KEY_COURSE_NAME = "course_name";
        public static final String KEY_COURSE_TIME = "course_time";


        //Attendance，考勤模块
        public static final String KEY_ATTENDANCE_ID = "attendance_id";
        public static final String KEY_ATTENDANCE_CODE = "attendance_code";
        public static final String KEY_ATTENDANCE_STATUS = "attendance_status";
        public static final String KEY_ATTENDANCE_BONUS_NUM = "attendance_bonus_num";
        public static final String KEY_ATTENDANCE_TIME = "attendance_time";
        public static final String KEY_ATTENDANCE_ATT_COUNT = "attendance_count";
        public static final String KEY_ATTENDANCE_ABS_COUNT = "absence_count";
        public static final String KEY_ATTENDANCE_VALID_DURATION = "attendance_valid_time";

        //Attention, 专注模块
        public static final String KEY_ATTENTION_ID = "attention_id";
        public static final String KEY_ATTENTION_TIME = "attention_time";
        public static final String KEY_ATTENTION_DURATION = "attention_duration";
        public static final String KEY_ATTENTION_FOCUS_COUNT = "attention_focus_count";
        public static final String KEY_ATTENTION_LOST_FOCUS_COUNT = "attention_lost_focus_count";
        public static final String KEY_ATTENTION_BONUS_NUM = "attention_bonus_num";
        public static final String KEY_ATTENTION_STATUS = "attention_status";

        //Summary, 总结反馈模块
        public static final String KEY_SUMMARY_REQUEST_TIME = "summary_request_time";
        public static final String KEY_SUMMARY_BONUS_NUM = "summary_bonus_num";
        public static final String KEY_SUMMARY_CONTENT = "summary_content";
        public static final String KEY_SUMMARY_STATUS = "summary_status";
        public static final String KEY_SUMMARY_SEND_TIME = "summary_send_time";

        //Homework, 作业模块
        public static final String KEY_HOMEWORK_PUBLISH_TIME = "homework_publish_time";
        public static final String KEY_HOMEWORK_SUBMIT_DDL = "homework_submit_ddl";
        public static final String KEY_HOMEWORK_CURRENT_TIME = "homework_current_time";
        public static final String KEY_HOMEWORK_STATUS = "homework_status";
        public static final String KEY_HOMEWORK_SCORE = "homework_score";
        public static final String KEY_HOMEWORK_RANK = "homework_rank";
        public static final String KEY_HOMEWORK_BONUS_NUM = "homework_bonus_num";
        public static final String KEY_HOMEWORK_TITLE = "homework_title";
        public static final String KEY_HOMEWORK_CONTENT = "homework_content";

        // Planter，首页
        public static final String KEY_PLANTER_STATUS = "planter_status";
        public static final String KEY_PLANTER_HAD_SUNSHINE = "planter_had_sunshine";
        public static final String KEY_PLANTER_HAD_WATER = "planter_had_water";
        public static final String KEY_PLANTER_HAD_SOIL = "planter_had_soil";
        public static final String KEY_PLANTER_PERCENTAGE = "planter_percentage";

        // Planter, 详情页
        public static final String KEY_PLANTER_USED_SUNSHINE = "planter_used_sunshine";
        public static final String KEY_PLANTER_USED_WATER = "planter_used_water";
        public static final String KEY_PLANTER_USED_SOIL = "planter_used_soil";
        public static final String KEY_PLANTER_RANK = "planter_rank"; // 详情页排名
        public static final String KEY_PLANTER_EVALUATION = "planter_evaluation"; // 成长树成长情况评估
        public static final String KEY_PLANTER_TITLE = "planter_title"; // 成长树系统认证称号
    }

    public static class DATA_FROM {
        public static final int DATA_FROM_PUSH = 1;
        public static final int DATA_FROM_REQUEST = 2;
    }

    public static class ATTENDANCE{
        public static final int ATTENDANCE_STATUS_SUCCESS = 1;
        public static final int ATTENDANCE_STATUS_FAIL = -2;
        public static final int ATTENDANCE_STATUS_ALREADY_CHECK_SUCCESS = 0;
        public static final int ATTENDANCE_STATUS_NOT_IN_TIME = -1;
        public static final int ATTENDANCE_STATUS_CODE_ERROR = -3;
        public static final int ATTENDANCE_STATUS_DEFAULT = -100;
    }

    public static class ATTENTION {
        public static final int ATTENTION_STATUS_SUCCESS = 1;
        public static final int ATTENTION_STATUS_DEFAULT = 0;
        public static final int ATTENTION_STATUS_FAIL = -3;
        public static final int ATTENTION_STATUS_NOT_PAY_ATTENTION = -1; // 未参与本次专注
        public static final int ATTENTION_STATUS_NOT_IN_TIME = -2; // 不在专注时间
    }

    public static class SUMMARY{
        public static final int SUMMARY_WAIT_FOR_SENDING = 0;
        public static final int SUMMARY_SEND_SUCCESS = 1;
        public static final int SUMMARY_CHECKING = 2;
    }

    public static class HOMEWORK{
        public static final int HOMEWORK_PUBLISHED = 0;
        public static final int HOMEWORK_SUBMIT_SUCCESS = 1;
        public static final int HOMEWORK_SCORED = 2;
    }

    public static class SIGN_UP_AND_LOGIN{
            public static int STATUS_COURSE_CODE_UNAVAILABLE = -100;
            public static int STATUS_COURSE_CODE_VALIDATE_SUCCESS = 1;
    }

    public static class TREE_STATUS{
        public static final int TREE_SEED = 0;
        public static final int TREE_SEEDLING = 1;
        public static final int TREE_SEEDLING_MATURE = 2;
        public static final int TREE_DEVELOPMENT = 3;
        public static final int TREE_MATURE = 4;
        public static final int TREE_FINAL = 5;

        public static final int TREE_MORE_THAN_FINAL = 6;
    }

    public static class BONUS_TYPE{
        public static final int BONUS_SUNSHINE = 1;
        public static final int BONUS_WATER = 2;
        public static final int BONUS_SOIL = 3;
    }

    public static class EVALUATION{
        public static final int EVAL_GOOD = 1;
    }

    public static class TREE{

        public static class SEED{
            public static final int SEED_TOTAL_SUNSHINE = 0;
            public static final int SEED_TOTAL_WATER = 0;
            public static final int SEED_TOTAL_SOIL = 0;
            public static final int SEED_TOTAL_ELEM_NUM = SEED_TOTAL_SOIL + SEED_TOTAL_SUNSHINE + SEED_TOTAL_WATER;
        }

        public static class SEEDLING{
            public static final int SEEDLING_TOTAL_SUNSHINE = 25;
            public static final int SEEDLING_TOTAL_WATER = 25;
            public static final int SEEDLING_TOTAL_SOIL = 25;
            public static final int SEEDLING_TOTAL_ELEM_NUM = SEEDLING_TOTAL_SUNSHINE + SEEDLING_TOTAL_WATER + SEEDLING_TOTAL_SOIL;
        }

        public static class SEEDLING_MATURE{
            public static final int SEEDLING_MATURE_TOTAL_SUNSHINE = 50;
            public static final int SEEDLING_MATURE_TOTAL_WATER = 50;
            public static final int SEEDLING_MATURE_TOTAL_SOIL = 50;
            public static final int SEEDLING_MATURE_TOTAL_ELEM_NUM = SEEDLING_MATURE_TOTAL_SUNSHINE + SEEDLING_MATURE_TOTAL_WATER + SEEDLING_MATURE_TOTAL_SOIL;
        }

        public static class TREE_DEVELOPMENT{
            public static final int TREE_DEVELOPMENT_TOTAL_SUNSHINE = 100;
            public static final int TREE_DEVELOPMENT_TOTAL_WATER = 100;
            public static final int TREE_DEVELOPMENT_TOTAL_SOIL = 100;
            public static final int TREE_DEVELOPMENT_TOTAL_ELEM_NUM = TREE_DEVELOPMENT_TOTAL_SUNSHINE + TREE_DEVELOPMENT_TOTAL_WATER + TREE_DEVELOPMENT_TOTAL_SOIL;
        }

        public static class TREE_MATURE{
            public static final int TREE_MATURE_TOTAL_SUNSHINE = 150;
            public static final int TREE_MATURE_TOTAL_WATER = 150;
            public static final int TREE_MATURE_TOTAL_SOIL = 150;
            public static final int TREE_MATURE_TOTAL_ELEM_NUM = TREE_MATURE_TOTAL_SUNSHINE + TREE_MATURE_TOTAL_WATER + TREE_MATURE_TOTAL_SOIL;
        }

        public static class TREE_FINAL{
            public static final int TREE_FINAL_TOTAL_SUNSHINE = 200;
            public static final int TREE_FINAL_TOTAL_WATER = 200;
            public static final int TREE_FINAL_TOTAL_SOIL = 200;
            public static final int TREE_FINAL_TOTAL_ELEM_NUM = TREE_FINAL_TOTAL_SUNSHINE + TREE_FINAL_TOTAL_WATER + TREE_FINAL_TOTAL_SOIL;
        }

    }


    public static String JPUSH_ALIAS = "Planter";


    public String TYPE = "type";
    public static final int MODULE_FRAME_PLANTER = 10;
    public static final int MODULE_PLANTER_DETAIL = 11;
    public static final int MODULE_FRAME_NOTIFICATION = 1;
    public static final int MODULE_FRAME_RESOURCE = 2;

    public static final int MODULE_COURSE_ATTENDANCE = 3;
    public static final int MODULE_COURSE_ATTENTION = 4;
    public static final int MODULE_COURSE_SUMMARY = 5;
    public static final int MODULE_COURSE_HOMEWORK = 6;
    public static final int MODULE_COURSE_GROUP = 7;
    public static final int MODULE_COURSE_OTHERS = 8;
    public static final int MODULE_COURSE_INTERACTION = 9;

    public static final String MODULE_PLANTER_NAME = "Planter";

    public static final String MODULE_COURSE_INTERACTION_NAME = "Interaction";

    public static final String MODULE_COURSE_ATTENDANCE_NAME = "Attendance";
    public static final String MODULE_COURSE_ATTENTION_NAME = "Attention";
    public static final String MODULE_COURSE_SUMMARY_NAME = "Summary";
    public static final String MODULE_COURSE_HOMEWORK_NAME = "Homework";
    public static final String MODULE_COURSE_GROUP_NAME = "Group";
    public static final String MODULE_COURSE_OTHERS_NAME = "Others";

    public static final String TEST_LONG_TITLE = "作业标题作业标题作业标题作业标题作业标题作业标题作业标题作业标题作业标题";

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
