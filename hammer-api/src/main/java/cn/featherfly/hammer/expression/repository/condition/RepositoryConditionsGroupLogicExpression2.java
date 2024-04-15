
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;

/**
 * repository conditions group logic expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryConditionsGroupLogicExpression2<C extends RepositoryConditionsGroupExpression2<C, L>,
    L extends RepositoryConditionsGroupLogicExpression2<C, L>>
    extends RepositoryConditionsLogicExpression2<C, L>, GroupEndExpression<C, L> {

}
