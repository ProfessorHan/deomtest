package com.hbsd.service;

import com.hbsd.domain.SysRoleResExample;
import com.hbsd.mapper.SysRoleResMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Hanfei
 * @Date: 2017/7/18
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:SysRoleResService
 */
@Service
public class SysRoleResService {

    @Autowired
    private SysRoleResMapper sysRoleResMapper;

    /**
     * 设置角色的菜单权限
     * @param roleId
     * @param resIds
     * @return
     */
    public boolean saveRoleRes(int roleId, String resIds) {
        try {
            SysRoleResExample sysRoleResExample = new SysRoleResExample();
            SysRoleResExample.Criteria criteria = sysRoleResExample.createCriteria();
            criteria.andRoleIdEqualTo(roleId);
            sysRoleResMapper.deleteByExample(sysRoleResExample);
            if (!StringUtils.isBlank(resIds)) {
                String[] split = resIds.split(",");
                List<Integer> list = Arrays.stream(split).
                        map(Integer::valueOf).
                        collect(Collectors.toList());
                sysRoleResMapper.saveRoleResIds(roleId,list);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
