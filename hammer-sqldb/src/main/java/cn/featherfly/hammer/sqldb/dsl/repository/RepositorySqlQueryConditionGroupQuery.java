
/*
 * All rights Reserved, Designed By zhongj
 * @Description: RepositorySqlQueryConditionGroupQuery
 * @author: zhongj
 * @date: 2023-07-25 13:25:25
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.RowIterable;
import cn.featherfly.common.repository.SimpleExecution;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.repository.mapper.TupleRowMapperBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePaginationResults;
import cn.featherfly.common.tuple.Tuple;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuple6;
import cn.featherfly.common.tuple.Tuples;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractMulitiRepositorySqlQueryConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractMulitiRepositorySqlQueryConditionsGroupExpression2;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractMulitiRepositorySqlQueryConditionsGroupExpression3;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractMulitiRepositorySqlQueryConditionsGroupExpression4;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractMulitiRepositorySqlQueryConditionsGroupExpression5;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractMulitiRepositorySqlQueryConditionsGroupExpression6;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractMulitiRepositorySqlQueryValueConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory.SqlPageQuery;
import cn.featherfly.hammer.sqldb.jdbc.mapper.TupleRowMapperBuilderImpl;

/**
 * repository sql query condition group query.
 *
 * @author zhongj
 */
public class RepositorySqlQueryConditionGroupQuery {

    private AbstractMulitiRepositorySqlConditionsGroupExpressionBase<?, ?, ?, ?, ?, ?> exp;

    private Limit limit;

    private RepositorySqlQueryRelation queryRelation;

    private SqlPageFactory sqlPageFactory;

    private Supplier<Tuple2<String, String>> expressionPage;

    /**
     * Instantiates a new entity sql query condition group query.
     *
     * @param repositorySqlConditionGroupExpression the repository sql condition group expression
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     */
    public RepositorySqlQueryConditionGroupQuery(
        AbstractMulitiRepositorySqlConditionsGroupExpressionBase<?, ?, ?, ?, ?,
            ?> repositorySqlConditionGroupExpression,
        SqlPageFactory sqlPageFactory, RepositorySqlQueryRelation queryRelation) {
        this(repositorySqlConditionGroupExpression, sqlPageFactory, queryRelation, null);
    }

