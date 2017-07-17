package com.hbsd.mapper;

import com.hbsd.domain.LegalCase;
import com.hbsd.domain.LegalCaseExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LegalCaseMapper {
    int countByExample(LegalCaseExample example);

    int deleteByExample(LegalCaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LegalCase record);

    int insertSelective(LegalCase record);

    List<LegalCase> selectByExample(LegalCaseExample example);

    LegalCase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LegalCase record, @Param("example") LegalCaseExample example);

    int updateByExample(@Param("record") LegalCase record, @Param("example") LegalCaseExample example);

    int updateByPrimaryKeySelective(LegalCase record);

    int updateByPrimaryKey(LegalCase record);
}