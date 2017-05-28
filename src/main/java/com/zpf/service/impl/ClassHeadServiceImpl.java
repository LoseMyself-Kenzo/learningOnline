package com.zpf.service.impl;

import com.zpf.dto.ClassHead;
import com.zpf.mapper.ClassHeadMapper;
import com.zpf.service.ClassHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description :
 * @date :2017/5/28 14:09
 */

@Service
public class ClassHeadServiceImpl implements ClassHeadService{
    @Autowired
    private ClassHeadMapper mapper;

    @Override
    public List<ClassHead> queryClass(ClassHead dto) {
        return mapper.queryHead(dto);
    }

    @Override
    public int updateClass(ClassHead dto) {
        return mapper.updateHead(dto);
    }

    @Override
    public int addClass(ClassHead dto) {
        return mapper.addClass(dto);
    }
}
