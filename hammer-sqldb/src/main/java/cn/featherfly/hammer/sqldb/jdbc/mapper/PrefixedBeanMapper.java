package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.util.function.Supplier;

import cn.featherfly.common.repository.mapper.RowMapper;

/**
 * prefixed bean mapper1.
 *
 * @param <T1> the generic type
 */
@FunctionalInterface
public interface PrefixedBeanMapper<T> extends Supplier<RowMapper<T>> {

    /**
     * Mapper.
     *
     * @return the row mapper
     */
    RowMapper<T> mapper();

    @Override
    default RowMapper<T> get() {
        return mapper();
    }
}