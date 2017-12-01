package cn.sparke.modules.sectionGrade.entity;

import cn.sparke.core.common.entity.BaseEntity;
import cn.sparke.modules.subject.entity.SubjectEntity;

import java.util.*;
import java.math.*;

/**
 * 学段年级Entity
 *
 * @author spark
 * @Date 2017-12-01 09:04:38
 */
public class SectionGradeEntity extends BaseEntity{
    //名称
    private String name;
    //上级id
    private String parentId;
    //级别（1级为学段 2级为年级）
    private Integer level;

    //年级列表
    List<SectionGradeEntity> gradeList;

    //科目列表
    List<SubjectEntity> subjectList;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setParentId(String parentId){
        this.parentId = parentId;
    }
    public String getParentId(){
        return this.parentId;
    }
    public void setLevel(Integer level){
        this.level = level;
    }
    public Integer getLevel(){
        return this.level;
    }

    public List<SectionGradeEntity> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<SectionGradeEntity> gradeList) {
        this.gradeList = gradeList;
    }

    public List<SubjectEntity> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<SubjectEntity> subjectList) {
        this.subjectList = subjectList;
    }
}
