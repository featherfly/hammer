
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;

/**
 * repository conditions group logic expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryConditionsGroupLogicExpression<C extends RepositoryConditionsGroupExpression<C, L>,
    L extends RepositoryConditionsGroupLogicExpression<C, L>>
    extends RepositoryConditionsLogicExpression<C, L>, GroupEndExpression<C, L> {

}
