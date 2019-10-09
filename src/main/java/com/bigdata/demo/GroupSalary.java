package com.bigdata.demo;

import java.util.List;

/**
 * @ Author: wangshengyu
 * @ Date: 2019/10/8 11:29
 * @ Version 1.0
 */
public class GroupSalary {
    private List<Salary> salaries;
    private String shortName;
    private int total;

    public List<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
