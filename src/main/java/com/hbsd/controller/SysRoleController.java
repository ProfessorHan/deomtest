package com.hbsd.controller;

import com.github.pagehelper.PageInfo;
import com.hbsd.domain.SysRole;
import com.hbsd.service.SysRoleService;
import com.hbsd.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by HanFei on 2017/7/17.
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/index")
    public String sysRoleIndex() {
        return "sys/sysRoleIndex";
    }

    @RequestMapping("/page")
    @ResponseBody
    public PageInfo getPage(@RequestParam(defaultValue = "1") Integer pageNumber,
                            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo page = sysRoleService.getPage(pageNumber, pageSize);
        return page;
    }

    @RequestMapping("/toSaveOrUpdate")
    public String toSaveOrUpdateView(Integer id, ModelMap modelMap) {
        if (id != null) {
            SysRole sysRole = sysRoleService.selectByPrimaryKey(id);
            modelMap.addAttribute("sysRole", sysRole);
        }
        return "sys/sysRoleSaveOrUpdate";
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public JsonResult toSaveOrUpdateView(SysRole sysRole) {
        if (sysRole.getId() == null) {
            sysRoleService.save(sysRole);
            return JsonResult.success("添加成功");
        } else {
            sysRoleService.update(sysRole);
            return JsonResult.success("修改成功");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam(required = true) Integer id) {
        boolean b = sysRoleService.deleteByPrimaryKey(id);
        return b ? JsonResult.success("删除成功") : JsonResult.success("删除失败");
    }

    @RequestMapping("/setStatus")
    @ResponseBody
    public JsonResult setUsability(@RequestParam(required = true) Integer id, Integer status) {
        SysRole sysRole = new SysRole();
        sysRole.setId(id);
        sysRole.setStatus(status);
        boolean b = sysRoleService.update(sysRole);
        return status == 1 ? JsonResult.success("已启用") : JsonResult.success("已禁用");
    }
}
