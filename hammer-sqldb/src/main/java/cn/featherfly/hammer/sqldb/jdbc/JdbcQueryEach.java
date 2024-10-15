
/*
 * All rights Reserved, Designed By zhongj
 * @Title: JdbcQuery.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: JdbcQuery
 * @author: zhongj
 * @date: 2023-07-10 16:15:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.db.NamedParamSql;
import cn.featherfly.common.lang.AutoCloseableIterable;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.mapper.RowMapper;

/**
 * jdbc query each. <br>
 * lazy load data from {@linkplain java.sql.ResultSet ResultSet} when invoke iterator.next() .
 *
 * <pre>
 * for (Map&lt;String, Object&gt; data : queryEach("")) { // each loop starts loading data
 * }
 * </pre>
 *
 * @author zhongj
 */
public interface JdbcQueryEach {
    /**
     * query each.
     *
     * @param sql sql
     * @param args args
     * @return map list
     */
    AutoCloseableIterable<Map<String, Serializable>> queryEach(String sql, Serializable... args);

    /**
     * query each.
     *
     * @param sql sql
     * @param args args
     * @return map list
     */
    AutoCloseableIterable<Map<String, Serializable>> queryEach(String sql, Map<String, Serializable> args);

    /**
     * query each.
     *
     * @param sql sql
     * @param args args
     * @return map list
     */
    default AutoCloseableIterable<Map<String, Serializable>> queryEach(NamedParamSql sql,
        Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return queryEach(execution.getExecution(), execution.getParams());
    }

    /**
     * query each.
     *
     * @param <T> generic type
     * @param sql sql
     * @param rowMapper rowMapper
     * @param args args
     * @return elementType object list
     */
    <T> AutoCloseableIterable<T> queryEach(String sql, RowMapper<T> rowMapper, Serializable... args);

    //    /**
    //     * query each.
    //     *
    //     * @param <T>       the generic type
    //     * @param sql       the sql
    //     * @param rowMapper the row mapper
    //     * @param args      the args
    //     * @return LogicExpressionist
    //     */
    //    <T> AutoCloseableIterable<T> queryEach(String sql, RowMapper<T> rowMapper, BeanPropertyValue<?>... args);

