
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
import java.util.Optional;
import java.util.function.Function;

import javax.cache.Cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.speedment.common.tuple.Tuple7;

import cn.featherfly.common.repository.QueryPageResults;
import cn.featherfly.common.repository.QueryPageResults.QueryPageResult;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(EntitySqlQueryConditionGroupQuery.class);

    private AbstractMulitiEntitySqlConditionsGroupExpressionBase<?, ?, ?, ?, ?, ?> exp;

    private Limit limit;

    //    private EntitySqlQueryTuple<R> queryTuple;

    private EntitySqlQueryRelation queryRelation;

    private SqlPageFactory sqlPageFactory;

    private Function<Limit, Tuple7<String, String, List<Object>, Limit, Optional<QueryPageResults>, String,
        Function<Object, Object>>> expressionPage;

    private final Cache<Object, QueryPageResults> countResultCache;

    /**
     * Instantiates a new entity sql query condition group query.
     *
     * @param entitySqlConditionGroupExpression the entity sql condition group expression
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     * @param countResultCache the count result cache
     */
    public EntitySqlQueryConditionGroupQuery(
        AbstractMulitiEntitySqlConditionsGroupExpressionBase<?, ?, ?, ?, ?, ?> entitySqlConditionGroupExpression,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation,
        Cache<Object, QueryPageResults> countResultCache) {
        this(entitySqlConditionGroupExpression, sqlPageFactory, queryRelation, countResultCache, null);
    }

    /**
     * Instantiates a new entity sql query condition group query.
     *
     * @param entitySqlConditionGroupExpression the entity sql condition group expression
     * @param sqlPageFactory the sql page factory
     * @param queryRelation the query relation
     * @param countResultCache the count result cache
     * @param limit the limit
     */
    public EntitySqlQueryConditionGroupQuery(
        AbstractMulitiEntitySqlConditionsGroupExpressionBase<?, ?, ?, ?, ?, ?> entitySqlConditionGroupExpression,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation queryRelation,
        Cache<Object, QueryPageResults> countResultCache, Limit limit) {
        super();
        this.limit = limit;
        this.queryRelation = queryRelation;
        this.sqlPageFactory = sqlPageFactory;
        this.countResultCache = countResultCache;
        exp = entitySqlConditionGroupExpression;

        if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression) {
            expressionPage = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression<?, ?, ?>) exp
                .getRoot())::expressionPagination;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryValueConditionsGroupExpression) {
            expressionPage = ((AbstractMulitiEntitySqlQueryValueConditionsGroupExpression<?, ?, ?, ?>) exp
                .getRoot())::expressionPagination;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression2) {
            expressionPage = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression2<?, ?, ?, ?, ?>) exp
                .getRoot())::expressionPagination;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression3) {
            expressionPage = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression3<?, ?, ?, ?, ?, ?>) exp
                .getRoot())::expressionPagination;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression4) {
            expressionPage = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression4<?, ?, ?, ?, ?, ?, ?>) exp
                .getRoot())::expressionPagination;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression5) {
            expressionPage = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression5<?, ?, ?, ?, ?, ?, ?, ?>) exp
                .getRoot())::expressionPagination;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression6) {
            expressionPage = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression6<?, ?, ?, ?, ?, ?, ?, ?, ?>) exp
                .getRoot())::expressionPagination;
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
    }

    /**
     * Pagination.
     *
     * @return the pagination results
     */
    public PaginationResults<R> pagination() {
        Tuple7<String, String, List<Object>, Limit, Optional<QueryPageResults>, String,
            Function<Object, Object>> tupleResult = expressionPage.apply(limit);
        String sql = tupleResult.get0();
        Limit newLimit = tupleResult.get3();
        List<Object> paramList = tupleResult.get2();
        Object[] oraginalParams = paramList.toArray();
        Object[] params = oraginalParams;
        QueryPageResults queryPageResults = tupleResult.get4().orElse(null);
        SimplePaginationResults<R> pagination = new SimplePaginationResults<>(newLimit);
        List<R> list = null;
        if (newLimit != null) {
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, newLimit.getOffset(),
                newLimit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        list = queryRelation.list(sql, params);
        pagination.setPageResults(list);

        if (queryRelation.getConfig().isPagingOptimization() && queryPageResults != null && !list.isEmpty()) { // cache enable
            queryPageResults
                .addQueryPageResult(new QueryPageResult(limit, (Number) tupleResult.get6().apply(list.get(0)),
                    (Number) tupleResult.get6().apply(list.get(list.size() - 1))));
        }

        // cache key
        if (newLimit != null) {
            paramList.add(0, tupleResult.get5());
            Long total = null;
            queryPageResults = queryPageResults(queryPageResults, paramList);
            if (queryPageResults != null) {
                total = queryPageResults.getTotal();
            }
            if (total == null) {
                total = queryRelation.getJdbc().queryLong(tupleResult.get1(), oraginalParams);
            } else {
                LOGGER.debug("pagination count result [{}] found in cache", total);
            }
            pagination.setTotal(total);

            if (countResultCache != null) {
                if (queryPageResults == null) {
                    queryPageResults = new QueryPageResults(pagination.getTotal());
                } else {
                    queryPageResults.setTotal(pagination.getTotal());
                }
                countResultCache.put(paramList, queryPageResults);
            }

        } else {
            // 如果没有设置分页，则查询出来的就是全量数据，不用再去做数量count了
            pagination.setTotal(list.size());
        }
        return pagination;
    }

    private QueryPageResults queryPageResults(QueryPageResults queryPageResults, List<Object> sqlAndParamsList) {
        if (queryPageResults == null && countResultCache != null) {
            return countResultCache.get(sqlAndParamsList);
        }
        return queryPageResults;
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
    }
}
