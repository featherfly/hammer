
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

import com.speedment.common.tuple.Tuple6;
import com.speedment.common.tuple.Tuple7;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.QueryPageResult;
import cn.featherfly.common.repository.QueryPageResult.PageInfo;
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

    private Function<Limit, Tuple7<String, String, List<Object>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Object>>> preparePagination;

    private Function<Limit, Tuple6<String, List<Object>, Optional<Limit>, Optional<QueryPageResult>, String,
        Function<Object, Object>>> prepareList;

    private final Cache<Object, QueryPageResult> queryPageResultCache;

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
        Cache<Object, QueryPageResult> countResultCache) {
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
        Cache<Object, QueryPageResult> countResultCache, Limit limit) {
        super();
        this.limit = limit;
        this.queryRelation = queryRelation;
        this.sqlPageFactory = sqlPageFactory;
        queryPageResultCache = countResultCache;
        exp = entitySqlConditionGroupExpression;

        if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression) {
            preparePagination = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression<?, ?, ?>) exp
                .getRoot())::preparePagination;
            prepareList = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression<?, ?, ?>) exp.getRoot())::prepareList;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryValueConditionsGroupExpression) {
            preparePagination = ((AbstractMulitiEntitySqlQueryValueConditionsGroupExpression<?, ?, ?, ?>) exp
                .getRoot())::preparePagination;
            prepareList = ((AbstractMulitiEntitySqlQueryValueConditionsGroupExpression<?, ?, ?, ?>) exp
                .getRoot())::prepareList;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression2) {
            preparePagination = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression2<?, ?, ?, ?, ?>) exp
                .getRoot())::preparePagination;
            prepareList = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression2<?, ?, ?, ?, ?>) exp
                .getRoot())::prepareList;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression3) {
            preparePagination = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression3<?, ?, ?, ?, ?, ?>) exp
                .getRoot())::preparePagination;
            prepareList = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression3<?, ?, ?, ?, ?, ?>) exp
                .getRoot())::prepareList;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression4) {
            preparePagination = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression4<?, ?, ?, ?, ?, ?, ?>) exp
                .getRoot())::preparePagination;
            prepareList = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression4<?, ?, ?, ?, ?, ?, ?>) exp
                .getRoot())::prepareList;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression5) {
            preparePagination = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression5<?, ?, ?, ?, ?, ?, ?, ?>) exp
                .getRoot())::preparePagination;
            prepareList = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression5<?, ?, ?, ?, ?, ?, ?, ?>) exp
                .getRoot())::prepareList;
        } else if (exp instanceof AbstractMulitiEntitySqlQueryConditionsGroupExpression6) {
            preparePagination = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression6<?, ?, ?, ?, ?, ?, ?, ?, ?>) exp
                .getRoot())::preparePagination;
            prepareList = ((AbstractMulitiEntitySqlQueryConditionsGroupExpression6<?, ?, ?, ?, ?, ?, ?, ?, ?>) exp
                .getRoot())::prepareList;
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
        Tuple6<String, List<Object>, Optional<Limit>, Optional<QueryPageResult>, String,
            Function<Object, Object>> tupleResult = prepareList.apply(limit);
        String sql = tupleResult.get0();
        Limit newLimit = tupleResult.get2().orElse(null);
        List<Object> paramList = tupleResult.get1();
        Object[] params = paramList.toArray();
        paramList.add(0, tupleResult.get4());
        QueryPageResult queryPageResults = tupleResult.get3().orElse(null);

        List<R> list = null;
        if (newLimit != null) {
            queryPageResults = queryPageResults(queryPageResults, paramList);
            list = getCacheList(queryPageResults, newLimit);
            if (list != null) {
                return list;
            }
            SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, newLimit.getOffset(),
                newLimit.getLimit(), params);
            sql = pageQuery.getSql();
            params = pageQuery.getParams();
        }
        list = queryRelation.list(sql, params);

        setCacheList(list, queryPageResults, newLimit, tupleResult.get5());
        //        if (queryPageResultCache != null && newLimit != null) {
        //            if (queryRelation.getConfig().isPagingOptimization()) { // cache id
        //                queryPageResults = Lang.ifNull(queryPageResults, new QueryPageResults());
        //                if (list.isEmpty()) {
        //                    queryPageResult = new QueryPageResult<>(limit);
        //                } else {
        //                    queryPageResult = new QueryPageResult<>(limit, (Number) tupleResult.get5().apply(list.get(0)),
        //                        (Number) tupleResult.get5().apply(list.get(list.size() - 1)));
        //                }
        //            }
        //            if (queryRelation.getConfig().isCachePageResults()) { // cache enable
        //                queryPageResults = Lang.ifNull(queryPageResults, new QueryPageResults());
        //                if (queryPageResult == null) {
        //                    queryPageResult = new QueryPageResult<>(list);
        //                } else {
        //                    queryPageResult.setList(list);
        //                }
        //                queryPageResults.addQueryPageResult(queryPageResult);
        //            }
        //        }

        return list;
    }

    /**
     * Pagination.
     *
     * @return the pagination results
     */
    public PaginationResults<R> pagination() {
        Tuple7<String, String, List<Object>, Optional<Limit>, Optional<QueryPageResult>, String,
            Function<Object, Object>> tupleResult = preparePagination.apply(limit);
        String sql = tupleResult.get0();
        Limit newLimit = tupleResult.get3().orElse(null);
        List<Object> paramList = tupleResult.get2();
        Object[] oraginalParams = paramList.toArray();
        Object[] params = oraginalParams;
        paramList.add(0, tupleResult.get5()); // cache key
        QueryPageResult queryPageResult = tupleResult.get4().orElse(null);
        SimplePaginationResults<R> pagination = new SimplePaginationResults<>(newLimit);
        List<R> list = null;
        if (newLimit != null) {
            queryPageResult = queryPageResults(queryPageResult, paramList);
            list = getCacheList(queryPageResult, limit);
            if (list == null) {
                SqlPageQuery<Object[]> pageQuery = sqlPageFactory.toPage(exp.getDialect(), sql, newLimit.getOffset(),
                    newLimit.getLimit(), params);
                sql = pageQuery.getSql();
                params = pageQuery.getParams();
                list = queryRelation.list(sql, params);
            }
            pagination.setPageResults(list);
        } else {
            list = queryRelation.list(sql, params);
            pagination.setPageResults(list);
        }

        queryPageResult = setCacheList(list, queryPageResult, limit, tupleResult.get6());
        //        if (queryPageResultCache != null && newLimit != null) {
        //            if (queryRelation.getConfig().isPagingOptimization()) { // cache id
        //                queryPageResults = Lang.ifNull(queryPageResults, new QueryPageResults());
        //                if (list.isEmpty()) {
        //                    queryPageResult = new QueryPageResult<>(limit);
        //                } else {
        //                    queryPageResult = new QueryPageResult<>(limit, (Number) tupleResult.get6().apply(list.get(0)),
        //                        (Number) tupleResult.get6().apply(list.get(list.size() - 1)));
        //                }
        //                queryPageResults.addQueryPageResult(queryPageResult);
        //            }
        //            if (queryRelation.getConfig().isCachePageResults()) { // cache enable
        //                queryPageResults = Lang.ifNull(queryPageResults, new QueryPageResults());
        //                if (queryPageResult == null) {
        //                    queryPageResult = new QueryPageResult<>(list);
        //                } else {
        //                    queryPageResult.setList(list);
        //                }
        //                queryPageResults.addQueryPageResult(queryPageResult);
        //            }
        //        }

        if (newLimit != null) {
            Long total = getTotal(queryPageResult, paramList);
            if (total == null) {
                total = queryRelation.getJdbc().queryLong(tupleResult.get1(), oraginalParams);
            } else {
                LOGGER.debug("pagination count result [{}] found in cache", total);
            }
            pagination.setTotal(total);

            setTotal(queryPageResult, paramList, pagination);
        } else {
            // 如果没有设置分页，则查询出来的就是全量数据，不用再去做数量count了
            pagination.setTotal(list.size());
        }
        return pagination;
    }

    private List<R> getCacheList(QueryPageResult queryPageResult, Limit limit) {
        if (queryRelation.getConfig().isCachePageResults() && queryPageResult != null) {
            return queryPageResult.getPageList(limit.getOffset());
            // 不用下面这样，在外面调用前就先尝试获取缓存了
            //            if (queryPageResults == null && queryPageResultCache != null) {
            //                queryPageResults = queryPageResultCache.get(paramList);
            //            }
        }
        return null;
    }

    private QueryPageResult setCacheList(List<R> list, QueryPageResult queryPageResult, Limit limit,
        Function<Object, Object> getId) {
        if (queryPageResultCache != null && limit != null) {
            if (queryRelation.getConfig().isPagingOptimization()) { // cache id
                queryPageResult = Lang.ifNull(queryPageResult, new QueryPageResult());
                PageInfo pageInfo = null;
                if (list.isEmpty()) {
                    pageInfo = new PageInfo(limit);
                } else {
                    pageInfo = new PageInfo(limit, (Number) getId.apply(list.get(0)),
                        (Number) getId.apply(list.get(list.size() - 1)));
                }
                queryPageResult.addQueryPageResult(pageInfo);
            }
            if (queryRelation.getConfig().isCachePageResults()) { // cache enable
                queryPageResult = Lang.ifNull(queryPageResult, new QueryPageResult());
                queryPageResult.addPageList(limit.getOffset(), list);
            }
        }
        return queryPageResult;
    }

    private Long getTotal(QueryPageResult queryPageResult, List<Object> sqlAndParamsList) {
        if (queryRelation.getConfig().isCachePageCount()) {
            queryPageResult = queryPageResults(queryPageResult, sqlAndParamsList);
            if (queryPageResult != null) {
                return queryPageResult.getTotal();
            }
        }
        return null;
    }

    private void setTotal(QueryPageResult queryPageResult, List<Object> sqlAndParamsList,
        SimplePaginationResults<R> pagination) {
        if (queryRelation.getConfig().isCachePageCount() && queryPageResultCache != null) {
            if (queryPageResult == null) {
                queryPageResult = new QueryPageResult(pagination.getTotal());
            } else {
                queryPageResult.setTotal(pagination.getTotal());
            }
            queryPageResultCache.put(sqlAndParamsList, queryPageResult);
        }
    }

    private QueryPageResult queryPageResults(QueryPageResult queryPageResults, List<Object> sqlAndParamsList) {
        if (queryPageResults == null && queryPageResultCache != null) {
            return queryPageResultCache.get(sqlAndParamsList);
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
