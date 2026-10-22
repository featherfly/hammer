
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * repository all conditions group expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryConditionsGroupExpression3<C extends RepositoryConditionsGroupExpression3<C, L>,
    L extends RepositoryConditionsGroupLogicExpression3<C, L>>
    extends RepositoryConditionsExpression3<C, L>, GroupExpression<C, L> {

}
