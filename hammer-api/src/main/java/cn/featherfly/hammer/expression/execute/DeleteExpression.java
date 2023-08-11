
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.expression.WhereExpression;

/**
 * DeleteExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface DeleteExpression<C extends ExecutableConditionGroupExpression<C, L>,
        L extends ExecutableConditionGroupLogicExpression<C, L>> extends WhereExpression<C, L> {
}
