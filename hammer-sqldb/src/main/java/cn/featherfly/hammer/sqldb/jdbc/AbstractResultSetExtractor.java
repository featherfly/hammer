
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-19 16:54:19
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.mapper.SqlResultSet;
import cn.featherfly.common.repository.mapper.RowMapper;

/**
 * AbstractResultSetExtractor.
 *
 * @author zhongj
 */
public abstract class AbstractResultSetExtractor<E> implements SqlResultSetExtractor<E> {

    private RowMapper<E> rowMapper;

    /**
     * Instantiates a new map result set extractor.
     *
     * @param rowMapper the row mapper
     */
    protected AbstractResultSetExtractor(RowMapper<E> rowMapper) {
        super();
        this.rowMapper = rowMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> extract(SqlResultSet resultSet) {
        List<E> list = new ArrayList<>();
        int row = 0;
        try {
            while (resultSet.getResultSet().next()) {
                list.add(rowMapper.mapRow(resultSet, row++));
            }
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
        return list;
    }

}
