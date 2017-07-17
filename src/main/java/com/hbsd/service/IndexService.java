package com.hbsd.service;

import com.hbsd.domain.SysMenu;
import com.hbsd.domain.SysMenuExample;
import com.hbsd.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Hanfei
 * @Date: 2017/7/13
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:IndexService
 */

@Service
public class IndexService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    public String initMenus() {
        List<SysMenu> sysMenus = sysMenuMapper.selectByExample(new SysMenuExample());
        sysMenus.sort((x, y) -> Integer.compare(y.getMenuOrder(), x.getMenuOrder()));
        String html = " <div class=\"sidebar-nav navbar-collapse\">" + getMenuHtml(0, sysMenus) + "</div>";
        return html;
    }

    private String getMenuHtml(Integer parentId, List<SysMenu> sysMenus) {
        StringBuilder menuHtml = new StringBuilder();
        List<SysMenu> menus = sysMenus.stream().
                filter(e -> e.getParentId() == parentId).
                collect(Collectors.toList());
        if (menus.size() == 0) {
            return menuHtml.toString();
        }
        menuHtml.append(parentId == 0 ? " <ul class=\"nav\" id=\"side-menu\">" : "<ul class=\"nav\">");
        for (SysMenu menu : menus) {
            menuHtml.append("<li>");
            menuHtml.append("<a href=\"" + menu.getMenuUrl() + "\" target=\"innerhtml\">");
            if (menu.getParentId() == 0) {
                menuHtml.append("<i class=\"" + menu.getMenuIcon() + "\"></i>");
            }
            menuHtml.append(menu.getMenuName());
            String subMenuHtml = getMenuHtml(menu.getId(), sysMenus);
            menuHtml.append(subMenuHtml.equals("") ? "</a>" : " <span class=\"fa arrow\"></span></a>").append(subMenuHtml);
            menuHtml.append("</li>");
        }
        menuHtml.append("</ul>");
        return menuHtml.toString();
    }

}
