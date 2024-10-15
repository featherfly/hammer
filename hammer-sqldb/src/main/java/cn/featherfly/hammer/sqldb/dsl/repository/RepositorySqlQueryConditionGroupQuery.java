
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
import java.util.function.Supplier;

import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuple6;
import cn.featherfly.common.tuple.Tuples;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.SimpleExecution;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePaginationResults;
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
            expressionPage = ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression2<?, ?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiRepositorySqlQueryConditionsGroupExpression3) {
            expressionPage = ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression3<?, ?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiRepositorySqlQueryConditionsGroupExpression4) {
            expressionPage = ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression4<?, ?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiRepositorySqlQueryConditionsGroupExpression5) {
            expressionPage = ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression5<?, ?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiRepositorySqlQueryConditionsGroupExpression6) {
            expressionPage = ((AbstractMulitiRepositorySqlQueryConditionsGroupExpression6<?, ?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else {
            throw new SqldbHammerException("unknow expression type " + exp.getClass().getName());
        }
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
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @return the list
     */
    public <E1, E2> List<Tuple2<E1, E2>> list(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryList(execution.getExecution(), type1, type2, prefixes,
            execution.getParams());
    }

    /**
     * List.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @return the list
     */
    public <E1, E2, E3> List<Tuple3<E1, E2, E3>> list(Tuple3<String, String, String> prefixes, Class<E1> type1,
        Class<E2> type2, Class<E3> type3) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryList(execution.getExecution(), type1, type2, type3, prefixes,
            execution.getParams());
    }

    /**
     * List.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param <E4> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @return the list
     */
    public <E1, E2, E3, E4> List<Tuple4<E1, E2, E3, E4>> list(Tuple4<String, String, String, String> prefixes,
        Class<E1> type1, Class<E2> type2, Class<E3> type3, Class<E4> type4) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryList(execution.getExecution(), type1, type2, type3, type4, prefixes,
            execution.getParams());
    }

    /**
     * List.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param <E4> the generic type
     * @param <E5> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param type5 the type 5
     * @return the list
     */
    public <E1, E2, E3, E4, E5> List<Tuple5<E1, E2, E3, E4, E5>> list(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryList(execution.getExecution(), type1, type2, type3, type4, type5, prefixes,
            execution.getParams());
    }

    /**
     * List.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param <E4> the generic type
     * @param <E5> the generic type
     * @param <E6> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param type5 the type 5
     * @param type6 the type 6
     * @return the list
     */
    public <E1, E2, E3, E4, E5, E6> List<Tuple6<E1, E2, E3, E4, E5, E6>> list(
        Tuple6<String, String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2,
        Class<E3> type3, Class<E4> type4, Class<E5> type5, Class<E6> type6) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryList(execution.getExecution(), type1, type2, type3, type4, type5, type6,
            prefixes, execution.getParams());
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
     * @return LogicExpressionist
     */
    public List<Map<String, Serializable>> list() {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryList(execution.getExecution(), execution.getParams());
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
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @return the pagination results
     */
    public <E1, E2> PaginationResults<Tuple2<E1, E2>> pagination(Tuple2<String, String> prefixes, Class<E1> type1,
        Class<E2> type2) {
        Tuple2<String, String> sqlTuple = null;
        if (limit != null) {
            sqlTuple = expressionPage.get();
        } else {
            sqlTuple = Tuples.of(exp.getRoot().expression(), null);
        }
        Serializable[] oraginalParams = Lang.toArray(exp.getRoot().getParams(), Serializable.class);
        String sql = sqlTuple.get0();
        Serializable[] params = oraginalParams;
        SimplePaginationResults<Tuple2<E1, E2>> pagination = new SimplePaginationResults<>(limit);
        List<Tuple2<E1, E2>> list = null;
        if (limit != null) {
            SqlPageQuery<Serializable[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, limit.getOffset(),
                limit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        list = queryRelation.getJdbc().queryList(sql, type1, type2, prefixes, params);
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
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @return the pagination results
     */
    public <E1, E2, E3> PaginationResults<Tuple3<E1, E2, E3>> pagination(Tuple3<String, String, String> prefixes,
        Class<E1> type1, Class<E2> type2, Class<E3> type3) {
        Tuple2<String, String> sqlTuple = null;
        if (limit != null) {
            sqlTuple = expressionPage.get();
        } else {
            sqlTuple = Tuples.of(exp.getRoot().expression(), null);
        }
        Serializable[] oraginalParams = Lang.toArray(exp.getRoot().getParams(), Serializable.class);
        String sql = sqlTuple.get0();
        Serializable[] params = oraginalParams;
        SimplePaginationResults<Tuple3<E1, E2, E3>> pagination = new SimplePaginationResults<>(limit);
        List<Tuple3<E1, E2, E3>> list = null;
        if (limit != null) {
            SqlPageQuery<Serializable[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, limit.getOffset(),
                limit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        list = queryRelation.getJdbc().queryList(sql, type1, type2, type3, prefixes, params);
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
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param <E4> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @return the pagination results
     */
    public <E1, E2, E3, E4> PaginationResults<Tuple4<E1, E2, E3, E4>> pagination(
        Tuple4<String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4) {
        Tuple2<String, String> sqlTuple = null;
        if (limit != null) {
            sqlTuple = expressionPage.get();
        } else {
            sqlTuple = Tuples.of(exp.getRoot().expression(), null);
        }
        Serializable[] oraginalParams = Lang.toArray(exp.getRoot().getParams(), Serializable.class);
        String sql = sqlTuple.get0();
        Serializable[] params = oraginalParams;
        SimplePaginationResults<Tuple4<E1, E2, E3, E4>> pagination = new SimplePaginationResults<>(limit);
        List<Tuple4<E1, E2, E3, E4>> list = null;
        if (limit != null) {
            SqlPageQuery<Serializable[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, limit.getOffset(),
                limit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        list = queryRelation.getJdbc().queryList(sql, type1, type2, type3, type4, prefixes, params);
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
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param <E4> the generic type
     * @param <E5> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param type5 the type 5
     * @return the pagination results
     */
    public <E1, E2, E3, E4, E5> PaginationResults<Tuple5<E1, E2, E3, E4, E5>> pagination(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        Tuple2<String, String> sqlTuple = null;
        if (limit != null) {
            sqlTuple = expressionPage.get();
        } else {
            sqlTuple = Tuples.of(exp.getRoot().expression(), null);
        }
        Serializable[] oraginalParams = Lang.toArray(exp.getRoot().getParams(), Serializable.class);
        String sql = sqlTuple.get0();
        Serializable[] params = oraginalParams;
        SimplePaginationResults<Tuple5<E1, E2, E3, E4, E5>> pagination = new SimplePaginationResults<>(limit);
        List<Tuple5<E1, E2, E3, E4, E5>> list = null;
        if (limit != null) {
            SqlPageQuery<Serializable[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, limit.getOffset(),
                limit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        list = queryRelation.getJdbc().queryList(sql, type1, type2, type3, type4, type5, prefixes, params);
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
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param <E4> the generic type
     * @param <E5> the generic type
     * @param <E6> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param type5 the type 5
     * @param type6 the type 6
     * @return the pagination results
     */
    public <E1, E2, E3, E4, E5, E6> PaginationResults<Tuple6<E1, E2, E3, E4, E5, E6>> pagination(
        Tuple6<String, String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2,
        Class<E3> type3, Class<E4> type4, Class<E5> type5, Class<E6> type6) {
        Tuple2<String, String> sqlTuple = null;
        if (limit != null) {
            sqlTuple = expressionPage.get();
        } else {
            sqlTuple = Tuples.of(exp.getRoot().expression(), null);
        }
        Serializable[] oraginalParams = Lang.toArray(exp.getRoot().getParams(), Serializable.class);
        String sql = sqlTuple.get0();
        Serializable[] params = oraginalParams;
        SimplePaginationResults<Tuple6<E1, E2, E3, E4, E5, E6>> pagination = new SimplePaginationResults<>(limit);
        List<Tuple6<E1, E2, E3, E4, E5, E6>> list = null;
        if (limit != null) {
            SqlPageQuery<Serializable[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, limit.getOffset(),
                limit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        list = queryRelation.getJdbc().queryList(sql, type1, type2, type3, type4, type5, type6, prefixes, params);
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
     * Single.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @return the tuple 2
     */
    public <E1, E2> Tuple2<E1, E2> single(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().querySingle(execution.getExecution(), type1, type2, prefixes,
            execution.getParams());
    }

    /**
     * Single.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @return the tuple 3
     */
    public <E1, E2, E3> Tuple3<E1, E2, E3> single(Tuple3<String, String, String> prefixes, Class<E1> type1,
        Class<E2> type2, Class<E3> type3) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().querySingle(execution.getExecution(), type1, type2, type3, prefixes,
            execution.getParams());
    }

    /**
     * Single.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param <E4> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @return the tuple 4
     */
    public <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> single(Tuple4<String, String, String, String> prefixes,
        Class<E1> type1, Class<E2> type2, Class<E3> type3, Class<E4> type4) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().querySingle(execution.getExecution(), type1, type2, type3, type4, prefixes,
            execution.getParams());
    }

    /**
     * Single.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param <E4> the generic type
     * @param <E5> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param type5 the type 5
     * @return the tuple 5
     */
    public <E1, E2, E3, E4, E5> Tuple5<E1, E2, E3, E4, E5> single(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().querySingle(execution.getExecution(), type1, type2, type3, type4, type5,
            prefixes, execution.getParams());
    }

    /**
     * Single.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param <E4> the generic type
     * @param <E5> the generic type
     * @param <E6> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param type5 the type 5
     * @param type6 the type 6
     * @return the tuple 6
     */
    public <E1, E2, E3, E4, E5, E6> Tuple6<E1, E2, E3, E4, E5, E6> single(
        Tuple6<String, String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2,
        Class<E3> type3, Class<E4> type4, Class<E5> type5, Class<E6> type6) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().querySingle(execution.getExecution(), type1, type2, type3, type4, type5, type6,
            prefixes, execution.getParams());
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

    /**
     * Unique.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @return the tuple 2
     */
    public <E1, E2> Tuple2<E1, E2> unique(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryUnique(execution.getExecution(), type1, type2, prefixes,
            execution.getParams());
    }

    /**
     * Unique.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @return the tuple 3
     */
    public <E1, E2, E3> Tuple3<E1, E2, E3> unique(Tuple3<String, String, String> prefixes, Class<E1> type1,
        Class<E2> type2, Class<E3> type3) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryUnique(execution.getExecution(), type1, type2, type3, prefixes,
            execution.getParams());
    }

    /**
     * Unique.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param <E4> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @return the tuple 4
     */
    public <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> unique(Tuple4<String, String, String, String> prefixes,
        Class<E1> type1, Class<E2> type2, Class<E3> type3, Class<E4> type4) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryUnique(execution.getExecution(), type1, type2, type3, type4, prefixes,
            execution.getParams());
    }

    /**
     * Unique.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param <E4> the generic type
     * @param <E5> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param type5 the type 5
     * @return the tuple 5
     */
    public <E1, E2, E3, E4, E5> Tuple5<E1, E2, E3, E4, E5> unique(
        Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
        Class<E4> type4, Class<E5> type5) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryUnique(execution.getExecution(), type1, type2, type3, type4, type5,
            prefixes, execution.getParams());
    }

    /**
     * Unique.
     *
     * @param <E1> the generic type
     * @param <E2> the generic type
     * @param <E3> the generic type
     * @param <E4> the generic type
     * @param <E5> the generic type
     * @param <E6> the generic type
     * @param prefixes the prefixes
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param type5 the type 5
     * @param type6 the type 6
     * @return the tuple 6
     */
    public <E1, E2, E3, E4, E5, E6> Tuple6<E1, E2, E3, E4, E5, E6> unique(
        Tuple6<String, String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2,
        Class<E3> type3, Class<E4> type4, Class<E5> type5, Class<E6> type6) {
        Execution execution = getExecution();
        return queryRelation.getJdbc().queryUnique(execution.getExecution(), type1, type2, type3, type4, type5, type6,
            prefixes, execution.getParams());
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
