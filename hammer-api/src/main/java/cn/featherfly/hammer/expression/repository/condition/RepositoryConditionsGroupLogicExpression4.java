
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.ConditionsGroupLogicExpression4;

/**
 * repository conditions group logic expression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryConditionsGroupLogicExpression4<C extends RepositoryConditionsGroupExpression4<C, L>,
        L extends RepositoryConditionsGroupLogicExpression4<C, L>>
        extends RepositoryConditionsLogicExpression4<C, L>, ConditionsGroupLogicExpression4<C, L> {

}
