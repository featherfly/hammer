
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.condition.RepositoryConditionsGroupExpression;
import cn.featherfly.hammer.expression.condition.RepositoryLogicGroupExpression;

/**
 * ConditionGroupLogicExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryConditionGroupLogicExpression<C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionGroupLogicExpression<C, L>> extends RepositoryLogicGroupExpression<C, L> {

}
