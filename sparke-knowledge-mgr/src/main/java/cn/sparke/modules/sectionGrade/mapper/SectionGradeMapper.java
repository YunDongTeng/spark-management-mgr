package cn.sparke.modules.sectionGrade.mapper;

import cn.sparke.core.modules.mybatis.mapper.BaseMapper;
import cn.sparke.modules.sectionGrade.entity.SectionGradeEntity;

/**
 * 学段年级Dao
 *
 * @author spark
 * @Date 2017-12-01 09:04:38
 */
public interface SectionGradeMapper extends BaseMapper<SectionGradeEntity>{


    void deleteByParentId(String id);
}
