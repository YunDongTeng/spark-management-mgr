package cn.sparke.modules.chapter.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import cn.sparke.modules.chapter.mapper.ChapterMapper;
import cn.sparke.modules.chapter.entity.ChapterEntity;

/**
 * 章节Dao
 *
 * @author spark
 * @Date 2017-12-01 15:48:20
 */
@Service
public class ChapterService{
    @Autowired
    private ChapterMapper chapterMapper;

    public void save(ChapterEntity chapter){
        chapter.preInsert();
        chapterMapper.insert(chapter);
    }

    public void update(ChapterEntity chapter){
        chapter.preUpdate();
        chapterMapper.update(chapter);
    }

    public ChapterEntity get(ChapterEntity chapter){
        return chapterMapper.get(chapter);
    }

    public ChapterEntity getById(String id){
        return chapterMapper.getById(id);
    }
    public Page<ChapterEntity> findList(ChapterEntity chapter){
       return chapterMapper.findList(chapter);
    }

    public void deleteById(String id){
      chapterMapper.deleteById(id);
    }

}
