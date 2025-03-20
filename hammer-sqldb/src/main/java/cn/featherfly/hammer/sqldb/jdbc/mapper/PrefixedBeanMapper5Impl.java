
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

import cn.featherfly.common.repository.mapper.PrefixedBeanMapper5;
import cn.featherfly.common.repository.mapper.PrefixedBeanMapper6;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.ChainListImpl;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuples;
import cn.featherfly.hammer.sqldb.jdbc.TupleNestedBeanPropertyRowMapper;

/**
 * The Class PrefixedBeanMapper5Impl.
 *
 * @author zhongj
 * @param <T1> the generic type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <T4> the generic type
 * @param <T5> the generic type
 */
public class PrefixedBeanMapper5Impl<T1, T2, T3, T4, T5> implements PrefixedBeanMapper5<T1, T2, T3, T4, T5> {

    private final List<Class<?>> types;

    private final Tuple5<String, String, String, String, String> prefixes;

    private final BiFunction<Class<?>, String, RowMapper<?>> getRowMapper;

    /**
     * Instantiates a new prefixed bean mapper 5 impl.
     *
     * @param manager the manager
     * @param types the types
     * @param prefixes the prefixes
     */
    public PrefixedBeanMapper5Impl(List<Class<?>> types,
        Tuple5<String, String, String, String, String> prefixes,
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
    public RowMapper<Tuple5<T1, T2, T3, T4, T5>> mapper() {
        return new TupleNestedBeanPropertyRowMapper<>(types, prefixes, getRowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T6> PrefixedBeanMapper6<T1, T2, T3, T4, T5, T6> map(String prefix, Class<T6> type) {
        return new PrefixedBeanMapper6Impl<>(new ChainListImpl<>(types).addChain(type),
            Tuples.of(prefixes.get0(), prefixes.get1(), prefixes.get2(), prefixes.get3(), prefixes.get4(), prefix),
            getRowMapper);
    }
}
