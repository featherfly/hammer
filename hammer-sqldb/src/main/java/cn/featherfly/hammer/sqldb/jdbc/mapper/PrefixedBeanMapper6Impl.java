
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
import cn.featherfly.common.tuple.Tuple6;
import cn.featherfly.hammer.sqldb.jdbc.TupleNestedBeanPropertyRowMapper;

/**
 * PrefixedBeanMapper1Impl.
 *
 * @author zhongj
 */
public class PrefixedBeanMapper6Impl<T1, T2, T3, T4, T5, T6> implements PrefixedBeanMapper6<T1, T2, T3, T4, T5, T6> {

    private final List<Class<?>> types;

    private final Tuple6<String, String, String, String, String, String> prefixes;

    private final SqlTypeMappingManager manager;

    /**
     * @param getRowMapper
     */
    public PrefixedBeanMapper6Impl(SqlTypeMappingManager manager, List<Class<?>> types,
        Tuple6<String, String, String, String, String, String> prefixes) {
        super();
        this.manager = manager;
        this.types = types;
        this.prefixes = prefixes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RowMapper<Tuple6<T1, T2, T3, T4, T5, T6>> mapper() {
        return new TupleNestedBeanPropertyRowMapper<>(types, prefixes, manager);
    }
}
