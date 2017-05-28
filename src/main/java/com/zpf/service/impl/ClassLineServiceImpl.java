package com.zpf.service.impl;

import com.zpf.dto.ClassLine;
import com.zpf.mapper.ClassLineMapper;
import com.zpf.service.ClassLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description :
 * @date :2017/5/28 14:26
 */
@Service
public class ClassLineServiceImpl implements ClassLineService {

    @Autowired
    private ClassLineMapper mapper;


    @Override
    public int addClass(ClassLine dto) {
        return mapper.addClass(dto);
    }

    @Override
    public int updateLine(ClassLine dto) {
        return mapper.updateLine(dto);
    }

    @Override
    public List<ClassLine> queryLine(Long id) {
        return mapper.queryLine(id);
    }
}
