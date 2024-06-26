
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
import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.mapping.AbstractGenericJavaSqlTypeMapper;
import cn.featherfly.common.lang.reflect.Type;

/**
 * ListToStringSqlTypeMapper.
 *
 * @author zhongj
 */
public class ListToStringSqlTypeMapper extends AbstractGenericJavaSqlTypeMapper<List<?>> {

    //            private BeanProperty<List> bp = BeanDescriptor.getBeanDescriptor(Article.class)
    //                    .getBeanProperty("content");

    @Override
    public boolean support(SQLType sqlType) {
        return JDBCType.VARCHAR.equals(sqlType);
    }

    @Override
    public boolean support(Type<List<?>> type) {
        return type.getType().equals(List.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(ResultSet rs, int parameterIndex, List<?> value) {
        StringBuilder sb = new StringBuilder();
        for (Object object : value) {
            sb.append(object.toString()).append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        JdbcUtils.setParameter(rs, parameterIndex, sb.toString());
    }

    @Override
    public void set(PreparedStatement prep, int columnIndex, List<?> value) {
        StringBuilder sb = new StringBuilder();
        for (Object object : value) {
            sb.append(object.toString()).append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        JdbcUtils.setParameter(prep, columnIndex, sb.toString());
    }

    @Override
    public List<?> get(ResultSet rs, int columnIndex) {
        try {
            List<? super Object> list = new ArrayList<>();
            String value = rs.getString(columnIndex);
            if (value == null) {
                return list;
            }
            for (String v : rs.getString(columnIndex).split(",")) {
                list.add(Long.valueOf(v));
            }
            //            return ArrayUtils.toNumbers(Long.class, rs.getString(columnIndex).split(","));
            return list;
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void set(CallableStatement call, String parameterName, List<?> value) {
        StringBuilder sb = new StringBuilder();
        for (Object object : value) {
            sb.append(object.toString()).append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        JdbcUtils.setParameter(call, parameterName, sb.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<?> get(CallableStatement call, int paramIndex) {
        try {
            List<? super Object> list = new ArrayList<>();
            String value = call.getString(paramIndex);
            if (value == null) {
                return list;
            }
            for (String v : call.getString(paramIndex).split(",")) {
                list.add(Long.valueOf(v));
            }
            //            return ArrayUtils.toNumbers(Long.class, rs.getString(columnIndex).split(","));
            return list;
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

}
