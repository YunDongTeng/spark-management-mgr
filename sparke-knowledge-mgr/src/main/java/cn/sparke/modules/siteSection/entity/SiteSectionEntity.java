package cn.sparke.modules.siteSection.entity;

import cn.sparke.core.common.entity.BaseEntity;
import java.util.*;
import java.math.*;

/**
 * 网站学段关系Entity
 *
 * @author spark
 * @Date 2017-12-01 12:33:58
 */
public class SiteSectionEntity extends BaseEntity{
    //网站id
    private String siteId;
    //学段id
    private String sectionId;

    private int type;
    private int level;
    //名称
    private String name;
    private String sectionGradeId;
    //上级id
    private String sectionGradeParentId;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSectionGradeId() {
        return sectionGradeId;
    }

    public void setSectionGradeId(String sectionGradeId) {
        this.sectionGradeId = sectionGradeId;
    }

    public String getSectionGradeParentId() {
        return sectionGradeParentId;
    }

    public void setSectionGradeParentId(String sectionGradeParentId) {
        this.sectionGradeParentId = sectionGradeParentId;
    }
}
