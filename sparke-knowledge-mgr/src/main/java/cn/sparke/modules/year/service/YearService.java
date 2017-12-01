package cn.sparke.modules.year.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import cn.sparke.modules.year.mapper.YearMapper;
import cn.sparke.modules.year.entity.YearEntity;

/**
 * 年份Dao
 *
 * @author spark
 * @Date 2017-11-30 19:10:00
 */
@Service
public class YearService{
    @Autowired
    private YearMapper yearMapper;

    public void save(YearEntity year){
        year.preInsert();
        yearMapper.insert(year);
    }

    public void update(YearEntity year){
        year.preUpdate();
        yearMapper.update(year);
    }

    public YearEntity get(YearEntity year){
        return yearMapper.get(year);
    }

    public YearEntity getById(String id){
        return yearMapper.getById(id);
    }
    public Page<YearEntity> findList(YearEntity year){
       return yearMapper.findList(year);
    }

    public void deleteById(String id){
      yearMapper.deleteById(id);
    }

}
