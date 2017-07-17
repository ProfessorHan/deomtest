package com.hbsd.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbsd.domain.SysUser;
import com.hbsd.domain.SysUserExample;
import com.hbsd.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Hanfei
 * @Date: 2017/7/15
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:sysUserService
 */
@Service
public class SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    public PageInfo getPage(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(new SysUserExample());
        PageInfo pageInfo = new PageInfo(sysUsers);
        return pageInfo;
    }

    public SysUser selectByPrimaryKey(int id) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
        return sysUser;
    }

    public void save(SysUser sysUser) {
        int i = sysUserMapper.insertSelective(sysUser);
    }

    public void update(SysUser sysUser) {
        int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }
}
