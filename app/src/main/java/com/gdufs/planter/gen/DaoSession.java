package com.gdufs.planter.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.gdufs.planter.module.attendance.model.AttendanceViewDBModel;
import com.gdufs.planter.module.attention.model.AttentionViewDBModel;
import com.gdufs.planter.module.group.model.GroupPushModel;
import com.gdufs.planter.module.homework.model.HomeworkViewDBModel;
import com.gdufs.planter.module.planter.model.PlanterDetailViewDBModel;
import com.gdufs.planter.module.planter.model.PlanterViewDBModel;
import com.gdufs.planter.module.summary.model.SummaryViewDBModel;

import com.gdufs.planter.gen.AttendanceViewDBModelDao;
import com.gdufs.planter.gen.AttentionViewDBModelDao;
import com.gdufs.planter.gen.GroupPushModelDao;
import com.gdufs.planter.gen.HomeworkViewDBModelDao;
import com.gdufs.planter.gen.PlanterDetailViewDBModelDao;
import com.gdufs.planter.gen.PlanterViewDBModelDao;
import com.gdufs.planter.gen.SummaryViewDBModelDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig attendanceViewDBModelDaoConfig;
    private final DaoConfig attentionViewDBModelDaoConfig;
    private final DaoConfig groupPushModelDaoConfig;
    private final DaoConfig homeworkViewDBModelDaoConfig;
    private final DaoConfig planterDetailViewDBModelDaoConfig;
    private final DaoConfig planterViewDBModelDaoConfig;
    private final DaoConfig summaryViewDBModelDaoConfig;

    private final AttendanceViewDBModelDao attendanceViewDBModelDao;
    private final AttentionViewDBModelDao attentionViewDBModelDao;
    private final GroupPushModelDao groupPushModelDao;
    private final HomeworkViewDBModelDao homeworkViewDBModelDao;
    private final PlanterDetailViewDBModelDao planterDetailViewDBModelDao;
    private final PlanterViewDBModelDao planterViewDBModelDao;
    private final SummaryViewDBModelDao summaryViewDBModelDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        attendanceViewDBModelDaoConfig = daoConfigMap.get(AttendanceViewDBModelDao.class).clone();
        attendanceViewDBModelDaoConfig.initIdentityScope(type);

        attentionViewDBModelDaoConfig = daoConfigMap.get(AttentionViewDBModelDao.class).clone();
        attentionViewDBModelDaoConfig.initIdentityScope(type);

        groupPushModelDaoConfig = daoConfigMap.get(GroupPushModelDao.class).clone();
        groupPushModelDaoConfig.initIdentityScope(type);

        homeworkViewDBModelDaoConfig = daoConfigMap.get(HomeworkViewDBModelDao.class).clone();
        homeworkViewDBModelDaoConfig.initIdentityScope(type);

        planterDetailViewDBModelDaoConfig = daoConfigMap.get(PlanterDetailViewDBModelDao.class).clone();
        planterDetailViewDBModelDaoConfig.initIdentityScope(type);

        planterViewDBModelDaoConfig = daoConfigMap.get(PlanterViewDBModelDao.class).clone();
        planterViewDBModelDaoConfig.initIdentityScope(type);

        summaryViewDBModelDaoConfig = daoConfigMap.get(SummaryViewDBModelDao.class).clone();
        summaryViewDBModelDaoConfig.initIdentityScope(type);

        attendanceViewDBModelDao = new AttendanceViewDBModelDao(attendanceViewDBModelDaoConfig, this);
        attentionViewDBModelDao = new AttentionViewDBModelDao(attentionViewDBModelDaoConfig, this);
        groupPushModelDao = new GroupPushModelDao(groupPushModelDaoConfig, this);
        homeworkViewDBModelDao = new HomeworkViewDBModelDao(homeworkViewDBModelDaoConfig, this);
        planterDetailViewDBModelDao = new PlanterDetailViewDBModelDao(planterDetailViewDBModelDaoConfig, this);
        planterViewDBModelDao = new PlanterViewDBModelDao(planterViewDBModelDaoConfig, this);
        summaryViewDBModelDao = new SummaryViewDBModelDao(summaryViewDBModelDaoConfig, this);

        registerDao(AttendanceViewDBModel.class, attendanceViewDBModelDao);
        registerDao(AttentionViewDBModel.class, attentionViewDBModelDao);
        registerDao(GroupPushModel.class, groupPushModelDao);
        registerDao(HomeworkViewDBModel.class, homeworkViewDBModelDao);
        registerDao(PlanterDetailViewDBModel.class, planterDetailViewDBModelDao);
        registerDao(PlanterViewDBModel.class, planterViewDBModelDao);
        registerDao(SummaryViewDBModel.class, summaryViewDBModelDao);
    }
    
    public void clear() {
        attendanceViewDBModelDaoConfig.clearIdentityScope();
        attentionViewDBModelDaoConfig.clearIdentityScope();
        groupPushModelDaoConfig.clearIdentityScope();
        homeworkViewDBModelDaoConfig.clearIdentityScope();
        planterDetailViewDBModelDaoConfig.clearIdentityScope();
        planterViewDBModelDaoConfig.clearIdentityScope();
        summaryViewDBModelDaoConfig.clearIdentityScope();
    }

    public AttendanceViewDBModelDao getAttendanceViewDBModelDao() {
        return attendanceViewDBModelDao;
    }

    public AttentionViewDBModelDao getAttentionViewDBModelDao() {
        return attentionViewDBModelDao;
    }

    public GroupPushModelDao getGroupPushModelDao() {
        return groupPushModelDao;
    }

    public HomeworkViewDBModelDao getHomeworkViewDBModelDao() {
        return homeworkViewDBModelDao;
    }

    public PlanterDetailViewDBModelDao getPlanterDetailViewDBModelDao() {
        return planterDetailViewDBModelDao;
    }

    public PlanterViewDBModelDao getPlanterViewDBModelDao() {
        return planterViewDBModelDao;
    }

    public SummaryViewDBModelDao getSummaryViewDBModelDao() {
        return summaryViewDBModelDao;
    }

}
