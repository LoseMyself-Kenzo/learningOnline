package com.zpf.service.impl;

import com.zpf.dto.Actor;
import com.zpf.mapper.ActorMapper;
import com.zpf.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pengfei.zheng@hand-china.com
 * @version 1.0
 * @name
 * @description:
 * @date 2017/4/6  12:50
 */
@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
    private ActorMapper mapper;

    @Override
    public List<Actor> findActorById(Long id) {
        List<Actor> actor = mapper.findActorById(id);
        return actor;
    }
}
