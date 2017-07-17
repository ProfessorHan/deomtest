package com.hbsd.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbsd.domain.SysRole;
import com.hbsd.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HanFei on 2017/7/17.
 */
@Service
public class SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;


    public PageInfo getPage(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(null);
        PageInfo pageInfo = new PageInfo(sysRoles);
        return pageInfo;
    }


    public SysRole selectByPrimaryKey(int id) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(id);
        return sysRole;
    }

    public boolean deleteByPrimaryKey(int id) {
        int i = sysRoleMapper.deleteByPrimaryKey(id);
        return i >= 0;
    }

    public boolean save(SysRole sysRole) {
        int i = sysRoleMapper.insertSelective(sysRole);
        return i >= 0;
    }
    public boolean update(SysRole sysRole) {
        int i = sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        return i >= 0;
    }

}
