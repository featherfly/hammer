
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
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuples;
import cn.featherfly.hammer.sqldb.jdbc.TupleNestedBeanPropertyRowMapper;

/**
 * PrefixedBeanMapper1Impl.
 *
 * @author zhongj
 */
public class PrefixedBeanMapper2Impl<T1, T2> implements PrefixedBeanMapper2<T1, T2> {

    private final List<Class<?>> types;

    private final Tuple2<String, String> prefixes;

    private final SqlTypeMappingManager manager;

    /**
     * @param getRowMapper
     */
    public PrefixedBeanMapper2Impl(SqlTypeMappingManager manager, List<Class<?>> types,
        Tuple2<String, String> prefixes) {
        super();
        this.manager = manager;
        this.types = types;
        this.prefixes = prefixes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RowMapper<Tuple2<T1, T2>> mapper() {
        return new TupleNestedBeanPropertyRowMapper<>(types, prefixes, manager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T3> PrefixedBeanMapper3<T1, T2, T3> map(String prefix, Class<T3> type) {
        return new PrefixedBeanMapper3Impl<>(manager, new ChainListImpl<>(types).addChain(type),
            Tuples.of(prefixes.get0(), prefixes.get1(), prefix));
    }
}
