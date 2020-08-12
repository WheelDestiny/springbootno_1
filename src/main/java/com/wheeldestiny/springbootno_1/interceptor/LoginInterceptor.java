package com.wheeldestiny.springbootno_1.interceptor;


import com.wheeldestiny.springbootno_1.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        boolean haveAnnotataion = handler.getClass().isAssignableFrom(HandlerMethod.class);
        if (haveAnnotataion) {
            loginTest oa = ((HandlerMethod)handler).getMethodAnnotation(loginTest.class);
            if (oa != null) {
                // 拦截处理代码
                //返回true通过，返回false拦截
                User user = (User) request.getSession().getAttribute("user");
                if (user==null){
                    response.sendRedirect("/login");
                    return false;
                }
            }
        }
        return true;
    }
}
