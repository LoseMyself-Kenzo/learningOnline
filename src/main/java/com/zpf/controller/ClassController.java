package com.zpf.controller;

import javax.servlet.http.*;
import com.zpf.dto.ClassHead;
import com.zpf.dto.ClassLine;
import com.zpf.dto.ResponseDate;
import com.zpf.service.ClassHeadService;
import com.zpf.service.ClassLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
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
        ModelAndView modelAndView = new ModelAndView("addLineClass");

        HttpSession session = request.getSession();

        Long id = (Long)session.getAttribute("user_id");

        dto.setCreateBy(id);

        List<ClassHead> list = service.queryClass(new ClassHead().setClassHeadName(dto.getClassHeadName()));
        if(list.size() == 0){
            int a = service.addClass(dto);
            modelAndView.addObject("id",a);
            list = service.queryClass(new ClassHead().setClassHeadName(dto.getClassHeadName()));
            ClassLine d = new ClassLine().setClassHeadId(list.get(0).getClassHeadId());
            for(int i = 0; i < number; ++i){
                service2.addClass(d.setNumber((long) i+1));
            }
        }

        List<ClassLine> list2 = service2.queryLine(new ClassLine().setClassHeadId(list.get(0).getClassHeadId()));
        modelAndView.addObject("list",list2);
        modelAndView.addObject("classHeadName",dto.getClassHeadName());
        modelAndView.addObject("number",number);

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

    @RequestMapping(value = "/upLine",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDate upLine(@RequestParam("url") String url,@RequestParam("classLineName") String classLineName,@RequestParam("classLineId") Long classLineId){
        ClassLine dto = new ClassLine().setClassLineId(classLineId).setUrl(url).setClassLineName(classLineName);
        ResponseDate rd = new ResponseDate().setMessage("false");

        int a = service2.updateLine(dto);

        if(a != 0){
            rd.setMessage("success");
        }

        return rd;
    }

    @RequestMapping(value = "/addVideo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDate addLine(@RequestParam("myfile") MultipartFile myfile,@RequestParam("classLineName") String classLineName) throws IOException {
        ResponseDate rd = new ResponseDate();

        System.out.println("fileName："+myfile.getOriginalFilename());
        String str =  new Date().getTime()+myfile.getOriginalFilename();
        String path="A:/learningOnline/src/main/webapp/video/" + str;

        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        myfile.transferTo(newFile);

        rd.setMessage(str);

        return rd;
    }
}

