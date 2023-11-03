
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression;

/**
 * repository query value conditions group expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface RepositoryQueryValueConditionsGroupExpression<
        C extends RepositoryQueryValueConditionsGroupExpression<C, L, S>,
        L extends RepositoryQueryValueConditionsGroupLogicExpression<C, L, S>,
        S extends RepositoryQueryValueSortExpression>
        extends RepositoryConditionsGroupExpression<C, L>, ConditionConfigureExpression<C, QueryConditionConfig> {
}
