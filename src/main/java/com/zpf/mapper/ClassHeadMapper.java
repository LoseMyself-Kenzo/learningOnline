package com.zpf.mapper;

import com.zpf.dto.ClassHead;

import java.util.List;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description :
 * @date :2017/5/25 13:59
 */
public interface ClassHeadMapper {
    List<ClassHead> queryHead(ClassHead dto);

    int updateHead(ClassHead dto);

    int addClass(ClassHead dto);
}
