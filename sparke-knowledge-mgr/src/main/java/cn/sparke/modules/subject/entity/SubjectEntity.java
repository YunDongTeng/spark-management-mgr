package cn.sparke.modules.subject.entity;

import cn.sparke.core.common.entity.BaseEntity;
import cn.sparke.modules.chapter.entity.ChapterEntity;

import java.util.*;
import java.math.*;

/**
 * 科目Entity
 *
 * @author spark
 * @Date 2017-11-30 19:00:54
 */
public class SubjectEntity extends BaseEntity{
    //名称
    private String name;
    private List<ChapterEntity> chapterList;

    public List<ChapterEntity> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<ChapterEntity> chapterList) {
        this.chapterList = chapterList;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

}
