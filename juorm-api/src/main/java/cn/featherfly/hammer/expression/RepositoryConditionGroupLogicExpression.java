
package cn.featherfly.hammer.expression;

import cn.featherfly.hammer.expression.condition.RepositoryConditionsGroupExpression;
import cn.featherfly.hammer.expression.condition.RepositoryLogicGroupExpression;

/**
 * <p>
 * *ConditionGroupLogicExpression
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryConditionGroupLogicExpression<C extends RepositoryConditionsGroupExpression<C, L>,
        L extends RepositoryConditionGroupLogicExpression<C, L>> extends RepositoryLogicGroupExpression<C, L> {

}
