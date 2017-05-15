package com.zpf.mapper;

import com.zpf.dto.Actor;

import java.util.List;

/**
 * @author pengfei.zheng@hand-china.com
 * @version 1.0
 * @name
 * @description:
 * @date 2017/4/6  12:46
 */
public interface ActorMapper {
    List<Actor> findActorById(Long id);
}
