
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-03-19 01:19:19
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.util.List;

import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
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

    private final SqlTypeMappingManager manager;

    /**
     * Instantiates a new prefixed bean mapper 5 impl.
     *
     * @param manager the manager
     * @param types the types
     * @param prefixes the prefixes
     */
    public PrefixedBeanMapper5Impl(SqlTypeMappingManager manager, List<Class<?>> types,
        Tuple5<String, String, String, String, String> prefixes) {
        super();
        this.manager = manager;
        this.types = types;
        this.prefixes = prefixes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RowMapper<Tuple5<T1, T2, T3, T4, T5>> mapper() {
        return new TupleNestedBeanPropertyRowMapper<>(types, prefixes, manager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T6> PrefixedBeanMapper6<T1, T2, T3, T4, T5, T6> map(String prefix, Class<T6> type) {
        return new PrefixedBeanMapper6Impl<>(manager, new ChainListImpl<>(types).addChain(type),
            Tuples.of(prefixes.get0(), prefixes.get1(), prefixes.get2(), prefixes.get3(), prefixes.get4(), prefix));
    }
}
