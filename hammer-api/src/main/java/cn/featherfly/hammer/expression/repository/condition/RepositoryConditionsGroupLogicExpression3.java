
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;

/**
 * repository conditions group logic expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryConditionsGroupLogicExpression3<C extends RepositoryConditionsGroupExpression3<C, L>,
    L extends RepositoryConditionsGroupLogicExpression3<C, L>>
    extends RepositoryConditionsLogicExpression3<C, L>, GroupEndExpression<C, L> {

}
