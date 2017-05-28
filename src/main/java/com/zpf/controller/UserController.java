package com.zpf.controller;

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
    public void toUser(@RequestParam("user_id") Long id,HttpServletResponse response,HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("user_id",id);
        response.sendRedirect("/User");
    }

    //  个人所学课程
    @RequestMapping(value = "/User",method = RequestMethod.GET)
    public ModelAndView user(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Long id = (Long)session.getAttribute("user_id");
        ModelAndView modelAndView = new ModelAndView("user");
        User dto = new User().setUserId(id);
        dto  = service.queryUser(dto);
        modelAndView.addObject("head",dto.getHead());
        modelAndView.addObject("user_id",dto.getUserId());
        modelAndView.addObject("email",dto.getEmail());
        if(dto.getRoleId() == 3){
            modelAndView.addObject("role",dto.getRoleId());
        }
        return modelAndView;

    }

    //  个人实验报告
    @RequestMapping(value = "/report")
    public ModelAndView reports(HttpServletRequest request,HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("report");

        HttpSession session = request.getSession();

        Long id = (Long)session.getAttribute("user_id");

        User dto = new User().setUserId(id);

        dto  = service.queryUser(dto);

        modelAndView.addObject("head",dto.getHead());

        return modelAndView;
    }

    //  个人资料设置界面
    @RequestMapping(value = "/profile")
    public ModelAndView profile(HttpServletResponse response,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("profile");

        HttpSession session = request.getSession();

        Long id = (Long)session.getAttribute("user_id");

        User dto = new User().setUserId(id);

        dto  = service.queryUser(dto);

        modelAndView.addObject("head",dto.getHead());
        modelAndView.addObject("school",dto.getSchool());
        modelAndView.addObject("is_work",dto.getIsWork());
        modelAndView.addObject("address",dto.getAddress());
        modelAndView.addObject("username",dto.getUserName());
        return modelAndView;
    }

    @RequestMapping(value = "/changeProfile")
    public ModelAndView changeProfile(User d,HttpServletRequest request) throws IOException {

        HttpSession session = request.getSession();

        ModelAndView modelAndView =new ModelAndView("profile");

        int i = 0;
        i = service.updateUser(d);
        if(i == 0 ){
            modelAndView.addObject("msg","更新错误,请重新输入!");
        }
        User dto = service.queryUser(d);

        modelAndView.addObject("head",dto.getHead());
        modelAndView.addObject("school",dto.getSchool());
        modelAndView.addObject("is_work",dto.getIsWork());
        modelAndView.addObject("address",dto.getAddress());
        modelAndView.addObject("username",dto.getUserName());
        session.setAttribute("username",dto.getUserName());
        return modelAndView;
    }
}
