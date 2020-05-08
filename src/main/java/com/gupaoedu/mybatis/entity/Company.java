package com.gupaoedu.mybatis.entity;

import java.util.List;

public class Company {
    private Long id;
    private String companyName;
    private List<Integer> businessScope;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Integer> getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(List<Integer> businessScope) {
        this.businessScope = businessScope;
    }
}
