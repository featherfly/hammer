
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-10 21:44:10
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.bean.PropertyAccessorFactory;
import cn.featherfly.common.db.SqlUtils;
import cn.featherfly.common.repository.ExecutionExecutorEx;
import cn.featherfly.common.repository.RowIterable;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.structure.page.SimplePaginationResults;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuple6;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory.SqlPageQuery;

/**
 * JdbcExecutor.
 *
 * @author zhongj
 */
public class JdbcExecutor implements ExecutionExecutorEx<String> {

    private final Jdbc jdbc;

    private final SqlPageFactory sqlPageFactory;

    private final PropertyAccessorFactory propertyAccessorFactory;

    /**
     * Instantiates a new jdbc executor.
     *
     * @param jdbc the jdbc
     * @param propertyAccessorFactory the property accessor factory
     * @param sqlPageFactory the sql page factory
     */
    public JdbcExecutor(Jdbc jdbc, PropertyAccessorFactory propertyAccessorFactory, SqlPageFactory sqlPageFactory) {
        super();
        this.jdbc = jdbc;
        this.propertyAccessorFactory = propertyAccessorFactory;
        this.sqlPageFactory = sqlPageFactory;
    }

    private <T> NestedBeanPropertyRowMapper<T> beanMapper(Class<T> element) {
        return new NestedBeanPropertyRowMapper<>(propertyAccessorFactory.create(element),
            jdbc.getSqlTypeMappingManager());
    }

