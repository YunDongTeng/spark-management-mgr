package cn.sparke.modules.gradeSubject.mapper;

import cn.sparke.core.modules.mybatis.mapper.BaseMapper;
import cn.sparke.modules.gradeSubject.entity.GradeSubjectEntity;

import java.util.List;

/**
 * 年级科目Dao
 *
 * @author spark
 * @Date 2017-12-01 14:11:43
 */
public interface GradeSubjectMapper extends BaseMapper<GradeSubjectEntity>{


    void batchInsert(List<GradeSubjectEntity> list);

    List<GradeSubjectEntity> findUnbindList(GradeSubjectEntity entity);

    List<GradeSubjectEntity> findBindList(GradeSubjectEntity entity);
}
