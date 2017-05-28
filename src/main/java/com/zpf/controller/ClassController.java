package com.zpf.controller;

import javax.servlet.http.*;
import com.zpf.dto.ClassHead;
import com.zpf.dto.ClassLine;
import com.zpf.dto.ResponseDate;
import com.zpf.service.ClassHeadService;
import com.zpf.service.ClassLineService;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description :
 * @date :2017/5/25 14:54
 */
@Controller
public class ClassController {

    @Autowired
    private ClassHeadService service;

    @Autowired
    private ClassLineService service2;

    @RequestMapping("/tech")
    public ModelAndView addClass(){
        ModelAndView modelAndView = new ModelAndView("addClass");
        return modelAndView;
    }

    @RequestMapping(value = "/addClass")
    public ModelAndView addClass(HttpServletRequest request,ClassHead dto,@RequestParam("number") Long number){
        ModelAndView modelAndView = new ModelAndView("addClass");

        HttpSession session = request.getSession();

        Long id = (Long)session.getAttribute("user_id");

        dto.setCreateBy(id);

        int a = service.addClass(dto);

        List<ClassHead> list = service.queryClass(new ClassHead().setClassHeadName(dto.getClassHeadName()));

        if(a != 0){
            modelAndView.addObject("id",a);
            modelAndView.addObject("number",number);
            modelAndView.setViewName("addLineClass");
            ClassLine d = new ClassLine().setClassHeadId(list.get(0).getClassHeadId());
            for(int i = 0; i < number; ++i){
                service2.addClass(d.setNumber((long) i));
            }
        }
        return modelAndView;
    }

    @RequestMapping("/isH")
    @ResponseBody
    public ResponseDate isHave(@RequestParam("name") String name){
        ResponseDate rd = new ResponseDate();

        rd.setTotal((long)0);

        List<ClassHead> list = service.queryClass(new ClassHead().setClassHeadName(name));

        rd.setTotal((long)list.size());

        return rd;
    }
}

