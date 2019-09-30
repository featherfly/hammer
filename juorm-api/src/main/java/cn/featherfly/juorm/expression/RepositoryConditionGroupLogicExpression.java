
package cn.featherfly.juorm.expression;

import cn.featherfly.juorm.expression.condition.RepositoryConditionsGroupExpression;
import cn.featherfly.juorm.expression.condition.RepositoryLogicGroupExpression;

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
