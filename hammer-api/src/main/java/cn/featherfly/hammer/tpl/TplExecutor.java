
package cn.featherfly.hammer.tpl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.repository.ExecutionExecutorEx;
import cn.featherfly.common.repository.Params;
import cn.featherfly.common.repository.RowIterable;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuple6;

/**
 * TplExecutor.
 *
 * @author zhongj
 */
public interface TplExecutor extends ExecutionExecutorEx<TplExecuteId> {
    /**
     * execute.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return executed success size
     */
    default int execute(String tplExecuteId, Params params) {
        return execute(tplExecuteId, (Map<String, Serializable>) params);
    }

    /**
     * execute.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return executed success size
     */
    int execute(String tplExecuteId, Map<String, Serializable> params);

    /**
     * query boolean value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return boolean
     */
    boolean bool(String tplExecuteId, Map<String, Serializable> params);

    /**
     * query int value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return int
     */
    int intValue(String tplExecuteId, Map<String, Serializable> params);

    /**
     * query long value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return long
     */
    long longValue(String tplExecuteId, Map<String, Serializable> params);

    /**
     * query double value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return double
     */
    double doubleValue(String tplExecuteId, Map<String, Serializable> params);

    /**
     * query value, use query str in template find with executeId.
     *
     * @param <E> the element type
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return value
     */
    <E> E value(String tplExecuteId, Map<String, Serializable> params);

    /**
     * query value, use query str in template find with executeId.
     *
     * @param <V> value type
     * @param tplExecuteId tpl execute id
     * @param valueType valueType
     * @param params params
     * @return value
     */
    <V> V value(String tplExecuteId, Class<V> valueType, Map<String, Serializable> params);

    /**
     * query number value, use query str in template find with executeId.
     *
     * @param <N> number type
     * @param tplExecuteId tpl execute id
     * @param numberType numberType
     * @param params params
     * @return number value
     */
    default <N extends Number> N number(String tplExecuteId, Class<N> numberType, Map<String, Serializable> params) {
        return value(tplExecuteId, numberType, params);
    }

    /**
     * query int value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return Integer
     */
    default Integer numberInt(String tplExecuteId, Map<String, Serializable> params) {
        return value(tplExecuteId, Integer.class, params);
    }

    /**
     * query long value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return Long
     */
    default Long numberLong(String tplExecuteId, Map<String, Serializable> params) {
        return value(tplExecuteId, Long.class, params);
    }

    /**
     * query double value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return BigDecimal
     */
    default Double numberDouble(String tplExecuteId, Map<String, Serializable> params) {
        return value(tplExecuteId, Double.class, params);
    }

    /**
     * query BigInteger value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return BigInteger
     */
    default BigInteger numberBigInteger(String tplExecuteId, Map<String, Serializable> params) {
        return value(tplExecuteId, BigInteger.class, params);
    }

    /**
     * query BigDecimal value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return BigDecimal
     */
    default BigDecimal numberBigDecimal(String tplExecuteId, Map<String, Serializable> params) {
        return value(tplExecuteId, BigDecimal.class, params);
    }

    /**
     * query boolean value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return boolean
     */
    default Boolean boolType(String tplExecuteId, Map<String, Serializable> params) {
        return value(tplExecuteId, Boolean.class, params);
    }

