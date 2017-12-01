package cn.sparke.modules.gradeSubject.entity;

import cn.sparke.core.common.entity.BaseEntity;
import java.util.*;
import java.math.*;

/**
 * 年级科目Entity
 *
 * @author spark
 * @Date 2017-12-01 14:11:43
 */
public class GradeSubjectEntity extends BaseEntity{
    //网站学段关系id
    private String siteSectionId;
    //网站id
    private String siteId;
    //学段id
    private String sectionId;
    //年级id
    private String gradeId;
    //科目id
    private String subjectId;
    private String name;

    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setSiteSectionId(String siteSectionId){
        this.siteSectionId = siteSectionId;
    }
    public String getSiteSectionId(){
        return this.siteSectionId;
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

}
