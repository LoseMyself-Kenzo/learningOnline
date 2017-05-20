package com.zpf.dto;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description : 课程表
 * @date :2017/5/20 1:55
 */
public class ClassTable extends BaseDTO{

    private Long classTableId;

    private Long classHeadId;

    private Long classLineId;

    private Long userId;

    public Long getClassTableId() {
        return classTableId;
    }

    public ClassTable setClassTableId(Long classTableId) {
        this.classTableId = classTableId;
        return this;
    }

    public Long getClassHeadId() {
        return classHeadId;
    }

    public ClassTable setClassHeadId(Long classHeadId) {
        this.classHeadId = classHeadId;
        return this;
    }

    public Long getClassLineId() {
        return classLineId;
    }

    public ClassTable setClassLineId(Long classLineId) {
        this.classLineId = classLineId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public ClassTable setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}
