package com.zpf.service;

import com.zpf.dto.User;

import java.util.List;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description :
 * @date :2017/5/4 15:54
 */
public interface UserService {
    public int updateUser(User dto);

    public User queryUser(User dto);

    public int addUser(User dto);
}
