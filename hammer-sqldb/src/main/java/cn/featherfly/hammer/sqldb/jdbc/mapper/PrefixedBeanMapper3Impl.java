
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
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuples;
import cn.featherfly.hammer.sqldb.jdbc.TupleNestedBeanPropertyRowMapper;

/**
 * PrefixedBeanMapper1Impl.
 *
 * @author zhongj
 */
public class PrefixedBeanMapper3Impl<T1, T2, T3> implements PrefixedBeanMapper3<T1, T2, T3> {

    private final List<Class<?>> types;

    private final Tuple3<String, String, String> prefixes;

    private final SqlTypeMappingManager manager;

    /**
     * Instantiates a new prefixed bean mapper 4 impl.
     *
     * @param manager the manager
     * @param types the types
     * @param prefixes the prefixes
     */
    public PrefixedBeanMapper3Impl(SqlTypeMappingManager manager, List<Class<?>> types,
        Tuple3<String, String, String> prefixes) {
        super();
        this.manager = manager;
        this.types = types;
        this.prefixes = prefixes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RowMapper<Tuple3<T1, T2, T3>> mapper() {
        return new TupleNestedBeanPropertyRowMapper<>(types, prefixes, manager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T4> PrefixedBeanMapper4<T1, T2, T3, T4> map(String prefix, Class<T4> type) {
        return new PrefixedBeanMapper4Impl<>(manager, new ChainListImpl<>(types).addChain(type),
            Tuples.of(prefixes.get0(), prefixes.get1(), prefixes.get2(), prefix));
    }
}