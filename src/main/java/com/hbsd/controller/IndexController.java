package com.hbsd.controller;

import com.hbsd.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index(ModelMap modelMap) {
        String s = indexService.initMenus();
        modelMap.addAttribute("menus",s);
        return "index";
    }
}
