
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
import cn.featherfly.common.tuple.Tuple2;

/**
 * query mapper setter2.
 *
 * @author zhongj
 */
public interface QueryMapperLimitedSetter2 extends QueryMapperLimitedSetter0 {

    /**
     * Mapper.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @return the paramed mapped executor
     */
    <T1, T2> QueryLimitExecutor<Tuple2<T1, T2>> mapper(Class<T1> type1, Class<T2> type2);

    /**
     * Mapper.
     *
     * @param <T> the generic type
     * @param mapperBuilderFunction the mapper builder function
     * @return the paramed mapped executor
     */
    <T> QueryLimitExecutor<T> mapper(Function<TupleRowMapperBuilder, RowMapper<T>> tupleRowMapperBuilderFunction);
}