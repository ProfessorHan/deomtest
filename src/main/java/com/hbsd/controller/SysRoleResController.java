package com.hbsd.controller;

import com.hbsd.service.SysMenuService;
import com.hbsd.service.SysRoleResService;
import com.hbsd.utils.JsonResult;
import com.hbsd.utils.ZtreeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Hanfei
 * @Date: 2017/7/18
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:SysRoleResController
 */
@Controller
@RequestMapping("/sysRoleRes")
public class SysRoleResController {

    @Autowired
    private SysRoleResService sysRoleResService;

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("/index")
    public String sysRoleResIndex(@RequestParam(required = true) int id, ModelMap map) {
        map.addAttribute("id", id);
        return "sys/sysRoleResIndex";
    }

    @RequestMapping(value = "/ztree")
    @ResponseBody
    public List<ZtreeData> getSysMenuZtree(Integer id) {
        List<ZtreeData> subZtreeDatas = sysMenuService.getZtreeData(id);
        ZtreeData root = new ZtreeData();
        root.setName("跟目录菜单");
        root.setId(0);
        root.setChildren(subZtreeDatas);
        root.setOpen(true);
        List<ZtreeData> ztreeDatas = new ArrayList<>();
        ztreeDatas.add(root);
        return ztreeDatas;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public JsonResult saveRoleRes(@RequestParam(required = true) int id, String resIds) {
        boolean b = sysRoleResService.saveRoleRes(id, resIds);
        return b ? JsonResult.success("保存成功") : JsonResult.failure("保存失败");
    }
}
