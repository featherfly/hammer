
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-11 11:23:11
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import cn.featherfly.common.repository.RowIterable;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.repository.mapper.TupleRowMapperBuilder;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuple6;
import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.data.query.LimitAwareQuery3;
import cn.featherfly.data.query.LimitAwareQuery4;
import cn.featherfly.data.query.LimitAwareQuery5;
import cn.featherfly.data.query.LimitAwareQuery6;
import cn.featherfly.data.query.QueryLimitExecutor;

/**
 * RepositoryLimitQuery.
 *
 * @author zhongj
 * @param <Map<String, Serializable>> the element type
 */
public class LimitAwareRepositoryQuery
    implements LimitAwareQuery1<Map<String, Serializable>>, LimitAwareQuery2<Map<String, Serializable>>,
    LimitAwareQuery3<Map<String, Serializable>>, LimitAwareQuery4<Map<String, Serializable>>,
    LimitAwareQuery5<Map<String, Serializable>>, LimitAwareQuery6<Map<String, Serializable>> {

    private final RepositorySqlQueryConditionGroupQuery repositorySqlQueryConditionGroupQuery;

    /**
     * Instantiates a new limit aware repository query.
     *
     * @param repositorySqlQueryConditionGroupQuery the repository sql query condition group query
     */
    public LimitAwareRepositoryQuery(RepositorySqlQueryConditionGroupQuery repositorySqlQueryConditionGroupQuery) {
        super();
        this.repositorySqlQueryConditionGroupQuery = repositorySqlQueryConditionGroupQuery;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> list() {
        return repositorySqlQueryConditionGroupQuery.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RowIterable<Map<String, Serializable>> each() {
        return repositorySqlQueryConditionGroupQuery.each();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> single() {
        return repositorySqlQueryConditionGroupQuery.single();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> unique() {
        return repositorySqlQueryConditionGroupQuery.unique();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Serializable>> pagination() {
        return repositorySqlQueryConditionGroupQuery.pagination();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {
        return repositorySqlQueryConditionGroupQuery.count();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> QueryLimitExecutor<T> mapper(RowMapper<T> rowMapper) {
        return new RepositorySqlQueryLimitExecutor<>(repositorySqlQueryConditionGroupQuery, rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> QueryLimitExecutor<T> mapper(Class<T> type) {
        return new RepositorySqlQueryLimitExecutor<>(repositorySqlQueryConditionGroupQuery,
            repositorySqlQueryConditionGroupQuery.createRowMapper(type));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> QueryLimitExecutor<Tuple2<T1, T2>> mapper(Class<T1> type1, Class<T2> type2) {
        return new RepositorySqlQueryLimitExecutor<>(repositorySqlQueryConditionGroupQuery,
            repositorySqlQueryConditionGroupQuery.createRowMapper(type1, type2));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> QueryLimitExecutor<Tuple3<T1, T2, T3>> mapper(Class<T1> type1, Class<T2> type2,
        Class<T3> type3) {
        return new RepositorySqlQueryLimitExecutor<>(repositorySqlQueryConditionGroupQuery,
            repositorySqlQueryConditionGroupQuery.createRowMapper(type1, type2, type3));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> QueryLimitExecutor<Tuple4<T1, T2, T3, T4>> mapper(Class<T1> type1, Class<T2> type2,
        Class<T3> type3, Class<T4> type4) {
        return new RepositorySqlQueryLimitExecutor<>(repositorySqlQueryConditionGroupQuery,
            repositorySqlQueryConditionGroupQuery.createRowMapper(type1, type2, type3, type4));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> QueryLimitExecutor<Tuple5<T1, T2, T3, T4, T5>> mapper(Class<T1> type1, Class<T2> type2,
        Class<T3> type3, Class<T4> type4, Class<T5> type5) {
        return new RepositorySqlQueryLimitExecutor<>(repositorySqlQueryConditionGroupQuery,
            repositorySqlQueryConditionGroupQuery.createRowMapper(type1, type2, type3, type4, type5));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> QueryLimitExecutor<Tuple6<T1, T2, T3, T4, T5, T6>> mapper(Class<T1> type1,
        Class<T2> type2, Class<T3> type3, Class<T4> type4, Class<T5> type5, Class<T6> type6) {
        return new RepositorySqlQueryLimitExecutor<>(repositorySqlQueryConditionGroupQuery,
            repositorySqlQueryConditionGroupQuery.createRowMapper(type1, type2, type3, type4, type5, type6));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <
        T> QueryLimitExecutor<T> mapper(Function<TupleRowMapperBuilder, RowMapper<T>> tupleRowMapperBuilderFunction) {
        return new RepositorySqlQueryLimitExecutor<>(repositorySqlQueryConditionGroupQuery,
            tupleRowMapperBuilderFunction.apply(repositorySqlQueryConditionGroupQuery.createTupleRowMapperBuilder()));
    }
}
