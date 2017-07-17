package com.hbsd.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hbsd.domain.SysUser;
import com.hbsd.utils.JsonResult;
import com.hbsd.utils.SessionUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Hanfei
 * @Date: 2017/7/15
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:AnthInterceptor
 */
public class AnthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SysUser user = SessionUtils.getUser(request);
        if (user != null) {
            return true;
        }
        String requestType = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(requestType)) {
            response.setContentType("application/json;charset=utf-8");
            JsonResult jsonResult = JsonResult.failure(-2, "登陆超时,请重新登陆");
            new ObjectMapper().writeValue(response.getOutputStream(), jsonResult);
        } else {
            response.sendRedirect(request.getContextPath() + "/login/index");
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
