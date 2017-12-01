package cn.sparke.modules.knowledge.service;

import cn.sparke.modules.knowledge.entity.KnowledgeEntity;
import cn.sparke.modules.knowledge.mapper.KnowledgeMapper;
import cn.sparke.modules.side.entity.SideEntity;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tyd on 2017-12-1.
 */
@Service(value = "knowledgeService")
public class KnowledgeService {

    @Autowired
    private KnowledgeMapper knowledgeMapper;

    public Page<KnowledgeEntity> findList(KnowledgeEntity knowledgeEntity) {
        return knowledgeMapper.findList(knowledgeEntity);
    }

    public KnowledgeEntity findOne(String id) {
        return knowledgeMapper.getById(id);
    }

    public int insert(KnowledgeEntity knowledgeEntity) {

        knowledgeEntity.preInsert();
        return knowledgeMapper.insert(knowledgeEntity);
    }

    public int update(KnowledgeEntity knowledgeEntity) {
        knowledgeEntity.preUpdate();
        return knowledgeMapper.update(knowledgeEntity);
    }

    public int delete(String id) {
        return knowledgeMapper.deleteById(id);
    }

    public List<SideEntity> getTreeList() {
        return knowledgeMapper.getTreeList();
    }

}
