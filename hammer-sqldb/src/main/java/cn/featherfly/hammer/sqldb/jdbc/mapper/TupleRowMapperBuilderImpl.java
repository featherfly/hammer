
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-03-19 01:09:19
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.util.function.Function;

import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuple6;
import cn.featherfly.hammer.sqldb.jdbc.TupleNestedBeanPropertyRowMapper;

/**
 * TupleRowMapperBuilderImpl.
 *
 * @author zhongj
 */
public class TupleRowMapperBuilderImpl implements TupleRowMapperBuilder {

    private final SqlTypeMappingManager manager;

    private final Function<Class<?>, RowMapper<?>> getRowMapper;

    /**
     * Instantiates a new tuple row mapper builder impl.
     *
     * @param manager the manager
     * @param getRowMapper the get row mapper
     */
    public TupleRowMapperBuilderImpl(SqlTypeMappingManager manager, Function<Class<?>, RowMapper<?>> getRowMapper) {
        super();
        this.manager = manager;
        this.getRowMapper = getRowMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> PrefixedBeanMapper1<T> map(String prefix, Class<T> type) {
        return new PrefixedBeanMapper1Impl<>(manager, prefix, type, getRowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> RowMapper<T> mapper(Class<T> type) {
        return (RowMapper<T>) getRowMapper.apply(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> RowMapper<Tuple2<T1, T2>> mapper(Class<T1> type1, Class<T2> type2) {
        return new TupleNestedBeanPropertyRowMapper<>(Lang.list(type1, type2), null, manager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> RowMapper<Tuple3<T1, T2, T3>> mapper(Class<T1> type1, Class<T2> type2, Class<T3> type3) {
        return new TupleNestedBeanPropertyRowMapper<>(Lang.list(type1, type2, type3), null, manager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> RowMapper<Tuple4<T1, T2, T3, T4>> mapper(Class<T1> type1, Class<T2> type2, Class<T3> type3,
        Class<T4> type4) {
        return new TupleNestedBeanPropertyRowMapper<>(Lang.list(type1, type2, type3, type4), null, manager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> RowMapper<Tuple5<T1, T2, T3, T4, T5>> mapper(Class<T1> type1, Class<T2> type2,
        Class<T3> type3, Class<T4> type4, Class<T5> type5) {
        return new TupleNestedBeanPropertyRowMapper<>(Lang.list(type1, type2, type3, type4, type5), null, manager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> RowMapper<Tuple6<T1, T2, T3, T4, T5, T6>> mapper(Class<T1> type1, Class<T2> type2,
        Class<T3> type3, Class<T4> type4, Class<T5> type5, Class<T6> type6) {
        return new TupleNestedBeanPropertyRowMapper<>(Lang.list(type1, type2, type3, type4, type5, type6), null,
            manager);
    }

}
