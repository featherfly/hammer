
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-03-19 19:53:19
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.mapper.SqlResultSet;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.repository.mapper.RowMapper;

/**
 * AbstractRowMapper.
 *
 * @author zhongj
 * @param <E> the element type
 */
public abstract class AbstractRowMapper<E> implements RowMapper<E> {

    /**
     * {@inheritDoc}
     */
    @Override
    public E mapRow(cn.featherfly.common.repository.mapper.ResultSet res, int rowNum) {
        ResultSet rs = null;
        if (res instanceof SqlResultSet) {
            SqlResultSet sqlrs = (SqlResultSet) res;
            rs = sqlrs.getResultSet();
            AssertIllegalArgument.isNotNull(rs, "java.sql.ResultSet");
        } else {
            throw new JdbcException("ResultSet is not type of SqlResultSet");
        }

        try {
            return mapRow(rs, rowNum);
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    /**
     * Map row.
     *
     * @param res the res
     * @param rowNum the row num
     * @return the e
     */
    public abstract E mapRow(ResultSet res, int rowNum) throws SQLException;

    /**
     * Gets the result set.
     *
     * @param res the res
     * @return the result set
     */
    protected ResultSet getResultSet(cn.featherfly.common.repository.mapper.ResultSet res) {
        ResultSet rs = null;
        if (res instanceof SqlResultSet) {
            SqlResultSet sqlrs = (SqlResultSet) res;
            rs = sqlrs.getResultSet();
            AssertIllegalArgument.isNotNull(rs, "java.sql.ResultSet");
        } else {
            throw new JdbcException("ResultSet is not type of SqlResultSet");
        }
        return rs;
    }
}
