
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-10 19:48:10
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.common.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;
import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;

/**
 * QueryExecutor.
 *
 * @author      zhongj
 * @param  <E0> the generic type
 */
public interface ArrayParamsQueryExecutor<E0> {

    /**
     * query boolean value, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @return           boolean
     */
    boolean bool(E0 execution, Object... params);

    /**
     * query int value, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @return           int
     */
    int intValue(E0 execution, Object... params);

    /**
     * query long value, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @return           long
     */
    long longValue(E0 execution, Object... params);

    /**
     * query double value, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @return           double
     */
    double doubleValue(E0 execution, Object... params);

    /**
     * query value, use query str in template find with executeId.
     *
     * @param  <V>       the value type
     * @param  execution the execution
     * @param  valueType the value type
     * @param  params    the params
     * @return           value
     */
    <V> V value(E0 execution, Class<V> valueType, Object... params);

    /**
     * query number value, use query str in template find with executeId.
     *
     * @param  <N>        the number type
     * @param  execution  the execution
     * @param  numberType the number type
     * @param  params     the params
     * @return            number value
     */
    default <N extends Number> N number(E0 execution, Class<N> numberType, Object... params) {
        return value(execution, numberType, params);
    }

    /**
     * query int value, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @return           Integer
     */
    default Integer numberInt(E0 execution, Object... params) {
        return value(execution, Integer.class, params);
    }

    /**
     * query long value, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @return           Long
     */
    default Long numberLong(E0 execution, Object... params) {
        return value(execution, Long.class, params);
    }

    /**
     * query double value, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @return           BigDecimal
     */
    default Double numberDouble(E0 execution, Object... params) {
        return value(execution, Double.class, params);
    }

    /**
     * query BigInteger value, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @return           BigInteger
     */
    default BigInteger numberBigInteger(E0 execution, Object... params) {
        return value(execution, BigInteger.class, params);
    }

    /**
     * query BigDecimal value, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @return           BigDecimal
     */
    default BigDecimal numberBigDecimal(E0 execution, Object... params) {
        return value(execution, BigDecimal.class, params);
    }

    /**
     * query boolean value, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @return           boolean
     */
    default Boolean boolType(E0 execution, Object... params) {
        return value(execution, Boolean.class, params);
    }

