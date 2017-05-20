package com.zpf.dto;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description : 课程头信息
 * @date :2017/5/20 1:54
 */
public class ClassHead extends BaseDTO{

    private Long classHeadId;

    private String classHeadName;

    private Long createBy;

    private String description;

    private Long tagId;

    public Long getClassHeadId() {
        return classHeadId;
    }

    public ClassHead setClassHeadId(Long classHeadId) {
        this.classHeadId = classHeadId;
        return this;
    }

    public String getClassHeadName() {
        return classHeadName;
    }

    public ClassHead setClassHeadName(String classHeadName) {
        this.classHeadName = classHeadName;
        return this;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public ClassHead setCreateBy(Long createBy) {
        this.createBy = createBy;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ClassHead setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getTagId() {
        return tagId;
    }

    public ClassHead setTagId(Long tagId) {
        this.tagId = tagId;
        return this;
    }
}
