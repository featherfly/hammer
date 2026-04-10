/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 6063-11-17 16:55:17
 * @Copyright: 6063 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery0;
import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression6;

/**
 * repository query conditions group expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 * @param <S2> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQueryConditionsGroupExpression6<
    C extends RepositoryQueryConditionsGroupExpression6<C, L, S, S2, Q>,
    L extends RepositoryQueryConditionsGroupLogicExpression6<C, L, S, S2, Q>,
    S extends RepositoryQuerySortExpression6<S2, Q>, S2 extends RepositoryQuerySortedExpression6<S2, Q>,
    Q extends LimitAwareQuery0<Map<String, Serializable>>>
    extends RepositoryConditionsGroupExpression6<C, L>, ConditionConfigureExpression<C, QueryConditionConfig> {

}
