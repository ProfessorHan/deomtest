package com.hbsd.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbsd.domain.*;
import com.hbsd.mapper.SysRoleMapper;
import com.hbsd.mapper.SysUserMapper;
import com.hbsd.mapper.SysUserRoleMapper;
import com.hbsd.utils.ZtreeData;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    public PageInfo getPage(int pageNumber, int pageSize, String email, String nickName, String beginDate, String endDate) throws ParseException {
        PageHelper.startPage(pageNumber, pageSize);
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        if (!StringUtils.isBlank(email)) {
            criteria.andEmailLike("%" + email + "%");
        }
        if (!StringUtils.isBlank(nickName)) {
            criteria.andNicknameLike("%" + nickName + "%");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (!StringUtils.isBlank(beginDate)) {
            criteria.andCreatetimeGreaterThanOrEqualTo(sdf.parse(beginDate));

        }
        if (!StringUtils.isBlank(endDate)) {
            criteria.andCreatetimeLessThanOrEqualTo(sdf.parse(new LocalDateTime(endDate).plusDays(1).toString("yyyy-MM-dd")));
        }
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        for (SysUser sysUser : sysUsers) {
            //todo
//            String roleName = sysUserRoleMapper.selectRoleNameByUserId(sysUser.getId());
//            sysUser.setRoleName(roleName);
        }
        PageInfo pageInfo = new PageInfo(sysUsers);
        return pageInfo;
    }

    public SysUser selectByPrimaryKey(int id) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
        return sysUser;
    }

    public boolean save(SysUser sysUser, String roleIds) {
        try {
            sysUser.setPwd(DigestUtils.md5DigestAsHex(sysUser.getPwd().getBytes("utf-8")));
            sysUser.setState(1);
            sysUserMapper.insertSelective(sysUser);
            saveUserRoles(sysUser.getId(), roleIds);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(SysUser sysUser, String roleIds) {
        try {
            int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
            if (roleIds == null) return true;
            saveUserRoles(sysUser.getId(), roleIds);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 给人员分配角色
     *
     * @param userId
     * @param roleIds
     * @return
     */
    public boolean saveUserRoles(int userId, String roleIds) {

        try {
            SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
            sysUserRoleExample.createCriteria().andUserIdEqualTo(userId);
            sysUserRoleMapper.deleteByExample(sysUserRoleExample);
            if (!StringUtils.isBlank(roleIds)) {
                List<Integer> roleIdList = Arrays.stream(roleIds.split(",")).
                        map(Integer::valueOf).distinct().
                        collect(Collectors.toList());
                //todo
//                sysUserRoleMapper.saveUserRole(userId, roleIdList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<ZtreeData> getUserRoleZtree(Integer userId) {
        List<ZtreeData> ztreeDatas = new ArrayList<>();
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectByExample(null);
        List<SysUserRole> list = new ArrayList<>();
        if (userId != null) {
            SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
            sysUserRoleExample.createCriteria().andUserIdEqualTo(userId);
            list = sysUserRoleMapper.selectByExample(sysUserRoleExample);
        }
        Set<Integer> set = new HashSet<>();
        for (SysUserRole sysUserRole : list) {
            set.add(sysUserRole.getRoleId());
        }
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(null);
        for (SysRole sysRole : sysRoles) {
            ZtreeData ztreeData = new ZtreeData();
            ztreeData.setId(sysRole.getId());
            ztreeData.setName(sysRole.getName());
            ztreeData.setOpen(true);
            ztreeData.setChecked(set.contains(sysRole.getId()));
            ztreeDatas.add(ztreeData);
        }
        return ztreeDatas;
    }

    public boolean deleteByPrimaryKey(int id) {
        int i = sysUserMapper.deleteByPrimaryKey(id);
        return i >= 1;
    }
    public static void main(String[] args) {
        Optional<SysUser> sysUser = Optional.of(new SysUser());
        boolean present = sysUser.isPresent();
        System.out.println(sysUser);
    }
}
