
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

import cn.featherfly.common.repository.mapper.PrefixedBeanMapper2;
import cn.featherfly.common.repository.mapper.PrefixedBeanMapper3;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.ChainListImpl;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuples;
import cn.featherfly.hammer.sqldb.jdbc.TupleNestedBeanPropertyRowMapper;

/**
 * PrefixedBeanMapper1Impl.
 *
 * @author zhongj
 * @param <T1> the generic type
 * @param <T2> the generic type
 */
public class PrefixedBeanMapper2Impl<T1, T2> implements PrefixedBeanMapper2<T1, T2> {

    private final List<Class<?>> types;

    private final Tuple2<String, String> prefixes;

    private final BiFunction<Class<?>, String, RowMapper<?>> getRowMapper;

    /**
     * Instantiates a new prefixed bean mapper 2 impl.
     *
     * @param types the types
     * @param prefixes the prefixes
     * @param getRowMapper the get row mapper
     */
    public PrefixedBeanMapper2Impl(List<Class<?>> types,
        Tuple2<String, String> prefixes, BiFunction<Class<?>, String, RowMapper<?>> getRowMapper) {
        super();
        this.types = types;
        this.prefixes = prefixes;
        this.getRowMapper = getRowMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RowMapper<Tuple2<T1, T2>> mapper() {
        return new TupleNestedBeanPropertyRowMapper<>(types, prefixes, getRowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T3> PrefixedBeanMapper3<T1, T2, T3> map(String prefix, Class<T3> type) {
        return new PrefixedBeanMapper3Impl<>(new ChainListImpl<>(types).addChain(type),
            Tuples.of(prefixes.get0(), prefixes.get1(), prefix), getRowMapper);
    }
}
