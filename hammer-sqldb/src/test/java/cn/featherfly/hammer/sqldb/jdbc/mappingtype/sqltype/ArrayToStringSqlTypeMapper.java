
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ListToStringSqlTypeMapper.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.sqltype
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2021-05-27 11:48:27
 * @Copyright: 2021 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mappingtype.sqltype;

import java.sql.CallableStatement;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.mapping.AbstractGenericJavaSqlTypeMapper;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.reflect.Type;

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
    public boolean support(Type<Long[]> type) {
        return type.getType().equals(Long[].class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(ResultSet rs, int parameterIndex, Long[] value) {
        System.out.println(ArrayUtils.toString(value, ','));
        JdbcUtils.setParameter(rs, parameterIndex, ArrayUtils.toString(value, ','));
    }

    @Override
    public void set(PreparedStatement prep, int columnIndex, Long[] value) {
        System.out.println(ArrayUtils.toString(value, ','));
        JdbcUtils.setParameter(prep, columnIndex, ArrayUtils.toString(value, ','));
    }

    @Override
    public Long[] get(ResultSet rs, int columnIndex) {
        try {
            String value = rs.getString(columnIndex);
            if (Lang.isEmpty(value)) {
                return ArrayUtils.EMPTY_LONG_OBJECT_ARRAY;
            } else {
                return ArrayUtils.toNumbers(Long.class, rs.getString(columnIndex).split(","));
            }
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void set(CallableStatement call, String parameterName, Long[] value) {
        System.out.println(ArrayUtils.toString(value, ','));
        JdbcUtils.setParameter(call, parameterName, ArrayUtils.toString(value, ','));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long[] get(CallableStatement call, int paramIndex) {
        try {
            String value = call.getString(paramIndex);
            if (Lang.isEmpty(value)) {
                return ArrayUtils.EMPTY_LONG_OBJECT_ARRAY;
            } else {
                return ArrayUtils.toNumbers(Long.class, call.getString(paramIndex).split(","));
            }
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }
}
