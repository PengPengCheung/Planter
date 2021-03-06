package com.gdufs.planter.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.gdufs.planter.module.summary.model.SummaryViewDBModel;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SUMMARY_VIEW_DBMODEL".
*/
public class SummaryViewDBModelDao extends AbstractDao<SummaryViewDBModel, Long> {

    public static final String TABLENAME = "SUMMARY_VIEW_DBMODEL";

    /**
     * Properties of entity SummaryViewDBModel.<br/>
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
        public final static Property MSummaryId = new Property(7, String.class, "mSummaryId", false, "M_SUMMARY_ID");
        public final static Property MSummaryRequestTime = new Property(8, String.class, "mSummaryRequestTime", false, "M_SUMMARY_REQUEST_TIME");
        public final static Property MSummaryBonusNum = new Property(9, int.class, "mSummaryBonusNum", false, "M_SUMMARY_BONUS_NUM");
        public final static Property MSummaryBonusType = new Property(10, int.class, "mSummaryBonusType", false, "M_SUMMARY_BONUS_TYPE");
        public final static Property MSummaryContent = new Property(11, String.class, "mSummaryContent", false, "M_SUMMARY_CONTENT");
        public final static Property MSummaryStatus = new Property(12, int.class, "mSummaryStatus", false, "M_SUMMARY_STATUS");
        public final static Property MOpenClassId = new Property(13, String.class, "mOpenClassId", false, "M_OPEN_CLASS_ID");
    }


    public SummaryViewDBModelDao(DaoConfig config) {
        super(config);
    }
    
    public SummaryViewDBModelDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SUMMARY_VIEW_DBMODEL\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"M_DATA_FROM\" INTEGER NOT NULL ," + // 1: mDataFrom
                "\"M_COURSE_ID\" TEXT," + // 2: mCourseId
                "\"M_MODULE_ID\" INTEGER NOT NULL ," + // 3: mModuleId
                "\"M_ACTION_ID\" INTEGER NOT NULL ," + // 4: mActionId
                "\"M_TEACHER_ID\" TEXT," + // 5: mTeacherId
                "\"M_STUDENT_ID\" TEXT," + // 6: mStudentId
                "\"M_SUMMARY_ID\" TEXT," + // 7: mSummaryId
                "\"M_SUMMARY_REQUEST_TIME\" TEXT," + // 8: mSummaryRequestTime
                "\"M_SUMMARY_BONUS_NUM\" INTEGER NOT NULL ," + // 9: mSummaryBonusNum
                "\"M_SUMMARY_BONUS_TYPE\" INTEGER NOT NULL ," + // 10: mSummaryBonusType
                "\"M_SUMMARY_CONTENT\" TEXT," + // 11: mSummaryContent
                "\"M_SUMMARY_STATUS\" INTEGER NOT NULL ," + // 12: mSummaryStatus
                "\"M_OPEN_CLASS_ID\" TEXT);"); // 13: mOpenClassId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SUMMARY_VIEW_DBMODEL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SummaryViewDBModel entity) {
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
 
        String mSummaryId = entity.getMSummaryId();
        if (mSummaryId != null) {
            stmt.bindString(8, mSummaryId);
        }
 
        String mSummaryRequestTime = entity.getMSummaryRequestTime();
        if (mSummaryRequestTime != null) {
            stmt.bindString(9, mSummaryRequestTime);
        }
        stmt.bindLong(10, entity.getMSummaryBonusNum());
        stmt.bindLong(11, entity.getMSummaryBonusType());
 
        String mSummaryContent = entity.getMSummaryContent();
        if (mSummaryContent != null) {
            stmt.bindString(12, mSummaryContent);
        }
        stmt.bindLong(13, entity.getMSummaryStatus());
 
        String mOpenClassId = entity.getMOpenClassId();
        if (mOpenClassId != null) {
            stmt.bindString(14, mOpenClassId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SummaryViewDBModel entity) {
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
 
        String mSummaryId = entity.getMSummaryId();
        if (mSummaryId != null) {
            stmt.bindString(8, mSummaryId);
        }
 
        String mSummaryRequestTime = entity.getMSummaryRequestTime();
        if (mSummaryRequestTime != null) {
            stmt.bindString(9, mSummaryRequestTime);
        }
        stmt.bindLong(10, entity.getMSummaryBonusNum());
        stmt.bindLong(11, entity.getMSummaryBonusType());
 
        String mSummaryContent = entity.getMSummaryContent();
        if (mSummaryContent != null) {
            stmt.bindString(12, mSummaryContent);
        }
        stmt.bindLong(13, entity.getMSummaryStatus());
 
        String mOpenClassId = entity.getMOpenClassId();
        if (mOpenClassId != null) {
            stmt.bindString(14, mOpenClassId);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public SummaryViewDBModel readEntity(Cursor cursor, int offset) {
        SummaryViewDBModel entity = new SummaryViewDBModel( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // mDataFrom
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // mCourseId
            cursor.getInt(offset + 3), // mModuleId
            cursor.getInt(offset + 4), // mActionId
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // mTeacherId
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // mStudentId
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // mSummaryId
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // mSummaryRequestTime
            cursor.getInt(offset + 9), // mSummaryBonusNum
            cursor.getInt(offset + 10), // mSummaryBonusType
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // mSummaryContent
            cursor.getInt(offset + 12), // mSummaryStatus
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13) // mOpenClassId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SummaryViewDBModel entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMDataFrom(cursor.getInt(offset + 1));
        entity.setMCourseId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMModuleId(cursor.getInt(offset + 3));
        entity.setMActionId(cursor.getInt(offset + 4));
        entity.setMTeacherId(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setMStudentId(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setMSummaryId(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setMSummaryRequestTime(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setMSummaryBonusNum(cursor.getInt(offset + 9));
        entity.setMSummaryBonusType(cursor.getInt(offset + 10));
        entity.setMSummaryContent(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setMSummaryStatus(cursor.getInt(offset + 12));
        entity.setMOpenClassId(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(SummaryViewDBModel entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(SummaryViewDBModel entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(SummaryViewDBModel entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
