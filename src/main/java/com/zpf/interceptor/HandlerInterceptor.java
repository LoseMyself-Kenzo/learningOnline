package com.zpf.interceptor;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pengfei.zheng@hand-china.com
 * @version 1.0
 * @name
 * @description:
 * @date 2017/4/10  14:07
 */
public class HandlerInterceptor implements org.springframework.web.servlet.HandlerInterceptor{

    // 进入Handler方法之前
    // 用于身份认证,身份授权
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("登录拦截器");
        // return false表示拦截,不向下执行,反之放行
        return true;
    }

    // 进入Handler方法之后,返回ModelAndView之前
    // 将公用模型数据传到视图(菜单导航),也可以统一指定视图
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器启动");
    }

    // 执行Handler完成执行此方法
    // 统一异常处理,统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
