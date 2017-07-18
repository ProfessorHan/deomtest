package com.hbsd.controller;

import com.hbsd.domain.SysUser;
import com.hbsd.service.IndexService;
import com.hbsd.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Hanfei
 * @Date: 2017/7/12
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:IndexController
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    private IndexService indexService;
    @GetMapping(value = "/")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        SysUser sysUser = SessionUtils.getUser(request);
        String s = indexService.initMenus(sysUser);
        modelMap.addAttribute("menus",s);
        return "index";
    }
}
