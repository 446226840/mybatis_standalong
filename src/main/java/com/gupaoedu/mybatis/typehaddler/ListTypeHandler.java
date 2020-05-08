package com.gupaoedu.mybatis.typehaddler;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * 数据库和实体数据的转换
 */
public class ListTypeHandler extends BaseTypeHandler<List> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List list, JdbcType jdbcType) throws SQLException {
        String str = StringUtils.join(list, ",");
        preparedStatement.setString(i,str);
    }

    @Override
    public List getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String result = resultSet.getString(s);
        if(s!=null && !"".equals(s)){
            List results = Arrays.asList(StringUtils.split(result,","));
            return results;
        }
        return null;
    }

    @Override
    public List getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public List getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
