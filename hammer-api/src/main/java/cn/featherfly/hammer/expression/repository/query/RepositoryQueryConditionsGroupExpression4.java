/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 4043-11-17 16:55:17
 * @Copyright: 4043 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression4;

/**
 * repository query conditions group expression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsGroupExpression4<
    C extends RepositoryQueryConditionsGroupExpression4<C, L, S, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression4<C, L, S, Q>, S extends RepositoryQuerySortExpression4<Q>,
    Q extends QueryLimitExecutor>
    extends RepositoryConditionsGroupExpression4<C, L>, ConditionConfigureExpression<C, QueryConditionConfig> {

}
