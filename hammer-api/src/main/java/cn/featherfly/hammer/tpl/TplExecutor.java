
package cn.featherfly.hammer.tpl;

import java.math.BigDecimal;
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
 * TplExecutor.
 *
 * @author zhongj
 */
public interface TplExecutor {
    /**
     * execute.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return executed success size
     */
    int execute(String tplExecuteId, Map<String, Object> params);

    /**
     * execute.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return executed success size
     */
    int execute(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query int value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return int
     */
    int intValue(String tplExecuteId, Map<String, Object> params);

    /**
     * query int value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return int
     */
    int intValue(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query long value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return long
     */
    long longValue(String tplExecuteId, Map<String, Object> params);

    /**
     * query long value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return long
     */
    long longValue(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query double value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return double
     */
    double doubleValue(String tplExecuteId, Map<String, Object> params);

    /**
     * query double value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return double
     */
    double doubleValue(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query value, use query str in template find with executeId.
     *
     * @param <E>          value type
     * @param tplExecuteId tpl execute id
     * @param valueType    valueType
     * @param params       params
     * @return value
     */
    <E> E value(String tplExecuteId, Class<E> valueType, Map<String, Object> params);

    /**
     * query value, use query str in template find with executeId.
     *
     * @param <E>          value type
     * @param tplExecuteId tpl execute id
     * @param valueType    valueType
     * @param params       params
     * @return value
     */
    <E> E value(TplExecuteId tplExecuteId, Class<E> valueType, Map<String, Object> params);

    /**
     * query number value, use query str in template find with executeId.
     *
     * @param <N>          number type
     * @param tplExecuteId tpl execute id
     * @param numberType   numberType
     * @param params       params
     * @return number value
     */
    <N extends Number> N number(String tplExecuteId, Class<N> numberType, Map<String, Object> params);

    /**
     * query number value, use query str in template find with executeId.
     *
     * @param <N>          number type
     * @param tplExecuteId tpl execute id
     * @param numberType   numberType
     * @param params       params
     * @return number value
     */
    <N extends Number> N number(TplExecuteId tplExecuteId, Class<N> numberType, Map<String, Object> params);

    /**
     * query int value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return Integer
     */
    Integer numberInt(String tplExecuteId, Map<String, Object> params);

    /**
     * query int value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return Integer
     */
    Integer numberInt(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query long value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return Long
     */
    Long numberLong(String tplExecuteId, Map<String, Object> params);

    /**
     * query long value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return Long
     */
    Long numberLong(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query bigDecimal value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return BigDecimal
     */
    BigDecimal numberBigDecimal(String tplExecuteId, Map<String, Object> params);

    /**
     * query bigDecimal value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return BigDecimal
     */
    BigDecimal numberBigDecimal(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query double value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return BigDecimal
     */
    Double numberDouble(String tplExecuteId, Map<String, Object> params);

    /**
     * query double value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return BigDecimal
     */
    Double numberDouble(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query string value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return String
     */
    String string(String tplExecuteId, Map<String, Object> params);

    /**
     * query string value, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return String
     */
    String string(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return map
     */
    Map<String, Object> single(String tplExecuteId, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return map
     */
    Map<String, Object> single(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return entity
     */
    <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return entity
     */
    <E> E single(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param params       params
     * @return the tuple 2
     */
    <R1, R2> Tuple2<R1, R2> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param params       params
     * @return the tuple 2
     */
    <R1, R2> Tuple2<R1, R2> single(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param prefixes     the prefixes
     * @param params       params
     * @return the tuple 2
     */
    <R1, R2> Tuple2<R1, R2> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param prefixes     the prefixes
     * @param params       params
     * @return the tuple 2
     */
    <R1, R2> Tuple2<R1, R2> single(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param params       params
     * @return the tuple 3
     */
    <R1, R2, R3> Tuple3<R1, R2, R3> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param params       params
     * @return the tuple 3
     */
    <R1, R2, R3> Tuple3<R1, R2, R3> single(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param prefixes     the prefixes
     * @param params       params
     * @return the tuple 3
     */
    <R1, R2, R3> Tuple3<R1, R2, R3> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param prefixes     the prefixes
     * @param params       params
     * @return the tuple 3
     */
    <R1, R2, R3> Tuple3<R1, R2, R3> single(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param params       params
     * @return the tuple 4
     */
    <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param params       params
     * @return the tuple 4
     */
    <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param prefixes     the prefixes
     * @param params       params
     * @return the tuple 4
     */
    <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Class<R4> entityType4, Tuple4<String, String, String, String> prefixes,
            Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param prefixes     the prefixes
     * @param params       params
     * @return the tuple 4
     */
    <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param params       params
     * @return the tuple 5
     */
    <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param params       params
     * @return the tuple 5
     */
    <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param prefixes     the prefixes
     * @param params       params
     * @return the tuple 5
     */
    <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param prefixes     the prefixes
     * @param params       params
     * @return the tuple 5
     */
    <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params);

    /**
     * Single.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param params       the params
     * @return the tuple 6
     */
    <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Map<String, Object> params);

    /**
     * Single.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param params       the params
     * @return the tuple 6
     */
    <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Map<String, Object> params);

    /**
     * Single.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param prefixes     the prefixes
     * @param params       the params
     * @return the tuple 6
     */
    <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
            Map<String, Object> params);

    /**
     * Single.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param prefixes     the prefixes
     * @param params       the params
     * @return the tuple 6
     */
    <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
            Map<String, Object> params);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return map list
     */
    List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @return map list
     */
    List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return entity list
     */
    <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @return entity list
     */
    <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return map list
     */
    List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, int offset, int limit);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return map list
     */
    List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, int offset, int limit);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return entity list
     */
    <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset, int limit);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return entity list
     */
    <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset, int limit);

    /**
     * query list, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param page         page
     * @return entity list
     */
    default <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query list, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param page         page
     * @return entity list
     */
    default <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query list, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param page         page
     * @return map list
     */
    default List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query list, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param page         page
     * @return map list
     */
    default List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param params       params
     * @return tuple2 list
     */
    <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param params       params
     * @return tuple2 list
     */
    <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple2 list
     */
    <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple2 list
     */
    <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param params       params
     * @param page         the page
     * @return tuple2 list
     */
    default <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param params       params
     * @param page         the page
     * @return tuple2 list
     */
    default <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param prefixes     the prefixes
     * @param params       params
     * @return tuple2 list
     */
    <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param prefixes     the prefixes
     * @param params       params
     * @return tuple2 list
     */
    <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple2 list
     */
    <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple2 list
     */
    <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple2 list
     */
    default <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, prefixes, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple2 list
     */
    default <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, prefixes, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param params       params
     * @return tuple3 list
     */
    <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param params       params
     * @return tuple3 list
     */
    <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple3 list
     */
    <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple3 list
     */
    <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param params       params
     * @param page         the page
     * @return tuple3 list
     */
    default <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param params       params
     * @param page         the page
     * @return tuple3 list
     */
    default <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param prefixes     the prefixes
     * @param params       params
     * @return tuple3 list
     */
    <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param prefixes     the prefixes
     * @param params       params
     * @return tuple3 list
     */
    <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple3 list
     */
    <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple3 list
     */
    <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple3 list
     */
    default <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, limit.getOffset(),
                limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple3 list
     */
    default <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, limit.getOffset(),
                limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param params       params
     * @return tuple4 list
     */
    <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param params       params
     * @return tuple4 list
     */
    <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple4 list
     */
    <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params, int offset,
            int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple4 list
     */
    <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params, int offset,
            int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param params       params
     * @param page         the page
     * @return tuple4 list
     */
    default <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params,
            Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params, limit.getOffset(),
                limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param params       params
     * @param page         the page
     * @return tuple4 list
     */
    default <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params,
            Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params, limit.getOffset(),
                limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param prefixes     the prefixes
     * @param params       params
     * @return tuple4 list
     */
    <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param prefixes     the prefixes
     * @param params       params
     * @return tuple4 list
     */
    <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple4 list
     */
    <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple4 list
     */
    <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple4 list
     */
    default <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params,
                limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple4 list
     */
    default <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params,
                limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param params       params
     * @return tuple5 list
     */
    <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param params       params
     * @return tuple5 list
     */
    <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple5 list
     */
    <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple5 list
     */
    <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param params       params
     * @param page         the page
     * @return tuple5 list
     */
    default <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, params,
                limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param params       params
     * @param page         the page
     * @return tuple5 list
     */
    default <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, params,
                limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param prefixes     the prefixes
     * @param params       params
     * @return tuple5 list
     */
    <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param prefixes     the prefixes
     * @param params       params
     * @return tuple5 list
     */
    <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple5 list
     */
    <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple5 list
     */
    <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple5 list
     */
    default <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes, params,
                limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple5 list
     */
    default <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes, params,
                limit.getOffset(), limit.getLimit());
    }

    /**
     * List.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param params       the params
     * @return LogicExpressionist
     */
    <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Map<String, Object> params);

    /**
     * List.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return LogicExpressionist
     */
    <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Map<String, Object> params, int offset, int limit);

    /**
     * List.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param params       the params
     * @param page         the page
     * @return LogicExpressionist
     */
    default <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6, params,
                limit.getOffset(), limit.getLimit());
    }

    /**
     * List.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param params       the params
     * @return LogicExpressionist
     */
    <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Map<String, Object> params);

