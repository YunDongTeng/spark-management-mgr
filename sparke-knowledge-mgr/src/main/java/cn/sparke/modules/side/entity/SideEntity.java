package cn.sparke.modules.side.entity;

import cn.sparke.core.common.entity.BaseEntity;
import cn.sparke.modules.sectionGrade.entity.SectionGradeEntity;

import java.util.*;
import java.math.*;

/**
 * 网站Entity
 *
 * @author spark
 * @Date 2017-11-30 14:01:11
 */
public class SideEntity extends BaseEntity{
    //网站名称
    private String name;
    //网站地址
    private String url;

    List<SectionGradeEntity> sectionList;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }

    public List<SectionGradeEntity> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<SectionGradeEntity> sectionList) {
        this.sectionList = sectionList;
    }
}
