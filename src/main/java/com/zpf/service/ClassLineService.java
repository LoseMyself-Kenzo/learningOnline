package com.zpf.service;

import com.zpf.dto.ClassLine;

import java.util.List;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description :
 * @date :2017/5/28 14:25
 */
public interface ClassLineService {
    int addClass(ClassLine dto);

    int updateLine(ClassLine dto);

    List<ClassLine> queryLine(ClassLine dto);
}
