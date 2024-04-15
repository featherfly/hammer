
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * repository all conditions group expression2.
 *
 * @author zhongj
 */
public interface RepositoryConditionsGroupExpression2<C extends RepositoryConditionsGroupExpression2<C, L>,
    L extends RepositoryConditionsGroupLogicExpression2<C, L>>
    extends RepositoryConditionsExpression2<C, L>, GroupExpression<C, L> {

}
