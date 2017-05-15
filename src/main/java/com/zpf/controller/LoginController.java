package com.zpf.controller;

import com.zpf.Utils.VerifyCodeUtils;
import com.zpf.dto.ResponseDate;
import com.zpf.dto.User;
import com.zpf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.zpf.Utils.identityCode;
import com.zpf.Utils.email;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;

/**
 * @author pengfei.zheng@hand-china.com
 * @version 1.0
 * @name
 * @description: 用户登录注册
 * @date 2017/4/10  14:49
 */
@Controller
public class LoginController {

    @Autowired
    private UserService service;

    @RequestMapping("/index")
    public String index(){
        return new String ("index");
    }

    //  跳转注册页面
    @RequestMapping("/sign_up")
    public String signUp() throws Exception{
        return new String("sign_up");
    }

    //  注册用户
    @RequestMapping(value = "/signUp",method = RequestMethod.POST)
    public ModelAndView signUp(User dto,@RequestParam("yzm") String yzm,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("sign_up");
        if(session.getAttribute("_code").equals(yzm.toLowerCase())){
            User d = new User().setEmail(dto.getEmail());
            d = service.queryUser(d);
            if(d != null){
                modelAndView.addObject("msg","该邮箱已注册,请重新输入!");
                return modelAndView;
            }
            service.addUser(dto);
            modelAndView.setViewName("index");
            modelAndView.addObject("username",dto.getEmail());
            return  modelAndView;
        }else{
            modelAndView.addObject("msg","验证码错误,请重新输入!");
        }
        return modelAndView;
    }

    // 验证邮箱是否存在
    @RequestMapping(value = "/isHave",method = RequestMethod.GET)
    @ResponseBody
    public ResponseDate isHave(@RequestParam(value = "email") String email){

        ResponseDate rd = new ResponseDate();

        User d = service.queryUser(new User().setEmail(email));

        if(d != null){
            rd.setMessage("该邮箱已被注册!");
        }

        return rd;
    }

    // 退出
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpServletRequest request,HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession(true);
        session.removeAttribute("username");
        response.sendRedirect("index.jsp");
    }

    // 登录
    @RequestMapping(value = "/login_in", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDate login_in(User dto,HttpServletRequest request){
        ResponseDate rd = new ResponseDate();
        User d = null;
        try{
            d = service.queryUser(dto);throw new NullPointerException();
        }catch (NullPointerException e){
            rd.setMessage("邮箱/密码错误!请重新输入!");
        }
        if(d != null){
            rd.setList(Collections.singletonList(d));
            HttpSession session = request.getSession(true);
            rd.setMessage(null);
            if(d.getUserName() != null){
                session.setAttribute("username", d.getUserName());
                session.setAttribute("user_id",d.getUserId());
            }else{
                session.setAttribute("username",d.getEmail());
                session.setAttribute("user_id",d.getUserId());
            }
        }
        return rd;
    }

    //  忘记密码跳转
    @RequestMapping("/forget")
    public String forget() throws Exception{
        return new String("forget_password");
    }


    //  生成验证码并发送邮件
    @RequestMapping(value = "/getIC", method = RequestMethod.GET)
    @ResponseBody
    public boolean getIc(@RequestParam("email") String em) throws Exception{
        boolean isOk = false;

        User dto = new User().setEmail(em);

        dto = service.queryUser(dto);
        //  获取验证码
        String IC = new identityCode().getIC();

        dto.setIc(IC);

        String email = null;

        if(service.updateUser(dto) != 0){
            email = dto.getEmail();
        }

        // 发送邮件
        new email().sendEmail(dto.getEmail(),IC);

        return isOk;
    }

    //  通过邮箱重置
    @RequestMapping(value = "/reset_password", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView isRest(User dto){

        ModelAndView modelAndView = new ModelAndView();
        //  查询验证码是否正确
        if(service.queryUser(dto) != null){
            modelAndView.setViewName("rest_password");
            modelAndView.addObject("email",dto.getEmail());
            return modelAndView;
        }
        //  验证码错误返回值
        modelAndView.addObject("msg","验证码不正确");
        modelAndView.addObject("email",dto.getEmail());
        modelAndView.setViewName("forget_password");
        return modelAndView;
    }

    //  确认更改密码
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ModelAndView changePassword(@RequestParam("rp") String rp,@RequestParam("yzm") String yzm,User dto,HttpSession session) throws Exception{
        ModelAndView md = new ModelAndView("rest_password");
        //  判断两次密码是否相同
        if(rp.equals(dto.getPassword())){
            if(session.getAttribute("_code").equals(yzm.toLowerCase())){
                md.setViewName("index");
                service.updateUser(dto);
                User d = service.queryUser(dto);
                md.addObject("username",d.getUserName());
                return  md;
            }else{
                md.addObject("msg","验证码输入不正确,请重新输入!");
                return  md;
            }
        }else{
            md.addObject("msg","确认密码与新密码不相同,请重新输入!");
            return md;
        }
    }

    //  生成上传验证码
    @RequestMapping(value="/getYzm",method=RequestMethod.GET)
    public void getYzm(HttpServletResponse response, HttpServletRequest request){
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");

            //生成随机字串
            String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
            //存入会话session
            HttpSession session = request.getSession(true);
            session.setAttribute("_code", verifyCode.toLowerCase());
            //生成图片
            int w = 146, h = 33;
            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
        } catch (Exception e) {
//            LoggerUtils.fmtError(getClass(),e, "获取验证码异常：%s",e.getMessage());
            System.out.println("获取验证码异常");
        }
    }
}
