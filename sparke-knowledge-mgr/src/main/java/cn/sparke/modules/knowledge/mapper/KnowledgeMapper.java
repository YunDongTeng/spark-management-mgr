package cn.sparke.modules.knowledge.mapper;

import cn.sparke.core.modules.mybatis.mapper.BaseMapper;
import cn.sparke.modules.knowledge.entity.KnowledgeEntity;
import cn.sparke.modules.side.entity.SideEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tyd on 2017-12-1.
 */
@Repository
public interface KnowledgeMapper extends BaseMapper<KnowledgeEntity>{

    List<SideEntity> getTreeList();
}
