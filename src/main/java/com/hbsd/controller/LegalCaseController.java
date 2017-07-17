package com.hbsd.controller;

import com.github.pagehelper.PageInfo;
import com.hbsd.domain.LegalCase;
import com.hbsd.service.LegalCaseService;
import com.hbsd.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Hanfei
 * @Date: 2017/7/13
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:LegalCaseController
 */

@Controller
@RequestMapping("/legalCase")
public class LegalCaseController {

    @Autowired
    private LegalCaseService legalCaseService;

    @GetMapping("/index")
    public String legalcaseIndex() {
        return "legalcaseIndex";
    }

    @RequestMapping("/page")
    @ResponseBody
    public PageInfo getPage(@RequestParam(defaultValue = "1") Integer pageNumber,
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            String caseNo, String caseName, String beginDate, String endDate, Integer caseType) {
        return legalCaseService.getPage(pageNumber, pageSize, caseNo, caseName, beginDate, endDate, caseType);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam(required = true) Integer id) {
        boolean b = legalCaseService.deleteByPrimaryKey(id);
        return b ? JsonResult.success("删除成功") : JsonResult.success("删除失败");
    }

    @RequestMapping("/toSaveOrUpdate")
    public String toSaveOrUpdateView(Integer id, ModelMap modelMap) {
        if (id != null) {
            LegalCase legalCase = legalCaseService.selectByPrimaryKey(id);
            modelMap.addAttribute("legalCase", legalCase);
        }
        return "legalCaseSaveOrUpdate";
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public JsonResult toSaveOrUpdateView(LegalCase legalCase) {
        if (legalCase.getId() == null) {
            legalCaseService.save(legalCase);
            return JsonResult.success("添加成功");
        } else {
            legalCaseService.update(legalCase);
            return JsonResult.success("修改成功");
        }
    }
}
