package cn.sparke.modules.knowledge.entity;


import cn.sparke.core.common.entity.BaseEntity;

/**
 * Created by tyd on 2017-11-8.
 *
 * @author tyd
 */
public class KnowledgeEntity extends BaseEntity {

    private String siteId;  //网站id
    private String sectionId;  //学段id
    private String gradeId;  //年级id
    private String subjectId;   //科目id
    private String chapterId;   //章节id
    private String categoryId; //分类id
    private String name;   //知识点名称
    private Integer frequency; //考频
    private String description;  //知识点描述
    private Integer status;  //状态


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

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
