
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository conditions logic expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryConditionsLogicExpression2<C extends RepositoryConditionsExpression2<C, L>,
    L extends RepositoryConditionsLogicExpression2<C, L>> extends LogicExpression<C, L> {

}
