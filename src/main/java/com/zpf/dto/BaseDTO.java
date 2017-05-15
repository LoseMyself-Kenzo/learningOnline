package com.zpf.dto;

import java.util.Date;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description :公共字段继承类
 * @date :2017/5/4 15:14
 */
public class BaseDTO {
    //  创建时间
    private Date creationDate;

    //  最后修改时间
    private Date lastUpdateDate;

    public Date getCreationDate() {
        return creationDate;
    }

    public BaseDTO setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public BaseDTO setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
        return this;
    }
}
