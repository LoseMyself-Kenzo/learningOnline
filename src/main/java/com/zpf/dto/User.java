package com.zpf.dto;

import java.util.Date;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description :用户DTO
 * @date :2017/5/4 15:10
 */
public class User extends BaseDTO{
    private String userName;
    private String password;
    private Long userId;
    private Long roleId;
    private Date birthday;
    private String address;
    private Long classTableId;
    private String email;
    private String ic;
    private Long isWork;
    private String school;
    private String head;

    public String getHead() {
        return head;
    }

    public User setHead(String head) {
        this.head = head;
        return this;
    }

    public Long getIsWork() {
        return isWork;
    }

    public User setIsWork(Long isWork) {
        this.isWork = isWork;
        return this;
    }

    public String getSchool() {
        return school;
    }

    public User setSchool(String school) {
        this.school = school;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public User setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getRoleId() {
        return roleId;
    }

    public User setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public Long getClassTableId() {
        return classTableId;
    }

    public User setClassTableId(Long classTableId) {
        this.classTableId = classTableId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getIc() {
        return ic;
    }

    public User setIc(String ic) {
        this.ic = ic;
        return this;
    }
}