    // ****************************************************************************************************************
    //  execution executor
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute(String execution, Map<String, Serializable> params) {
        return jdbc.update(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool(String execution, Map<String, Serializable> params) {
        return jdbc.queryBool(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue(String execution, Map<String, Serializable> params) {
        return jdbc.queryInt(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue(String execution, Map<String, Serializable> params) {
        return jdbc.queryLong(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue(String execution, Map<String, Serializable> params) {
        return jdbc.queryDouble(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> V value(String execution, Map<String, Serializable> params) {
        return jdbc.queryValue(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> V value(String execution, Class<V> valueType, Map<String, Serializable> params) {
        return jdbc.queryValue(execution, valueType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> single(String execution, Map<String, Serializable> params) {
        return jdbc.querySingle(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single(String execution, Class<T> mapType, Map<String, Serializable> params) {
        return jdbc.querySingle(execution, mapType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single(String execution, RowMapper<T> rowMapper, Map<String, Serializable> params) {
        return jdbc.querySingle(execution, rowMapper, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> single(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params) {
        return jdbc.querySingle(execution, mapType1, mapType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> single(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> params) {
        return jdbc.querySingle(execution, mapType1, mapType2, mapType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> single(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes,
        Map<String, Serializable> params) {
        return jdbc.querySingle(execution, mapType1, mapType2, mapType3, mapType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> single(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params) {
        return jdbc.querySingle(execution, mapType1, mapType2, mapType3, mapType4, mapType5, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> single(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Tuple6<String, String, String, String, String, String> prefixes, Map<String, Serializable> params) {
        return jdbc.querySingle(execution, mapType1, mapType2, mapType3, mapType4, mapType5, mapType6, prefixes,
            params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> unique(String execution, Map<String, Serializable> params) {
        return jdbc.queryUnique(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique(String execution, Class<T> mapType, Map<String, Serializable> params) {
        return jdbc.queryUnique(execution, mapType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique(String execution, RowMapper<T> rowMapper, Map<String, Serializable> params) {
        return jdbc.queryUnique(execution, rowMapper, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> unique(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params) {
        return jdbc.queryUnique(execution, mapType1, mapType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> unique(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> params) {
        return jdbc.queryUnique(execution, mapType1, mapType2, mapType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> unique(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes,
        Map<String, Serializable> params) {
        return jdbc.queryUnique(execution, mapType1, mapType2, mapType3, mapType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> unique(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params) {
        return jdbc.queryUnique(execution, mapType1, mapType2, mapType3, mapType4, mapType5, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> unique(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Tuple6<String, String, String, String, String, String> prefixes, Map<String, Serializable> params) {
        return jdbc.queryUnique(execution, mapType1, mapType2, mapType3, mapType4, mapType5, mapType6, prefixes,
            params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> list(String execution, Map<String, Serializable> params) {
        return jdbc.queryList(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> list(String execution, Map<String, Serializable> params, int offset,
        int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryList(pageQuery.getSql(), pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(String execution, Class<T> mapType, Map<String, Serializable> params) {
        return jdbc.queryList(execution, mapType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(String execution, RowMapper<T> rowMapper, Map<String, Serializable> params) {
        return jdbc.queryList(execution, rowMapper, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(String execution, Class<T> mapType, Map<String, Serializable> params, int offset,
        int limit) {
        return list(execution, beanMapper(mapType), params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(String execution, RowMapper<T> rowMapper, Map<String, Serializable> params, int offset,
        int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryList(pageQuery.getSql(), rowMapper, pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> List<Tuple2<T1, T2>> list(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params) {
        return jdbc.queryList(execution, mapType1, mapType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> List<Tuple2<T1, T2>> list(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params, int offset, int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, prefixes, pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> List<Tuple3<T1, T2, T3>> list(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> params) {
        return jdbc.queryList(execution, mapType1, mapType2, mapType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> List<Tuple3<T1, T2, T3>> list(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, prefixes, pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> list(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes,
        Map<String, Serializable> params) {
        return jdbc.queryList(execution, mapType1, mapType2, mapType3, mapType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> list(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, mapType4, prefixes,
            pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> list(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params) {
        return jdbc.queryList(execution, mapType1, mapType2, mapType3, mapType4, mapType5, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> list(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, mapType4, mapType5, prefixes,
            pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> List<Tuple6<T1, T2, T3, T4, T5, T6>> list(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Tuple6<String, String, String, String, String, String> prefixes, Map<String, Serializable> params) {
        return jdbc.queryList(execution, mapType1, mapType2, mapType3, mapType4, mapType5, mapType6, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> List<Tuple6<T1, T2, T3, T4, T5, T6>> list(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Tuple6<String, String, String, String, String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, mapType4, mapType5, mapType6, prefixes,
            pageQuery.getParams());
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Serializable>> pagination(String execution, Map<String, Serializable> params,
        int offset, int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageFactory.toPage(jdbc.getDialect(), execution, offset,
            limit, params);

        SimplePaginationResults<Map<String, Serializable>> pagination = new SimplePaginationResults<>(offset, limit);
        List<Map<String, Serializable>> list = null;

        list = jdbc.queryList(pageQuery.getSql(), pageQuery.getParams());
        pagination.setPageResults(list);

        String countSql = SqlUtils.convertSelectToCount(execution);
        int total = jdbc.queryInt(countSql, params);
        pagination.setTotal(total);
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> PaginationResults<T> pagination(String execution, Class<T> mapType, Map<String, Serializable> params,
        int offset, int limit) {
        return pagination(execution, beanMapper(mapType), params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> PaginationResults<T> pagination(String execution, RowMapper<T> rowMapper,
        Map<String, Serializable> params, int offset, int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageFactory.toPage(jdbc.getDialect(), execution, offset,
            limit, params);

        SimplePaginationResults<T> pagination = new SimplePaginationResults<>(offset, limit);
        List<T> list = null;

        list = jdbc.queryList(pageQuery.getSql(), rowMapper, pageQuery.getParams());
        pagination.setPageResults(list);

        String countSql = SqlUtils.convertSelectToCount(execution);
        int total = jdbc.queryInt(countSql, params);
        pagination.setTotal(total);
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> PaginationResults<Tuple2<T1, T2>> pagination(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Tuple2<String, String> prefixes, Map<String, Serializable> params, int offset, int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageFactory.toPage(jdbc.getDialect(), execution, offset,
            limit, params);

        SimplePaginationResults<Tuple2<T1, T2>> pagination = new SimplePaginationResults<>(offset, limit);
        List<Tuple2<T1, T2>> list = null;

        list = jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, prefixes, pageQuery.getParams());
        pagination.setPageResults(list);

        String countSql = SqlUtils.convertSelectToCount(execution);
        int total = jdbc.queryInt(countSql, params);
        pagination.setTotal(total);
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> PaginationResults<Tuple3<T1, T2, T3>> pagination(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageFactory.toPage(jdbc.getDialect(), execution, offset,
            limit, params);

        SimplePaginationResults<Tuple3<T1, T2, T3>> pagination = new SimplePaginationResults<>(offset, limit);
        List<Tuple3<T1, T2, T3>> list = null;

        list = jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, prefixes, pageQuery.getParams());
        pagination.setPageResults(list);

        String countSql = SqlUtils.convertSelectToCount(execution);
        int total = jdbc.queryInt(countSql, params);
        pagination.setTotal(total);
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> PaginationResults<Tuple4<T1, T2, T3, T4>> pagination(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageFactory.toPage(jdbc.getDialect(), execution, offset,
            limit, params);

        SimplePaginationResults<Tuple4<T1, T2, T3, T4>> pagination = new SimplePaginationResults<>(offset, limit);
        List<Tuple4<T1, T2, T3, T4>> list = null;

        list = jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, mapType4, prefixes,
            pageQuery.getParams());
        pagination.setPageResults(list);

        String countSql = SqlUtils.convertSelectToCount(execution);
        int total = jdbc.queryInt(countSql, params);
        pagination.setTotal(total);
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> PaginationResults<Tuple5<T1, T2, T3, T4, T5>> pagination(String execution,
        Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageFactory.toPage(jdbc.getDialect(), execution, offset,
            limit, params);

        SimplePaginationResults<Tuple5<T1, T2, T3, T4, T5>> pagination = new SimplePaginationResults<>(offset, limit);
        List<Tuple5<T1, T2, T3, T4, T5>> list = null;

        list = jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, mapType4, mapType5, prefixes,
            pageQuery.getParams());
        pagination.setPageResults(list);

        String countSql = SqlUtils.convertSelectToCount(execution);
        int total = jdbc.queryInt(countSql, params);
        pagination.setTotal(total);
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> PaginationResults<Tuple6<T1, T2, T3, T4, T5, T6>> pagination(String execution,
        Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Class<T6> mapType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageFactory.toPage(jdbc.getDialect(), execution, offset,
            limit, params);

        SimplePaginationResults<
            Tuple6<T1, T2, T3, T4, T5, T6>> pagination = new SimplePaginationResults<>(offset, limit);
        List<Tuple6<T1, T2, T3, T4, T5, T6>> list = null;

        list = jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, mapType4, mapType5, mapType6, prefixes,
            pageQuery.getParams());
        pagination.setPageResults(list);

        String countSql = SqlUtils.convertSelectToCount(execution);
        int total = jdbc.queryInt(countSql, params);
        pagination.setTotal(total);
        return pagination;
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute(String execution, Serializable... params) {
        return jdbc.update(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool(String execution, Serializable... params) {
        return jdbc.queryBool(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue(String execution, Serializable... params) {
        return jdbc.queryInt(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue(String execution, Serializable... params) {
        return jdbc.queryLong(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue(String execution, Serializable... params) {
        return jdbc.queryLong(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> V value(String execution, Serializable... params) {
        return jdbc.queryValue(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> V value(String execution, Class<V> valueType, Serializable... params) {
        return jdbc.queryValue(execution, valueType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> single(String execution, Serializable... params) {
        return jdbc.querySingle(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single(String execution, Class<T> mapType, Serializable... params) {
        return jdbc.querySingle(execution, mapType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T single(String execution, RowMapper<T> rowMapper, Serializable... params) {
        return jdbc.querySingle(execution, rowMapper, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> single(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Serializable... params) {
        return jdbc.querySingle(execution, mapType1, mapType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> single(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Tuple3<String, String, String> prefixes, Serializable... params) {
        return jdbc.querySingle(execution, mapType1, mapType2, mapType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> single(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes,
        Serializable... params) {
        return jdbc.querySingle(execution, mapType1, mapType2, mapType3, mapType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> single(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... params) {
        return jdbc.querySingle(execution, mapType1, mapType2, mapType3, mapType4, mapType5, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> single(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Tuple6<String, String, String, String, String, String> prefixes, Serializable... params) {
        return jdbc.querySingle(execution, mapType1, mapType2, mapType3, mapType4, mapType5, mapType6, prefixes,
            params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> unique(String execution, Serializable... params) {
        return jdbc.queryUnique(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique(String execution, Class<T> mapType, Serializable... params) {
        return jdbc.queryUnique(execution, mapType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T unique(String execution, RowMapper<T> rowMapper, Serializable... params) {
        return jdbc.queryUnique(execution, rowMapper, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> Tuple2<T1, T2> unique(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Serializable... params) {
        return jdbc.queryUnique(execution, mapType1, mapType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> Tuple3<T1, T2, T3> unique(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Tuple3<String, String, String> prefixes, Serializable... params) {
        return jdbc.queryUnique(execution, mapType1, mapType2, mapType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> unique(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes,
        Serializable... params) {
        return jdbc.queryUnique(execution, mapType1, mapType2, mapType3, mapType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> unique(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... params) {
        return jdbc.queryUnique(execution, mapType1, mapType2, mapType3, mapType4, mapType5, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> unique(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Tuple6<String, String, String, String, String, String> prefixes, Serializable... params) {
        return jdbc.queryUnique(execution, mapType1, mapType2, mapType3, mapType4, mapType5, mapType6, prefixes,
            params);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> list(String execution, Serializable... params) {
        return jdbc.queryList(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> list(String execution, Serializable[] params, int offset, int limit) {
        SqlPageQuery<Serializable[]> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryList(pageQuery.getSql(), pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(String execution, Class<T> mapType, Serializable... params) {
        return jdbc.queryList(execution, mapType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(String execution, RowMapper<T> rowMapper, Serializable... params) {
        return jdbc.queryList(execution, rowMapper, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(String execution, Class<T> mapType, Serializable[] params, int offset, int limit) {
        return list(execution, beanMapper(mapType), params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> list(String execution, RowMapper<T> rowMapper, Serializable[] params, int offset, int limit) {
        SqlPageQuery<Serializable[]> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryList(pageQuery.getSql(), rowMapper, pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> List<Tuple2<T1, T2>> list(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Serializable... params) {
        return jdbc.queryList(execution, mapType1, mapType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> List<Tuple2<T1, T2>> list(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Serializable[] params, int offset, int limit) {
        SqlPageQuery<Serializable[]> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, prefixes, pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> List<Tuple3<T1, T2, T3>> list(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Tuple3<String, String, String> prefixes, Serializable... params) {
        return jdbc.queryList(execution, mapType1, mapType2, mapType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> List<Tuple3<T1, T2, T3>> list(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Tuple3<String, String, String> prefixes, Serializable[] params, int offset, int limit) {
        SqlPageQuery<Serializable[]> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, prefixes, pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> list(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes,
        Serializable... params) {
        return jdbc.queryList(execution, mapType1, mapType2, mapType3, mapType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> list(String execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes, Serializable[] params,
        int offset, int limit) {
        SqlPageQuery<Serializable[]> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, mapType4, prefixes,
            pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> list(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... params) {
        return jdbc.queryList(execution, mapType1, mapType2, mapType3, mapType4, mapType5, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> list(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable[] params, int offset, int limit) {
        SqlPageQuery<Serializable[]> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, mapType4, mapType5, prefixes,
            pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> List<Tuple6<T1, T2, T3, T4, T5, T6>> list(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Tuple6<String, String, String, String, String, String> prefixes, Serializable... params) {
        return jdbc.queryList(execution, mapType1, mapType2, mapType3, mapType4, mapType5, mapType6, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> List<Tuple6<T1, T2, T3, T4, T5, T6>> list(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Tuple6<String, String, String, String, String, String> prefixes, Serializable[] params, int offset, int limit) {
        SqlPageQuery<Serializable[]> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, mapType4, mapType5, mapType6, prefixes,
            pageQuery.getParams());
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public RowIterable<Map<String, Serializable>> each(String execution, Map<String, Serializable> params) {
        return jdbc.queryEach(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> RowIterable<T> each(String execution, Class<T> mappingType, Map<String, Serializable> params) {
        return jdbc.queryEach(execution, mappingType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> RowIterable<T> each(String execution, RowMapper<T> rowMapper, Map<String, Serializable> params) {
        return jdbc.queryEach(execution, rowMapper, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RowIterable<Map<String, Serializable>> each(String execution, Map<String, Serializable> params, int offset,
        int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryEach(pageQuery.getSql(), pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> RowIterable<T> each(String execution, Class<T> mappingType, Map<String, Serializable> params, int offset,
        int limit) {
        return each(execution, beanMapper(mappingType), params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> RowIterable<T> each(String execution, RowMapper<T> rowMapper, Map<String, Serializable> params,
        int offset, int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryEach(pageQuery.getSql(), rowMapper, pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> RowIterable<Tuple2<T1, T2>> each(String execution, Class<T1> mappingType1, Class<T2> mappingType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params) {
        return jdbc.queryEach(execution, mappingType1, mappingType2, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> RowIterable<Tuple2<T1, T2>> each(String execution, Class<T1> mappingType1, Class<T2> mappingType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params, int offset, int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryEach(pageQuery.getSql(), mappingType1, mappingType2, prefixes, pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> RowIterable<Tuple3<T1, T2, T3>> each(String execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Class<T3> mappingType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params) {
        return jdbc.queryEach(execution, mappingType1, mappingType2, mappingType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> RowIterable<Tuple3<T1, T2, T3>> each(String execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Class<T3> mappingType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryEach(pageQuery.getSql(), mappingType1, mappingType2, mappingType3, prefixes,
            pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> RowIterable<Tuple4<T1, T2, T3, T4>> each(String execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params) {
        return jdbc.queryEach(execution, mappingType1, mappingType2, mappingType3, mappingType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> RowIterable<Tuple4<T1, T2, T3, T4>> each(String execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params, int offset, int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryEach(pageQuery.getSql(), mappingType1, mappingType2, mappingType3, mappingType4, prefixes,
            pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> RowIterable<Tuple5<T1, T2, T3, T4, T5>> each(String execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4, Class<T5> mappingType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params) {
        return jdbc.queryEach(execution, mappingType1, mappingType2, mappingType3, mappingType4, mappingType5, prefixes,
            params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> RowIterable<Tuple5<T1, T2, T3, T4, T5>> each(String execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4, Class<T5> mappingType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryEach(pageQuery.getSql(), mappingType1, mappingType2, mappingType3, mappingType4, mappingType5,
            prefixes, pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> RowIterable<Tuple6<T1, T2, T3, T4, T5, T6>> each(String execution,
        Class<T1> mappingType1, Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4,
        Class<T5> mappingType5, Class<T6> mappingType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params) {
        return jdbc.queryEach(execution, mappingType1, mappingType2, mappingType3, mappingType4, mappingType5,
            mappingType6, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> RowIterable<Tuple6<T1, T2, T3, T4, T5, T6>> each(String execution,
        Class<T1> mappingType1, Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4,
        Class<T5> mappingType5, Class<T6> mappingType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit) {
        SqlPageQuery<Map<String, Serializable>> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryEach(pageQuery.getSql(), mappingType1, mappingType2, mappingType3, mappingType4, mappingType5,
            mappingType6, prefixes, pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RowIterable<Map<String, Serializable>> each(String execution, Serializable... params) {
        return jdbc.queryEach(execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> RowIterable<T> each(String execution, Class<T> mappingType, Serializable... params) {
        return jdbc.queryEach(execution, mappingType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> RowIterable<T> each(String execution, RowMapper<T> rowMapper, Serializable... params) {
        return jdbc.queryEach(execution, rowMapper, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RowIterable<Map<String, Serializable>> each(String execution, Serializable[] params, int offset, int limit) {
        SqlPageQuery<Serializable[]> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryEach(pageQuery.getSql(), pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> RowIterable<T> each(String execution, Class<T> mappingType, Serializable[] params, int offset,
        int limit) {
        return each(execution, beanMapper(mappingType), params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> RowIterable<T> each(String execution, RowMapper<T> rowMapper, Serializable[] params, int offset,
        int limit) {
        SqlPageQuery<Serializable[]> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryEach(pageQuery.getSql(), rowMapper, pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> RowIterable<Tuple2<T1, T2>> each(String execution, Class<T1> mappingType1, Class<T2> mappingType2,
        Tuple2<String, String> prefixes, Serializable... params) {
        return jdbc.queryEach(execution, mappingType1, mappingType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> RowIterable<Tuple2<T1, T2>> each(String execution, Class<T1> mappingType1, Class<T2> mappingType2,
        Tuple2<String, String> prefixes, Serializable[] params, int offset, int limit) {
        SqlPageQuery<Serializable[]> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryEach(pageQuery.getSql(), mappingType1, mappingType2, prefixes, pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> RowIterable<Tuple3<T1, T2, T3>> each(String execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Class<T3> mappingType3, Tuple3<String, String, String> prefixes,
        Serializable... params) {
        return jdbc.queryEach(execution, mappingType1, mappingType2, mappingType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> RowIterable<Tuple3<T1, T2, T3>> each(String execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Class<T3> mappingType3, Tuple3<String, String, String> prefixes, Serializable[] params,
        int offset, int limit) {
        SqlPageQuery<Serializable[]> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryEach(pageQuery.getSql(), mappingType1, mappingType2, mappingType3, prefixes,
            pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> RowIterable<Tuple4<T1, T2, T3, T4>> each(String execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4,
        Tuple4<String, String, String, String> prefixes, Serializable... params) {
        return jdbc.queryEach(execution, mappingType1, mappingType2, mappingType3, mappingType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> RowIterable<Tuple4<T1, T2, T3, T4>> each(String execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4,
        Tuple4<String, String, String, String> prefixes, Serializable[] params, int offset, int limit) {
        SqlPageQuery<Serializable[]> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryEach(pageQuery.getSql(), mappingType1, mappingType2, mappingType3, mappingType4, prefixes,
            pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> RowIterable<Tuple5<T1, T2, T3, T4, T5>> each(String execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4, Class<T5> mappingType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... params) {
        return jdbc.queryEach(execution, mappingType1, mappingType2, mappingType3, mappingType4, mappingType5, prefixes,
            params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> RowIterable<Tuple5<T1, T2, T3, T4, T5>> each(String execution, Class<T1> mappingType1,
        Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4, Class<T5> mappingType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable[] params, int offset, int limit) {
        SqlPageQuery<Serializable[]> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryEach(pageQuery.getSql(), mappingType1, mappingType2, mappingType3, mappingType4, mappingType5,
            prefixes, pageQuery.getParams());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> RowIterable<Tuple6<T1, T2, T3, T4, T5, T6>> each(String execution,
        Class<T1> mappingType1, Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4,
        Class<T5> mappingType5, Class<T6> mappingType6, Tuple6<String, String, String, String, String, String> prefixes,
        Serializable... params) {
        return jdbc.queryEach(execution, mappingType1, mappingType2, mappingType3, mappingType4, mappingType5,
            mappingType6, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> RowIterable<Tuple6<T1, T2, T3, T4, T5, T6>> each(String execution,
        Class<T1> mappingType1, Class<T2> mappingType2, Class<T3> mappingType3, Class<T4> mappingType4,
        Class<T5> mappingType5, Class<T6> mappingType6, Tuple6<String, String, String, String, String, String> prefixes,
        Serializable[] params, int offset, int limit) {
        SqlPageQuery<Serializable[]> pageQuery = sqlPageQuery(execution, params, offset, limit);
        return jdbc.queryEach(pageQuery.getSql(), mappingType1, mappingType2, mappingType3, mappingType4, mappingType5,
            mappingType6, prefixes, pageQuery.getParams());
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Serializable>> pagination(String execution, Serializable[] params, int offset,
        int limit) {
        SqlPageQuery<
            Serializable[]> pageQuery = sqlPageFactory.toPage(jdbc.getDialect(), execution, offset, limit, params);

        SimplePaginationResults<Map<String, Serializable>> pagination = new SimplePaginationResults<>(offset, limit);
        List<Map<String, Serializable>> list = null;

        list = jdbc.queryList(pageQuery.getSql(), pageQuery.getParams());
        pagination.setPageResults(list);

        String countSql = SqlUtils.convertSelectToCount(execution);
        int total = jdbc.queryInt(countSql, params);
        pagination.setTotal(total);
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> PaginationResults<T> pagination(String execution, Class<T> mapType, Serializable[] params, int offset,
        int limit) {
        return pagination(execution, beanMapper(mapType), params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> PaginationResults<T> pagination(String execution, RowMapper<T> rowMapper, Serializable[] params,
        int offset, int limit) {
        SqlPageQuery<
            Serializable[]> pageQuery = sqlPageFactory.toPage(jdbc.getDialect(), execution, offset, limit, params);

        SimplePaginationResults<T> pagination = new SimplePaginationResults<>(offset, limit);
        List<T> list = null;

        list = jdbc.queryList(pageQuery.getSql(), rowMapper, pageQuery.getParams());
        pagination.setPageResults(list);

        String countSql = SqlUtils.convertSelectToCount(execution);
        int total = jdbc.queryInt(countSql, params);
        pagination.setTotal(total);
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2> PaginationResults<Tuple2<T1, T2>> pagination(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Tuple2<String, String> prefixes, Serializable[] params, int offset, int limit) {
        SqlPageQuery<
            Serializable[]> pageQuery = sqlPageFactory.toPage(jdbc.getDialect(), execution, offset, limit, params);

        SimplePaginationResults<Tuple2<T1, T2>> pagination = new SimplePaginationResults<>(offset, limit);
        List<Tuple2<T1, T2>> list = null;

        list = jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, prefixes, pageQuery.getParams());
        pagination.setPageResults(list);

        String countSql = SqlUtils.convertSelectToCount(execution);
        int total = jdbc.queryInt(countSql, params);
        pagination.setTotal(total);
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3> PaginationResults<Tuple3<T1, T2, T3>> pagination(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Tuple3<String, String, String> prefixes, Serializable[] params,
        int offset, int limit) {
        SqlPageQuery<
            Serializable[]> pageQuery = sqlPageFactory.toPage(jdbc.getDialect(), execution, offset, limit, params);

        SimplePaginationResults<Tuple3<T1, T2, T3>> pagination = new SimplePaginationResults<>(offset, limit);
        List<Tuple3<T1, T2, T3>> list = null;

        list = jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, prefixes, pageQuery.getParams());
        pagination.setPageResults(list);

        String countSql = SqlUtils.convertSelectToCount(execution);
        int total = jdbc.queryInt(countSql, params);
        pagination.setTotal(total);
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4> PaginationResults<Tuple4<T1, T2, T3, T4>> pagination(String execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes,
        Serializable[] params, int offset, int limit) {
        SqlPageQuery<
            Serializable[]> pageQuery = sqlPageFactory.toPage(jdbc.getDialect(), execution, offset, limit, params);

        SimplePaginationResults<Tuple4<T1, T2, T3, T4>> pagination = new SimplePaginationResults<>(offset, limit);
        List<Tuple4<T1, T2, T3, T4>> list = null;

        list = jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, mapType4, prefixes,
            pageQuery.getParams());
        pagination.setPageResults(list);

        String countSql = SqlUtils.convertSelectToCount(execution);
        int total = jdbc.queryInt(countSql, params);
        pagination.setTotal(total);
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5> PaginationResults<Tuple5<T1, T2, T3, T4, T5>> pagination(String execution,
        Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable[] params, int offset, int limit) {
        SqlPageQuery<
            Serializable[]> pageQuery = sqlPageFactory.toPage(jdbc.getDialect(), execution, offset, limit, params);

        SimplePaginationResults<Tuple5<T1, T2, T3, T4, T5>> pagination = new SimplePaginationResults<>(offset, limit);
        List<Tuple5<T1, T2, T3, T4, T5>> list = null;

        list = jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, mapType4, mapType5, prefixes,
            pageQuery.getParams());
        pagination.setPageResults(list);

        String countSql = SqlUtils.convertSelectToCount(execution);
        int total = jdbc.queryInt(countSql, params);
        pagination.setTotal(total);
        return pagination;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1, T2, T3, T4, T5, T6> PaginationResults<Tuple6<T1, T2, T3, T4, T5, T6>> pagination(String execution,
        Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Class<T6> mapType6, Tuple6<String, String, String, String, String, String> prefixes, Serializable[] params,
        int offset, int limit) {
        SqlPageQuery<
            Serializable[]> pageQuery = sqlPageFactory.toPage(jdbc.getDialect(), execution, offset, limit, params);

        SimplePaginationResults<
            Tuple6<T1, T2, T3, T4, T5, T6>> pagination = new SimplePaginationResults<>(offset, limit);
        List<Tuple6<T1, T2, T3, T4, T5, T6>> list = null;

        list = jdbc.queryList(pageQuery.getSql(), mapType1, mapType2, mapType3, mapType4, mapType5, mapType6, prefixes,
            pageQuery.getParams());
        pagination.setPageResults(list);

        String countSql = SqlUtils.convertSelectToCount(execution);
        int total = jdbc.queryInt(countSql, params);
        pagination.setTotal(total);
        return pagination;
    }

    private SqlPageQuery<Map<String, Serializable>> sqlPageQuery(String sql, Map<String, Serializable> params,
        int offset, int limit) {
        return sqlPageFactory.toPage(jdbc.getDialect(), sql, offset, limit, params);
    }

    private SqlPageQuery<Serializable[]> sqlPageQuery(String sql, Serializable[] params, int offset, int limit) {
        return sqlPageFactory.toPage(jdbc.getDialect(), sql, offset, limit, params);
    }

    /**
     * get jdbc value.
     *
     * @return jdbc
     */
    public Jdbc getJdbc() {
        return jdbc;
    }

    /**
     * get sqlPageFactory value.
     *
     * @return sqlPageFactory
     */
    public SqlPageFactory getSqlPageFactory() {
        return sqlPageFactory;
    }
}
