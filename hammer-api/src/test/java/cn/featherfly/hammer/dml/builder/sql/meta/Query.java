
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 18:04:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * Query.
 *
 * @author zhongj
 */
public interface Query {

    <R extends QueryableRepository, R2 extends FilterableRepository, F extends QueryFetch<R, R2, F, W, C, L>,
            W extends Where<R2, C, L>, C extends ConditionExpression,
            L extends LogicExpression<C, L>> F find(RepositoryQuery<R, R2, F, W, C, L> repository);
}
