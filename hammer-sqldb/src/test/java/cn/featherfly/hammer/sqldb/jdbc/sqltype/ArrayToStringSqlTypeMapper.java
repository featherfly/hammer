
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ListToStringSqlTypeMapper.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.sqltype
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2021-05-27 11:48:27
 * @Copyright: 2021 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.sqltype;

import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.mapping.AbstractGenericJavaSqlTypeMapper;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.GenericType;

/**
 * ListToStringSqlTypeMapper.
 *
 * @author zhongj
 */
public class ArrayToStringSqlTypeMapper extends AbstractGenericJavaSqlTypeMapper<Long[]> {

    @Override
    public boolean support(SQLType sqlType) {
        return JDBCType.VARCHAR.equals(sqlType);
    }

    @Override
    public boolean support(GenericType<Long[]> type) {
        return type.getType().equals(Long[].class);
    }

    @Override
    public Class<Long[]> getJavaType(SQLType sqlType) {
        return Long[].class;
    }

    @Override
    public SQLType getSqlType(GenericType<Long[]> javaType) {
        return JDBCType.VARCHAR;
    }

    @Override
    public void set(PreparedStatement prep, int columnIndex, Long[] value) {
        System.out.println(ArrayUtils.toString(value, ','));
        JdbcUtils.setParameter(prep, columnIndex, ArrayUtils.toString(value, ','));
    }

    @Override
    public Long[] get(ResultSet rs, int columnIndex) {
        try {
            return ArrayUtils.toNumbers(Long.class, rs.getString(columnIndex).split(","));
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }
}
