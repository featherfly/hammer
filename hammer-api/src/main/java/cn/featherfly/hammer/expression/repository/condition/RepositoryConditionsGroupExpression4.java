
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.GroupExpression;

/**
 * repository all conditions group expression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryConditionsGroupExpression4<C extends RepositoryConditionsGroupExpression4<C, L>,
    L extends RepositoryConditionsGroupLogicExpression4<C, L>>
    extends RepositoryConditionsExpression4<C, L>, GroupExpression<C, L> {

}
