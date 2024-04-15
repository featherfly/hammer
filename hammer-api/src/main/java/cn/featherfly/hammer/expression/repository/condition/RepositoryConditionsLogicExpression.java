
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository conditions logic expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryConditionsLogicExpression<C extends RepositoryConditionsExpression<C, L>,
    L extends RepositoryConditionsLogicExpression<C, L>> extends LogicExpression<C, L> {

}
