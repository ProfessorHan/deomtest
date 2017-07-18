package com.hbsd.service;

import com.hbsd.domain.*;
import com.hbsd.mapper.SysMenuMapper;
import com.hbsd.mapper.SysRoleResMapper;
import com.hbsd.utils.ZtreeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Hanfei
 * @Date: 2017/7/15
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:sysMenuService
 */

@Service
public class SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysRoleResMapper sysRoleResMapper;

    private ThreadLocal<List<SysMenu>> threadLocal = new ThreadLocal<>();

    public List<ZtreeData> getZtreeData(Integer roleId) {
        initSysMenus();
        List<Integer> resIds = new ArrayList<>();
        if (roleId != null) {
            SysRoleResExample sysRoleResExample = new SysRoleResExample();
            sysRoleResExample.createCriteria().andRoleIdEqualTo(roleId);
            List<SysRoleRes> sysRoleResList = sysRoleResMapper.selectByExample(sysRoleResExample);
            for (SysRoleRes sysRoleRes : sysRoleResList) {
                resIds.add(sysRoleRes.getResId());
            }
        }
        List<ZtreeData> ztreeDatas = createZtree(0,resIds);
        return ztreeDatas;
    }

    public List<SysMenu> getSysMenus() {
        initSysMenus();
        List<SysMenu> sysMenus = new ArrayList<>();
        createSysMenus(sysMenus, 0, 0);
        return sysMenus;
    }

    public void createSysMenus(List<SysMenu> sysMenus, int parentId, int menuLevel) {
        menuLevel++;
        List<SysMenu> nextSysMenus = threadLocal.get().stream().
                filter(e -> e.getParentId() == parentId).
                collect(Collectors.toList());
        for (SysMenu nextSysMenu : nextSysMenus) {
            nextSysMenu.setMenuLevel(menuLevel);
            sysMenus.add(nextSysMenu);
            createSysMenus(sysMenus, nextSysMenu.getId(), menuLevel);
        }
    }

    private void initSysMenus() {
        SysMenuExample sysMenuExample = new SysMenuExample();
        sysMenuExample.setOrderByClause("id asc");
        List<SysMenu> sysMenus = sysMenuMapper.selectByExample(sysMenuExample);
        threadLocal.set(sysMenus);
    }


    private List<ZtreeData> createZtree(Integer parentId,List<Integer> resIds) {
        List<SysMenu> sysMenus = threadLocal.get().stream().
                filter(e -> e.getParentId() == parentId).
                collect(Collectors.toList());
        List<ZtreeData> ztreeDatas = new ArrayList<>();
        for (SysMenu sysMenu : sysMenus) {
            ZtreeData ztreeData = new ZtreeData();
            ztreeData.setId(sysMenu.getId());
            ztreeData.setName(sysMenu.getMenuName());
            ztreeData.setIconSkin(null);
            ztreeData.setChecked(resIds.contains(sysMenu.getId()));
            ztreeData.setOpen(true);
            ztreeData.setChildren(createZtree(sysMenu.getId(),resIds));
            ztreeDatas.add(ztreeData);
        }
        return ztreeDatas;
    }

    public boolean deleteByPrimaryKey(int id) {
        int i = sysMenuMapper.deleteByPrimaryKey(id);
        return i >= 1;
    }

    public SysMenu selectByPrimaryKey(int id) {
        SysMenu sysMenu = sysMenuMapper.selectByPrimaryKey(id);
        return sysMenu;
    }

    public boolean update(SysMenu sysMenu) {
        int i = sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
        return i >= 1;
    }

    public boolean save(SysMenu sysMenu) {
        int i = sysMenuMapper.insertSelective(sysMenu);
        return i >= 1;
    }
}
