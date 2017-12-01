package cn.sparke.modules.sectionGrade.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import cn.sparke.modules.sectionGrade.mapper.SectionGradeMapper;
import cn.sparke.modules.sectionGrade.entity.SectionGradeEntity;

/**
 * 学段年级Dao
 *
 * @author spark
 * @Date 2017-12-01 09:04:38
 */
@Service
public class SectionGradeService{
    @Autowired
    private SectionGradeMapper sectionGradeMapper;

    public void save(SectionGradeEntity sectionGrade){
        sectionGrade.preInsert();
        sectionGradeMapper.insert(sectionGrade);
    }

    public void update(SectionGradeEntity sectionGrade){
        sectionGrade.preUpdate();
        sectionGradeMapper.update(sectionGrade);
    }

    public SectionGradeEntity get(SectionGradeEntity sectionGrade){
        return sectionGradeMapper.get(sectionGrade);
    }

    public SectionGradeEntity getById(String id){
        return sectionGradeMapper.getById(id);
    }
    public Page<SectionGradeEntity> findList(SectionGradeEntity sectionGrade){
       return sectionGradeMapper.findList(sectionGrade);
    }

    public void deleteById(String id){
      sectionGradeMapper.deleteById(id);
      sectionGradeMapper.deleteByParentId(id);
    }

}
