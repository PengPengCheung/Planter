package com.gdufs.planter.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.gdufs.planter.module.homework.model.HomeworkViewDBModel;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "HOMEWORK_VIEW_DBMODEL".
*/
public class HomeworkViewDBModelDao extends AbstractDao<HomeworkViewDBModel, Long> {

    public static final String TABLENAME = "HOMEWORK_VIEW_DBMODEL";

    /**
     * Properties of entity HomeworkViewDBModel.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property MDataFrom = new Property(1, int.class, "mDataFrom", false, "M_DATA_FROM");
        public final static Property MCourseId = new Property(2, String.class, "mCourseId", false, "M_COURSE_ID");
        public final static Property MModuleId = new Property(3, int.class, "mModuleId", false, "M_MODULE_ID");
        public final static Property MActionId = new Property(4, int.class, "mActionId", false, "M_ACTION_ID");
        public final static Property MTeacherId = new Property(5, String.class, "mTeacherId", false, "M_TEACHER_ID");
        public final static Property MStudentId = new Property(6, String.class, "mStudentId", false, "M_STUDENT_ID");
        public final static Property MHomeworkId = new Property(7, String.class, "mHomeworkId", false, "M_HOMEWORK_ID");
        public final static Property MHomeworkStatus = new Property(8, int.class, "mHomeworkStatus", false, "M_HOMEWORK_STATUS");
        public final static Property MHomeworkTitle = new Property(9, String.class, "mHomeworkTitle", false, "M_HOMEWORK_TITLE");
        public final static Property MHomeworkContent = new Property(10, String.class, "mHomeworkContent", false, "M_HOMEWORK_CONTENT");
        public final static Property MHomeworkSubmitDDL = new Property(11, String.class, "mHomeworkSubmitDDL", false, "M_HOMEWORK_SUBMIT_DDL");
        public final static Property MHomeworkPublishTime = new Property(12, String.class, "mHomeworkPublishTime", false, "M_HOMEWORK_PUBLISH_TIME");
        public final static Property MHomeworkItemCurrentTime = new Property(13, String.class, "mHomeworkItemCurrentTime", false, "M_HOMEWORK_ITEM_CURRENT_TIME");
        public final static Property MHomeworkScore = new Property(14, int.class, "mHomeworkScore", false, "M_HOMEWORK_SCORE");
        public final static Property MHomeworkRank = new Property(15, int.class, "mHomeworkRank", false, "M_HOMEWORK_RANK");
        public final static Property MHomeworkBonusNum = new Property(16, int.class, "mHomeworkBonusNum", false, "M_HOMEWORK_BONUS_NUM");
    }


    public HomeworkViewDBModelDao(DaoConfig config) {
        super(config);
    }
    
    public HomeworkViewDBModelDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"HOMEWORK_VIEW_DBMODEL\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"M_DATA_FROM\" INTEGER NOT NULL ," + // 1: mDataFrom
                "\"M_COURSE_ID\" TEXT," + // 2: mCourseId
                "\"M_MODULE_ID\" INTEGER NOT NULL ," + // 3: mModuleId
                "\"M_ACTION_ID\" INTEGER NOT NULL ," + // 4: mActionId
                "\"M_TEACHER_ID\" TEXT," + // 5: mTeacherId
                "\"M_STUDENT_ID\" TEXT," + // 6: mStudentId
                "\"M_HOMEWORK_ID\" TEXT," + // 7: mHomeworkId
                "\"M_HOMEWORK_STATUS\" INTEGER NOT NULL ," + // 8: mHomeworkStatus
                "\"M_HOMEWORK_TITLE\" TEXT," + // 9: mHomeworkTitle
                "\"M_HOMEWORK_CONTENT\" TEXT," + // 10: mHomeworkContent
                "\"M_HOMEWORK_SUBMIT_DDL\" TEXT," + // 11: mHomeworkSubmitDDL
                "\"M_HOMEWORK_PUBLISH_TIME\" TEXT," + // 12: mHomeworkPublishTime
                "\"M_HOMEWORK_ITEM_CURRENT_TIME\" TEXT," + // 13: mHomeworkItemCurrentTime
                "\"M_HOMEWORK_SCORE\" INTEGER NOT NULL ," + // 14: mHomeworkScore
                "\"M_HOMEWORK_RANK\" INTEGER NOT NULL ," + // 15: mHomeworkRank
                "\"M_HOMEWORK_BONUS_NUM\" INTEGER NOT NULL );"); // 16: mHomeworkBonusNum
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"HOMEWORK_VIEW_DBMODEL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, HomeworkViewDBModel entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getMDataFrom());
 
        String mCourseId = entity.getMCourseId();
        if (mCourseId != null) {
            stmt.bindString(3, mCourseId);
        }
        stmt.bindLong(4, entity.getMModuleId());
        stmt.bindLong(5, entity.getMActionId());
 
        String mTeacherId = entity.getMTeacherId();
        if (mTeacherId != null) {
            stmt.bindString(6, mTeacherId);
        }
 
        String mStudentId = entity.getMStudentId();
        if (mStudentId != null) {
            stmt.bindString(7, mStudentId);
        }
 
        String mHomeworkId = entity.getMHomeworkId();
        if (mHomeworkId != null) {
            stmt.bindString(8, mHomeworkId);
        }
        stmt.bindLong(9, entity.getMHomeworkStatus());
 
        String mHomeworkTitle = entity.getMHomeworkTitle();
        if (mHomeworkTitle != null) {
            stmt.bindString(10, mHomeworkTitle);
        }
 
        String mHomeworkContent = entity.getMHomeworkContent();
        if (mHomeworkContent != null) {
            stmt.bindString(11, mHomeworkContent);
        }
 
        String mHomeworkSubmitDDL = entity.getMHomeworkSubmitDDL();
        if (mHomeworkSubmitDDL != null) {
            stmt.bindString(12, mHomeworkSubmitDDL);
        }
 
        String mHomeworkPublishTime = entity.getMHomeworkPublishTime();
        if (mHomeworkPublishTime != null) {
            stmt.bindString(13, mHomeworkPublishTime);
        }
 
        String mHomeworkItemCurrentTime = entity.getMHomeworkItemCurrentTime();
        if (mHomeworkItemCurrentTime != null) {
            stmt.bindString(14, mHomeworkItemCurrentTime);
        }
        stmt.bindLong(15, entity.getMHomeworkScore());
        stmt.bindLong(16, entity.getMHomeworkRank());
        stmt.bindLong(17, entity.getMHomeworkBonusNum());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, HomeworkViewDBModel entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getMDataFrom());
 
        String mCourseId = entity.getMCourseId();
        if (mCourseId != null) {
            stmt.bindString(3, mCourseId);
        }
        stmt.bindLong(4, entity.getMModuleId());
        stmt.bindLong(5, entity.getMActionId());
 
        String mTeacherId = entity.getMTeacherId();
        if (mTeacherId != null) {
            stmt.bindString(6, mTeacherId);
        }
 
        String mStudentId = entity.getMStudentId();
        if (mStudentId != null) {
            stmt.bindString(7, mStudentId);
        }
 
        String mHomeworkId = entity.getMHomeworkId();
        if (mHomeworkId != null) {
            stmt.bindString(8, mHomeworkId);
        }
        stmt.bindLong(9, entity.getMHomeworkStatus());
 
        String mHomeworkTitle = entity.getMHomeworkTitle();
        if (mHomeworkTitle != null) {
            stmt.bindString(10, mHomeworkTitle);
        }
 
        String mHomeworkContent = entity.getMHomeworkContent();
        if (mHomeworkContent != null) {
            stmt.bindString(11, mHomeworkContent);
        }
 
        String mHomeworkSubmitDDL = entity.getMHomeworkSubmitDDL();
        if (mHomeworkSubmitDDL != null) {
            stmt.bindString(12, mHomeworkSubmitDDL);
        }
 
        String mHomeworkPublishTime = entity.getMHomeworkPublishTime();
        if (mHomeworkPublishTime != null) {
            stmt.bindString(13, mHomeworkPublishTime);
        }
 
        String mHomeworkItemCurrentTime = entity.getMHomeworkItemCurrentTime();
        if (mHomeworkItemCurrentTime != null) {
            stmt.bindString(14, mHomeworkItemCurrentTime);
        }
        stmt.bindLong(15, entity.getMHomeworkScore());
        stmt.bindLong(16, entity.getMHomeworkRank());
        stmt.bindLong(17, entity.getMHomeworkBonusNum());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public HomeworkViewDBModel readEntity(Cursor cursor, int offset) {
        HomeworkViewDBModel entity = new HomeworkViewDBModel( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // mDataFrom
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // mCourseId
            cursor.getInt(offset + 3), // mModuleId
            cursor.getInt(offset + 4), // mActionId
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // mTeacherId
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // mStudentId
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // mHomeworkId
            cursor.getInt(offset + 8), // mHomeworkStatus
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // mHomeworkTitle
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // mHomeworkContent
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // mHomeworkSubmitDDL
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // mHomeworkPublishTime
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // mHomeworkItemCurrentTime
            cursor.getInt(offset + 14), // mHomeworkScore
            cursor.getInt(offset + 15), // mHomeworkRank
            cursor.getInt(offset + 16) // mHomeworkBonusNum
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, HomeworkViewDBModel entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMDataFrom(cursor.getInt(offset + 1));
        entity.setMCourseId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMModuleId(cursor.getInt(offset + 3));
        entity.setMActionId(cursor.getInt(offset + 4));
        entity.setMTeacherId(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setMStudentId(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setMHomeworkId(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setMHomeworkStatus(cursor.getInt(offset + 8));
        entity.setMHomeworkTitle(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setMHomeworkContent(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setMHomeworkSubmitDDL(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setMHomeworkPublishTime(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setMHomeworkItemCurrentTime(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setMHomeworkScore(cursor.getInt(offset + 14));
        entity.setMHomeworkRank(cursor.getInt(offset + 15));
        entity.setMHomeworkBonusNum(cursor.getInt(offset + 16));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(HomeworkViewDBModel entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(HomeworkViewDBModel entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(HomeworkViewDBModel entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}