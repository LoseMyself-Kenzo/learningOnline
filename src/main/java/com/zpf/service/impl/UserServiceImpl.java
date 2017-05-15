package com.zpf.service.impl;

import com.zpf.dto.User;
import com.zpf.mapper.UserMapper;
import com.zpf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description :
 * @date :2017/5/4 15:55
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper mapper;

    @Override
    public int updateUser(User dto) {
        return mapper.updateUser(dto);
    }

    @Override
    public User queryUser(User dto) {
        return mapper.queryUser(dto);
    }

    @Override
    public int addUser(User dto) {
        return mapper.insertUser(dto);
    }
}
