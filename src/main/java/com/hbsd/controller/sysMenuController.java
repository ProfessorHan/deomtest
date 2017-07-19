package com.hbsd.controller;

import com.hbsd.domain.SysMenu;
import com.hbsd.service.SysMenuService;
import com.hbsd.utils.JsonResult;
import com.hbsd.utils.ZtreeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Hanfei
 * @Date: 2017/7/15
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:sysMenuController
 */
@Controller
@RequestMapping("/sysMenu")
public class sysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping(value = "/index")
    public String sysMenuIndex() {
        return "sys/sysMenuIndex";
    }

    @RequestMapping(value = "/page")
    @ResponseBody
    public List<SysMenu> getPage() {
        List<SysMenu> sysMenus = sysMenuService.getSysMenus();
        return sysMenus;
    }

    @RequestMapping(value = "/ztree")
    @ResponseBody
    public List<ZtreeData> getSysMenuZtree() {
        return sysMenuService.getZtreeData(null);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam(required = true) Integer id) {
        boolean b = sysMenuService.deleteByPrimaryKey(id);
        return b ? JsonResult.success("删除成功") : JsonResult.success("删除失败");
    }


    @GetMapping(value = "/toEdit")
    public String toSysMenuEdit(@RequestParam(required = true) int id, ModelMap modelMap) {
        SysMenu sysMenu = sysMenuService.selectByPrimaryKey(id);
        modelMap.addAttribute("sysMenu", sysMenu);
        return "sys/sysMenuEdit";
    }

    @GetMapping(value = "/toSave")
    public String toSysMenuSave( ModelMap modelMap) {
        return "sys/sysMenuSave";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public JsonResult sysMenuEdit(SysMenu sysMenu) {
        boolean update = sysMenuService.update(sysMenu);
        return update ? JsonResult.success("修改成功") : JsonResult.failure("修改失败");
    }


    @RequestMapping("/save")
    @ResponseBody
    public JsonResult sysMenuSave(SysMenu sysMenu) {
        sysMenu.setMenuType(1);
        boolean save = sysMenuService.save(sysMenu);
        return save ? JsonResult.success("保存成功") : JsonResult.failure("保存失败");
    }
}
