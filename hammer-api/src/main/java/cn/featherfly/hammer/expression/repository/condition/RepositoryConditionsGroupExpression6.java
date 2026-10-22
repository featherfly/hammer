
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * repository all conditions group expression6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryConditionsGroupExpression6<C extends RepositoryConditionsGroupExpression6<C, L>,
    L extends RepositoryConditionsGroupLogicExpression6<C, L>>
    extends RepositoryConditionsExpression6<C, L>, GroupExpression<C, L> {

}
