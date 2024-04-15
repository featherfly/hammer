
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;

/**
 * repository conditions group logic expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryConditionsGroupLogicExpression5<C extends RepositoryConditionsGroupExpression5<C, L>,
    L extends RepositoryConditionsGroupLogicExpression5<C, L>>
    extends RepositoryConditionsLogicExpression5<C, L>, GroupEndExpression<C, L> {

}
