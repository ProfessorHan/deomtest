package com.hbsd.controller;

import com.github.pagehelper.PageInfo;
import com.hbsd.domain.SysUser;
import com.hbsd.service.LoginService;
import com.hbsd.service.SysUserService;
import com.hbsd.utils.JsonResult;
import com.hbsd.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Hanfei
 * @Date: 2017/7/15
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:sysUserController
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/index")
    public String index(ModelMap modelMap) {
        return "sys/sysUserIndex";
    }

    @GetMapping(value = "/toPwdChange")
    public String toPwdChange() {
        return "sys/pwdChange";
    }

    @RequestMapping("/page")
    @ResponseBody
    public PageInfo getPage(@RequestParam(defaultValue = "1") Integer pageNumber,
                            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo page = sysUserService.getPage(pageNumber, pageSize);
        return page;
    }

    @PostMapping(value = "/pwdChange")
    @ResponseBody
    public JsonResult pwdChange(String oldPwd, String newPwd, String checkPwd, HttpServletRequest request) throws Exception{
        SysUser user = SessionUtils.getUser(request);
        boolean login = loginService.login(user.getEmail(), oldPwd, request);
        if (!login) {
            return JsonResult.failure("原始密码不正确");
        }
        if (!newPwd.equals(checkPwd)) {
            return JsonResult.failure("两次密码输入不一致");
        }
        SysUser sysUser = new SysUser();
        sysUser.setId(user.getId());
        sysUser.setPwd(DigestUtils.md5DigestAsHex(newPwd.getBytes("utf-8")));
        sysUserService.update(sysUser);
        return JsonResult.success("密码修改成功");
    }
}