    /**
     * query string value, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @return           String
     */
    default String string(E0 execution, Object... params) {
        return value(execution, String.class, params);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @return           map
     */
    Map<String, Object> single(E0 execution, Object... params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T>       the generic type
     * @param  execution the execution
     * @param  mapType   mapping type
     * @param  params    the params
     * @return           entity
     */
    <T> T single(E0 execution, Class<T> mapType, Object... params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  params    the params
     * @return           the tuple 2
     */
    default <T1, T2> Tuple2<T1, T2> single(E0 execution, Class<T1> mapType1, Class<T2> mapType2, Object... params) {
        return single(execution, mapType1, mapType2, (Tuple2<String, String>) null, params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  execution the tpl execute id
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @return           the tuple 2
     */
    <T1, T2> Tuple2<T1, T2> single(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Object... params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  params    the params
     * @return           the tuple 3
     */
    default <T1, T2, T3> Tuple3<T1, T2, T3> single(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Object... params) {
        return single(execution, mapType1, mapType2, mapType3, (Tuple3<String, String, String>) null, params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @return           the tuple 3
     */
    <T1, T2, T3> Tuple3<T1, T2, T3> single(E0 execution, Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3,
        Tuple3<String, String, String> prefixes, Object... params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  params    the params
     * @return           the tuple 4
     */
    default <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> single(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Object... params) {
        return single(execution, mapType1, mapType2, mapType3, mapType4, (Tuple4<String, String, String, String>) null,
            params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @return           the tuple 4
     */
    <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> single(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes, Object... params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  params    the params
     * @return           the tuple 5
     */
    default <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> single(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Object... params) {
        return single(execution, mapType1, mapType2, mapType3, mapType4, mapType5,
            (Tuple5<String, String, String, String, String>) null, params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @return           the tuple 5
     */
    <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> single(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Object... params);

    /**
     * Single.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  <T6>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  mapType6  mapping type 6
     * @param  params    the params
     * @return           the tuple 6
     */
    default <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> single(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Object... params) {
        return single(execution, mapType1, mapType2, mapType3, mapType4, mapType5, mapType6,
            (Tuple6<String, String, String, String, String, String>) null, params);
    }

    /**
     * Single.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  <T6>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  mapType6  mapping type 6
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @return           the tuple 6
     */
    <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> single(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Tuple6<String, String, String, String, String, String> prefixes, Object... params);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @return           map
     */
    Map<String, Object> unique(E0 execution, Object... params);

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param  <T>       the element type
     * @param  execution the execution
     * @param  mapType   mapping type
     * @param  params    the params
     * @return           entity
     */
    <T> T unique(E0 execution, Class<T> mapType, Object... params);

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  params    the params
     * @return           the tuple 2
     */
    default <T1, T2> Tuple2<T1, T2> unique(E0 execution, Class<T1> mapType1, Class<T2> mapType2, Object... params) {
        return unique(execution, mapType1, mapType2, (Tuple2<String, String>) null, params);
    }

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @return           the tuple 2
     */
    <T1, T2> Tuple2<T1, T2> unique(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Object... params);

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  params    the params
     * @return           the tuple 3
     */
    default <T1, T2, T3> Tuple3<T1, T2, T3> unique(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Object... params) {
        return unique(execution, mapType1, mapType2, mapType3, (Tuple3<String, String, String>) null, params);
    }

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @return           the tuple 3
     */
    <T1, T2, T3> Tuple3<T1, T2, T3> unique(E0 execution, Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3,
        Tuple3<String, String, String> prefixes, Object... params);

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  params    the params
     * @return           the tuple 4
     */
    default <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> unique(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Object... params) {
        return unique(execution, mapType1, mapType2, mapType3, mapType4, (Tuple4<String, String, String, String>) null,
            params);
    }

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @return           the tuple 4
     */
    <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> unique(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes, Object... params);

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  params    the params
     * @return           the tuple 5
     */
    default <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> unique(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Object... params) {
        return unique(execution, mapType1, mapType2, mapType3, mapType4, mapType5,
            (Tuple5<String, String, String, String, String>) null, params);
    }

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @return           the tuple 5
     */
    <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> unique(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Object... params);

    /**
     * Unique.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  <T6>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  mapType6  mapping type 6
     * @param  params    the params
     * @return           the tuple 6
     */
    default <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> unique(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Object... params) {
        return unique(execution, mapType1, mapType2, mapType3, mapType4, mapType5, mapType6,
            (Tuple6<String, String, String, String, String, String>) null, params);
    }

    /**
     * Unique.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  <T6>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  mapType6  mapping type 6
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @return           the tuple 6
     */
    <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> unique(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Tuple6<String, String, String, String, String, String> prefixes, Object... params);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * query list, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @return           map list
     */
    List<Map<String, Object>> list(E0 execution, Object... params);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param  <T>       the element type
     * @param  execution the execution
     * @param  mapType   mapping type
     * @param  params    the params
     * @return           entity list
     */
    <T> List<T> list(E0 execution, Class<T> mapType, Object... params);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           map list
     */
    List<Map<String, Object>> list(E0 execution, Object[] params, int offset, int limit);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param  <T>       the element type
     * @param  execution the execution
     * @param  mapType   mapping type
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           entity list
     */
    <T> List<T> list(E0 execution, Class<T> mapType, Object[] params, int offset, int limit);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param  <T>       the element type
     * @param  execution the execution
     * @param  mapType   mapping type
     * @param  params    the params
     * @param  page      the page
     * @return           entity list
     */
    default <T> List<T> list(E0 execution, Class<T> mapType, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return list(execution, mapType, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query list, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @param  page      the page
     * @return           map list
     */
    default List<Map<String, Object>> list(E0 execution, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return list(execution, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  params    the params
     * @return           tuple2 list
     */
    default <T1, T2> List<Tuple2<T1, T2>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2, Object... params) {
        return list(execution, mapType1, mapType2, (Tuple2<String, String>) null, params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple2 list
     */
    default <T1, T2> List<Tuple2<T1, T2>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2, Object[] params,
        int offset, int limit) {
        return list(execution, mapType1, mapType2, (Tuple2<String, String>) null, params, offset, limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  params    the params
     * @param  page      the page
     * @return           tuple2 list
     */
    default <T1, T2> List<Tuple2<T1, T2>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2, Object[] params,
        Page page) {
        Limit limit = new Limit(page);
        return list(execution, mapType1, mapType2, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @return           tuple2 list
     */
    <T1, T2> List<Tuple2<T1, T2>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Object... params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple2 list
     */
    <T1, T2> List<Tuple2<T1, T2>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Object[] params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  page      the page
     * @return           tuple2 list
     */
    default <T1, T2> List<Tuple2<T1, T2>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return list(execution, mapType1, mapType2, prefixes, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  params    the params
     * @return           tuple3 list
     */
    default <T1, T2, T3> List<Tuple3<T1, T2, T3>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Object... params) {
        return list(execution, mapType1, mapType2, mapType3, (Tuple3<String, String, String>) null, params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple3 list
     */
    default <T1, T2, T3> List<Tuple3<T1, T2, T3>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Object[] params, int offset, int limit) {
        return list(execution, mapType1, mapType2, mapType3, (Tuple3<String, String, String>) null, params, offset,
            limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  params    the params
     * @param  page      the page
     * @return           tuple3 list
     */
    default <T1, T2, T3> List<Tuple3<T1, T2, T3>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return list(execution, mapType1, mapType2, mapType3, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @return           tuple3 list
     */
    <T1, T2, T3> List<Tuple3<T1, T2, T3>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3,
        Tuple3<String, String, String> prefixes, Object... params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple3 list
     */
    <T1, T2, T3> List<Tuple3<T1, T2, T3>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3,
        Tuple3<String, String, String> prefixes, Object[] params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  page      the page
     * @return           tuple3 list
     */
    default <T1, T2, T3> List<Tuple3<T1, T2, T3>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Tuple3<String, String, String> prefixes, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return list(execution, mapType1, mapType2, mapType3, prefixes, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  params    the params
     * @return           tuple4 list
     */
    default <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Object... params) {
        return list(execution, mapType1, mapType2, mapType3, mapType4, (Tuple4<String, String, String, String>) null,
            params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple4 list
     */
    default <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Object[] params, int offset, int limit) {
        return list(execution, mapType1, mapType2, mapType3, mapType4, (Tuple4<String, String, String, String>) null,
            params, offset, limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  params    the params
     * @param  page      the page
     * @return           tuple4 list
     */
    default <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return list(execution, mapType1, mapType2, mapType3, mapType4, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @return           tuple4 list
     */
    <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes, Object... params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple4 list
     */
    <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes, Object[] params,
        int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  page      the page
     * @return           tuple4 list
     */
    default <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes, Object[] params,
        Page page) {
        Limit limit = new Limit(page);
        return list(execution, mapType1, mapType2, mapType3, mapType4, prefixes, params, limit.getOffset(),
            limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  params    the params
     * @return           tuple5 list
     */
    default <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> list(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Object... params) {
        return list(execution, mapType1, mapType2, mapType3, mapType4, mapType5,
            (Tuple5<String, String, String, String, String>) null, params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @return           tuple5 list
     */
    <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Object... params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple5 list
     */
    default <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> list(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Object[] params, int offset,
        int limit) {
        return list(execution, mapType1, mapType2, mapType3, mapType4, mapType5,
            (Tuple5<String, String, String, String, String>) null, params, offset, limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  params    the params
     * @param  page      the page
     * @return           tuple5 list
     */
    default <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> list(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return list(execution, mapType1, mapType2, mapType3, mapType4, mapType5, params, limit.getOffset(),
            limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple5 list
     */
    <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> list(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Object[] params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  page      the page
     * @return           tuple5 list
     */
    default <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> list(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return list(execution, mapType1, mapType2, mapType3, mapType4, mapType5, prefixes, params, limit.getOffset(),
            limit.getLimit());
    }

    /**
     * List.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  <T6>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  mapType6  mapping type 6
     * @param  params    the params
     * @return           LogicExpressionist
     */
    default <T1, T2, T3, T4, T5, T6> List<Tuple6<T1, T2, T3, T4, T5, T6>> list(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Object... params) {
        return list(execution, mapType1, mapType2, mapType3, mapType4, mapType5, mapType6,
            (Tuple6<String, String, String, String, String, String>) null, params);
    }

    /**
     * List.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  <T6>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  mapType6  mapping type 6
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           LogicExpressionist
     */
    default <T1, T2, T3, T4, T5, T6> List<Tuple6<T1, T2, T3, T4, T5, T6>> list(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Object[] params, int offset, int limit) {
        return list(execution, mapType1, mapType2, mapType3, mapType4, mapType5, mapType6,
            (Tuple6<String, String, String, String, String, String>) null, params, offset, limit);
    }

    /**
     * List.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  <T6>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  mapType6  mapping type 6
     * @param  params    the params
     * @param  page      the page
     * @return           LogicExpressionist
     */
    default <T1, T2, T3, T4, T5, T6> List<Tuple6<T1, T2, T3, T4, T5, T6>> list(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Object[] params, Page page) {
        Limit limit = new Limit(page);
        return list(execution, mapType1, mapType2, mapType3, mapType4, mapType5, mapType6, params, limit.getOffset(),
            limit.getLimit());
    }

    /**
     * List.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  <T6>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  mapType6  mapping type 6
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @return           LogicExpressionist
     */
    <T1, T2, T3, T4, T5, T6> List<Tuple6<T1, T2, T3, T4, T5, T6>> list(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Tuple6<String, String, String, String, String, String> prefixes, Object... params);

    /**
     * List.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  <T6>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  mapType6  mapping type 6
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           LogicExpressionist
     */
    <T1, T2, T3, T4, T5, T6> List<Tuple6<T1, T2, T3, T4, T5, T6>> list(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Tuple6<String, String, String, String, String, String> prefixes, Object[] params, int offset, int limit);

    /**
     * List.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  <T6>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  mapType6  mapping type 6
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  page      the page
     * @return           LogicExpressionist
     */
    default <T1, T2, T3, T4, T5, T6> List<Tuple6<T1, T2, T3, T4, T5, T6>> list(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5, Class<T6> mapType6,
        Tuple6<String, String, String, String, String, String> prefixes, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return list(execution, mapType1, mapType2, mapType3, mapType4, mapType5, mapType6, prefixes, params,
            limit.getOffset(), limit.getLimit());
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * query page, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           map pagination
     */
    PaginationResults<Map<String, Object>> pagination(E0 execution, Object[] params, int offset, int limit);

    /**
     * query page, use query str in template find with executeId.
     *
     * @param  execution the execution
     * @param  params    the params
     * @param  page      the page
     * @return           map pagination
     */
    default PaginationResults<Map<String, Object>> pagination(E0 execution, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return pagination(execution, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query page, use query str in template find with executeId.
     *
     * @param  <T>       the element type
     * @param  execution the execution
     * @param  mapType   mapping type
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           entity pagination
     */
    <T> PaginationResults<T> pagination(E0 execution, Class<T> mapType, Object[] params, int offset, int limit);

    /**
     * query page, use query str in template find with executeId.
     *
     * @param  <T>       the element type
     * @param  execution the execution
     * @param  mapType   mapping type
     * @param  params    the params
     * @param  page      the page
     * @return           entity pagination
     */
    default <T> PaginationResults<T> pagination(E0 execution, Class<T> mapType, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return pagination(execution, mapType, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple2 pagination
     */
    default <T1, T2> PaginationResults<Tuple2<T1, T2>> pagination(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Object[] params, int offset, int limit) {
        return pagination(execution, mapType1, mapType2, (Tuple2<String, String>) null, params, offset, limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  params    the params
     * @param  page      the page
     * @return           tuple2 pagination
     */
    default <T1, T2> PaginationResults<Tuple2<T1, T2>> pagination(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Object[] params, Page page) {
        Limit limit = new Limit(page);
        return pagination(execution, mapType1, mapType2, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple2 pagination
     */
    <T1, T2> PaginationResults<Tuple2<T1, T2>> pagination(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Object[] params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  page      the page
     * @return           tuple2 pagination
     */
    default <T1, T2> PaginationResults<Tuple2<T1, T2>> pagination(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Tuple2<String, String> prefixes, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return pagination(execution, mapType1, mapType2, prefixes, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple3 pagination
     */
    default <T1, T2, T3> PaginationResults<Tuple3<T1, T2, T3>> pagination(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Object[] params, int offset, int limit) {
        return pagination(execution, mapType1, mapType2, mapType3, (Tuple3<String, String, String>) null, params,
            offset, limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  params    the params
     * @param  page      the page
     * @return           tuple3 pagination
     */
    default <T1, T2, T3> PaginationResults<Tuple3<T1, T2, T3>> pagination(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return pagination(execution, mapType1, mapType2, mapType3, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple3 pagination
     */
    <T1, T2, T3> PaginationResults<Tuple3<T1, T2, T3>> pagination(E0 execution, Class<T1> mapType1, Class<T2> mapType2,
        Class<T3> mapType3, Tuple3<String, String, String> prefixes, Object[] params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  page      the page
     * @return           tuple3 pagination
     */
    default <T1, T2, T3> PaginationResults<Tuple3<T1, T2, T3>> pagination(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Tuple3<String, String, String> prefixes, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return pagination(execution, mapType1, mapType2, mapType3, prefixes, params, limit.getOffset(),
            limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple4 pagination
     */
    default <T1, T2, T3, T4> PaginationResults<Tuple4<T1, T2, T3, T4>> pagination(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Object[] params, int offset, int limit) {
        return pagination(execution, mapType1, mapType2, mapType3, mapType4,
            (Tuple4<String, String, String, String>) null, params, offset, limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  params    the params
     * @param  page      the page
     * @return           tuple4 pagination
     */
    default <T1, T2, T3, T4> PaginationResults<Tuple4<T1, T2, T3, T4>> pagination(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return pagination(execution, mapType1, mapType2, mapType3, mapType4, params, limit.getOffset(),
            limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple4 pagination
     */
    <T1, T2, T3, T4> PaginationResults<Tuple4<T1, T2, T3, T4>> pagination(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes,
        Object[] params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  page      the page
     * @return           tuple4 pagination
     */
    default <T1, T2, T3, T4> PaginationResults<Tuple4<T1, T2, T3, T4>> pagination(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Tuple4<String, String, String, String> prefixes,
        Object[] params, Page page) {
        Limit limit = new Limit(page);
        return pagination(execution, mapType1, mapType2, mapType3, mapType4, prefixes, params, limit.getOffset(),
            limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple5 pagination
     */
    default <T1, T2, T3, T4, T5> PaginationResults<Tuple5<T1, T2, T3, T4, T5>> pagination(E0 execution,
        Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Object[] params, int offset, int limit) {
        return pagination(execution, mapType1, mapType2, mapType3, mapType4, mapType5,
            (Tuple5<String, String, String, String, String>) null, params, offset, limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  params    the params
     * @param  page      the page
     * @return           tuple5 pagination
     */
    default <T1, T2, T3, T4, T5> PaginationResults<Tuple5<T1, T2, T3, T4, T5>> pagination(E0 execution,
        Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Object[] params, Page page) {
        Limit limit = new Limit(page);
        return pagination(execution, mapType1, mapType2, mapType3, mapType4, mapType5, params, limit.getOffset(),
            limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           tuple5 pagination
     */
    <T1, T2, T3, T4, T5> PaginationResults<Tuple5<T1, T2, T3, T4, T5>> pagination(E0 execution, Class<T1> mapType1,
        Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Object[] params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  page      the page
     * @return           tuple5 pagination
     */
    default <T1, T2, T3, T4, T5> PaginationResults<Tuple5<T1, T2, T3, T4, T5>> pagination(E0 execution,
        Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Tuple5<String, String, String, String, String> prefixes, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return pagination(execution, mapType1, mapType2, mapType3, mapType4, mapType5, prefixes, params,
            limit.getOffset(), limit.getLimit());
    }

    /**
     * Pagination.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  <T6>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  mapType6  mapping type 6
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           the pagination results
     */
    default <T1, T2, T3, T4, T5, T6> PaginationResults<Tuple6<T1, T2, T3, T4, T5, T6>> pagination(E0 execution,
        Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Class<T6> mapType6, Object[] params, int offset, int limit) {
        return pagination(execution, mapType1, mapType2, mapType3, mapType4, mapType5, mapType6,
            (Tuple6<String, String, String, String, String, String>) null, params, offset, limit);
    }

    /**
     * Pagination.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  <T6>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  mapType6  mapping type 6
     * @param  params    the params
     * @param  page      the page
     * @return           the pagination results
     */
    default <T1, T2, T3, T4, T5, T6> PaginationResults<Tuple6<T1, T2, T3, T4, T5, T6>> pagination(E0 execution,
        Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Class<T6> mapType6, Object[] params, Page page) {
        Limit limit = new Limit(page);
        return pagination(execution, mapType1, mapType2, mapType3, mapType4, mapType5, mapType6, params,
            limit.getOffset(), limit.getLimit());
    }

    /**
     * Pagination.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  <T6>      the generic type
     * @param  execution the execution
     * @param  mapType1  mapping type 1
     * @param  mapType2  mapping type 2
     * @param  mapType3  mapping type 3
     * @param  mapType4  mapping type 4
     * @param  mapType5  mapping type 5
     * @param  mapType6  mapping type 6
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  offset    the offset
     * @param  limit     the limit
     * @return           LogicExpressionist
     */
    <T1, T2, T3, T4, T5, T6> PaginationResults<Tuple6<T1, T2, T3, T4, T5, T6>> pagination(E0 execution,
        Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Class<T6> mapType6, Tuple6<String, String, String, String, String, String> prefixes, Object[] params,
        int offset, int limit);

    /**
     * Pagination.
     *
     * @param  <T1>      the generic type
     * @param  <T2>      the generic type
     * @param  <T3>      the generic type
     * @param  <T4>      the generic type
     * @param  <T5>      the generic type
     * @param  <T6>      the generic type
     * @param  execution the execution
     * @param  mapType1  the mapping type 1
     * @param  mapType2  the mapping type 2
     * @param  mapType3  the mapping type 3
     * @param  mapType4  the mapping type 4
     * @param  mapType5  the mapping type 5
     * @param  mapType6  the mapping type 6
     * @param  prefixes  the prefixes
     * @param  params    the params
     * @param  page      the page
     * @return           LogicExpressionist
     */
    default <T1, T2, T3, T4, T5, T6> PaginationResults<Tuple6<T1, T2, T3, T4, T5, T6>> pagination(E0 execution,
        Class<T1> mapType1, Class<T2> mapType2, Class<T3> mapType3, Class<T4> mapType4, Class<T5> mapType5,
        Class<T6> mapType6, Tuple6<String, String, String, String, String, String> prefixes, Object[] params,
        Page page) {
        Limit limit = new Limit(page);
        return pagination(execution, mapType1, mapType2, mapType3, mapType4, mapType5, mapType6, prefixes, params,
            limit.getOffset(), limit.getLimit());
    }
}