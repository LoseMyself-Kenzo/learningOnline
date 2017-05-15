package com.zpf.controller;

import com.zpf.dto.ResponseDate;
import com.zpf.dto.User;
import com.zpf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collections;

/**
 * @author :LoseMyself    pengfei.zheng@hand-china.com
 * @version :1.0
 * @description : 用户个人资料
 * @date :2017/5/14 12:59
 */

@Controller
public class UserController {

    @Autowired
    private UserService service;

    //  跳转个人资料界面
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ModelAndView toUser(@RequestParam("user_id") Long id){
        ModelAndView modelAndView = new ModelAndView("user");

        User dto = new User().setUserId(id);

        dto  = service.queryUser(dto);
        modelAndView.addObject("head",dto.getHead());
        modelAndView.addObject("user_id",dto.getUserId());
        modelAndView.addObject("email",dto.getEmail());
        modelAndView.addObject("model1","1");
        modelAndView.addObject("model2",null);
        modelAndView.addObject("model3",null);

        return modelAndView;
    }

    //  个人所学课程
    @RequestMapping(value = "/User",method = RequestMethod.GET)
    public ResponseDate user(HttpSession session, HttpServletRequest request, HttpServletResponse response, @RequestParam("user_id")Long id) throws IOException {

        // 返回对象值
        ResponseDate responseDate = new ResponseDate();

        User dto = new User().setUserId(id);

        try{
            dto = service.queryUser(dto);
        }catch (NullPointerException e){
            dto = null;
            responseDate.setMessage("该账号不存在!");
            response.sendRedirect("index.jsp");
        }

        if(dto != null){
            responseDate.setMessage("success");
            responseDate.setList(Collections.singletonList(dto));
        }

        return responseDate;
    }

    //  个人实验报告
    @RequestMapping(value = "/User/report",method = RequestMethod.GET)
    public ResponseDate reports(HttpServletRequest request,HttpServletResponse response,@RequestParam("user_id") Long id){
        ResponseDate responseDate = new ResponseDate();



        return responseDate;
    }

    //  个人资料设置界面
    @RequestMapping(value = "/User/profile",method = RequestMethod.GET)
    public ResponseDate profile(HttpServletResponse response,HttpServletRequest request,@RequestParam("user_id")Long id){
        ResponseDate responseDate = new ResponseDate();


        return responseDate;
    }
}