    /**
     * Instantiates a new entity sql query condition group query.
     *
     * @param repositorySqlConditionGroupExpression the repository sql condition group expression
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     * @param limit the limit
     */
    public RepositorySqlQueryConditionGroupQuery(
        AbstractMulitiRepositorySqlConditionsGroupExpressionBase<?, ?, ?, ?, ?,
            ?> repositorySqlConditionGroupExpression,
        SqlPageFactory sqlPageFactory, RepositorySqlQueryRelation queryRelation, Limit limit) {
        super();
        this.limit = limit;
        this.queryRelation = queryRelation;
        this.sqlPageFactory = sqlPageFactory;
        exp = repositorySqlConditionGroupExpression;

        if (exp instanceof AbstractMulitiRepositorySqlQueryConditionsGroupExpression) {
            expressionPage = ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiRepositorySqlQueryValueConditionsGroupExpression) {
            expressionPage = ((AbstractMulitiRepositorySqlQueryValueConditionsGroupExpression) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiRepositorySqlQueryConditionsGroupExpression2) {
            expressionPage = ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression2<?, ?, ?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiRepositorySqlQueryConditionsGroupExpression3) {
            expressionPage = ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression3<?, ?, ?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiRepositorySqlQueryConditionsGroupExpression4) {
            expressionPage = ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression4<?, ?, ?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiRepositorySqlQueryConditionsGroupExpression5) {
            expressionPage = ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression5<?, ?, ?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiRepositorySqlQueryConditionsGroupExpression6) {
            expressionPage = ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression6<?, ?, ?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else {
            throw new SqldbHammerException("unknow expression type " + exp.getClass().getName());
        }
    }

    /**
     * Creates the row mapper.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the row mapper
     */
    public <T> RowMapper<T> createRowMapper(Class<T> type) {
        return queryRelation.getJdbc().createRowMapper(type);
    }

    /**
     * Creates the row mapper.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the row mapper
     */
    public TupleRowMapperBuilder createTupleRowMapperBuilder() {
        return new TupleRowMapperBuilderImpl(queryRelation.getJdbc()::createRowMapper);
    }

    /**
     * Creates the row mapper.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the row mapper
     */
    public <T> RowMapper<T> createRowMapper(Class<T> type, String prefix) {
        return queryRelation.getJdbc().createRowMapper(type, prefix);
    }

    @SuppressWarnings("unchecked")
    private <T extends Tuple> T getPrefixes() {
        return (T) Tuples
            .ofArray(queryRelation.getAliasManager().getNameAlias().keySet().stream().map(a -> a + ".").toArray());
    }

    /**
     * Creates the row mapper.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @return the row mapper
     */
    public <T1, T2> RowMapper<Tuple2<T1, T2>> createRowMapper(Class<T1> type1, Class<T2> type2) {
        return queryRelation.getJdbc().createRowMapper(type1, type2, getPrefixes());
    }

    /**
     * Creates the row mapper.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @return the row mapper
     */
    public <T1, T2, T3> RowMapper<Tuple3<T1, T2, T3>> createRowMapper(Class<T1> type1, Class<T2> type2,
        Class<T3> type3) {
        return queryRelation.getJdbc().createRowMapper(type1, type2, type3, getPrefixes());
    }

    /**
     * Creates the row mapper.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @return the row mapper
     */
    public <T1, T2, T3, T4> RowMapper<Tuple4<T1, T2, T3, T4>> createRowMapper(Class<T1> type1, Class<T2> type2,
        Class<T3> type3, Class<T4> type4) {
        return queryRelation.getJdbc().createRowMapper(type1, type2, type3, type4, getPrefixes());
    }

    /**
     * Creates the row mapper.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param type5 the type 5
     * @return the row mapper
     */
    public <T1, T2, T3, T4, T5> RowMapper<Tuple5<T1, T2, T3, T4, T5>> createRowMapper(Class<T1> type1, Class<T2> type2,
        Class<T3> type3, Class<T4> type4, Class<T5> type5) {
        return queryRelation.getJdbc().createRowMapper(type1, type2, type3, type4, type5, getPrefixes());
    }

    /**
     * Creates the row mapper.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param <T6> the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param type5 the type 5
     * @param type6 the type 6
     * @return the row mapper
     */
    public <T1, T2, T3, T4, T5, T6> RowMapper<Tuple6<T1, T2, T3, T4, T5, T6>> createRowMapper(Class<T1> type1,
        Class<T2> type2, Class<T3> type3, Class<T4> type4, Class<T5> type5, Class<T6> type6) {
        return queryRelation.getJdbc().createRowMapper(type1, type2, type3, type4, type5, type6, getPrefixes());
    }

    /**
     * set limit value.
     *
     * @param limit limit
     */
    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    /**
     * count.
     *
     * @return count value
     */
    public long count() {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryLong(execution.getExecution(), execution.getParams());
    }

    public <T> T value() {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryValue(execution.getExecution(), execution.getParams());
    }

    public <T> T value(Class<T> type) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryValue(execution.getExecution(), type, execution.getParams());
    }

    /**
     * List.
     *
     * @param <E> the element type
     * @param type the type
     * @return the list
     */
    public <E> List<E> list(Class<E> type) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryList(execution.getExecution(), type, execution.getParams());
    }

