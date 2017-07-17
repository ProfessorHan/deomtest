package com.hbsd.domain;

import java.util.ArrayList;
import java.util.List;

public class LegalCaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LegalCaseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCaseStateIsNull() {
            addCriterion("case_state is null");
            return (Criteria) this;
        }

        public Criteria andCaseStateIsNotNull() {
            addCriterion("case_state is not null");
            return (Criteria) this;
        }

        public Criteria andCaseStateEqualTo(Integer value) {
            addCriterion("case_state =", value, "caseState");
            return (Criteria) this;
        }

        public Criteria andCaseStateNotEqualTo(Integer value) {
            addCriterion("case_state <>", value, "caseState");
            return (Criteria) this;
        }

        public Criteria andCaseStateGreaterThan(Integer value) {
            addCriterion("case_state >", value, "caseState");
            return (Criteria) this;
        }

        public Criteria andCaseStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_state >=", value, "caseState");
            return (Criteria) this;
        }

        public Criteria andCaseStateLessThan(Integer value) {
            addCriterion("case_state <", value, "caseState");
            return (Criteria) this;
        }

        public Criteria andCaseStateLessThanOrEqualTo(Integer value) {
            addCriterion("case_state <=", value, "caseState");
            return (Criteria) this;
        }

        public Criteria andCaseStateIn(List<Integer> values) {
            addCriterion("case_state in", values, "caseState");
            return (Criteria) this;
        }

        public Criteria andCaseStateNotIn(List<Integer> values) {
            addCriterion("case_state not in", values, "caseState");
            return (Criteria) this;
        }

        public Criteria andCaseStateBetween(Integer value1, Integer value2) {
            addCriterion("case_state between", value1, value2, "caseState");
            return (Criteria) this;
        }

        public Criteria andCaseStateNotBetween(Integer value1, Integer value2) {
            addCriterion("case_state not between", value1, value2, "caseState");
            return (Criteria) this;
        }

        public Criteria andCaseNoIsNull() {
            addCriterion("case_no is null");
            return (Criteria) this;
        }

        public Criteria andCaseNoIsNotNull() {
            addCriterion("case_no is not null");
            return (Criteria) this;
        }

        public Criteria andCaseNoEqualTo(String value) {
            addCriterion("case_no =", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoNotEqualTo(String value) {
            addCriterion("case_no <>", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoGreaterThan(String value) {
            addCriterion("case_no >", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoGreaterThanOrEqualTo(String value) {
            addCriterion("case_no >=", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoLessThan(String value) {
            addCriterion("case_no <", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoLessThanOrEqualTo(String value) {
            addCriterion("case_no <=", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoLike(String value) {
            addCriterion("case_no like", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoNotLike(String value) {
            addCriterion("case_no not like", value, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoIn(List<String> values) {
            addCriterion("case_no in", values, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoNotIn(List<String> values) {
            addCriterion("case_no not in", values, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoBetween(String value1, String value2) {
            addCriterion("case_no between", value1, value2, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNoNotBetween(String value1, String value2) {
            addCriterion("case_no not between", value1, value2, "caseNo");
            return (Criteria) this;
        }

        public Criteria andCaseNameIsNull() {
            addCriterion("case_name is null");
            return (Criteria) this;
        }

        public Criteria andCaseNameIsNotNull() {
            addCriterion("case_name is not null");
            return (Criteria) this;
        }

        public Criteria andCaseNameEqualTo(String value) {
            addCriterion("case_name =", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotEqualTo(String value) {
            addCriterion("case_name <>", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameGreaterThan(String value) {
            addCriterion("case_name >", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameGreaterThanOrEqualTo(String value) {
            addCriterion("case_name >=", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameLessThan(String value) {
            addCriterion("case_name <", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameLessThanOrEqualTo(String value) {
            addCriterion("case_name <=", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameLike(String value) {
            addCriterion("case_name like", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotLike(String value) {
            addCriterion("case_name not like", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameIn(List<String> values) {
            addCriterion("case_name in", values, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotIn(List<String> values) {
            addCriterion("case_name not in", values, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameBetween(String value1, String value2) {
            addCriterion("case_name between", value1, value2, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotBetween(String value1, String value2) {
            addCriterion("case_name not between", value1, value2, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNatureIsNull() {
            addCriterion("case_nature is null");
            return (Criteria) this;
        }

        public Criteria andCaseNatureIsNotNull() {
            addCriterion("case_nature is not null");
            return (Criteria) this;
        }

        public Criteria andCaseNatureEqualTo(String value) {
            addCriterion("case_nature =", value, "caseNature");
            return (Criteria) this;
        }

        public Criteria andCaseNatureNotEqualTo(String value) {
            addCriterion("case_nature <>", value, "caseNature");
            return (Criteria) this;
        }

        public Criteria andCaseNatureGreaterThan(String value) {
            addCriterion("case_nature >", value, "caseNature");
            return (Criteria) this;
        }

        public Criteria andCaseNatureGreaterThanOrEqualTo(String value) {
            addCriterion("case_nature >=", value, "caseNature");
            return (Criteria) this;
        }

        public Criteria andCaseNatureLessThan(String value) {
            addCriterion("case_nature <", value, "caseNature");
            return (Criteria) this;
        }

        public Criteria andCaseNatureLessThanOrEqualTo(String value) {
            addCriterion("case_nature <=", value, "caseNature");
            return (Criteria) this;
        }

        public Criteria andCaseNatureLike(String value) {
            addCriterion("case_nature like", value, "caseNature");
            return (Criteria) this;
        }

        public Criteria andCaseNatureNotLike(String value) {
            addCriterion("case_nature not like", value, "caseNature");
            return (Criteria) this;
        }

        public Criteria andCaseNatureIn(List<String> values) {
            addCriterion("case_nature in", values, "caseNature");
            return (Criteria) this;
        }

        public Criteria andCaseNatureNotIn(List<String> values) {
            addCriterion("case_nature not in", values, "caseNature");
            return (Criteria) this;
        }

        public Criteria andCaseNatureBetween(String value1, String value2) {
            addCriterion("case_nature between", value1, value2, "caseNature");
            return (Criteria) this;
        }

        public Criteria andCaseNatureNotBetween(String value1, String value2) {
            addCriterion("case_nature not between", value1, value2, "caseNature");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIsNull() {
            addCriterion("case_type is null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIsNotNull() {
            addCriterion("case_type is not null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeEqualTo(Integer value) {
            addCriterion("case_type =", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotEqualTo(Integer value) {
            addCriterion("case_type <>", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThan(Integer value) {
            addCriterion("case_type >", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_type >=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThan(Integer value) {
            addCriterion("case_type <", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("case_type <=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIn(List<Integer> values) {
            addCriterion("case_type in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotIn(List<Integer> values) {
            addCriterion("case_type not in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeBetween(Integer value1, Integer value2) {
            addCriterion("case_type between", value1, value2, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("case_type not between", value1, value2, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNameIsNull() {
            addCriterion("case_type_name is null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNameIsNotNull() {
            addCriterion("case_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNameEqualTo(String value) {
            addCriterion("case_type_name =", value, "caseTypeName");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNameNotEqualTo(String value) {
            addCriterion("case_type_name <>", value, "caseTypeName");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNameGreaterThan(String value) {
            addCriterion("case_type_name >", value, "caseTypeName");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("case_type_name >=", value, "caseTypeName");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNameLessThan(String value) {
            addCriterion("case_type_name <", value, "caseTypeName");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNameLessThanOrEqualTo(String value) {
            addCriterion("case_type_name <=", value, "caseTypeName");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNameLike(String value) {
            addCriterion("case_type_name like", value, "caseTypeName");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNameNotLike(String value) {
            addCriterion("case_type_name not like", value, "caseTypeName");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNameIn(List<String> values) {
            addCriterion("case_type_name in", values, "caseTypeName");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNameNotIn(List<String> values) {
            addCriterion("case_type_name not in", values, "caseTypeName");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNameBetween(String value1, String value2) {
            addCriterion("case_type_name between", value1, value2, "caseTypeName");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNameNotBetween(String value1, String value2) {
            addCriterion("case_type_name not between", value1, value2, "caseTypeName");
            return (Criteria) this;
        }

        public Criteria andCaseStepsIsNull() {
            addCriterion("case_steps is null");
            return (Criteria) this;
        }

        public Criteria andCaseStepsIsNotNull() {
            addCriterion("case_steps is not null");
            return (Criteria) this;
        }

        public Criteria andCaseStepsEqualTo(Integer value) {
            addCriterion("case_steps =", value, "caseSteps");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNotEqualTo(Integer value) {
            addCriterion("case_steps <>", value, "caseSteps");
            return (Criteria) this;
        }

        public Criteria andCaseStepsGreaterThan(Integer value) {
            addCriterion("case_steps >", value, "caseSteps");
            return (Criteria) this;
        }

        public Criteria andCaseStepsGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_steps >=", value, "caseSteps");
            return (Criteria) this;
        }

        public Criteria andCaseStepsLessThan(Integer value) {
            addCriterion("case_steps <", value, "caseSteps");
            return (Criteria) this;
        }

        public Criteria andCaseStepsLessThanOrEqualTo(Integer value) {
            addCriterion("case_steps <=", value, "caseSteps");
            return (Criteria) this;
        }

        public Criteria andCaseStepsIn(List<Integer> values) {
            addCriterion("case_steps in", values, "caseSteps");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNotIn(List<Integer> values) {
            addCriterion("case_steps not in", values, "caseSteps");
            return (Criteria) this;
        }

        public Criteria andCaseStepsBetween(Integer value1, Integer value2) {
            addCriterion("case_steps between", value1, value2, "caseSteps");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNotBetween(Integer value1, Integer value2) {
            addCriterion("case_steps not between", value1, value2, "caseSteps");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNameIsNull() {
            addCriterion("case_steps_name is null");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNameIsNotNull() {
            addCriterion("case_steps_name is not null");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNameEqualTo(String value) {
            addCriterion("case_steps_name =", value, "caseStepsName");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNameNotEqualTo(String value) {
            addCriterion("case_steps_name <>", value, "caseStepsName");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNameGreaterThan(String value) {
            addCriterion("case_steps_name >", value, "caseStepsName");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNameGreaterThanOrEqualTo(String value) {
            addCriterion("case_steps_name >=", value, "caseStepsName");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNameLessThan(String value) {
            addCriterion("case_steps_name <", value, "caseStepsName");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNameLessThanOrEqualTo(String value) {
            addCriterion("case_steps_name <=", value, "caseStepsName");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNameLike(String value) {
            addCriterion("case_steps_name like", value, "caseStepsName");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNameNotLike(String value) {
            addCriterion("case_steps_name not like", value, "caseStepsName");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNameIn(List<String> values) {
            addCriterion("case_steps_name in", values, "caseStepsName");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNameNotIn(List<String> values) {
            addCriterion("case_steps_name not in", values, "caseStepsName");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNameBetween(String value1, String value2) {
            addCriterion("case_steps_name between", value1, value2, "caseStepsName");
            return (Criteria) this;
        }

        public Criteria andCaseStepsNameNotBetween(String value1, String value2) {
            addCriterion("case_steps_name not between", value1, value2, "caseStepsName");
            return (Criteria) this;
        }

        public Criteria andCaseStepsDateIsNull() {
            addCriterion("case_steps_date is null");
            return (Criteria) this;
        }

        public Criteria andCaseStepsDateIsNotNull() {
            addCriterion("case_steps_date is not null");
            return (Criteria) this;
        }

        public Criteria andCaseStepsDateEqualTo(String value) {
            addCriterion("case_steps_date =", value, "caseStepsDate");
            return (Criteria) this;
        }

        public Criteria andCaseStepsDateNotEqualTo(String value) {
            addCriterion("case_steps_date <>", value, "caseStepsDate");
            return (Criteria) this;
        }

        public Criteria andCaseStepsDateGreaterThan(String value) {
            addCriterion("case_steps_date >", value, "caseStepsDate");
            return (Criteria) this;
        }

        public Criteria andCaseStepsDateGreaterThanOrEqualTo(String value) {
            addCriterion("case_steps_date >=", value, "caseStepsDate");
            return (Criteria) this;
        }

        public Criteria andCaseStepsDateLessThan(String value) {
            addCriterion("case_steps_date <", value, "caseStepsDate");
            return (Criteria) this;
        }

        public Criteria andCaseStepsDateLessThanOrEqualTo(String value) {
            addCriterion("case_steps_date <=", value, "caseStepsDate");
            return (Criteria) this;
        }

        public Criteria andCaseStepsDateLike(String value) {
            addCriterion("case_steps_date like", value, "caseStepsDate");
            return (Criteria) this;
        }

        public Criteria andCaseStepsDateNotLike(String value) {
            addCriterion("case_steps_date not like", value, "caseStepsDate");
            return (Criteria) this;
        }

        public Criteria andCaseStepsDateIn(List<String> values) {
            addCriterion("case_steps_date in", values, "caseStepsDate");
            return (Criteria) this;
        }

        public Criteria andCaseStepsDateNotIn(List<String> values) {
            addCriterion("case_steps_date not in", values, "caseStepsDate");
            return (Criteria) this;
        }

        public Criteria andCaseStepsDateBetween(String value1, String value2) {
            addCriterion("case_steps_date between", value1, value2, "caseStepsDate");
            return (Criteria) this;
        }

        public Criteria andCaseStepsDateNotBetween(String value1, String value2) {
            addCriterion("case_steps_date not between", value1, value2, "caseStepsDate");
            return (Criteria) this;
        }

        public Criteria andCasePeopleIdIsNull() {
            addCriterion("case_people_id is null");
            return (Criteria) this;
        }

        public Criteria andCasePeopleIdIsNotNull() {
            addCriterion("case_people_id is not null");
            return (Criteria) this;
        }

        public Criteria andCasePeopleIdEqualTo(Integer value) {
            addCriterion("case_people_id =", value, "casePeopleId");
            return (Criteria) this;
        }

        public Criteria andCasePeopleIdNotEqualTo(Integer value) {
            addCriterion("case_people_id <>", value, "casePeopleId");
            return (Criteria) this;
        }

        public Criteria andCasePeopleIdGreaterThan(Integer value) {
            addCriterion("case_people_id >", value, "casePeopleId");
            return (Criteria) this;
        }

        public Criteria andCasePeopleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_people_id >=", value, "casePeopleId");
            return (Criteria) this;
        }

        public Criteria andCasePeopleIdLessThan(Integer value) {
            addCriterion("case_people_id <", value, "casePeopleId");
            return (Criteria) this;
        }

        public Criteria andCasePeopleIdLessThanOrEqualTo(Integer value) {
            addCriterion("case_people_id <=", value, "casePeopleId");
            return (Criteria) this;
        }

        public Criteria andCasePeopleIdIn(List<Integer> values) {
            addCriterion("case_people_id in", values, "casePeopleId");
            return (Criteria) this;
        }

        public Criteria andCasePeopleIdNotIn(List<Integer> values) {
            addCriterion("case_people_id not in", values, "casePeopleId");
            return (Criteria) this;
        }

        public Criteria andCasePeopleIdBetween(Integer value1, Integer value2) {
            addCriterion("case_people_id between", value1, value2, "casePeopleId");
            return (Criteria) this;
        }

        public Criteria andCasePeopleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("case_people_id not between", value1, value2, "casePeopleId");
            return (Criteria) this;
        }

        public Criteria andCaseFirstPoliceIdIsNull() {
            addCriterion("case_first_police_id is null");
            return (Criteria) this;
        }

        public Criteria andCaseFirstPoliceIdIsNotNull() {
            addCriterion("case_first_police_id is not null");
            return (Criteria) this;
        }

        public Criteria andCaseFirstPoliceIdEqualTo(Integer value) {
            addCriterion("case_first_police_id =", value, "caseFirstPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseFirstPoliceIdNotEqualTo(Integer value) {
            addCriterion("case_first_police_id <>", value, "caseFirstPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseFirstPoliceIdGreaterThan(Integer value) {
            addCriterion("case_first_police_id >", value, "caseFirstPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseFirstPoliceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_first_police_id >=", value, "caseFirstPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseFirstPoliceIdLessThan(Integer value) {
            addCriterion("case_first_police_id <", value, "caseFirstPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseFirstPoliceIdLessThanOrEqualTo(Integer value) {
            addCriterion("case_first_police_id <=", value, "caseFirstPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseFirstPoliceIdIn(List<Integer> values) {
            addCriterion("case_first_police_id in", values, "caseFirstPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseFirstPoliceIdNotIn(List<Integer> values) {
            addCriterion("case_first_police_id not in", values, "caseFirstPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseFirstPoliceIdBetween(Integer value1, Integer value2) {
            addCriterion("case_first_police_id between", value1, value2, "caseFirstPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseFirstPoliceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("case_first_police_id not between", value1, value2, "caseFirstPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseSecondPoliceIdIsNull() {
            addCriterion("case_second_police_id is null");
            return (Criteria) this;
        }

        public Criteria andCaseSecondPoliceIdIsNotNull() {
            addCriterion("case_second_police_id is not null");
            return (Criteria) this;
        }

        public Criteria andCaseSecondPoliceIdEqualTo(Integer value) {
            addCriterion("case_second_police_id =", value, "caseSecondPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseSecondPoliceIdNotEqualTo(Integer value) {
            addCriterion("case_second_police_id <>", value, "caseSecondPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseSecondPoliceIdGreaterThan(Integer value) {
            addCriterion("case_second_police_id >", value, "caseSecondPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseSecondPoliceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_second_police_id >=", value, "caseSecondPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseSecondPoliceIdLessThan(Integer value) {
            addCriterion("case_second_police_id <", value, "caseSecondPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseSecondPoliceIdLessThanOrEqualTo(Integer value) {
            addCriterion("case_second_police_id <=", value, "caseSecondPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseSecondPoliceIdIn(List<Integer> values) {
            addCriterion("case_second_police_id in", values, "caseSecondPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseSecondPoliceIdNotIn(List<Integer> values) {
            addCriterion("case_second_police_id not in", values, "caseSecondPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseSecondPoliceIdBetween(Integer value1, Integer value2) {
            addCriterion("case_second_police_id between", value1, value2, "caseSecondPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseSecondPoliceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("case_second_police_id not between", value1, value2, "caseSecondPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseLegalPoliceIdIsNull() {
            addCriterion("case_legal_police_id is null");
            return (Criteria) this;
        }

        public Criteria andCaseLegalPoliceIdIsNotNull() {
            addCriterion("case_legal_police_id is not null");
            return (Criteria) this;
        }

        public Criteria andCaseLegalPoliceIdEqualTo(Integer value) {
            addCriterion("case_legal_police_id =", value, "caseLegalPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseLegalPoliceIdNotEqualTo(Integer value) {
            addCriterion("case_legal_police_id <>", value, "caseLegalPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseLegalPoliceIdGreaterThan(Integer value) {
            addCriterion("case_legal_police_id >", value, "caseLegalPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseLegalPoliceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_legal_police_id >=", value, "caseLegalPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseLegalPoliceIdLessThan(Integer value) {
            addCriterion("case_legal_police_id <", value, "caseLegalPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseLegalPoliceIdLessThanOrEqualTo(Integer value) {
            addCriterion("case_legal_police_id <=", value, "caseLegalPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseLegalPoliceIdIn(List<Integer> values) {
            addCriterion("case_legal_police_id in", values, "caseLegalPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseLegalPoliceIdNotIn(List<Integer> values) {
            addCriterion("case_legal_police_id not in", values, "caseLegalPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseLegalPoliceIdBetween(Integer value1, Integer value2) {
            addCriterion("case_legal_police_id between", value1, value2, "caseLegalPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseLegalPoliceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("case_legal_police_id not between", value1, value2, "caseLegalPoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseCreateDateIsNull() {
            addCriterion("case_create_date is null");
            return (Criteria) this;
        }

        public Criteria andCaseCreateDateIsNotNull() {
            addCriterion("case_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCaseCreateDateEqualTo(String value) {
            addCriterion("case_create_date =", value, "caseCreateDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreateDateNotEqualTo(String value) {
            addCriterion("case_create_date <>", value, "caseCreateDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreateDateGreaterThan(String value) {
            addCriterion("case_create_date >", value, "caseCreateDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("case_create_date >=", value, "caseCreateDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreateDateLessThan(String value) {
            addCriterion("case_create_date <", value, "caseCreateDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreateDateLessThanOrEqualTo(String value) {
            addCriterion("case_create_date <=", value, "caseCreateDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreateDateLike(String value) {
            addCriterion("case_create_date like", value, "caseCreateDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreateDateNotLike(String value) {
            addCriterion("case_create_date not like", value, "caseCreateDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreateDateIn(List<String> values) {
            addCriterion("case_create_date in", values, "caseCreateDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreateDateNotIn(List<String> values) {
            addCriterion("case_create_date not in", values, "caseCreateDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreateDateBetween(String value1, String value2) {
            addCriterion("case_create_date between", value1, value2, "caseCreateDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreateDateNotBetween(String value1, String value2) {
            addCriterion("case_create_date not between", value1, value2, "caseCreateDate");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceIdIsNull() {
            addCriterion("case_create_police_id is null");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceIdIsNotNull() {
            addCriterion("case_create_police_id is not null");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceIdEqualTo(Integer value) {
            addCriterion("case_create_police_id =", value, "caseCreatePoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceIdNotEqualTo(Integer value) {
            addCriterion("case_create_police_id <>", value, "caseCreatePoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceIdGreaterThan(Integer value) {
            addCriterion("case_create_police_id >", value, "caseCreatePoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_create_police_id >=", value, "caseCreatePoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceIdLessThan(Integer value) {
            addCriterion("case_create_police_id <", value, "caseCreatePoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceIdLessThanOrEqualTo(Integer value) {
            addCriterion("case_create_police_id <=", value, "caseCreatePoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceIdIn(List<Integer> values) {
            addCriterion("case_create_police_id in", values, "caseCreatePoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceIdNotIn(List<Integer> values) {
            addCriterion("case_create_police_id not in", values, "caseCreatePoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceIdBetween(Integer value1, Integer value2) {
            addCriterion("case_create_police_id between", value1, value2, "caseCreatePoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("case_create_police_id not between", value1, value2, "caseCreatePoliceId");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceNameIsNull() {
            addCriterion("case_create_police_name is null");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceNameIsNotNull() {
            addCriterion("case_create_police_name is not null");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceNameEqualTo(String value) {
            addCriterion("case_create_police_name =", value, "caseCreatePoliceName");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceNameNotEqualTo(String value) {
            addCriterion("case_create_police_name <>", value, "caseCreatePoliceName");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceNameGreaterThan(String value) {
            addCriterion("case_create_police_name >", value, "caseCreatePoliceName");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceNameGreaterThanOrEqualTo(String value) {
            addCriterion("case_create_police_name >=", value, "caseCreatePoliceName");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceNameLessThan(String value) {
            addCriterion("case_create_police_name <", value, "caseCreatePoliceName");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceNameLessThanOrEqualTo(String value) {
            addCriterion("case_create_police_name <=", value, "caseCreatePoliceName");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceNameLike(String value) {
            addCriterion("case_create_police_name like", value, "caseCreatePoliceName");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceNameNotLike(String value) {
            addCriterion("case_create_police_name not like", value, "caseCreatePoliceName");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceNameIn(List<String> values) {
            addCriterion("case_create_police_name in", values, "caseCreatePoliceName");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceNameNotIn(List<String> values) {
            addCriterion("case_create_police_name not in", values, "caseCreatePoliceName");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceNameBetween(String value1, String value2) {
            addCriterion("case_create_police_name between", value1, value2, "caseCreatePoliceName");
            return (Criteria) this;
        }

        public Criteria andCaseCreatePoliceNameNotBetween(String value1, String value2) {
            addCriterion("case_create_police_name not between", value1, value2, "caseCreatePoliceName");
            return (Criteria) this;
        }

        public Criteria andCaseCustomIsNull() {
            addCriterion("case_custom is null");
            return (Criteria) this;
        }

        public Criteria andCaseCustomIsNotNull() {
            addCriterion("case_custom is not null");
            return (Criteria) this;
        }

        public Criteria andCaseCustomEqualTo(Integer value) {
            addCriterion("case_custom =", value, "caseCustom");
            return (Criteria) this;
        }

        public Criteria andCaseCustomNotEqualTo(Integer value) {
            addCriterion("case_custom <>", value, "caseCustom");
            return (Criteria) this;
        }

        public Criteria andCaseCustomGreaterThan(Integer value) {
            addCriterion("case_custom >", value, "caseCustom");
            return (Criteria) this;
        }

        public Criteria andCaseCustomGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_custom >=", value, "caseCustom");
            return (Criteria) this;
        }

        public Criteria andCaseCustomLessThan(Integer value) {
            addCriterion("case_custom <", value, "caseCustom");
            return (Criteria) this;
        }

        public Criteria andCaseCustomLessThanOrEqualTo(Integer value) {
            addCriterion("case_custom <=", value, "caseCustom");
            return (Criteria) this;
        }

        public Criteria andCaseCustomIn(List<Integer> values) {
            addCriterion("case_custom in", values, "caseCustom");
            return (Criteria) this;
        }

        public Criteria andCaseCustomNotIn(List<Integer> values) {
            addCriterion("case_custom not in", values, "caseCustom");
            return (Criteria) this;
        }

        public Criteria andCaseCustomBetween(Integer value1, Integer value2) {
            addCriterion("case_custom between", value1, value2, "caseCustom");
            return (Criteria) this;
        }

        public Criteria andCaseCustomNotBetween(Integer value1, Integer value2) {
            addCriterion("case_custom not between", value1, value2, "caseCustom");
            return (Criteria) this;
        }

        public Criteria andCaseCompleteIsNull() {
            addCriterion("case_complete is null");
            return (Criteria) this;
        }

        public Criteria andCaseCompleteIsNotNull() {
            addCriterion("case_complete is not null");
            return (Criteria) this;
        }

        public Criteria andCaseCompleteEqualTo(Integer value) {
            addCriterion("case_complete =", value, "caseComplete");
            return (Criteria) this;
        }

        public Criteria andCaseCompleteNotEqualTo(Integer value) {
            addCriterion("case_complete <>", value, "caseComplete");
            return (Criteria) this;
        }

        public Criteria andCaseCompleteGreaterThan(Integer value) {
            addCriterion("case_complete >", value, "caseComplete");
            return (Criteria) this;
        }

        public Criteria andCaseCompleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_complete >=", value, "caseComplete");
            return (Criteria) this;
        }

        public Criteria andCaseCompleteLessThan(Integer value) {
            addCriterion("case_complete <", value, "caseComplete");
            return (Criteria) this;
        }

        public Criteria andCaseCompleteLessThanOrEqualTo(Integer value) {
            addCriterion("case_complete <=", value, "caseComplete");
            return (Criteria) this;
        }

        public Criteria andCaseCompleteIn(List<Integer> values) {
            addCriterion("case_complete in", values, "caseComplete");
            return (Criteria) this;
        }

        public Criteria andCaseCompleteNotIn(List<Integer> values) {
            addCriterion("case_complete not in", values, "caseComplete");
            return (Criteria) this;
        }

        public Criteria andCaseCompleteBetween(Integer value1, Integer value2) {
            addCriterion("case_complete between", value1, value2, "caseComplete");
            return (Criteria) this;
        }

        public Criteria andCaseCompleteNotBetween(Integer value1, Integer value2) {
            addCriterion("case_complete not between", value1, value2, "caseComplete");
            return (Criteria) this;
        }

        public Criteria andCaseRemandIsNull() {
            addCriterion("case_remand is null");
            return (Criteria) this;
        }

        public Criteria andCaseRemandIsNotNull() {
            addCriterion("case_remand is not null");
            return (Criteria) this;
        }

        public Criteria andCaseRemandEqualTo(Integer value) {
            addCriterion("case_remand =", value, "caseRemand");
            return (Criteria) this;
        }

        public Criteria andCaseRemandNotEqualTo(Integer value) {
            addCriterion("case_remand <>", value, "caseRemand");
            return (Criteria) this;
        }

        public Criteria andCaseRemandGreaterThan(Integer value) {
            addCriterion("case_remand >", value, "caseRemand");
            return (Criteria) this;
        }

        public Criteria andCaseRemandGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_remand >=", value, "caseRemand");
            return (Criteria) this;
        }

        public Criteria andCaseRemandLessThan(Integer value) {
            addCriterion("case_remand <", value, "caseRemand");
            return (Criteria) this;
        }

        public Criteria andCaseRemandLessThanOrEqualTo(Integer value) {
            addCriterion("case_remand <=", value, "caseRemand");
            return (Criteria) this;
        }

        public Criteria andCaseRemandIn(List<Integer> values) {
            addCriterion("case_remand in", values, "caseRemand");
            return (Criteria) this;
        }

        public Criteria andCaseRemandNotIn(List<Integer> values) {
            addCriterion("case_remand not in", values, "caseRemand");
            return (Criteria) this;
        }

        public Criteria andCaseRemandBetween(Integer value1, Integer value2) {
            addCriterion("case_remand between", value1, value2, "caseRemand");
            return (Criteria) this;
        }

        public Criteria andCaseRemandNotBetween(Integer value1, Integer value2) {
            addCriterion("case_remand not between", value1, value2, "caseRemand");
            return (Criteria) this;
        }

        public Criteria andCaseSupervisionIsNull() {
            addCriterion("case_supervision is null");
            return (Criteria) this;
        }

        public Criteria andCaseSupervisionIsNotNull() {
            addCriterion("case_supervision is not null");
            return (Criteria) this;
        }

        public Criteria andCaseSupervisionEqualTo(Integer value) {
            addCriterion("case_supervision =", value, "caseSupervision");
            return (Criteria) this;
        }

        public Criteria andCaseSupervisionNotEqualTo(Integer value) {
            addCriterion("case_supervision <>", value, "caseSupervision");
            return (Criteria) this;
        }

        public Criteria andCaseSupervisionGreaterThan(Integer value) {
            addCriterion("case_supervision >", value, "caseSupervision");
            return (Criteria) this;
        }

        public Criteria andCaseSupervisionGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_supervision >=", value, "caseSupervision");
            return (Criteria) this;
        }

        public Criteria andCaseSupervisionLessThan(Integer value) {
            addCriterion("case_supervision <", value, "caseSupervision");
            return (Criteria) this;
        }

        public Criteria andCaseSupervisionLessThanOrEqualTo(Integer value) {
            addCriterion("case_supervision <=", value, "caseSupervision");
            return (Criteria) this;
        }

        public Criteria andCaseSupervisionIn(List<Integer> values) {
            addCriterion("case_supervision in", values, "caseSupervision");
            return (Criteria) this;
        }

        public Criteria andCaseSupervisionNotIn(List<Integer> values) {
            addCriterion("case_supervision not in", values, "caseSupervision");
            return (Criteria) this;
        }

        public Criteria andCaseSupervisionBetween(Integer value1, Integer value2) {
            addCriterion("case_supervision between", value1, value2, "caseSupervision");
            return (Criteria) this;
        }

        public Criteria andCaseSupervisionNotBetween(Integer value1, Integer value2) {
            addCriterion("case_supervision not between", value1, value2, "caseSupervision");
            return (Criteria) this;
        }

        public Criteria andCaseFugitiveIsNull() {
            addCriterion("case_fugitive is null");
            return (Criteria) this;
        }

        public Criteria andCaseFugitiveIsNotNull() {
            addCriterion("case_fugitive is not null");
            return (Criteria) this;
        }

        public Criteria andCaseFugitiveEqualTo(Integer value) {
            addCriterion("case_fugitive =", value, "caseFugitive");
            return (Criteria) this;
        }

        public Criteria andCaseFugitiveNotEqualTo(Integer value) {
            addCriterion("case_fugitive <>", value, "caseFugitive");
            return (Criteria) this;
        }

        public Criteria andCaseFugitiveGreaterThan(Integer value) {
            addCriterion("case_fugitive >", value, "caseFugitive");
            return (Criteria) this;
        }

        public Criteria andCaseFugitiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_fugitive >=", value, "caseFugitive");
            return (Criteria) this;
        }

        public Criteria andCaseFugitiveLessThan(Integer value) {
            addCriterion("case_fugitive <", value, "caseFugitive");
            return (Criteria) this;
        }

        public Criteria andCaseFugitiveLessThanOrEqualTo(Integer value) {
            addCriterion("case_fugitive <=", value, "caseFugitive");
            return (Criteria) this;
        }

        public Criteria andCaseFugitiveIn(List<Integer> values) {
            addCriterion("case_fugitive in", values, "caseFugitive");
            return (Criteria) this;
        }

        public Criteria andCaseFugitiveNotIn(List<Integer> values) {
            addCriterion("case_fugitive not in", values, "caseFugitive");
            return (Criteria) this;
        }

        public Criteria andCaseFugitiveBetween(Integer value1, Integer value2) {
            addCriterion("case_fugitive between", value1, value2, "caseFugitive");
            return (Criteria) this;
        }

        public Criteria andCaseFugitiveNotBetween(Integer value1, Integer value2) {
            addCriterion("case_fugitive not between", value1, value2, "caseFugitive");
            return (Criteria) this;
        }

        public Criteria andCaseExplainIsNull() {
            addCriterion("case_explain is null");
            return (Criteria) this;
        }

        public Criteria andCaseExplainIsNotNull() {
            addCriterion("case_explain is not null");
            return (Criteria) this;
        }

        public Criteria andCaseExplainEqualTo(String value) {
            addCriterion("case_explain =", value, "caseExplain");
            return (Criteria) this;
        }

        public Criteria andCaseExplainNotEqualTo(String value) {
            addCriterion("case_explain <>", value, "caseExplain");
            return (Criteria) this;
        }

        public Criteria andCaseExplainGreaterThan(String value) {
            addCriterion("case_explain >", value, "caseExplain");
            return (Criteria) this;
        }

        public Criteria andCaseExplainGreaterThanOrEqualTo(String value) {
            addCriterion("case_explain >=", value, "caseExplain");
            return (Criteria) this;
        }

        public Criteria andCaseExplainLessThan(String value) {
            addCriterion("case_explain <", value, "caseExplain");
            return (Criteria) this;
        }

        public Criteria andCaseExplainLessThanOrEqualTo(String value) {
            addCriterion("case_explain <=", value, "caseExplain");
            return (Criteria) this;
        }

        public Criteria andCaseExplainLike(String value) {
            addCriterion("case_explain like", value, "caseExplain");
            return (Criteria) this;
        }

        public Criteria andCaseExplainNotLike(String value) {
            addCriterion("case_explain not like", value, "caseExplain");
            return (Criteria) this;
        }

        public Criteria andCaseExplainIn(List<String> values) {
            addCriterion("case_explain in", values, "caseExplain");
            return (Criteria) this;
        }

        public Criteria andCaseExplainNotIn(List<String> values) {
            addCriterion("case_explain not in", values, "caseExplain");
            return (Criteria) this;
        }

        public Criteria andCaseExplainBetween(String value1, String value2) {
            addCriterion("case_explain between", value1, value2, "caseExplain");
            return (Criteria) this;
        }

        public Criteria andCaseExplainNotBetween(String value1, String value2) {
            addCriterion("case_explain not between", value1, value2, "caseExplain");
            return (Criteria) this;
        }

        public Criteria andCaseAdminHoldDayIsNull() {
            addCriterion("case_admin_hold_day is null");
            return (Criteria) this;
        }

        public Criteria andCaseAdminHoldDayIsNotNull() {
            addCriterion("case_admin_hold_day is not null");
            return (Criteria) this;
        }

        public Criteria andCaseAdminHoldDayEqualTo(Integer value) {
            addCriterion("case_admin_hold_day =", value, "caseAdminHoldDay");
            return (Criteria) this;
        }

        public Criteria andCaseAdminHoldDayNotEqualTo(Integer value) {
            addCriterion("case_admin_hold_day <>", value, "caseAdminHoldDay");
            return (Criteria) this;
        }

        public Criteria andCaseAdminHoldDayGreaterThan(Integer value) {
            addCriterion("case_admin_hold_day >", value, "caseAdminHoldDay");
            return (Criteria) this;
        }

        public Criteria andCaseAdminHoldDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("case_admin_hold_day >=", value, "caseAdminHoldDay");
            return (Criteria) this;
        }

        public Criteria andCaseAdminHoldDayLessThan(Integer value) {
            addCriterion("case_admin_hold_day <", value, "caseAdminHoldDay");
            return (Criteria) this;
        }

        public Criteria andCaseAdminHoldDayLessThanOrEqualTo(Integer value) {
            addCriterion("case_admin_hold_day <=", value, "caseAdminHoldDay");
            return (Criteria) this;
        }

        public Criteria andCaseAdminHoldDayIn(List<Integer> values) {
            addCriterion("case_admin_hold_day in", values, "caseAdminHoldDay");
            return (Criteria) this;
        }

        public Criteria andCaseAdminHoldDayNotIn(List<Integer> values) {
            addCriterion("case_admin_hold_day not in", values, "caseAdminHoldDay");
            return (Criteria) this;
        }

        public Criteria andCaseAdminHoldDayBetween(Integer value1, Integer value2) {
            addCriterion("case_admin_hold_day between", value1, value2, "caseAdminHoldDay");
            return (Criteria) this;
        }

        public Criteria andCaseAdminHoldDayNotBetween(Integer value1, Integer value2) {
            addCriterion("case_admin_hold_day not between", value1, value2, "caseAdminHoldDay");
            return (Criteria) this;
        }

        public Criteria andCaseAdminMoneyIsNull() {
            addCriterion("case_admin_money is null");
            return (Criteria) this;
        }

        public Criteria andCaseAdminMoneyIsNotNull() {
            addCriterion("case_admin_money is not null");
            return (Criteria) this;
        }

        public Criteria andCaseAdminMoneyEqualTo(String value) {
            addCriterion("case_admin_money =", value, "caseAdminMoney");
            return (Criteria) this;
        }

        public Criteria andCaseAdminMoneyNotEqualTo(String value) {
            addCriterion("case_admin_money <>", value, "caseAdminMoney");
            return (Criteria) this;
        }

        public Criteria andCaseAdminMoneyGreaterThan(String value) {
            addCriterion("case_admin_money >", value, "caseAdminMoney");
            return (Criteria) this;
        }

        public Criteria andCaseAdminMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("case_admin_money >=", value, "caseAdminMoney");
            return (Criteria) this;
        }

        public Criteria andCaseAdminMoneyLessThan(String value) {
            addCriterion("case_admin_money <", value, "caseAdminMoney");
            return (Criteria) this;
        }

        public Criteria andCaseAdminMoneyLessThanOrEqualTo(String value) {
            addCriterion("case_admin_money <=", value, "caseAdminMoney");
            return (Criteria) this;
        }

        public Criteria andCaseAdminMoneyLike(String value) {
            addCriterion("case_admin_money like", value, "caseAdminMoney");
            return (Criteria) this;
        }

        public Criteria andCaseAdminMoneyNotLike(String value) {
            addCriterion("case_admin_money not like", value, "caseAdminMoney");
            return (Criteria) this;
        }

        public Criteria andCaseAdminMoneyIn(List<String> values) {
            addCriterion("case_admin_money in", values, "caseAdminMoney");
            return (Criteria) this;
        }

        public Criteria andCaseAdminMoneyNotIn(List<String> values) {
            addCriterion("case_admin_money not in", values, "caseAdminMoney");
            return (Criteria) this;
        }

        public Criteria andCaseAdminMoneyBetween(String value1, String value2) {
            addCriterion("case_admin_money between", value1, value2, "caseAdminMoney");
            return (Criteria) this;
        }

        public Criteria andCaseAdminMoneyNotBetween(String value1, String value2) {
            addCriterion("case_admin_money not between", value1, value2, "caseAdminMoney");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}