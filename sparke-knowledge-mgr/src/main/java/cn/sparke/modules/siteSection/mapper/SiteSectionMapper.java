package cn.sparke.modules.siteSection.mapper;

import cn.sparke.core.modules.mybatis.mapper.BaseMapper;
import cn.sparke.modules.siteSection.entity.SiteSectionEntity;

import java.util.List;

/**
 * 网站学段关系Dao
 *
 * @author spark
 * @Date 2017-12-01 12:33:58
 */
public interface SiteSectionMapper extends BaseMapper<SiteSectionEntity>{


    List<SiteSectionEntity> findUnbindList(SiteSectionEntity entity);

    List<SiteSectionEntity> findBindList(SiteSectionEntity entity);

    void batchInsert(List<SiteSectionEntity> list);
}
