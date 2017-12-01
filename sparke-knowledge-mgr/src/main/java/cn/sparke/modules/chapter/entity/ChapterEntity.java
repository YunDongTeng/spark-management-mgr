package cn.sparke.modules.chapter.entity;

import cn.sparke.core.common.entity.BaseEntity;
import java.util.*;
import java.math.*;

/**
 * 章节Entity
 *
 * @author spark
 * @Date 2017-12-01 15:48:20
 */
public class ChapterEntity extends BaseEntity{
    //年级科目关系id
    private String gradeSubjectId;
    //网站id
    private String siteId;
    //学段id
    private String sectionId;
    //年级id
    private String gradeId;
    //科目id
    private String subjectId;
    //章节名称
    private String name;

    public void setGradeSubjectId(String gradeSubjectId){
        this.gradeSubjectId = gradeSubjectId;
    }
    public String getGradeSubjectId(){
        return this.gradeSubjectId;
    }
    public void setSiteId(String siteId){
        this.siteId = siteId;
    }
    public String getSiteId(){
        return this.siteId;
    }
    public void setSectionId(String sectionId){
        this.sectionId = sectionId;
    }
    public String getSectionId(){
        return this.sectionId;
    }
    public void setGradeId(String gradeId){
        this.gradeId = gradeId;
    }
    public String getGradeId(){
        return this.gradeId;
    }
    public void setSubjectId(String subjectId){
        this.subjectId = subjectId;
    }
    public String getSubjectId(){
        return this.subjectId;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

}
