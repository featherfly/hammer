
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-04 17:26:04
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.data.query;

import java.util.function.Function;

import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.repository.mapper.TupleRowMapperBuilder;
import cn.featherfly.common.tuple.Tuple3;

/**
 * query mapper setter3.
 *
 * @author zhongj
 */
public interface QueryMapperSetter3 extends QueryMapperSetter0 {

    /**
     * Mapper.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @return the paramed mapped executor
     */
    default <T1, T2, T3> QueryExecutor<Tuple3<T1, T2, T3>> mapper(Class<T1> type1, Class<T2> type2, Class<T3> type3) {
        return mapper(builder -> builder.mapper(type1, type2, type3));
    }

    /**
     * Mapper.
     *
     * @param <T> the generic type
     * @param tupleRowMapperBuilderFunction the tuple row mapper builder function
     * @return the paramed mapped executor
     */
    <T> QueryExecutor<T> mapper(Function<TupleRowMapperBuilder, RowMapper<T>> tupleRowMapperBuilderFunction);
}