
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 18:04:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta;

import java.util.function.BiConsumer;
import java.util.function.Function;

import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * Query.
 *
 * @author zhongj
 */
public interface QueryFetch<R extends Repository, R2 extends FilterableRepository,
        F extends QueryFetch<R, R2, F, W, C, L>, W extends Where<R2, C, L>, C extends ConditionExpression,
        L extends LogicExpression<C, L>> {

    F fetch(BiConsumer<F, R> fetcher);

    F field(Function<R, Field> fetchField);

    F fields(Function<R, Field[]> fetchField);

    F field(Field... fetchFields);

    W where();
}
