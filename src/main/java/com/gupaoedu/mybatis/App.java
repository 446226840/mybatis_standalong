package com.gupaoedu.mybatis;

import com.alibaba.fastjson.JSON;
import com.gupaoedu.mybatis.entity.Company;
import com.gupaoedu.mybatis.mapper.CompanyMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */

public class App 
{
    private SqlSessionFactory sqlSessionFactory ;

    @Before
    public void init() throws IOException {
        String mybatisCofigName = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(mybatisCofigName);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void getAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CompanyMapper companyMapper = sqlSession.getMapper(CompanyMapper.class);
        List<Company> companyList = companyMapper.getCompanys();
        System.out.println(JSON.toJSONString(companyList));
        sqlSession.close();

    }

    @Test
    public void updateCompany(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CompanyMapper companyMapper = sqlSession.getMapper(CompanyMapper.class);
        List<Integer> str = new ArrayList<>();
        str.add(2);
//        str.add(5);
        companyMapper.updateCompany(str,1L);
        sqlSession.commit();
        sqlSession.close();

    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
