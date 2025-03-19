package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.function.Supplier;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.repository.mapper.RowMapper;

/**
 * prefixed bean mapper1.
 *
 * @author zhongj
 * @param <T1> the generic type
 */
@FunctionalInterface
public interface PrefixedBeanMapper<T> extends Supplier<RowMapper<T>> {

    Class<Map<String, Serializable>> MAP_TYPE = ClassUtils.castGenericType(Map.class,
        Collections.emptyMap());

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