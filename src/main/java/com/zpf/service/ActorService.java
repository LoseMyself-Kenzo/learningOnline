package com.zpf.service;

import com.zpf.dto.Actor;

import java.util.List;

/**
 * @author pengfei.zheng@hand-china.com
 * @version 1.0
 * @name
 * @description:
 * @date 2017/4/6  12:49
 */
public interface ActorService {
    List<Actor> findActorById(Long id);
}
