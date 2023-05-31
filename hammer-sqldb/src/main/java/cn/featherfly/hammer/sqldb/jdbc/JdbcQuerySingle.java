
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

import java.util.Map;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.repository.mapping.RowMapper;

/**
 * The Interface JdbcQuerySingle.
 *
 * @author zhongj
 */
public interface JdbcQuerySingle {

    /**
     * Query single.
     *
     * @param sql  sql
     * @param args args
     * @return map
     */
    Map<String, Object> querySingle(String sql, Map<String, Object> args);

    /**
     * Query single.
     *
     * @param sql  sql
     * @param args args
     * @return map
     */
    Map<String, Object> querySingle(String sql, Object... args);

    //  /**
    //     * Query single.
    //     *
    //     * @param <T>         the generic type
    //     * @param sql         the sql
    //     * @param elementType the element type
    //     * @param args        the args
    //     * @return the t
    //     */
    //    <T> T querySingle(String sql, Class<T> elementType, BeanPropertyValue<?>... args);

    /**
     * Query single.
     *
     * @param <T>       generic type
     * @param sql       sql
     * @param rowMapper rowMapper
     * @param args      args
     * @return single elementType object
     */
    <T> T querySingle(String sql, RowMapper<T> rowMapper, Object... args);

    //    /**
    //     * Query single.
    //     *
    //     * @param <T>       the generic type
    //     * @param sql       the sql
    //     * @param rowMapper the row mapper
    //     * @param args      the args
    //     * @return the t
    //     */
    //    <T> T querySingle(String sql, RowMapper<T> rowMapper, BeanPropertyValue<?>... args);

    /**
     * Query single.
     *
     * @param <T>       generic type
     * @param sql       sql
     * @param rowMapper rowMapper
     * @param args      args
     * @return single elementType object
     */
    <T> T querySingle(String sql, RowMapper<T> rowMapper, Map<String, Object> args);

    /**
     * Query single.
     *
     * @param <T>         generic type
     * @param sql         sql
     * @param elementType return object type
     * @param args        args
     * @return element type object list
     */
    <T> T querySingle(String sql, Class<T> elementType, Map<String, Object> args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param args         the args
     * @return the tuple 2
     */
    default <T1, T2> Tuple2<T1, T2> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Map<String, Object> args) {
        return querySingle(sql, elementType1, elementType2, (Tuple2<String, String>) null, args);
    }

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes     the prefixes of mapping element type
     * @param args         the args
     * @return the tuple 2
     */
    <T1, T2> Tuple2<T1, T2> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Map<String, Object> args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param args         the args
     * @return the list
     */
    default <T1, T2, T3> Tuple3<T1, T2, T3> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Map<String, Object> args) {
        return querySingle(sql, elementType1, elementType2, elementType3, (Tuple3<String, String, String>) null, args);
    }

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3> Tuple3<T1, T2, T3> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Map<String, Object> args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param args         the args
     * @return the list
     */
    default <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> querySingle(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Map<String, Object> args) {
        return querySingle(sql, elementType1, elementType2, elementType3, elementType4,
                (Tuple4<String, String, String, String>) null, args);
    }

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Class<T4> elementType4, Tuple4<String, String, String, String> prefixes,
            Map<String, Object> args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param args         the args
     * @return the list
     */
    default <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> querySingle(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Map<String, Object> args) {
        return querySingle(sql, elementType1, elementType2, elementType3, elementType4, elementType5,
                (Tuple5<String, String, String, String, String>) null, args);
    }

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> querySingle(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> args);

    /**
     * Query single.
     *
     * @param <T>         generic type
     * @param sql         sql
     * @param elementType return object type
     * @param args        args
     * @return single elementType object
     */
    <T> T querySingle(String sql, Class<T> elementType, Object... args);

    //    /**
    //     * Query single.
    //     *
    //     * @param <T1>         the generic type
    //     * @param <T2>         the generic type
    //     * @param sql          the sql
    //     * @param elementType1 the element type 1
    //     * @param elementType2 the element type 2
    //     * @param args         the args
    //     * @return the tuple 2
    //     */
    //    <T1, T2> Tuple2<T1, T2> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2, Object... args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param args         the args
     * @return the tuple 2
     */
    default <T1, T2> Tuple2<T1, T2> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Object... args) {
        return querySingle(sql, elementType1, elementType2, (Tuple2<String, String>) null, args);
    }

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes     the prefixes of mapping element type
     * @param args         the args
     * @return the tuple 2
     */
    <T1, T2> Tuple2<T1, T2> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Object... args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param args         the args
     * @return the list
     */
    default <T1, T2, T3> Tuple3<T1, T2, T3> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Object... args) {
        return querySingle(sql, elementType1, elementType2, elementType3, (Tuple3<String, String, String>) null, args);
    }

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3> Tuple3<T1, T2, T3> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Object... args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param args         the args
     * @return the list
     */
    default <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> querySingle(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Object... args) {
        return querySingle(sql, elementType1, elementType2, elementType3, elementType4,
                (Tuple4<String, String, String, String>) null, args);
    }

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Class<T4> elementType4, Tuple4<String, String, String, String> prefixes,
            Object... args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param args         the args
     * @return the list
     */
    default <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> querySingle(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Object... args) {
        return querySingle(sql, elementType1, elementType2, elementType3, elementType4, elementType5,
                (Tuple5<String, String, String, String, String>) null, args);
    }

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> querySingle(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Object... args);
}