    /**
     * List.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return LogicExpressionist
     */
    <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Map<String, Object> params, int offset, int limit);

    /**
     * List.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param params       the params
     * @param page         the page
     * @return LogicExpressionist
     */
    default <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6, params,
                limit.getOffset(), limit.getLimit());
    }

    /**
     * List.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param prefixes     the prefixes
     * @param params       the params
     * @return LogicExpressionist
     */
    <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
            Map<String, Object> params);

    /**
     * List.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param prefixes     the prefixes
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return LogicExpressionist
     */
    <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
            Map<String, Object> params, int offset, int limit);

    /**
     * List.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param prefixes     the prefixes
     * @param params       the params
     * @param page         the page
     * @return LogicExpressionist
     */
    default <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * List.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param prefixes     the prefixes
     * @param params       the params
     * @return LogicExpressionist
     */
    <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
            Map<String, Object> params);

    /**
     * List.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param prefixes     the prefixes
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return LogicExpressionist
     */
    <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
            Map<String, Object> params, int offset, int limit);

    /**
     * List.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param prefixes     the prefixes
     * @param params       the params
     * @param page         the page
     * @return LogicExpressionist
     */
    default <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, params, limit.getOffset(), limit.getLimit());
    }

    // /**
    // * <p>
    // * query list, use query str in template find with executeId
    // * </p>
    // *
    // * @param <E>
    // * @param executeId executeId
    // * @param entityType entityType
    // * @param params params
    // * @return list
    // */
    // <E> List<E> list(String executeId, Class<E> entityType, Object params);
    //
    // /**
    // * <p>
    // * query list, use query str in template find with executeId
    // * </p>
    // *
    // * @param <E>
    // * @param executeId executeId
    // * @param entityType entityType
    // * @param params params
    // * @param paging ispaging
    // * @return list
    // */
    // <E> List<E> list(String executeId, Class<E> entityType, Object params,
    // boolean paging);

    // /**
    // * <p>
    // * query list, use query str in template find with executeId
    // * </p>
    // *
    // * @param <E>
    // * @param executeId executeId
    // * @param entityType entityType
    // * @param params params
    // * @return list
    // */
    // <E> PaginationResults<E> pagination(String executeId, Class<E>
    // entityType,
    // Object params);

    /**
     * query page, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return map pagination
     */
    PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params, int offset,
            int limit);

    /**
     * query page, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return map pagination
     */
    PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params, int offset,
            int limit);

    /**
     * query page, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param page         page
     * @return map pagination
     */
    default PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query page, use query str in template find with executeId.
     *
     * @param tplExecuteId tpl execute id
     * @param params       params
     * @param page         page
     * @return map pagination
     */
    default PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query page, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return entity pagination
     */
    <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit);

    /**
     * query page, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param offset       paging start with offset
     * @param limit        paging end with limit
     * @return entity pagination
     */
    <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit);

    /**
     * query page, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param page         page
     * @return entity pagination
     */
    default <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query page, use query str in template find with executeId.
     *
     * @param <E>          entity type
     * @param tplExecuteId tpl execute id
     * @param entityType   entityType
     * @param params       params
     * @param page         page
     * @return entity pagination
     */
    default <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple2 pagination
     */
    <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple2 pagination
     */
    <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param params       params
     * @param page         the page
     * @return tuple2 pagination
     */
    default <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param params       params
     * @param page         the page
     * @return tuple2 pagination
     */
    default <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple2 pagination
     */
    <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple2 pagination
     */
    <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple2 pagination
     */
    default <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, prefixes, params, limit.getOffset(),
                limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple2 pagination
     */
    default <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, prefixes, params, limit.getOffset(),
                limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple3 pagination
     */
    <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple3 pagination
     */
    <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param params       params
     * @param page         the page
     * @return tuple3 pagination
     */
    default <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, params, limit.getOffset(),
                limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param params       params
     * @param page         the page
     * @return tuple3 pagination
     */
    default <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params,
            Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, params, limit.getOffset(),
                limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple3 pagination
     */
    <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple3 pagination
     */
    <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple3 pagination
     */
    default <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, limit.getOffset(),
                limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple3 pagination
     */
    default <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
            Tuple3<String, String, String> prefixes, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, limit.getOffset(),
                limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple4 pagination
     */
    <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params, int offset,
            int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple4 pagination
     */
    <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param params       params
     * @param page         the page
     * @return tuple4 pagination
     */
    default <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params, limit.getOffset(),
                limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param params       params
     * @param page         the page
     * @return tuple4 pagination
     */
    default <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params, limit.getOffset(),
                limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple4 pagination
     */
    <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple4 pagination
     */
    <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple4 pagination
     */
    default <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params,
                limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple4 pagination
     */
    default <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params,
                limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple5 pagination
     */
    <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple5 pagination
     */
    <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Map<String, Object> params, int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param params       params
     * @param page         the page
     * @return tuple5 pagination
     */
    default <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, params,
                limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param params       params
     * @param page         the page
     * @return tuple5 pagination
     */
    default <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, params,
                limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple5 pagination
     */
    <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params,
            int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param prefixes     the prefixes
     * @param params       params
     * @param offset       the offset
     * @param limit        the limit
     * @return tuple5 pagination
     */
    <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params,
            int offset, int limit);

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple5 pagination
     */
    default <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params,
            Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                params, limit.getOffset(), limit.getLimit());
    }

    /**
     * query single, use query str in template find with executeId.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param tplExecuteId tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param prefixes     the prefixes
     * @param params       params
     * @param page         the page
     * @return tuple5 pagination
     */
    default <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params,
            Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, prefixes,
                params, limit.getOffset(), limit.getLimit());
    }

    /**
     * Pagination.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return the pagination results
     */
    <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params, int offset, int limit);

    /**
     * Pagination.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param params       the params
     * @param page         the page
     * @return the pagination results
     */
    default <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                params, limit.getOffset(), limit.getLimit());
    }

    /**
     * Pagination.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return the pagination results
     */
    <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params, int offset, int limit);

    /**
     * Pagination.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param params       the params
     * @param page         the page
     * @return the pagination results
     */
    default <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(
            TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
            Class<R4> entityType4, Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params,
            Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                params, limit.getOffset(), limit.getLimit());
    }

    /**
     * Pagination.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param prefixes     the prefixes
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return the pagination results
     */
    <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit);

    /**
     * Pagination.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param prefixes     the prefixes
     * @param params       the params
     * @param page         the page
     * @return the pagination results
     */
    default <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, params, limit.getOffset(), limit.getLimit());
    }

    /**
     * Pagination.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param prefixes     the prefixes
     * @param params       the params
     * @param offset       the offset
     * @param limit        the limit
     * @return LogicExpressionist
     */
    <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit);

    /**
     * Pagination.
     *
     * @param <R1>         the generic type
     * @param <R2>         the generic type
     * @param <R3>         the generic type
     * @param <R4>         the generic type
     * @param <R5>         the generic type
     * @param <R6>         the generic type
     * @param tplExecuteId the tpl execute id
     * @param entityType1  the entity type 1
     * @param entityType2  the entity type 2
     * @param entityType3  the entity type 3
     * @param entityType4  the entity type 4
     * @param entityType5  the entity type 5
     * @param entityType6  the entity type 6
     * @param prefixes     the prefixes
     * @param params       the params
     * @param page         the page
     * @return LogicExpressionist
     */
    default <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(
            TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
            Class<R4> entityType4, Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params, Page page) {
        Limit limit = new Limit(page);
        return pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5, entityType6,
                prefixes, params, limit.getOffset(), limit.getLimit());
    }

}
