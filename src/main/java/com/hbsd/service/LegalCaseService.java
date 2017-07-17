package com.hbsd.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbsd.domain.LegalCase;
import com.hbsd.domain.LegalCaseExample;
import com.hbsd.mapper.LegalCaseMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Hanfei
 * @Date: 2017/7/13
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:LegalCaseService
 */

@Service
public class LegalCaseService {

    @Autowired
    private LegalCaseMapper legalCaseMapper;

    public PageInfo getPage(int pageNum, int pageSize, String caseNo, String caseName, String beginDate, String endDate, Integer caseType) {
        PageHelper.startPage(pageNum, pageSize);
        LegalCaseExample legalCaseExample = new LegalCaseExample();
        LegalCaseExample.Criteria criteria = legalCaseExample.createCriteria();
        if (!StringUtils.isBlank(caseNo)) {
            criteria.andCaseNoLike("%" + caseNo + "%");
        }
        if (!StringUtils.isBlank(caseName)) {
            criteria.andCaseNameLike("%" + caseName + "%");
        }
        if (!StringUtils.isBlank(beginDate)) {
            criteria.andCaseCreateDateGreaterThan("%" + beginDate + "%");
        }
        if (!StringUtils.isBlank(endDate)) {
            criteria.andCaseCreateDateLessThan("%" + endDate + "%");
        }
        if (caseType == 2 || caseType == 3) {
            criteria.andCaseTypeEqualTo(caseType);
        }
        List<LegalCase> legalCases = legalCaseMapper.selectByExample(legalCaseExample);
        PageInfo pageInfo = new PageInfo(legalCases);
        return pageInfo;
    }

    public boolean deleteByPrimaryKey(int id) {
        try {
            legalCaseMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public LegalCase selectByPrimaryKey(int id) {
        return legalCaseMapper.selectByPrimaryKey(id);
    }

    public void save(LegalCase legalCase) {
        int i = legalCaseMapper.insertSelective(legalCase);
    }

    public void update(LegalCase legalCase) {
        int i = legalCaseMapper.updateByPrimaryKeySelective(legalCase);
    }

}
