package com.zpf.mapper;

import com.zpf.dto.User;

import java.util.List;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description :用户Mapper
 * @date :2017/5/4 15:17
 */
public interface UserMapper {

    public int updateUser(User dto);

    public User queryUser(User dto);

    public int insertUser(User dto);
}