    /**
     * List.
     *
     * @param <E> the element type
     * @param rowMapper the row mapper
     * @return the list
     */
    public <E> List<E> list(RowMapper<E> rowMapper) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryList(execution.getExecution(), rowMapper, execution.getParams());
    }

    /**
     * List.
     *
     * @param <E> the element type
     * @param tupleRowMapperBuilderFunction the tuple row mapper builder function
     * @return the list
     */
    public <E> List<E> list(Function<TupleRowMapperBuilder, RowMapper<E>> tupleRowMapperBuilderFunction) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryList(execution.getExecution(), tupleRowMapperBuilderFunction,
            execution.getParams());
    }

    /**
     * List.
     *
     * @return list
     */
    public List<Map<String, Serializable>> list() {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryList(execution.getExecution(), execution.getParams());
    }

    /**
     * each.
     *
     * @return each iterable
     */
    public RowIterable<Map<String, Serializable>> each() {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryEach(execution.getExecution(), execution.getParams());
    }

    /**
     * each.
     *
     * @param <E> the element type
     * @param rowMapper the row mapper
     * @return each iterable
     */
    public <E> RowIterable<E> each(RowMapper<E> rowMapper) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryEach(execution.getExecution(), rowMapper, execution.getParams());
    }

    /**
     * each.
     *
     * @param <E> the element type
     * @param tupleRowMapperBuilderFunction the tuple row mapper builder function
     * @return each iterable
     */
    public <E> RowIterable<E> each(Function<TupleRowMapperBuilder, RowMapper<E>> tupleRowMapperBuilderFunction) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryEach(execution.getExecution(), tupleRowMapperBuilderFunction,
            execution.getParams());
    }

    /**
     * Pagination.
     *
     * @return the pagination results
     */
    public PaginationResults<Map<String, Serializable>> pagination() {
        Tuple2<String, String> sqlTuple = null;
        if (limit != null) {
            sqlTuple = expressionPage.get();
        } else {
            sqlTuple = Tuples.of(exp.getRoot().expression(), null);
        }
        Serializable[] oraginalParams = Lang.toArray(exp.getRoot().getParams(), Serializable.class);
        String sql = sqlTuple.get0();
        Serializable[] params = oraginalParams;
        SimplePaginationResults<Map<String, Serializable>> pagination = new SimplePaginationResults<>(limit);
        List<Map<String, Serializable>> list = null;
        if (limit != null) {
            SqlPageQuery<Serializable[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, limit.getOffset(),
                limit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        list = queryRelation.getJdbc().queryList(sql, params);
        pagination.setPageResults(list);

        if (limit != null) {
            int total = queryRelation.getJdbc().queryInt(sqlTuple.get1(), oraginalParams);
            pagination.setTotal(total);
        } else {
            // 如果没有设置分页，则查询出来的就是全量数据，不用再去做数量count了
            pagination.setTotal(list.size());
        }
        return pagination;
    }

    /**
     * Pagination.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the pagination results
     */
    public <T> PaginationResults<T> pagination(Class<T> type) {
        Tuple2<String, String> sqlTuple = null;
        if (limit != null) {
            sqlTuple = expressionPage.get();
        } else {
            sqlTuple = Tuples.of(exp.getRoot().expression(), null);
        }
        Serializable[] oraginalParams = Lang.toArray(exp.getRoot().getParams(), Serializable.class);
        String sql = sqlTuple.get0();
        Serializable[] params = oraginalParams;
        SimplePaginationResults<T> pagination = new SimplePaginationResults<>(limit);
        List<T> list = null;
        if (limit != null) {
            SqlPageQuery<Serializable[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, limit.getOffset(),
                limit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        list = queryRelation.getJdbc().queryList(sql, type, params);
        pagination.setPageResults(list);

        if (limit != null) {
            int total = queryRelation.getJdbc().queryInt(sqlTuple.get1(), oraginalParams);
            pagination.setTotal(total);
        } else {
            // 如果没有设置分页，则查询出来的就是全量数据，不用再去做数量count了
            pagination.setTotal(list.size());
        }
        return pagination;
    }

    /**
     * Pagination.
     *
     * @param <T> the generic type
     * @param rowMapper the row mapper
     * @return the pagination results
     */
    public <T> PaginationResults<T> pagination(RowMapper<T> rowMapper) {
        Tuple2<String, String> sqlTuple = null;
        if (limit != null) {
            sqlTuple = expressionPage.get();
        } else {
            sqlTuple = Tuples.of(exp.getRoot().expression(), null);
        }
        Serializable[] oraginalParams = Lang.toArray(exp.getRoot().getParams(), Serializable.class);
        String sql = sqlTuple.get0();
        Serializable[] params = oraginalParams;
        SimplePaginationResults<T> pagination = new SimplePaginationResults<>(limit);
        List<T> list = null;
        if (limit != null) {
            SqlPageQuery<Serializable[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, limit.getOffset(),
                limit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        list = queryRelation.getJdbc().queryList(sql, rowMapper, params);
        pagination.setPageResults(list);

        if (limit != null) {
            int total = queryRelation.getJdbc().queryInt(sqlTuple.get1(), oraginalParams);
            pagination.setTotal(total);
        } else {
            // 如果没有设置分页，则查询出来的就是全量数据，不用再去做数量count了
            pagination.setTotal(list.size());
        }
        return pagination;
    }

    /**
     * each.
     *
     * @param <T> the element type
     * @param tupleRowMapperBuilderFunction the tuple row mapper builder function
     * @return each iterable
     */
    public <T> PaginationResults<T> pagination(
        Function<TupleRowMapperBuilder, RowMapper<T>> tupleRowMapperBuilderFunction) {
        Tuple2<String, String> sqlTuple = null;
        if (limit != null) {
            sqlTuple = expressionPage.get();
        } else {
            sqlTuple = Tuples.of(exp.getRoot().expression(), null);
        }
        Serializable[] oraginalParams = Lang.toArray(exp.getRoot().getParams(), Serializable.class);
        String sql = sqlTuple.get0();
        Serializable[] params = oraginalParams;
        SimplePaginationResults<T> pagination = new SimplePaginationResults<>(limit);
        List<T> list = null;
        if (limit != null) {
            SqlPageQuery<Serializable[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, limit.getOffset(),
                limit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        list = queryRelation.getJdbc().queryList(sql, tupleRowMapperBuilderFunction, params);
        pagination.setPageResults(list);

        if (limit != null) {
            int total = queryRelation.getJdbc().queryInt(sqlTuple.get1(), oraginalParams);
            pagination.setTotal(total);
        } else {
            // 如果没有设置分页，则查询出来的就是全量数据，不用再去做数量count了
            pagination.setTotal(list.size());
        }
        return pagination;
    }

    /**
     * Single.
     *
     * @return the map
     */
    public Map<String, Serializable> single() {
        Execution execution = getExecution();
        return queryRelation.getJdbc().querySingle(execution.getExecution(), execution.getParams());
    }

    /**
     * Single.
     *
     * @param <E> the element type
     * @param rowMapper the row mapper
     * @return the map
     */
    public <E> E single(RowMapper<E> rowMapper) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().querySingle(execution.getExecution(), rowMapper, execution.getParams());
    }

    public <E> E single(Function<TupleRowMapperBuilder, RowMapper<E>> tupleRowMapperBuilderFunction) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().querySingle(execution.getExecution(), tupleRowMapperBuilderFunction,
            execution.getParams());
    }

    /**
     * Single.
     *
     * @param <E> the element type
     * @param type the type
     * @return the map
     */
    public <E> E single(Class<E> type) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().querySingle(execution.getExecution(), type, execution.getParams());
    }

    /**
     * Unique.
     *
     * @return the map
     */
    public Map<String, Serializable> unique() {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryUnique(execution.getExecution(), execution.getParams());
    }

    /**
     * unique.
     *
     * @param <E> the element type
     * @param rowMapper the row mapper
     * @return the map
     */
    public <E> E unique(RowMapper<E> rowMapper) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryUnique(execution.getExecution(), rowMapper, execution.getParams());
    }

    public <E> E unique(Function<TupleRowMapperBuilder, RowMapper<E>> tupleRowMapperBuilderFunction) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryUnique(execution.getExecution(), tupleRowMapperBuilderFunction,
            execution.getParams());
    }

    /**
     * unique.
     *
     * @param <E> the element type
     * @param type the type
     * @return the map
     */
    public <E> E unique(Class<E> type) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryUnique(execution.getExecution(), type, execution.getParams());
    }

    private Execution getExecution() {
        String sql = exp.getRoot().expression();
        Serializable[] params = Lang.toArray(exp.getRoot().getParams(), Serializable.class);
        if (limit != null) {
            SqlPageQuery<Serializable[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, limit.getOffset(),
                limit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        return new SimpleExecution(sql, params);
    }
}
