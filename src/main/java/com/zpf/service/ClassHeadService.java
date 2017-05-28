package com.zpf.service;

import com.zpf.dto.ClassHead;

import java.util.List;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description :
 * @date :2017/5/28 14:05
 */
public interface ClassHeadService {
    List<ClassHead> queryClass(ClassHead dto);

    int updateClass(ClassHead dto);

    int addClass(ClassHead dto);
}
