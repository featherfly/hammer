
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.expression.ConditionGroupExpression;
import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.WhereExpression;

/**
 * SetExecutableUpdateExpression.
 *
 * @author zhongj
 */
public interface ExecutableUpdateSetExpression<U extends ExecutableUpdateSetExpression<U, C, L>,
        C extends ConditionGroupExpression<C, L>, L extends ConditionGroupLogicExpression<C, L>>
        extends WhereExpression<C, L>, UpdateSetExpression<U, C, L>, Executor {
}
