package com.gupaoedu.mybatis.mapper;

import com.gupaoedu.mybatis.entity.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyMapper {
    public List<Company> getCompanys();

    void updateCompany(@Param("businessScope") List<Integer> businessScope,@Param("id") Long id);
}