    /**
     * query string value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return String
     */
    default String string(String tplExecuteId, Map<String, Serializable> params) {
        return value(tplExecuteId, String.class, params);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * query single, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return map
     */
    Map<String, Serializable> single(String tplExecuteId, Map<String, Serializable> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <E> entity type
     * @param tplExecuteId tpl execute id
     * @param entityType entityType
     * @param params params
     * @return entity
     */
    <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Serializable> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param params params
     * @return the tuple 2
     */
    default <R1, R2> Tuple2<R1, R2> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Map<String, Serializable> params) {
        return single(tplExecuteId, entityType1, entityType2, (Tuple2<String, String>) null, params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param prefixes the prefixes
     * @param params params
     * @return the tuple 2
     */
    <R1, R2> Tuple2<R1, R2> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param params params
     * @return the tuple 3
     */
    default <R1, R2, R3> Tuple3<R1, R2, R3> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Map<String, Serializable> params) {
        return single(tplExecuteId, entityType1, entityType2, entityType3, (Tuple3<String, String, String>) null,
            params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param prefixes the prefixes
     * @param params params
     * @return the tuple 3
     */
    <R1, R2, R3> Tuple3<R1, R2, R3> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param params params
     * @return the tuple 4
     */
    default <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Serializable> params) {
        return single(tplExecuteId, entityType1, entityType2, entityType3, entityType4,
            (Tuple4<String, String, String, String>) null, params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param prefixes the prefixes
     * @param params params
     * @return the tuple 4
     */
    <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Class<R4> entityType4, Tuple4<String, String, String, String> prefixes,
        Map<String, Serializable> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param params params
     * @return the tuple 5
     */
    default <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Map<String, Serializable> params) {
        return single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
            (Tuple5<String, String, String, String, String>) null, params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param prefixes the prefixes
     * @param params params
     * @return the tuple 5
     */
    <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params);

    /**
     * Single.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param <R6> the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param entityType6 the entity type 6
     * @param params the params
     * @return the tuple 6
     */
    default <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Class<R6> entityType6, Map<String, Serializable> params) {
        return single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
            (Tuple6<String, String, String, String, String, String>) null, params);
    }

    /**
     * Single.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param <R6> the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param entityType6 the entity type 6
     * @param prefixes the prefixes
     * @param params the params
     * @return the tuple 6
     */
    <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return map
     */
    Map<String, Serializable> unique(String tplExecuteId, Map<String, Serializable> params);

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param <E> entity type
     * @param tplExecuteId tpl execute id
     * @param entityType entityType
     * @param params params
     * @return entity
     */
    <E> E unique(String tplExecuteId, Class<E> entityType, Map<String, Serializable> params);

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param params params
     * @return the tuple 2
     */
    default <R1, R2> Tuple2<R1, R2> unique(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Map<String, Serializable> params) {
        return unique(tplExecuteId, entityType1, entityType2, (Tuple2<String, String>) null, params);
    }

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param prefixes the prefixes
     * @param params params
     * @return the tuple 2
     */
    <R1, R2> Tuple2<R1, R2> unique(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params);

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param params params
     * @return the tuple 3
     */
    default <R1, R2, R3> Tuple3<R1, R2, R3> unique(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Map<String, Serializable> params) {
        return unique(tplExecuteId, entityType1, entityType2, entityType3, (Tuple3<String, String, String>) null,
            params);
    }

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param prefixes the prefixes
     * @param params params
     * @return the tuple 3
     */
    <R1, R2, R3> Tuple3<R1, R2, R3> unique(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> params);

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param params params
     * @return the tuple 4
     */
    default <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> unique(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Serializable> params) {
        return unique(tplExecuteId, entityType1, entityType2, entityType3, entityType4,
            (Tuple4<String, String, String, String>) null, params);
    }

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param prefixes the prefixes
     * @param params params
     * @return the tuple 4
     */
    <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> unique(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Class<R4> entityType4, Tuple4<String, String, String, String> prefixes,
        Map<String, Serializable> params);

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param params params
     * @return the tuple 5
     */
    default <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> unique(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Map<String, Serializable> params) {
        return unique(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
            (Tuple5<String, String, String, String, String>) null, params);
    }

    /**
     * query unique, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param prefixes the prefixes
     * @param params params
     * @return the tuple 5
     */
    <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> unique(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params);

    /**
     * Unique.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param <R6> the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param entityType6 the entity type 6
     * @param params the params
     * @return the tuple 6
     */
    default <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> unique(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Class<R6> entityType6, Map<String, Serializable> params) {
        return unique(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
            (Tuple6<String, String, String, String, String, String>) null, params);
    }

    /**
     * Unique.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param <R6> the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param entityType6 the entity type 6
     * @param prefixes the prefixes
     * @param params the params
     * @return the tuple 6
     */
    <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> unique(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * query list, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @return map list
     */
    List<Map<String, Serializable>> list(String tplExecuteId, Map<String, Serializable> params);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param <E> entity type
     * @param tplExecuteId tpl execute id
     * @param entityType entityType
     * @param params params
     * @return entity list
     */
    <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Serializable> params);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @param offset paging start with offset
     * @param limit paging end with limit
     * @return map list
     */
    List<Map<String, Serializable>> list(String tplExecuteId, Map<String, Serializable> params, int offset, int limit);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param <E> entity type
     * @param tplExecuteId tpl execute id
     * @param entityType entityType
     * @param params params
     * @param offset paging start with offset
     * @param limit paging end with limit
     * @return entity list
     */
    <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Serializable> params, int offset, int limit);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param <E> entity type
     * @param tplExecuteId tpl execute id
     * @param entityType entityType
     * @param params params
     * @param page page
     * @return entity list
     */
    default <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query list, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @param page page
     * @return map list
     */
    default List<Map<String, Serializable>> list(String tplExecuteId, Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param params params
     * @return tuple2 list
     */
    default <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Map<String, Serializable> params) {
        return list(tplExecuteId, entityType1, entityType2, (Tuple2<String, String>) null, params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param params params
     * @param offset the offset
     * @param limit the limit
     * @return tuple2 list
     */
    default <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Map<String, Serializable> params, int offset, int limit) {
        return list(tplExecuteId, entityType1, entityType2, (Tuple2<String, String>) null, params, offset, limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param params params
     * @param page the page
     * @return tuple2 list
     */
    default <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param prefixes the prefixes
     * @param params params
     * @return tuple2 list
     */
    <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param prefixes the prefixes
     * @param params params
     * @param offset the offset
     * @param limit the limit
     * @return tuple2 list
     */
    <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param prefixes the prefixes
     * @param params params
     * @param page the page
     * @return tuple2 list
     */
    default <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Tuple2<String, String> prefixes, Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, prefixes, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param params params
     * @return tuple3 list
     */
    default <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Map<String, Serializable> params) {
        return list(tplExecuteId, entityType1, entityType2, entityType3, (Tuple3<String, String, String>) null, params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param params the params
     * @param offset the offset
     * @param limit the limit
     * @return tuple3 list
     */
    default <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Map<String, Serializable> params, int offset, int limit) {
        return list(tplExecuteId, entityType1, entityType2, entityType3, (Tuple3<String, String, String>) null, params,
            offset, limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param params params
     * @param page the page
     * @return tuple3 list
     */
    default <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param prefixes the prefixes
     * @param params params
     * @return tuple3 list
     */
    <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param prefixes the prefixes
     * @param params params
     * @param offset the offset
     * @param limit the limit
     * @return tuple3 list
     */
    <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
        Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param prefixes the prefixes
     * @param params params
     * @param page the page
     * @return tuple3 list
     */
    default <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, limit.getOffset(),
            limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param params params
     * @return tuple4 list
     */
    default <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Serializable> params) {
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4,
            (Tuple4<String, String, String, String>) null, params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param params params
     * @param offset the offset
     * @param limit the limit
     * @return tuple4 list
     */
    default <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Serializable> params,
        int offset, int limit) {
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4,
            (Tuple4<String, String, String, String>) null, params, offset, limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param params params
     * @param page the page
     * @return tuple4 list
     */
    default <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Serializable> params,
        Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params, limit.getOffset(),
            limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param prefixes the prefixes
     * @param params params
     * @return tuple4 list
     */
    <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param prefixes the prefixes
     * @param params params
     * @param offset the offset
     * @param limit the limit
     * @return tuple4 list
     */
    <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param prefixes the prefixes
     * @param params params
     * @param page the page
     * @return tuple4 list
     */
    default <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params,
            limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param params params
     * @return tuple5 list
     */
    default <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Map<String, Serializable> params) {
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
            (Tuple5<String, String, String, String, String>) null, params);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param params params
     * @param offset the offset
     * @param limit the limit
     * @return tuple5 list
     */
    default <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Map<String, Serializable> params, int offset, int limit) {
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
            (Tuple5<String, String, String, String, String>) null, params, offset, limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param params params
     * @param page the page
     * @return tuple5 list
     */
    default <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, params,
            limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param prefixes the prefixes
     * @param params params
     * @return tuple5 list
     */
    <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param prefixes the prefixes
     * @param params params
     * @param offset the offset
     * @param limit the limit
     * @return tuple5 list
     */
    <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param prefixes the prefixes
     * @param params params
     * @param page the page
     * @return tuple5 list
     */
    default <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Tuple5<String, String, String, String, String> prefixes, Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes, params,
            limit.getOffset(), limit.getLimit());
    }

    /**
     * List.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param <R6> the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param entityType6 the entity type 6
     * @param params the params
     * @return LogicExpressionist
     */
    default <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params) {
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
            (Tuple6<String, String, String, String, String, String>) null, params);
    }

    /**
     * List.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param <R6> the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param entityType6 the entity type 6
     * @param params the params
     * @param offset the offset
     * @param limit the limit
     * @return LogicExpressionist
     */
    default <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params, int offset, int limit) {
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
            (Tuple6<String, String, String, String, String, String>) null, params, offset, limit);
    }

    /**
     * List.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param <R6> the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param entityType6 the entity type 6
     * @param params the params
     * @param page the page
     * @return LogicExpressionist
     */
    default <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6, params,
            limit.getOffset(), limit.getLimit());
    }

    /**
     * List.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param <R6> the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param entityType6 the entity type 6
     * @param prefixes the prefixes
     * @param params the params
     * @return LogicExpressionist
     */
    <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params);

    /**
     * List.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param <R6> the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param entityType6 the entity type 6
     * @param prefixes the prefixes
     * @param params the params
     * @param offset the offset
     * @param limit the limit
     * @return LogicExpressionist
     */
    <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
        Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit);

    /**
     * List.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param <R6> the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param entityType6 the entity type 6
     * @param prefixes the prefixes
     * @param params the params
     * @param page the page
     * @return LogicExpressionist
     */
    default <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
            prefixes, params, limit.getOffset(), limit.getLimit());
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * query each, use query str in template find with executeId.
     *
     * @param tplExecuteId the tpl execute id
     * @param params the params
     * @return map list
     */
    RowIterable<Map<String, Serializable>> each(String tplExecuteId, Map<String, Serializable> params);

    /**
     * query each, use query str in template find with executeId.
     *
     * @param <T> the element type
     * @param tplExecuteId the tpl execute id
     * @param mappingType mapping type
     * @param params the params
     * @return entity list
     */
    <T> RowIterable<T> each(String tplExecuteId, Class<T> mappingType, Map<String, Serializable> params);

    /**
     * query each, use query str in template find with executeId.
     *
     * @param <T> the element type
     * @param tplExecuteId the tpl execute id
     * @param rowMapper the row mapper
     * @param params the params
     * @return entity list
     */
    <T> RowIterable<T> each(String tplExecuteId, RowMapper<T> rowMapper, Map<String, Serializable> params);

    /**
     * query each, use query str in template find with executeId.
     *
     * @param tplExecuteId the tpl execute id
     * @param params the params
     * @param offset the offset
     * @param limit the limit
     * @return map list
     */
    RowIterable<Map<String, Serializable>> each(String tplExecuteId, Map<String, Serializable> params, int offset,
        int limit);

    /**
     * query each, use query str in template find with executeId.
     *
     * @param <T> the element type
     * @param tplExecuteId the tpl execute id
     * @param mappingType mapping type
     * @param params the params
     * @param offset the offset
     * @param limit the limit
     * @return entity list
     */
    <T> RowIterable<T> each(String tplExecuteId, Class<T> mappingType, Map<String, Serializable> params, int offset,
        int limit);

    /**
     * query each, use query str in template find with executeId.
     *
     * @param <T> the element type
     * @param tplExecuteId the tpl execute id
     * @param rowMapper the row mapper
     * @param params the params
     * @param offset the offset
     * @param limit the limit
     * @return entity list
     */
    <T> RowIterable<T> each(String tplExecuteId, RowMapper<T> rowMapper, Map<String, Serializable> params, int offset,
        int limit);

    /**
     * query each, use query str in template find with executeId.
     *
     * @param <T> the element type
     * @param tplExecuteId the tpl execute id
     * @param mappingType mapping type
     * @param params the params
     * @param page the page
     * @return entity list
     */
    default <T> RowIterable<T> each(String tplExecuteId, Class<T> mappingType, Map<String, Serializable> params,
        Page page) {
        Limit limit = new Limit(page);
        return each(tplExecuteId, mappingType, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query each, use query str in template find with executeId.
     *
     * @param <T> the element type
     * @param tplExecuteId the tpl execute id
     * @param rowMapper the row mapper
     * @param params the params
     * @param page the page
     * @return entity list
     */
    default <T> RowIterable<T> each(String tplExecuteId, RowMapper<T> rowMapper, Map<String, Serializable> params,
        Page page) {
        Limit limit = new Limit(page);
        return each(tplExecuteId, rowMapper, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query each, use query str in template find with executeId.
     *
     * @param tplExecuteId the tpl execute id
     * @param params the params
     * @param page the page
     * @return map list
     */
    default RowIterable<Map<String, Serializable>> each(String tplExecuteId, Map<String, Serializable> params,
        Page page) {
        Limit limit = new Limit(page);
        return each(tplExecuteId, params, limit.getOffset(), limit.getLimit());
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * query page, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @param offset paging start with offset
     * @param limit paging end with limit
     * @return map pagination
     */
    PaginationResults<Map<String, Serializable>> pagination(String tplExecuteId, Map<String, Serializable> params,
        int offset, int limit);

    /**
     * query page, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params params
     * @param page page
     * @return map pagination
     */
    default PaginationResults<Map<String, Serializable>> pagination(String tplExecuteId,
        Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query page, use query str in template find with executeId.
     *
     * @param <E> entity type
     * @param tplExecuteId tpl execute id
     * @param entityType entityType
     * @param params params
     * @param offset paging start with offset
     * @param limit paging end with limit
     * @return entity pagination
     */
    <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Serializable> params,
        int offset, int limit);

    /**
     * query page, use query str in template find with executeId.
     *
     * @param <E> entity type
     * @param tplExecuteId tpl execute id
     * @param entityType entityType
     * @param params params
     * @param page page
     * @return entity pagination
     */
    default <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType,
        Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param params params
     * @param offset the offset
     * @param limit the limit
     * @return tuple2 pagination
     */
    default <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Map<String, Serializable> params, int offset, int limit) {
        return pagination(tplExecuteId, entityType1, entityType2, (Tuple2<String, String>) null, params, offset, limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param params params
     * @param page the page
     * @return tuple2 pagination
     */
    default <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param prefixes the prefixes
     * @param params params
     * @param offset the offset
     * @param limit the limit
     * @return tuple2 pagination
     */
    <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Serializable> params, int offset,
        int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param prefixes the prefixes
     * @param params params
     * @param page the page
     * @return tuple2 pagination
     */
    default <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, prefixes, params, limit.getOffset(),
            limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param params the params
     * @param offset the offset
     * @param limit the limit
     * @return tuple3 pagination
     */
    default <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Map<String, Serializable> params, int offset, int limit) {
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, (Tuple3<String, String, String>) null,
            params, offset, limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param params params
     * @param page the page
     * @return tuple3 pagination
     */
    default <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, params, limit.getOffset(),
            limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param prefixes the prefixes
     * @param params params
     * @param offset the offset
     * @param limit the limit
     * @return tuple3 pagination
     */
    <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param prefixes the prefixes
     * @param params params
     * @param page the page
     * @return tuple3 pagination
     */
    default <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
        Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, limit.getOffset(),
            limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param params params
     * @param offset the offset
     * @param limit the limit
     * @return tuple4 pagination
     */
    default <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Map<String, Serializable> params, int offset, int limit) {
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4,
            (Tuple4<String, String, String, String>) null, params, offset, limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param params params
     * @param page the page
     * @return tuple4 pagination
     */
    default <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params, limit.getOffset(),
            limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param prefixes the prefixes
     * @param params params
     * @param offset the offset
     * @param limit the limit
     * @return tuple4 pagination
     */
    <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId, Class<R1> entityType1,
        Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param prefixes the prefixes
     * @param params params
     * @param page the page
     * @return tuple4 pagination
     */
    default <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Tuple4<String, String, String, String> prefixes, Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params,
            limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param params params
     * @param offset the offset
     * @param limit the limit
     * @return tuple5 pagination
     */
    default <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Map<String, Serializable> params, int offset, int limit) {
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
            (Tuple5<String, String, String, String, String>) null, params, offset, limit);
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param params params
     * @param page the page
     * @return tuple5 pagination
     */
    default <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, params,
            limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param prefixes the prefixes
     * @param params params
     * @param offset the offset
     * @param limit the limit
     * @return tuple5 pagination
     */
    <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param prefixes the prefixes
     * @param params params
     * @param page the page
     * @return tuple5 pagination
     */
    default <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes,
        Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
            params, limit.getOffset(), limit.getLimit());
    }

    /**
     * Pagination.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param <R6> the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param entityType6 the entity type 6
     * @param params the params
     * @param offset the offset
     * @param limit the limit
     * @return the pagination results
     */
    default <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params, int offset, int limit) {
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
            (Tuple6<String, String, String, String, String, String>) null, params, offset, limit);
    }

    /**
     * Pagination.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param <R6> the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param entityType6 the entity type 6
     * @param params the params
     * @param page the page
     * @return the pagination results
     */
    default <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
            params, limit.getOffset(), limit.getLimit());
    }

    /**
     * Pagination.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param <R6> the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param entityType6 the entity type 6
     * @param prefixes the prefixes
     * @param params the params
     * @param offset the offset
     * @param limit the limit
     * @return the pagination results
     */
    <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params, int offset, int limit);

    /**
     * Pagination.
     *
     * @param <R1> the generic type
     * @param <R2> the generic type
     * @param <R3> the generic type
     * @param <R4> the generic type
     * @param <R5> the generic type
     * @param <R6> the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1 the entity type 1
     * @param entityType2 the entity type 2
     * @param entityType3 the entity type 3
     * @param entityType4 the entity type 4
     * @param entityType5 the entity type 5
     * @param entityType6 the entity type 6
     * @param prefixes the prefixes
     * @param params the params
     * @param page the page
     * @return the pagination results
     */
    default <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(String tplExecuteId,
        Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
        Class<R5> entityType5, Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
        Map<String, Serializable> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
            prefixes, params, limit.getOffset(), limit.getLimit());
    }
}
