package com.hbsd.controller;

import com.hbsd.domain.SysUser;
import com.hbsd.service.LoginService;
import com.hbsd.utils.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author: Hanfei
 * @Date: 2017/7/15
 * @Company:http://www.hbsddz.com
 * @Project:deomtestq
 * @Class:LoginController
 */

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/index")
    public String loginIndex() {
        return "loginIndex";
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonResult loginSave(String username, String password, HttpServletRequest request) {
        if (StringUtils.isEmpty(username)) {
            return JsonResult.failure("用户名不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return JsonResult.failure("密码不能为空");
        }
        boolean login = loginService.login(username, password, request);
        return login ? JsonResult.success("登陆成功") : JsonResult.failure("用户名或密码错误");
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        loginService.logout(request);
        String contextPath = request.getContextPath();
        return "redirect:" + contextPath + "/login/index";
    }

    @RequestMapping("/test")
    @ResponseBody
    public JsonResult test(@Valid SysUser sysUser, BindingResult bindingResult) {
        System.out.println(sysUser);
        System.out.println(bindingResult);
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                String objectName = allError.getObjectName();
                String defaultMessage = allError.getDefaultMessage();
                Object[] arguments = allError.getArguments();
                System.out.println(arguments);
                System.out.println(objectName);
                System.out.println(defaultMessage);
            }
        }
        return JsonResult.success("你好");
    }

}
