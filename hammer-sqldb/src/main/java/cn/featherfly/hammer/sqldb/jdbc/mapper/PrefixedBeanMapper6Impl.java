
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-03-19 01:19:19
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.util.List;
import java.util.function.BiFunction;

import cn.featherfly.common.repository.mapper.PrefixedBeanMapper6;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.tuple.Tuple6;
import cn.featherfly.hammer.sqldb.jdbc.TupleNestedBeanPropertyRowMapper;

/**
 * PrefixedBeanMapper6Impl.
 *
 * @author zhongj
 */
public class PrefixedBeanMapper6Impl<T1, T2, T3, T4, T5, T6> implements PrefixedBeanMapper6<T1, T2, T3, T4, T5, T6> {

    private final List<Class<?>> types;

    private final Tuple6<String, String, String, String, String, String> prefixes;

    private final BiFunction<Class<?>, String, RowMapper<?>> getRowMapper;

    /**
     * Instantiates a new prefixed bean mapper 6 impl.
     *
     * @param types the types
     * @param prefixes the prefixes
     * @param getRowMapper the get row mapper
     */
    public PrefixedBeanMapper6Impl(List<Class<?>> types,
        Tuple6<String, String, String, String, String, String> prefixes,
        BiFunction<Class<?>, String, RowMapper<?>> getRowMapper) {
        super();
        this.types = types;
        this.prefixes = prefixes;
        this.getRowMapper = getRowMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RowMapper<Tuple6<T1, T2, T3, T4, T5, T6>> mapper() {
        return new TupleNestedBeanPropertyRowMapper<>(types, prefixes, getRowMapper);
    }
}
