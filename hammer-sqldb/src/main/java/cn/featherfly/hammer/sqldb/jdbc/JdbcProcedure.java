
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

import java.util.List;
import java.util.Map;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.repository.mapping.RowMapper;

/**
 * jdbc procedure.
 *
 * @author zhongj
 */
public interface JdbcProcedure {

    /**
     * call procedure .
     *
     * @param name the procedure name
     * @param args the args
     * @return the list
     */
    int call(String name, Object... args);

    //    /**
    //     * call procedure .
    //     *
    //     * @param name the procedure name
    //     * @param args the args
    //     * @return the list
    //     */
    //    int call(String name, Map<String, Object> args);

    /**
     * call procedure query.
     *
     * @param name the procedure name
     * @param args the args
     * @return the list
     */
    List<Map<String, Object>> callQuery(String name, Object... args);

    /**
     * call procedure query.
     *
     * @param <E>    the element type
     * @param name   the procedure name
     * @param mapper the mapper
     * @param args   the args
     * @return the list
     */
    <E> List<E> callQuery(String name, RowMapper<E> mapper, Object... args);

    /**
     * call procedure query.
     *
     * @param <T>         the generic type
     * @param name        the procedure name
     * @param elementType the element type
     * @param args        the args
     * @return the list
     */
    <T> List<T> callQuery(String name, Class<T> elementType, Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param args         the args
     * @return the list
     */
    default <T1, T2> List<Tuple2<T1, T2>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
            Object... args) {
        return callQuery(name, elementType1, elementType2, (Tuple2<String, String>) null, args);
    }

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2> List<Tuple2<T1, T2>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param args         the args
     * @return the list
     */
    default <T1, T2, T3> List<Tuple3<T1, T2, T3>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Object... args) {
        return callQuery(name, elementType1, elementType2, elementType3, (Tuple3<String, String, String>) null, args);
    }

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3> List<Tuple3<T1, T2, T3>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param args         the args
     * @return the list
     */
    default <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> callQuery(String name, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Object... args) {
        return callQuery(name, elementType1, elementType2, elementType3, elementType4,
                (Tuple4<String, String, String, String>) null, args);
    }

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Class<T4> elementType4, Tuple4<String, String, String, String> prefixes,
            Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param args         the args
     * @return the list
     */
    default <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> callQuery(String name, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Object... args) {
        return callQuery(name, elementType1, elementType2, elementType3, elementType4, elementType5,
                (Tuple5<String, String, String, String, String>) null, args);
    }

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> callQuery(String name, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Object... args);

    /**
     * call procedure query.
     *
     * @param name the procedure name
     * @param args the args
     * @return the list
     */
    Map<String, Object> callQuerySingle(String name, Object... args);

    /**
     * call procedure query.
     *
     * @param <E>    the element type
     * @param name   the procedure name
     * @param mapper the mapper
     * @param args   the args
     * @return the list
     */
    <E> E callQuerySingle(String name, RowMapper<E> mapper, Object... args);

    /**
     * call procedure query.
     *
     * @param <T>         the generic type
     * @param name        the procedure name
     * @param elementType the element type
     * @param args        the args
     * @return the t
     */
    <T> T callQuerySingle(String name, Class<T> elementType, Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param args         the args
     * @return the tuple 2
     */
    default <T1, T2> Tuple2<T1, T2> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
            Object... args) {
        return callQuerySingle(name, elementType1, elementType2, (Tuple2<String, String>) null, args);
    }

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the tuple 2
     */
    <T1, T2> Tuple2<T1, T2> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the tuple 3
     */
    default <T1, T2, T3> Tuple3<T1, T2, T3> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Object... args) {
        return callQuerySingle(name, elementType1, elementType2, elementType3, (Tuple3<String, String, String>) null,
                args);
    }

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the tuple 3
     */
    <T1, T2, T3> Tuple3<T1, T2, T3> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the tuple 4
     */
    default <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> callQuerySingle(String name, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Object... args) {
        return callQuerySingle(name, elementType1, elementType2, elementType3, elementType4,
                (Tuple4<String, String, String, String>) null, args);
    }

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the tuple 4
     */
    <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Class<T4> elementType4, Tuple4<String, String, String, String> prefixes,
            Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param args         the args
     * @return the tuple 5
     */
    default <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> callQuerySingle(String name, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Object... args) {
        return callQuerySingle(name, elementType1, elementType2, elementType3, elementType4, elementType5,
                (Tuple5<String, String, String, String, String>) null, args);
    }

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the tuple 5
     */
    <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> callQuerySingle(String name, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Object... args);

}
