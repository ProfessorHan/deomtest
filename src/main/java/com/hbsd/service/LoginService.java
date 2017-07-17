package com.hbsd.service;

import com.hbsd.domain.SysUser;
import com.hbsd.domain.SysUserExample;
import com.hbsd.mapper.SysUserMapper;
import com.hbsd.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Author: Hanfei
 * @Date: 2017/7/15
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:LoginService
 */

@Service
public class LoginService {
    @Autowired
    private SysUserMapper sysUserMapper;

    public boolean login(String username, String password, HttpServletRequest request) {

        SysUser sysUser = null;
        try {
            password = DigestUtils.md5DigestAsHex(password.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andEmailEqualTo(username);
        criteria.andPwdEqualTo(password);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        if (sysUsers.size() != 0) {
            sysUser = sysUsers.get(0);
            SessionUtils.setUser(sysUser, request);
            return true;
        }
        return false;
    }

    public void logout(HttpServletRequest request) {
        SessionUtils.removeUser(request);
    }
}
