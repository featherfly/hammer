
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
import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.repository.mapping.RowMapper;

/**
 * The Interface JdbcQueryList.
 *
 * @author zhongj
 */
public interface JdbcQueryStream {
    /**
     * Query.
     *
     * @param sql  sql
     * @param args args
     * @return map list
     */
    Iterable<Map<String, Object>> queryStream(String sql, Object... args);

    /**
     * Query.
     *
     * @param sql  sql
     * @param args args
     * @return map list
     */
    Iterable<Map<String, Object>> queryStream(String sql, Map<String, Object> args);

    /**
     * Query.
     *
     * @param <T>       generic type
     * @param sql       sql
     * @param rowMapper rowMapper
     * @param args      args
     * @return elementType object list
     */
    <T> Iterable<T> queryStream(String sql, RowMapper<T> rowMapper, Object... args);

    //    /**
    //     * Query.
    //     *
    //     * @param <T>       the generic type
    //     * @param sql       the sql
    //     * @param rowMapper the row mapper
    //     * @param args      the args
    //     * @return the list
    //     */
    //    <T> Iterable<T> queryStream(String sql, RowMapper<T> rowMapper, BeanPropertyValue<?>... args);

    /**
     * Query.
     *
     * @param <T>         generic type
     * @param sql         sql
     * @param elementType return object type
     * @param args        args
     * @return elementType object list
     */
    <T> Iterable<T> queryStream(String sql, Class<T> elementType, Object... args);

    /**
     * Query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param args         the args
     * @return the list
     */
    default <T1, T2> Iterable<Tuple2<T1, T2>> queryStream(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Object... args) {
        return queryStream(sql, elementType1, elementType2, (Tuple2<String, String>) null, args);
    }

    /**
     * Query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2> Iterable<Tuple2<T1, T2>> queryStream(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Object... args);

    /**
     * Query.
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
    default <T1, T2, T3> Iterable<Tuple3<T1, T2, T3>> queryStream(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Object... args) {
        return queryStream(sql, elementType1, elementType2, elementType3, (Tuple3<String, String, String>) null, args);
    }

    /**
     * Query.
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
    <T1, T2, T3> Iterable<Tuple3<T1, T2, T3>> queryStream(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Object... args);

    /**
     * Query.
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
    default <T1, T2, T3, T4> Iterable<Tuple4<T1, T2, T3, T4>> queryStream(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Object... args) {
        return queryStream(sql, elementType1, elementType2, elementType3, elementType4,
                (Tuple4<String, String, String, String>) null, args);
    }

    /**
     * Query.
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
    <T1, T2, T3, T4> Iterable<Tuple4<T1, T2, T3, T4>> queryStream(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
            Tuple4<String, String, String, String> prefixes, Object... args);

    /**
     * Query.
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
    default <T1, T2, T3, T4, T5> Iterable<Tuple5<T1, T2, T3, T4, T5>> queryStream(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Object... args) {
        return queryStream(sql, elementType1, elementType2, elementType3, elementType4, elementType5,
                (Tuple5<String, String, String, String, String>) null, args);
    }

    /**
     * Query.
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
    <T1, T2, T3, T4, T5> Iterable<Tuple5<T1, T2, T3, T4, T5>> queryStream(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Object... args);

    /**
     * Query .
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param <T6>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param elementType6 the element type 6
     * @param args         the args
     * @return the list
     */
    default <T1, T2, T3, T4, T5, T6> Iterable<Tuple6<T1, T2, T3, T4, T5, T6>> queryStream(String sql,
            Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
            Class<T5> elementType5, Class<T6> elementType6, Object... args) {
        return queryStream(sql, elementType1, elementType2, elementType3, elementType4, elementType5, elementType6,
                (Tuple6<String, String, String, String, String, String>) null, args);
    }

    /**
     * Query .
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param <T6>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param elementType6 the element type 6
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4, T5, T6> Iterable<Tuple6<T1, T2, T3, T4, T5, T6>> queryStream(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Class<T6> elementType6, Tuple6<String, String, String, String, String, String> prefixes, Object... args);

    //    /**
    //     * Query.
    //     *
    //     * @param <T>         the generic type
    //     * @param sql         the sql
    //     * @param elementType the element type
    //     * @param args        the args
    //     * @return the list
    //     */
    //    <T> Iterable<T> queryStream(String sql, Class<T> elementType, BeanPropertyValue<?>... args);

    /**
     * Query.
     *
     * @param <T>       generic type
     * @param sql       sql
     * @param rowMapper rowMapper
     * @param args      args
     * @return elementType object list
     */
    <T> Iterable<T> queryStream(String sql, RowMapper<T> rowMapper, Map<String, Object> args);

    /**
     * Query.
     *
     * @param <T>         generic type
     * @param sql         sql
     * @param elementType return object type
     * @param args        args
     * @return elementType object list
     */
    <T> Iterable<T> queryStream(String sql, Class<T> elementType, Map<String, Object> args);

    /**
     * Query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param args         the args
     * @return the list
     */
    default <T1, T2> Iterable<Tuple2<T1, T2>> queryStream(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Map<String, Object> args) {
        return queryStream(sql, elementType1, elementType2, (Tuple2<String, String>) null, args);
    }

    /**
     * Query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2> Iterable<Tuple2<T1, T2>> queryStream(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Map<String, Object> args);

    /**
     * Query.
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
    default <T1, T2, T3> Iterable<Tuple3<T1, T2, T3>> queryStream(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Map<String, Object> args) {
        return queryStream(sql, elementType1, elementType2, elementType3, (Tuple3<String, String, String>) null, args);
    }

    /**
     * Query.
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
    <T1, T2, T3> Iterable<Tuple3<T1, T2, T3>> queryStream(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Map<String, Object> args);

    /**
     * Query.
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
    default <T1, T2, T3, T4> Iterable<Tuple4<T1, T2, T3, T4>> queryStream(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Map<String, Object> args) {
        return queryStream(sql, elementType1, elementType2, elementType3, elementType4,
                (Tuple4<String, String, String, String>) null, args);
    }

    /**
     * Query.
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
    <T1, T2, T3, T4> Iterable<Tuple4<T1, T2, T3, T4>> queryStream(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> args);

    /**
     * Query.
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
    default <T1, T2, T3, T4, T5> Iterable<Tuple5<T1, T2, T3, T4, T5>> queryStream(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Map<String, Object> args) {
        return queryStream(sql, elementType1, elementType2, elementType3, elementType4, elementType5,
                (Tuple5<String, String, String, String, String>) null, args);
    }

    /**
     * Query.
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
    <T1, T2, T3, T4, T5> Iterable<Tuple5<T1, T2, T3, T4, T5>> queryStream(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> args);

    /**
     * Query .
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param <T6>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param elementType6 the element type 6
     * @param args         the args
     * @return the list
     */
    default <T1, T2, T3, T4, T5, T6> Iterable<Tuple6<T1, T2, T3, T4, T5, T6>> queryStream(String sql,
            Class<T1> elementType1, Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4,
            Class<T5> elementType5, Class<T6> elementType6, Map<String, Object> args) {
        return queryStream(sql, elementType1, elementType2, elementType3, elementType4, elementType5, elementType6,
                (Tuple6<String, String, String, String, String, String>) null, args);
    }

    /**
     * Query .
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param <T6>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param elementType6 the element type 6
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4, T5, T6> Iterable<Tuple6<T1, T2, T3, T4, T5, T6>> queryStream(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Class<T6> elementType6, Tuple6<String, String, String, String, String, String> prefixes,
            Map<String, Object> args);
}
