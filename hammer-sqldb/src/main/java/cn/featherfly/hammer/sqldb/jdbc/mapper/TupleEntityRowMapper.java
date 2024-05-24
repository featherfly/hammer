
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-26 22:15:26
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.speedment.common.tuple.Tuple;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.mapper.SqlResultSet;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.repository.mapper.RowMapper;

/**
 * TupleEntityRowMapper.
 *
 * @author zhongj
 * @param <T> the entity type
 */
public class TupleEntityRowMapper<T extends Tuple> implements RowMapper<T> {

    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final List<EntityRowMapper<?>> rowMappers = new ArrayList<>();

    /**
     * Instantiates a new entity mapper.
     *
     * @param rowMappers the row mappers
     */
    public TupleEntityRowMapper(EntityRowMapper<?>... rowMappers) {
        super();
        CollectionUtils.addAll(this.rowMappers, rowMappers);
    }

    /**
     * Instantiates a new tuple entity row mapper.
     *
     * @param rowMappers the row mappers
     */
    public TupleEntityRowMapper(List<EntityRowMapper<?>> rowMappers) {
        super();
        CollectionUtils.addAll(this.rowMappers, rowMappers);
    }

    /**
     * 每条记录映射为对象.
     *
     * @param rs 结果集
     * @param rowNumber 行数
     * @return 映射后的对象
     */
    @Override
    public T mapRow(cn.featherfly.common.repository.mapper.ResultSet rs, int rowNumber) {
        if (rs instanceof SqlResultSet) {
            SqlResultSet sqlrs = (SqlResultSet) rs;
            return mapRow(sqlrs.getResultSet(), rowNumber);
        }
        return null;
    }

    /**
     * 每条记录映射为对象.
     *
     * @param resultSet 结果集
     * @param rowNumber 行数
     * @return 映射后的对象
     */
    @SuppressWarnings("unchecked")
    public T mapRow(ResultSet resultSet, int rowNumber) {
        Object[] results = new Object[rowMappers.size()];
        final AtomicInteger column = new AtomicInteger(1);
        for (int i = 0; i < rowMappers.size(); i++) {
            results[i] = rowMappers.get(i).mapRow(resultSet, rowNumber, column);
        }
        return (T) Tuples.ofArray(results);
    }

}
