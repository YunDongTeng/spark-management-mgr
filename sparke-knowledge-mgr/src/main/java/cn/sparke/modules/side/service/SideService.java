package cn.sparke.modules.side.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import cn.sparke.modules.side.mapper.SideMapper;
import cn.sparke.modules.side.entity.SideEntity;

/**
 * 网站Dao
 *
 * @author spark
 * @Date 2017-11-30 14:01:11
 */
@Service
public class SideService{
    @Autowired
    private SideMapper sideMapper;

    public void save(SideEntity side){
        side.preInsert();
        sideMapper.insert(side);
    }

    public void update(SideEntity side){
        side.preUpdate();
        sideMapper.update(side);
    }

    public SideEntity get(SideEntity side){
        return sideMapper.get(side);
    }

    public SideEntity getById(String id){
        return sideMapper.getById(id);
    }
    public Page<SideEntity> findList(SideEntity side){
       return sideMapper.findList(side);
    }

    public void deleteById(String id){
      sideMapper.deleteById(id);
    }

}
