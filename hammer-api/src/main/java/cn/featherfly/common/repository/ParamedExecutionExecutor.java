
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-10 14:41:10
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.common.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;
import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.repository.mapping.TupleMapperBuilder;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;

/**
 * ExecutionExecutor.
 *
 * @author zhongj
 */
public interface ParamedExecutionExecutor {

    /**
     * Mapper.
     *
     * @param <T>     the generic type
     * @param mapType the map type
     * @return the paramed mapped executor
     */
    <T> ParamedMappedExecutor<T> mapper(Class<T> mapType);

    /**
     * Mapper.
     *
     * @param <T1>  the generic type
     * @param <T2>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @return the paramed mapped executor
     */
    <T1, T2> ParamedMappedExecutor<Tuple2<T1, T2>> mapper(Class<T1> type1, Class<T2> type2);

    /**
     * Mapper.
     *
     * @param <T1>  the generic type
     * @param <T2>  the generic type
     * @param <T3>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @return the paramed mapped executor
     */
    <T1, T2, T3> ParamedMappedExecutor<Tuple3<T1, T2, T3>> mapper(Class<T1> type1, Class<T2> type2, Class<T3> type3);

    /**
     * Mapper.
     *
     * @param <T1>  the generic type
     * @param <T2>  the generic type
     * @param <T3>  the generic type
     * @param <T4>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @return the paramed mapped executor
     */
    <T1, T2, T3, T4> ParamedMappedExecutor<Tuple4<T1, T2, T3, T4>> mapper(Class<T1> type1, Class<T2> type2,
            Class<T3> type3, Class<T4> type4);

    /**
     * Mapper.
     *
     * @param <T1>  the generic type
     * @param <T2>  the generic type
     * @param <T3>  the generic type
     * @param <T4>  the generic type
     * @param <T5>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param type5 the type 5
     * @return the paramed mapped executor
     */
    <T1, T2, T3, T4, T5> ParamedMappedExecutor<Tuple5<T1, T2, T3, T4, T5>> mapper(Class<T1> type1, Class<T2> type2,
            Class<T3> type3, Class<T4> type4, Class<T5> type5);

    /**
     * Mapper.
     *
     * @param <T1>  the generic type
     * @param <T2>  the generic type
     * @param <T3>  the generic type
     * @param <T4>  the generic type
     * @param <T5>  the generic type
     * @param <T6>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param type5 the type 5
     * @param type6 the type 6
     * @return the paramed mapped executor
     */
    <T1, T2, T3, T4, T5, T6> ParamedMappedExecutor<Tuple6<T1, T2, T3, T4, T5, T6>> mapper(Class<T1> type1,
            Class<T2> type2, Class<T3> type3, Class<T4> type4, Class<T5> type5, Class<T6> type6);

    /**
     * Mapper.
     *
     * @param <T>                   the generic type
     * @param mapperBuilderFunction the mapper builder function
     * @return the paramed mapped executor
     */
    <T> ParamedMappedExecutor<T> mapper(Function<TupleMapperBuilder, ParamedMappedExecutor<T>> mapperBuilderFunction);

    /**
     * execute.
     *
     * @return executed success size
     */
    int execute();

    /**
     * query 32 bit integer(int).
     *
     * @return int
     */
    default int int32() {
        return intValue();
    }

    /**
     * query int value.
     *
     * @return int
     */
    int intValue();

    /**
     * query 64 bit integer(long).
     *
     * @return long
     */
    default long int64() {
        return longValue();
    }

    /**
     * query long value.
     *
     * @return long
     */
    long longValue();

    /**
     * query double value.
     *
     * @return double
     */
    double doubleValue();

    /**
     * query boolean. if query return value will be null, use {@link #boolType()} instead.
     *
     * @return boolean
     */
    boolean bool();

    /**
     * query boolean wrapper type.
     *
     * @return Boolean
     */
    default Boolean boolType() {
        return value(Boolean.class);
    }

