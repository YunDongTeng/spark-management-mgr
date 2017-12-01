package cn.sparke.modules.siteSection.service;

import cn.sparke.core.common.entity.BaseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import cn.sparke.modules.siteSection.mapper.SiteSectionMapper;
import cn.sparke.modules.siteSection.entity.SiteSectionEntity;

import java.util.List;

/**
 * 网站学段关系Dao
 *
 * @author spark
 * @Date 2017-12-01 12:33:58
 */
@Service
public class SiteSectionService{
    @Autowired
    private SiteSectionMapper siteSectionMapper;

    public void save(SiteSectionEntity siteSection){
        siteSection.preInsert();
        siteSectionMapper.insert(siteSection);
    }

    public void update(SiteSectionEntity siteSection){
        siteSection.preUpdate();
        siteSectionMapper.update(siteSection);
    }

    public SiteSectionEntity get(SiteSectionEntity siteSection){
        return siteSectionMapper.get(siteSection);
    }

    public SiteSectionEntity getById(String id){
        return siteSectionMapper.getById(id);
    }
    public Page<SiteSectionEntity> findList(SiteSectionEntity siteSection){
       return siteSectionMapper.findList(siteSection);
    }

    public void deleteById(String id){
      siteSectionMapper.deleteById(id);
    }

    public List<SiteSectionEntity> findUnbindList(SiteSectionEntity entity) {
        return siteSectionMapper.findUnbindList(entity);
    }

    public List<SiteSectionEntity>  findBindList(SiteSectionEntity entity) {
        return siteSectionMapper.findBindList(entity);
    }

    public void batchInsert(List<SiteSectionEntity> list) {
        list.forEach(BaseEntity::preInsert);
        siteSectionMapper.batchInsert(list);
    }
}
