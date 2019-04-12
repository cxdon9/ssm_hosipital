package com.baizhi.controller;

import com.baizhi.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {


    /**
     * preHandle早于controller方法执行
     * 如果这个方法return true,则会正常执行controller中的方法 (放行)
     * 如果这个方法return false,则不会执行接下来的请求
     */
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return true;
        } else {
            resp.sendRedirect("/ssm_hospital/index.jsp");
            return false;
        }
    }

    /**
     * 已经执行了controller方法
     * postHandle 在return 视图之前 执行
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 已经执行了controller方法
     * afterCompletion 在return 视图之后 执行
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