    /**
     * query value.
     *
     * @param <V>       the value type
     * @param valueType the value type
     * @return value
     */
    <V> V value(Class<V> valueType);

    /**
     * query number value.
     *
     * @param <N>        the number type
     * @param numberType the number type
     * @return number value
     */
    default <N extends Number> N number(Class<N> numberType) {
        return value(numberType);
    }

    /**
     * query int value.
     *
     * @return Integer
     */
    default Integer numberInt() {
        return value(Integer.class);
    }

    /**
     * query long value.
     *
     * @return Long
     */
    default Long numberLong() {
        return value(Long.class);
    }

    /**
     * query double value.
     *
     * @return BigDecimal
     */
    default Double numberDouble() {
        return value(Double.class);
    }

    /**
     * query bigInteger value.
     *
     * @return BigDecimal
     */
    default BigInteger numberBigInteger() {
        return value(BigInteger.class);
    }

    /**
     * query bigDecimal value.
     *
     * @return BigDecimal
     */
    default BigDecimal numberBigDecimal() {
        return value(BigDecimal.class);
    }

    /**
     * query string value.
     *
     * @return String
     */
    default String string() {
        return value(String.class);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * query single.
     *
     * @return map
     */
    Map<String, Object> single();

    /**
     * query single.
     *
     * @param <T>     the generic type
     * @param mapType the map type
     * @return map object
     */
    <T> T single(Class<T> mapType);

    /**
     * query unique.
     *
     * @return map
     */
    Map<String, Object> unique();

    /**
     * query unique.
     *
     * @param <T>     the generic type
     * @param mapType the map type
     * @return map object
     */
    <T> T unique(Class<T> mapType);

    /**
     * query list.
     *
     * @return map list
     */
    List<Map<String, Object>> list();

    /**
     * query list.
     *
     * @param <T>     the generic type
     * @param mapType the map type
     * @return map object list
     */
    <T> List<T> list(Class<T> mapType);

    /**
     * query paged list.
     *
     * @param offset the offset
     * @param limit  the limit
     * @return paged map list
     */
    List<Map<String, Object>> list(int offset, int limit);

    /**
     * query paged list.
     *
     * @param page the page
     * @return paged map list
     */
    default List<Map<String, Object>> list(Page page) {
        Limit limit = new Limit(page);
        return list(limit.getOffset(), limit.getLimit());
    }

    /**
     * query paged list.
     *
     * @param <E>     the element type
     * @param mapType the map type
     * @param offset  the offset
     * @param limit   the limit
     * @return paged map object list
     */
    <E> List<E> list(Class<E> mapType, int offset, int limit);

    /**
     * query paged list.
     *
     * @param <E>     the element type
     * @param mapType the map type
     * @param page    the page
     * @return paged map object list
     */
    default <E> List<E> list(Class<E> mapType, Page page) {
        Limit limit = new Limit(page);
        return list(mapType, limit.getOffset(), limit.getLimit());
    }

    /**
     * query page.
     *
     * @param offset the offset
     * @param limit  the limit
     * @return map pagination
     */
    PaginationResults<Map<String, Object>> pagination(int offset, int limit);

    /**
     * query page.
     *
     * @param page the page
     * @return map pagination
     */
    default PaginationResults<Map<String, Object>> pagination(Page page) {
        Limit limit = new Limit(page);
        return pagination(limit.getOffset(), limit.getLimit());
    }

    /**
     * query page.
     *
     * @param <T>     the generic type
     * @param mapType the map type
     * @param offset  the offset
     * @param limit   the limit
     * @return map object pagination
     */
    <T> PaginationResults<T> pagination(Class<T> mapType, int offset, int limit);

    /**
     * query page.
     *
     * @param <T>     the generic type
     * @param mapType the map type
     * @param page    the page
     * @return map object pagination
     */
    default <T> PaginationResults<T> pagination(Class<T> mapType, Page page) {
        Limit limit = new Limit(page);
        return pagination(mapType, limit.getOffset(), limit.getLimit());
    }
}
