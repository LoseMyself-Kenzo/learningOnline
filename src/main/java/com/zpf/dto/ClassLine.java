package com.zpf.dto;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description : 课程行
 * @date :2017/5/20 1:55
 */
public class ClassLine extends BaseDTO{

    private Long classLineId;

    private String classLineName;

    private Long classHeadId;

    private Long number;

    private String url;

    public String getUrl() {
        return url;
    }

    public ClassLine setUrl(String url) {
        this.url = url;
        return this;
    }

    public Long getClassLineId() {
        return classLineId;
    }

    public ClassLine setClassLineId(Long classLineId) {
        this.classLineId = classLineId;
        return this;
    }

    public String getClassLineName() {
        return classLineName;
    }

    public ClassLine setClassLineName(String classLineName) {
        this.classLineName = classLineName;
        return this;
    }

    public Long getClassHeadId() {
        return classHeadId;
    }

    public ClassLine setClassHeadId(Long classHeadId) {
        this.classHeadId = classHeadId;
        return this;
    }

    public Long getNumber() {
        return number;
    }

    public ClassLine setNumber(Long number) {
        this.number = number;
        return this;
    }
}
