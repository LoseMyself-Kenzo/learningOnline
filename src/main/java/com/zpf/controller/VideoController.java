package com.zpf.controller;

import com.zpf.dto.ClassHead;
import com.zpf.dto.ClassLine;
import com.zpf.service.ClassHeadService;
import com.zpf.service.ClassLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description :
 * @date :2017/5/30 20:02
 */

@Controller
public class VideoController {

    @Autowired
    private ClassHeadService service;

    @Autowired
    private ClassLineService service2;

    @RequestMapping("/courses")
    public ModelAndView toHome(){
        ModelAndView md = new ModelAndView("home");

        ClassHead dto = new ClassHead();
        List<ClassHead> list = service.queryClass(dto);

        md.addObject("list",list);

        return md;
    }

    @RequestMapping("/course_head")
    public ModelAndView toHead(@RequestParam("id") Long id){
        ModelAndView md = new ModelAndView("course");

        List<ClassHead> l = service.queryClass(new ClassHead().setClassHeadId(id));

        md.addObject("des",l.get(0).getDescription());
        md.addObject("name",l.get(0).getClassHeadName());

        List<ClassLine> list = service2.queryLine(new ClassLine().setClassHeadId(id));
        md.addObject("list",list);

        return md;
    }

    @RequestMapping("/course_line")
    public ModelAndView toLine(@RequestParam("id") Long id){
        ModelAndView md = new ModelAndView("video");

        List<ClassLine> list = service2.queryLine(new ClassLine().setClassLineId(id));

        ClassLine dto = list.get(0);

        md.addObject("dto",dto);

        return md;
    }
}
