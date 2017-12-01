package cn.sparke.modules.gradeSubject.service;

import cn.sparke.modules.sectionGrade.mapper.SectionGradeMapper;
import cn.sparke.modules.siteSection.entity.SiteSectionEntity;
import cn.sparke.modules.siteSection.mapper.SiteSectionMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import cn.sparke.modules.gradeSubject.mapper.GradeSubjectMapper;
import cn.sparke.modules.gradeSubject.entity.GradeSubjectEntity;

import java.util.List;

/**
 * 年级科目Dao
 *
 * @author spark
 * @Date 2017-12-01 14:11:43
 */
@Service
public class GradeSubjectService{
    @Autowired
    private GradeSubjectMapper gradeSubjectMapper;
    @Autowired
    private SiteSectionMapper siteSectionMapper;
    @Autowired
    private SectionGradeMapper sectionGradeMapper;

    public void save(GradeSubjectEntity gradeSubject){
        gradeSubject.preInsert();
        gradeSubjectMapper.insert(gradeSubject);
    }

    public void update(GradeSubjectEntity gradeSubject){
        gradeSubject.preUpdate();
        gradeSubjectMapper.update(gradeSubject);
    }

    public GradeSubjectEntity get(GradeSubjectEntity gradeSubject){
        return gradeSubjectMapper.get(gradeSubject);
    }

    public GradeSubjectEntity getById(String id){
        return gradeSubjectMapper.getById(id);
    }
    public Page<GradeSubjectEntity> findList(GradeSubjectEntity gradeSubject){
       return gradeSubjectMapper.findList(gradeSubject);
    }

    public void deleteById(String id){
      gradeSubjectMapper.deleteById(id);
    }

    public void batchInsert(List<GradeSubjectEntity> list) {
        SiteSectionEntity siteSectionEntity =siteSectionMapper.getById(list.get(0).getSiteSectionId());
        sectionGradeMapper.getById(siteSectionEntity.getSectionId());
        list.forEach(bean -> {
            bean.setSiteId(siteSectionEntity.getSiteId());
            bean.setSectionId(siteSectionEntity.getSectionId());
            bean.preInsert();
        });
        gradeSubjectMapper.batchInsert(list);
    }

    public List<GradeSubjectEntity> findUnbindList(GradeSubjectEntity entity) {
        return gradeSubjectMapper.findUnbindList(entity);
    }

    public List<GradeSubjectEntity> findBindList(GradeSubjectEntity entity) {
        return gradeSubjectMapper.findBindList(entity);
    }
}
