package com.gdufs.planter.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.gdufs.planter.module.planter.model.PlanterViewDBModel;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PLANTER_VIEW_DBMODEL".
*/
public class PlanterViewDBModelDao extends AbstractDao<PlanterViewDBModel, Long> {

    public static final String TABLENAME = "PLANTER_VIEW_DBMODEL";

    /**
     * Properties of entity PlanterViewDBModel.<br/>
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
        public final static Property MPlanterStatus = new Property(7, int.class, "mPlanterStatus", false, "M_PLANTER_STATUS");
        public final static Property MCourseName = new Property(8, String.class, "mCourseName", false, "M_COURSE_NAME");
        public final static Property MCourseTime = new Property(9, String.class, "mCourseTime", false, "M_COURSE_TIME");
        public final static Property MPlanterSunshine = new Property(10, int.class, "mPlanterSunshine", false, "M_PLANTER_SUNSHINE");
        public final static Property MPlanterWater = new Property(11, int.class, "mPlanterWater", false, "M_PLANTER_WATER");
        public final static Property MPlanterSoil = new Property(12, int.class, "mPlanterSoil", false, "M_PLANTER_SOIL");
        public final static Property MPlanterPercent = new Property(13, int.class, "mPlanterPercent", false, "M_PLANTER_PERCENT");
    }


    public PlanterViewDBModelDao(DaoConfig config) {
        super(config);
    }
    
    public PlanterViewDBModelDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PLANTER_VIEW_DBMODEL\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"M_DATA_FROM\" INTEGER NOT NULL ," + // 1: mDataFrom
                "\"M_COURSE_ID\" TEXT," + // 2: mCourseId
                "\"M_MODULE_ID\" INTEGER NOT NULL ," + // 3: mModuleId
                "\"M_ACTION_ID\" INTEGER NOT NULL ," + // 4: mActionId
                "\"M_TEACHER_ID\" TEXT," + // 5: mTeacherId
                "\"M_STUDENT_ID\" TEXT," + // 6: mStudentId
                "\"M_PLANTER_STATUS\" INTEGER NOT NULL ," + // 7: mPlanterStatus
                "\"M_COURSE_NAME\" TEXT," + // 8: mCourseName
                "\"M_COURSE_TIME\" TEXT," + // 9: mCourseTime
                "\"M_PLANTER_SUNSHINE\" INTEGER NOT NULL ," + // 10: mPlanterSunshine
                "\"M_PLANTER_WATER\" INTEGER NOT NULL ," + // 11: mPlanterWater
                "\"M_PLANTER_SOIL\" INTEGER NOT NULL ," + // 12: mPlanterSoil
                "\"M_PLANTER_PERCENT\" INTEGER NOT NULL );"); // 13: mPlanterPercent
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PLANTER_VIEW_DBMODEL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PlanterViewDBModel entity) {
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
        stmt.bindLong(8, entity.getMPlanterStatus());
 
        String mCourseName = entity.getMCourseName();
        if (mCourseName != null) {
            stmt.bindString(9, mCourseName);
        }
 
        String mCourseTime = entity.getMCourseTime();
        if (mCourseTime != null) {
            stmt.bindString(10, mCourseTime);
        }
        stmt.bindLong(11, entity.getMPlanterSunshine());
        stmt.bindLong(12, entity.getMPlanterWater());
        stmt.bindLong(13, entity.getMPlanterSoil());
        stmt.bindLong(14, entity.getMPlanterPercent());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PlanterViewDBModel entity) {
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
        stmt.bindLong(8, entity.getMPlanterStatus());
 
        String mCourseName = entity.getMCourseName();
        if (mCourseName != null) {
            stmt.bindString(9, mCourseName);
        }
 
        String mCourseTime = entity.getMCourseTime();
        if (mCourseTime != null) {
            stmt.bindString(10, mCourseTime);
        }
        stmt.bindLong(11, entity.getMPlanterSunshine());
        stmt.bindLong(12, entity.getMPlanterWater());
        stmt.bindLong(13, entity.getMPlanterSoil());
        stmt.bindLong(14, entity.getMPlanterPercent());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public PlanterViewDBModel readEntity(Cursor cursor, int offset) {
        PlanterViewDBModel entity = new PlanterViewDBModel( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // mDataFrom
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // mCourseId
            cursor.getInt(offset + 3), // mModuleId
            cursor.getInt(offset + 4), // mActionId
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // mTeacherId
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // mStudentId
            cursor.getInt(offset + 7), // mPlanterStatus
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // mCourseName
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // mCourseTime
            cursor.getInt(offset + 10), // mPlanterSunshine
            cursor.getInt(offset + 11), // mPlanterWater
            cursor.getInt(offset + 12), // mPlanterSoil
            cursor.getInt(offset + 13) // mPlanterPercent
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PlanterViewDBModel entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMDataFrom(cursor.getInt(offset + 1));
        entity.setMCourseId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMModuleId(cursor.getInt(offset + 3));
        entity.setMActionId(cursor.getInt(offset + 4));
        entity.setMTeacherId(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setMStudentId(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setMPlanterStatus(cursor.getInt(offset + 7));
        entity.setMCourseName(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setMCourseTime(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setMPlanterSunshine(cursor.getInt(offset + 10));
        entity.setMPlanterWater(cursor.getInt(offset + 11));
        entity.setMPlanterSoil(cursor.getInt(offset + 12));
        entity.setMPlanterPercent(cursor.getInt(offset + 13));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(PlanterViewDBModel entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(PlanterViewDBModel entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PlanterViewDBModel entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
