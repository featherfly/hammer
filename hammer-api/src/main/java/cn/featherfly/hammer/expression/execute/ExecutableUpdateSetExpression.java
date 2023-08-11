
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.expression.WhereExpression;

/**
 * SetExecutableUpdateExpression.
 *
 * @author zhongj
 */
public interface ExecutableUpdateSetExpression<U extends ExecutableUpdateSetExpression<U, C, L>,
        C extends ExecutableConditionGroupExpression<C, L>, L extends ExecutableConditionGroupLogicExpression<C, L>>
        extends WhereExpression<C, L>, UpdateSetExpression<U, C, L>, Executor {
}
