package cn.sparke.modules.subject.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import cn.sparke.modules.subject.mapper.SubjectMapper;
import cn.sparke.modules.subject.entity.SubjectEntity;

/**
 * 科目Dao
 *
 * @author spark
 * @Date 2017-11-30 19:00:54
 */
@Service
public class SubjectService{
    @Autowired
    private SubjectMapper subjectMapper;

    public void save(SubjectEntity subject){
        subject.preInsert();
        subjectMapper.insert(subject);
    }

    public void update(SubjectEntity subject){
        subject.preUpdate();
        subjectMapper.update(subject);
    }

    public SubjectEntity get(SubjectEntity subject){
        return subjectMapper.get(subject);
    }

    public SubjectEntity getById(String id){
        return subjectMapper.getById(id);
    }
    public Page<SubjectEntity> findList(SubjectEntity subject){
       return subjectMapper.findList(subject);
    }

    public void deleteById(String id){
      subjectMapper.deleteById(id);
    }

}
