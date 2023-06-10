package com.ssm.web;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminAccessInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session
                = request.getSession();
        System.out.println("Admin:" + session.getAttribute("admin"));
        if (session.getAttribute("admin") == null) {
            //发起重定向
            String path="/admin/toLogin";
            response.sendRedirect(path);
            System.out.println("AdminAccessInterceptor:preHandle:redirect to /admin/toLogin");
            return false;//返回false不再执行后续的控制器
        }
        System.out.println("AdminAccessInterceptor:preHandle:pass");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
