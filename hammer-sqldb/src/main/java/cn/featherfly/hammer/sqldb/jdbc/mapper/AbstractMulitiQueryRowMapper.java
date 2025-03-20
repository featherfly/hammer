
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2022-02-20 01:28:20
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.util.function.BiFunction;

import cn.featherfly.common.repository.mapper.RowMapper;

/**
 * AbstractMulitiQueryRowMapper.
 *
 * @author zhongj
 */
public abstract class AbstractMulitiQueryRowMapper {

    private final RowMapper<?>[] rowMappers;

    /** The get row mapper. */
    protected final BiFunction<Class<?>, String, RowMapper<?>> getRowMapper;

    /**
     * Instantiates a new abstract muliti query row mapper.
     *
     * @param rowMappers the row mappers
     * @param getRowMapper the get row mapper
     */
    protected AbstractMulitiQueryRowMapper(RowMapper<?>[] rowMappers,
        BiFunction<Class<?>, String, RowMapper<?>> getRowMapper) {
        this.rowMappers = rowMappers;
        this.getRowMapper = getRowMapper;
    }

    /**
     * Gets the row mappers.
     *
     * @return the row mappers
     */
    public RowMapper<?>[] getRowMappers() {
        return rowMappers;
    }

    /**
     * Gets the row mapper.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the row mapper
     */
    @SuppressWarnings("unchecked")
    protected <T> RowMapper<T> getRowMapper(Class<T> type) {
        return (RowMapper<T>) getRowMapper.apply(type, null);
    }
}
