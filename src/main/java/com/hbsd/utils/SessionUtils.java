package com.hbsd.utils;


import com.hbsd.domain.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Hanfei
 * @Date: 2017/5/17
 * @Company:http://www.hbsddz.com
 * @Project:shebao
 * @Class:SessionUtils
 */
public class SessionUtils {

    private static final Logger logger = LoggerFactory.getLogger(SessionUtils.class);

    private static final String SESSION_USER = "session_user";

    /**
     * 设置session的值
     *
     * @param request
     * @param key
     * @param value
     */
    public static void setAttr(HttpServletRequest request, String key, Object value) {
        request.getSession(true).setAttribute(key, value);
    }


    /**
     * 删除Session值
     *
     * @param request
     * @param key
     */
    public static void removeAttr(HttpServletRequest request, String key) {
        request.getSession(true).removeAttribute(key);
    }


    /**
     * 设置用户信息 到session
     *
     * @param sysUser
     * @param request
     */
    public static void setUser( SysUser sysUser,HttpServletRequest request) {
        request.getSession(true).setAttribute(SESSION_USER, sysUser);
    }


    /**
     * 从session中获取用户信息
     *
     * @param request
     * @return SysUser
     */
    public static SysUser getUser(HttpServletRequest request) {
        return (SysUser) request.getSession(true).getAttribute(SESSION_USER);
    }


    /**
     * 从session中删除用户信息
     *
     * @param request
     * @return SysUser
     */
    public static void removeUser(HttpServletRequest request) {
        request.getSession(true).removeAttribute(SESSION_USER);
    }
}