    /**
     * query each.
     *
     * @param <T> generic type
     * @param sql sql
     * @param elementType return object type
     * @param args args
     * @return elementType object list
     */
    <T> AutoCloseableIterable<T> queryEach(String sql, Class<T> elementType, Serializable... args);

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2> AutoCloseableIterable<Tuple2<T1, T2>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Serializable... args) {
        return queryEach(sql, elementType1, elementType2, (Tuple2<String, String>) null, args);
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    <T1, T2> AutoCloseableIterable<Tuple2<T1, T2>> queryEach(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Tuple2<String, String> prefixes, Serializable... args);

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3> AutoCloseableIterable<Tuple3<T1, T2, T3>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Serializable... args) {
        return queryEach(sql, elementType1, elementType2, elementType3, (Tuple3<String, String, String>) null, args);
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    <T1, T2, T3> AutoCloseableIterable<Tuple3<T1, T2, T3>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Tuple3<String, String, String> prefixes, Serializable... args);

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3, T4> AutoCloseableIterable<Tuple4<T1, T2, T3, T4>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Serializable... args) {
        return queryEach(sql, elementType1, elementType2, elementType3, elementType4,
            (Tuple4<String, String, String, String>) null, args);
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    <T1, T2, T3, T4> AutoCloseableIterable<Tuple4<T1, T2, T3, T4>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Tuple4<String, String, String, String> prefixes, Serializable... args);

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3, T4, T5> AutoCloseableIterable<Tuple5<T1, T2, T3, T4, T5>> queryEach(String sql,
        Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Class<T5> elementType5, Serializable... args) {
        return queryEach(sql, elementType1, elementType2, elementType3, elementType4, elementType5,
            (Tuple5<String, String, String, String, String>) null, args);
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    <T1, T2, T3, T4, T5> AutoCloseableIterable<Tuple5<T1, T2, T3, T4, T5>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... args);

    /**
     * query each .
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param <T6> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param elementType6 the element type 6
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3, T4, T5, T6> AutoCloseableIterable<Tuple6<T1, T2, T3, T4, T5, T6>> queryEach(String sql,
        Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Class<T5> elementType5, Class<T6> elementType6, Serializable... args) {
        return queryEach(sql, elementType1, elementType2, elementType3, elementType4, elementType5, elementType6,
            (Tuple6<String, String, String, String, String, String>) null, args);
    }

    /**
     * query each .
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param <T6> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param elementType6 the element type 6
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    <T1, T2, T3, T4, T5, T6> AutoCloseableIterable<Tuple6<T1, T2, T3, T4, T5, T6>> queryEach(String sql,
        Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Class<T5> elementType5, Class<T6> elementType6, Tuple6<String, String, String, String, String, String> prefixes,
        Serializable... args);

    //    /**
    //     * query each.
    //     *
    //     * @param <T>         the generic type
    //     * @param sql         the sql
    //     * @param elementType the element type
    //     * @param args        the args
    //     * @return LogicExpressionist
    //     */
    //    <T> AutoCloseableIterable<T> queryEach(String sql, Class<T> elementType, BeanPropertyValue<?>... args);

    /**
     * query each.
     *
     * @param <T> generic type
     * @param sql sql
     * @param rowMapper rowMapper
     * @param args args
     * @return elementType object list
     */
    <T> AutoCloseableIterable<T> queryEach(String sql, RowMapper<T> rowMapper, Map<String, Serializable> args);

    /**
     * query each.
     *
     * @param <T> generic type
     * @param sql sql
     * @param rowMapper rowMapper
     * @param args args
     * @return elementType object list
     */
    default <T> AutoCloseableIterable<T> queryEach(NamedParamSql sql, RowMapper<T> rowMapper,
        Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return queryEach(execution.getExecution(), rowMapper, execution.getParams());
    }

    /**
     * query each.
     *
     * @param <T> generic type
     * @param sql sql
     * @param elementType return object type
     * @param args args
     * @return elementType object list
     */
    <T> AutoCloseableIterable<T> queryEach(String sql, Class<T> elementType, Map<String, Serializable> args);

    /**
     * query each.
     *
     * @param <T> generic type
     * @param sql sql
     * @param elementType return object type
     * @param args args
     * @return elementType object list
     */
    default <T> AutoCloseableIterable<T> queryEach(NamedParamSql sql, Class<T> elementType,
        Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return queryEach(execution.getExecution(), elementType, execution.getParams());
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2> AutoCloseableIterable<Tuple2<T1, T2>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Map<String, Serializable> args) {
        return queryEach(sql, elementType1, elementType2, (Tuple2<String, String>) null, args);
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2> AutoCloseableIterable<Tuple2<T1, T2>> queryEach(NamedParamSql sql, Class<T1> elementType1,
        Class<T2> elementType2, Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return queryEach(execution.getExecution(), elementType1, elementType2, execution.getParams());
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    <T1, T2> AutoCloseableIterable<Tuple2<T1, T2>> queryEach(String sql, Class<T1> elementType1, Class<T2> elementType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> args);

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2> AutoCloseableIterable<Tuple2<T1, T2>> queryEach(NamedParamSql sql, Class<T1> elementType1,
        Class<T2> elementType2, Tuple2<String, String> prefixes, Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return queryEach(execution.getExecution(), elementType1, elementType2, prefixes, execution.getParams());
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3> AutoCloseableIterable<Tuple3<T1, T2, T3>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Map<String, Serializable> args) {
        return queryEach(sql, elementType1, elementType2, elementType3, (Tuple3<String, String, String>) null, args);
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3> AutoCloseableIterable<Tuple3<T1, T2, T3>> queryEach(NamedParamSql sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return queryEach(execution.getExecution(), elementType1, elementType2, elementType3, execution.getParams());
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    <T1, T2, T3> AutoCloseableIterable<Tuple3<T1, T2, T3>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> args);

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3> AutoCloseableIterable<Tuple3<T1, T2, T3>> queryEach(NamedParamSql sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return queryEach(execution.getExecution(), elementType1, elementType2, elementType3, prefixes,
            execution.getParams());
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3, T4> AutoCloseableIterable<Tuple4<T1, T2, T3, T4>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Map<String, Serializable> args) {
        return queryEach(sql, elementType1, elementType2, elementType3, elementType4,
            (Tuple4<String, String, String, String>) null, args);
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3, T4> AutoCloseableIterable<Tuple4<T1, T2, T3, T4>> queryEach(NamedParamSql sql,
        Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return queryEach(execution.getExecution(), elementType1, elementType2, elementType3, elementType4,
            execution.getParams());
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    <T1, T2, T3, T4> AutoCloseableIterable<Tuple4<T1, T2, T3, T4>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> args);

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3, T4> AutoCloseableIterable<Tuple4<T1, T2, T3, T4>> queryEach(NamedParamSql sql,
        Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return queryEach(execution.getExecution(), elementType1, elementType2, elementType3, elementType4, prefixes,
            execution.getParams());
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3, T4, T5> AutoCloseableIterable<Tuple5<T1, T2, T3, T4, T5>> queryEach(String sql,
        Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Class<T5> elementType5, Map<String, Serializable> args) {
        return queryEach(sql, elementType1, elementType2, elementType3, elementType4, elementType5,
            (Tuple5<String, String, String, String, String>) null, args);
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3, T4, T5> AutoCloseableIterable<Tuple5<T1, T2, T3, T4, T5>> queryEach(NamedParamSql sql,
        Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Class<T5> elementType5, Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return queryEach(execution.getExecution(), elementType1, elementType2, elementType3, elementType4, elementType5,
            execution.getParams());
    }

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    <T1, T2, T3, T4, T5> AutoCloseableIterable<Tuple5<T1, T2, T3, T4, T5>> queryEach(String sql, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> args);

    /**
     * query each.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3, T4, T5> AutoCloseableIterable<Tuple5<T1, T2, T3, T4, T5>> queryEach(NamedParamSql sql,
        Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Class<T5> elementType5, Tuple5<String, String, String, String, String> prefixes,
        Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return queryEach(execution.getExecution(), elementType1, elementType2, elementType3, elementType4, elementType5,
            prefixes, execution.getParams());
    }

    /**
     * query each .
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param <T6> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param elementType6 the element type 6
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3, T4, T5, T6> AutoCloseableIterable<Tuple6<T1, T2, T3, T4, T5, T6>> queryEach(String sql,
        Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Class<T5> elementType5, Class<T6> elementType6, Map<String, Serializable> args) {
        return queryEach(sql, elementType1, elementType2, elementType3, elementType4, elementType5, elementType6,
            (Tuple6<String, String, String, String, String, String>) null, args);
    }

    /**
     * query each .
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param <T6> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param elementType6 the element type 6
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3, T4, T5, T6> AutoCloseableIterable<Tuple6<T1, T2, T3, T4, T5, T6>> queryEach(NamedParamSql sql,
        Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Class<T5> elementType5, Class<T6> elementType6, Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return queryEach(execution.getExecution(), elementType1, elementType2, elementType3, elementType4, elementType5,
            elementType6, execution.getParams());
    }

    /**
     * query each .
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param <T6> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param elementType6 the element type 6
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    <T1, T2, T3, T4, T5, T6> AutoCloseableIterable<Tuple6<T1, T2, T3, T4, T5, T6>> queryEach(String sql,
        Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Class<T5> elementType5, Class<T6> elementType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> args);

    /**
     * query each .
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param <T6> the generic type
     * @param sql the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param elementType6 the element type 6
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3, T4, T5, T6> AutoCloseableIterable<Tuple6<T1, T2, T3, T4, T5, T6>> queryEach(NamedParamSql sql,
        Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
        Class<T5> elementType5, Class<T6> elementType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> args) {
        Execution execution = sql.getExecution(args);
        return queryEach(execution.getExecution(), elementType1, elementType2, elementType3, elementType4, elementType5,
            elementType6, prefixes, execution.getParams());
    }
}
