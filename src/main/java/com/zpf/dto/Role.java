package com.zpf.dto;

import java.util.Date;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description :
 * @date :2017/5/25 14:21
 */
public class Role {
    private Long roleId;

    private String roleName;

    private Date startDate;

    private Date endDate;

    public Long getRoleId() {
        return roleId;
    }

    public Role setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public Role setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Role setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Role setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
