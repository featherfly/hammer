/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 16:55:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsExpression;

/**
 * repository query conditions expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface RepositoryQueryConditionsExpression<C extends RepositoryQueryConditionsExpression<C, L, S>,
        L extends RepositoryQueryConditionsLogicExpression<C, L, S>, S extends RepositoryQuerySortExpression>
        extends RepositoryConditionsExpression<C, L>, ConditionConfigureExpression<C, QueryConditionConfig> {
}
