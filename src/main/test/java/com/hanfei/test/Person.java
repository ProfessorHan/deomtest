package com.hanfei.test;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Hanfei
 * @Date: 2017/9/2
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:Person
 */
@XStreamAlias("Person")
public class Person {
    private String name;

    private Integer age;

    private Double salary;
    @XStreamImplicit(itemFieldName = "dept")
    private List<Dept> dept = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<com.hanfei.test.Dept> getDept() {
        return dept;
    }

    public void setDept(List<com.hanfei.test.Dept> dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", dept=" + dept +
                '}';
    }
}
