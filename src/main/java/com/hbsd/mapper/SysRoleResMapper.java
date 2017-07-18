package com.hbsd.mapper;

import com.hbsd.domain.SysRoleRes;
import com.hbsd.domain.SysRoleResExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleResMapper {
    int countByExample(SysRoleResExample example);

    int deleteByExample(SysRoleResExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleRes record);

    int insertSelective(SysRoleRes record);

    List<SysRoleRes> selectByExample(SysRoleResExample example);

    SysRoleRes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRoleRes record, @Param("example") SysRoleResExample example);

    int updateByExample(@Param("record") SysRoleRes record, @Param("example") SysRoleResExample example);

    int updateByPrimaryKeySelective(SysRoleRes record);

    int updateByPrimaryKey(SysRoleRes record);

    int saveRoleResIds(@Param("roleId") Integer roleId,@Param("resIds") List<Integer> resIds);
}