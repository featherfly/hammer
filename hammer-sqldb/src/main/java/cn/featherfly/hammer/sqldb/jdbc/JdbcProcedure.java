
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
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import cn.featherfly.common.tuple.MutableTuple;
import cn.featherfly.common.tuple.Tuple;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.repository.MulitiQuery;
import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper;
import cn.featherfly.common.repository.mapper.MulitiQueryTupleMapperBuilder;
import cn.featherfly.common.repository.mapper.RowMapper;

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
     * @return LogicExpressionist
     */
    int call(String name, Serializable... args);

    //    /**
    //     * call procedure .
    //     *
    //     * @param name the procedure name
    //     * @param args the args
    //     * @return LogicExpressionist
    //     */
    //    int call(String name, SequencedMap<String, Object> args);
    //    如果map不按照参数顺序设置，则会报错，因为无法从metadata中获取参数的名称（只能获取顺序）
    //    所以都需要按照顺序设置了，则还设置名称是多余的

    /**
     * call procedure .
     *
     * @param <T> the generic type
     * @param name the procedure name
     * @param args the args
     * @return LogicExpressionist
     */
    <T extends MutableTuple> int call(String name, T args);

    //    /**
    //     * call procedure .
    //     *
    //     * @param name the procedure name
    //     * @param args the args
    //     * @return LogicExpressionist
    //     */
    //    int call(String name, Map<String, Object> args);

    /**
     * call procedure query.
     *
     * @param name the procedure name
     * @param args the args
     * @return LogicExpressionist
     */
    List<Map<String, Serializable>> callQuery(String name, Serializable... args);

    /**
     * call procedure query.
     *
     * @param <T> the generic type
     * @param name the procedure name
     * @param elementType the element type
     * @param args the args
     * @return LogicExpressionist
     */
    <T> List<T> callQuery(String name, Class<T> elementType, Serializable... args);

    /**
     * call procedure query.
     *
     * @param <E> the element type
     * @param name the procedure name
     * @param mapper the mapper
     * @param args the args
     * @return LogicExpressionist
     */
    <E> List<E> callQuery(String name, RowMapper<E> mapper, Serializable... args);

    /**
     * call procedure muliti-query. lazy load data at {@link MulitiQuery#next()}, so the caller
     * needs to close the MulitiQuery object manually.
     *
     * <pre>
     * <code>
     * // use try with resource, auto close
     * try (MulitiQuery query = jdbc.callMultiQuery("procedurename", params)) {
     *      while (query.hasNext()) {
     *          Map&lt;String,Object&gt; map = query.next();
     *          // or
     *          User user =  query.next(User.class);
     *          // or
     *          RowMapper&lt;User&gt; userRowMapper = new ... // your custome RowMapper
     *          User user =  query.next(userRowMapper);
     *      }
     * } catch (Exception e) {
     *       // Logic for handling exceptions
     * }
     * </code>
     * </pre>
     *
     * @param name the procedure name
     * @param args the args
     * @return muliti-query object
     */
    MulitiQuery callMultiQuery(String name, Serializable... args);

    /**
     * call procedure muliti-query.
     *
     * @param <T> the generic type
     * @param name the procedure name
     * @param mapperFunction the mapper function
     * @param args the args
     * @return muliti-query object
     */
    <T extends Tuple> T callMultiQuery(String name,
        Function<MulitiQueryTupleMapperBuilder, MulitiQueryRowMapper<T>> mapperFunction, Serializable... args);

    //    /**
    //     * call procedure muliti-query.
    //     *
    //     * @param <E> the element type
    //     * @param name the procedure name
    //     * @param mapper the mapper
    //     * @param args the args
    //     * @return LogicExpressionist
    //     */
    //    <E> List<E> callMultiQuery(String name, RowMapper<E> mapper, Serializable...args);
    //
    //    /**
    //     * call procedure muliti-query.
    //     *
    //     * @param <T> the generic type
    //     * @param name the procedure name
    //     * @param elementType the element type
    //     * @param args the args
    //     * @return LogicExpressionist
    //     */
    //    <T> List<T> callMultiQuery(String name, Class<T> elementType, Serializable...args);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2> List<Tuple2<T1, T2>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
        Serializable... args) {
        return callQuery(name, elementType1, elementType2, (Tuple2<String, String>) null, args);
    }

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    <T1, T2> List<Tuple2<T1, T2>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
        Tuple2<String, String> prefixes, Serializable... args);

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3> List<Tuple3<T1, T2, T3>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
        Class<T3> elementType3, Serializable... args) {
        return callQuery(name, elementType1, elementType2, elementType3, (Tuple3<String, String, String>) null, args);
    }

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    <T1, T2, T3> List<Tuple3<T1, T2, T3>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
        Class<T3> elementType3, Tuple3<String, String, String> prefixes, Serializable... args);

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> callQuery(String name, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Serializable... args) {
        return callQuery(name, elementType1, elementType2, elementType3, elementType4,
            (Tuple4<String, String, String, String>) null, args);
    }

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
        Class<T3> elementType3, Class<T4> elementType4, Tuple4<String, String, String, String> prefixes,
        Serializable... args);

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param args the args
     * @return LogicExpressionist
     */
    default <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> callQuery(String name, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Serializable... args) {
        return callQuery(name, elementType1, elementType2, elementType3, elementType4, elementType5,
            (Tuple5<String, String, String, String, String>) null, args);
    }

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes the prefixes
     * @param args the args
     * @return LogicExpressionist
     */
    <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> callQuery(String name, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... args);

    /**
     * call procedure query.
     *
     * @param name the procedure name
     * @param args the args
     * @return LogicExpressionist
     */
    Map<String, Serializable> callQuerySingle(String name, Serializable... args);

    /**
     * call procedure query.
     *
     * @param <E> the element type
     * @param name the procedure name
     * @param mapper the mapper
     * @param args the args
     * @return LogicExpressionist
     */
    <E> E callQuerySingle(String name, RowMapper<E> mapper, Serializable... args);

    /**
     * call procedure query.
     *
     * @param <T> the generic type
     * @param name the procedure name
     * @param elementType the element type
     * @param args the args
     * @return the t
     */
    <T> T callQuerySingle(String name, Class<T> elementType, Serializable... args);

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param args the args
     * @return the tuple 2
     */
    default <T1, T2> Tuple2<T1, T2> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
        Serializable... args) {
        return callQuerySingle(name, elementType1, elementType2, (Tuple2<String, String>) null, args);
    }

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes the prefixes
     * @param args the args
     * @return the tuple 2
     */
    <T1, T2> Tuple2<T1, T2> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
        Tuple2<String, String> prefixes, Serializable... args);

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param args the args
     * @return the tuple 3
     */
    default <T1, T2, T3> Tuple3<T1, T2, T3> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
        Class<T3> elementType3, Serializable... args) {
        return callQuerySingle(name, elementType1, elementType2, elementType3, (Tuple3<String, String, String>) null,
            args);
    }

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes the prefixes
     * @param args the args
     * @return the tuple 3
     */
    <T1, T2, T3> Tuple3<T1, T2, T3> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
        Class<T3> elementType3, Tuple3<String, String, String> prefixes, Serializable... args);

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param args the args
     * @return the tuple 4
     */
    default <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> callQuerySingle(String name, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Serializable... args) {
        return callQuerySingle(name, elementType1, elementType2, elementType3, elementType4,
            (Tuple4<String, String, String, String>) null, args);
    }

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes the prefixes
     * @param args the args
     * @return the tuple 4
     */
    <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
        Class<T3> elementType3, Class<T4> elementType4, Tuple4<String, String, String, String> prefixes,
        Serializable... args);

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param args the args
     * @return the tuple 5
     */
    default <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> callQuerySingle(String name, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Serializable... args) {
        return callQuerySingle(name, elementType1, elementType2, elementType3, elementType4, elementType5,
            (Tuple5<String, String, String, String, String>) null, args);
    }

    /**
     * call procedure query.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param name the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes the prefixes
     * @param args the args
     * @return the tuple 5
     */
    <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> callQuerySingle(String name, Class<T1> elementType1,
        Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
        Tuple5<String, String, String, String, String> prefixes, Serializable... args);

}
