
/*
 * All rights Reserved, Designed By zhongj
 * @Title: SqlQueryConditionGroup.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query
 * @Description: SqlQueryConditionGroup
 * @author: zhongj
 * @date: 2023-07-25 13:25:25
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity;

import java.util.List;
import java.util.function.Supplier;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePaginationResults;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.dsl.entity.query.AbstractMulitiEntitySqlQueryConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.query.AbstractMulitiEntitySqlQueryConditionsGroupExpression2;
import cn.featherfly.hammer.sqldb.dsl.entity.query.AbstractMulitiEntitySqlQueryConditionsGroupExpression3;
import cn.featherfly.hammer.sqldb.dsl.entity.query.AbstractMulitiEntitySqlQueryConditionsGroupExpression4;
import cn.featherfly.hammer.sqldb.dsl.entity.query.AbstractMulitiEntitySqlQueryConditionsGroupExpression5;
import cn.featherfly.hammer.sqldb.dsl.entity.query.AbstractMulitiEntitySqlQueryConditionsGroupExpression6;
import cn.featherfly.hammer.sqldb.dsl.entity.query.AbstractMulitiEntitySqlQueryValueConditionsGroupExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory.SqlPageQuery;

/**
 * entity sql query condition group query.
 *
 * @author zhongj
 * @param <R> the generic type
 */
public class EntitySqlQueryConditionGroupQuery<R> {

    private AbstractMulitiEntitySqlConditionsGroupExpressionBase<?, ?, ?, ?, ?, ?> exp;

    private Limit limit;

    //    private EntitySqlQueryTuple<R> queryTuple;

    private EntitySqlQueryRelation queryRelation;

    private SqlPageFactory sqlPageFactory;

    private Supplier<Tuple2<String, String>> expressionPage;

    /**
     * Instantiates a new entity sql query condition group query.
     *
     * @param entitySqlConditionGroupExpression the entity sql condition group expression
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     */
    public EntitySqlQueryConditionGroupQuery(
        AbstractMulitiEntitySqlConditionsGroupExpressionBase<?, ?, ?, ?, ?, ?> entitySqlConditionGroupExpression,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation) {
        this(entitySqlConditionGroupExpression, sqlPageFactory, queryRelation, null);
    }

    /**
     * Instantiates a new entity sql query condition group query.
     *
     * @param entitySqlConditionGroupExpression the entity sql condition group expression
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     * @param limit the limit
     */
    public EntitySqlQueryConditionGroupQuery(
        AbstractMulitiEntitySqlConditionsGroupExpressionBase<?, ?, ?, ?, ?, ?> entitySqlConditionGroupExpression,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation, Limit limit) {
        super();
        this.limit = limit;
        this.queryRelation = queryRelation;
        this.sqlPageFactory = sqlPageFactory;
        exp = entitySqlConditionGroupExpression;

        if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression) {
            expressionPage = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression<?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryValueConditionsGroupExpression) {
            expressionPage = ((AbstractMulitiEntitySqlQueryValueConditionsGroupExpression<?, ?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression2) {
            expressionPage = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression2<?, ?, ?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression3) {
            expressionPage = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression3<?, ?, ?, ?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression4) {
            expressionPage = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression4<?, ?, ?, ?, ?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression5) {
            expressionPage = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression5<?, ?, ?, ?, ?, ?, ?, ?>) exp
                .getRoot())::expressionPage;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression6) {
            expressionPage = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression6<?, ?, ?, ?, ?, ?, ?, ?, ?>) exp
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
     * @return LogicExpressionist
     */
    public List<R> list() {
        String sql = exp.getRoot().expression();
        Object[] params = exp.getRoot().getParams().toArray();
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, limit.getOffset(),
                limit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        return queryRelation.list(sql, params);
        //        Class<R> resultType = (Class<R>) exp.queryRelation.getResultType();
        //        if (ClassUtils.isParent(Tuple.class, resultType)) {
        //            return queryTuple.list(sql, resultType, params);
        //            //            return (List<R>) jdbc.query(sql, classMapping.getType(), classMapping2.getType(),
        //            //                    Tuples.of(queryAlias + ".", queryAlias2 + "."), params);
        //        } else {
        //            return jdbc.query(sql, resultType, params);
        //        }
    }

    /**
     * Pagination.
     *
     * @return the pagination results
     */
    public PaginationResults<R> pagination() {
        Tuple2<String, String> sqlTuple = null;
        if (limit != null) {
            sqlTuple = expressionPage.get();
        } else {
            sqlTuple = Tuples.of(exp.getRoot().expression(), "");
        }
        Object[] oraginalParams = exp.getRoot().getParams().toArray();
        String sql = sqlTuple.get0();
        Object[] params = oraginalParams;
        SimplePaginationResults<R> pagination = new SimplePaginationResults<>(limit);
        List<R> list = null;
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, limit.getOffset(),
                limit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        list = queryRelation.list(sql, params);
        pagination.setPageResults(list);

        if (limit != null) {
            //            String countSql = SqlUtils.convertSelectToCount(oraginalSql);
            //            int total = queryRelation.getJdbc().queryInt(countSql, oraginalParams);
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
     * @return the r
     */
    public R single() {
        String sql = exp.getRoot().expression();
        Object[] params = exp.getRoot().getParams().toArray();
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, limit.getOffset(),
                limit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        return queryRelation.single(sql, params);
        //        Class<R> resultType = (Class<R>) exp.queryRelation.getResultType();
        //        if (ClassUtils.isParent(Tuple.class, resultType)) {
        //            return queryTuple.single(sql, resultType, params);
        //        } else {
        //            return jdbc.querySingle(sql, resultType, params);
        //        }
    }

    /**
     * Unique.
     *
     * @return the r
     */
    public R unique() {
        String sql = exp.getRoot().expression();
        Object[] params = exp.getRoot().getParams().toArray();
        if (limit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, limit.getOffset(),
                limit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        return queryRelation.unique(sql, params);
        //        Class<R> resultType = (Class<R>) exp.queryRelation.getResultType();
        //        if (ClassUtils.isParent(Tuple.class, resultType)) {
        //            //            return (R) jdbc.queryUnique(sql, classMapping.getType(), classMapping2.getType(),
        //            //                    Tuples.of(queryAlias + ".", queryAlias2 + "."), params);
        //            return queryTuple.unique(sql, resultType, params);
        //        } else {
        //            return jdbc.queryUnique(sql, resultType, params);
        //        }
    }

    //    /**
    //     * The Interface EntitySqlQueryTuple.
    //     *
    //     * @author zhongj
    //     * @param <R> the generic type
    //     */
    //    public interface EntitySqlQueryTuple<R> {
    //
    //        /**
    //         * Single tuple.
    //         *
    //         * @param sql        the sql
    //         * @param resultType the result type
    //         * @param params     the params
    //         * @return the r
    //         */
    //        R single(String sql, Class<R> resultType, Object[] params);
    //
    //        /**
    //         * Unique tuple.
    //         *
    //         * @param sql        the sql
    //         * @param resultType the result type
    //         * @param params     the params
    //         * @return the r
    //         */
    //        R unique(String sql, Class<R> resultType, Object[] params);
    //
    //        /**
    //         * List tuple.
    //         *
    //         * @param sql        the sql
    //         * @param resultType the result type
    //         * @param params     the params
    //         * @return LogicExpressionist
    //         */
    //        List<R> list(String sql, Class<R> resultType, Object[] params);
    //    }
}
