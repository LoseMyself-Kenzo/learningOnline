package com.zpf.interceptor;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author pengfei.zheng@hand-china.com
 * @version 1.0
 * @name
 * @description:
 * @date 2017/4/10  14:07
 */
public class LoginInterceptor implements org.springframework.web.servlet.HandlerInterceptor{

    // 进入Handler方法之前
    // 用于身份认证,身份授权
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 获取请求的url
        String url = request.getRequestURI();
        // 判断url是否是公开地址(实际使用时将公开地址配置在配置文件中)
        if(url.indexOf("login") >= 0){
            // 如果进行登录提交,放行
            return true;
        }
        // 判断Session
        HttpSession session = request.getSession();
        // 获取用户名
        String username = (String)session.getAttribute("username");
        if(username != null){
            // 身份存在,放行
            return true;
        }
        // 表示用户需要认证,跳转登录界面
//        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return true;
    }

    // 进入Handler方法之后,返回ModelAndView之前
    // 将公用模型数据传到视图(菜单导航),也可以统一指定视图
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    // 执行Handler完成执行此方法
    // 统一异常处理,统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
