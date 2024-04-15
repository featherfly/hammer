
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * repository all conditions group expression.
 *
 * @author zhongj
 */
public interface RepositoryConditionsGroupExpression<C extends RepositoryConditionsGroupExpression<C, L>,
    L extends RepositoryConditionsGroupLogicExpression<C, L>>
    extends RepositoryConditionsExpression<C, L>, GroupExpression<C, L> {

}
