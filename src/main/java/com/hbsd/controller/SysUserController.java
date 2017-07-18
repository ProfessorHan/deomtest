package com.hbsd.controller;

import com.github.pagehelper.PageInfo;
import com.hbsd.domain.SysUser;
import com.hbsd.service.LoginService;
import com.hbsd.service.SysUserService;
import com.hbsd.utils.JsonResult;
import com.hbsd.utils.SessionUtils;
import com.hbsd.utils.ZtreeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            String email, String nickName, String beginDate, String endDate) throws ParseException {
        PageInfo page = sysUserService.getPage(pageNumber, pageSize, email, nickName, beginDate, endDate);
        return page;
    }

    @PostMapping(value = "/pwdChange")
    @ResponseBody
    public JsonResult pwdChange(String oldPwd, String newPwd, String checkPwd, HttpServletRequest request) throws Exception {
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
        sysUserService.update(sysUser,null);
        return JsonResult.success("密码修改成功");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam(required = true) Integer id) {
        boolean b = sysUserService.deleteByPrimaryKey(id);
        return b ? JsonResult.success("删除成功") : JsonResult.success("删除失败");
    }

    @RequestMapping("/toSaveOrUpdate")
    public String toSaveOrUpdateView(Integer id, ModelMap modelMap) {
        if (id != null) {
            SysUser sysUser = sysUserService.selectByPrimaryKey(id);
            modelMap.addAttribute("sysUser", sysUser);
        }
        return "sys/sysUserSaveOrUpdate";
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public JsonResult toSaveOrUpdateView(SysUser sysUser,String roleIds,HttpServletRequest request) {
        if (sysUser.getId() == null) {
            sysUser.setCreatetime(new Date());
            sysUser.setCreateby(SessionUtils.getUser(request).getId());
            sysUserService.save(sysUser,roleIds);
            return JsonResult.success("添加成功");
        } else {
            sysUserService.update(sysUser,roleIds);
            return JsonResult.success("修改成功");
        }
    }
    @RequestMapping("/ztree")
    @ResponseBody
    public List<ZtreeData> getUserRole(@RequestParam(required = true) Integer id) {
        List<ZtreeData> userRoleZtree = sysUserService.getUserRoleZtree(id);
        return userRoleZtree;
    }
}