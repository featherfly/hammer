
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.WhereExpression;

/**
 * SetExecutableUpdateExpression.
 *
 * @author zhongj
 */
public interface ExecutableUpdateSetExpression<U extends ExecutableUpdateSetExpression<U, C, L>,
        C extends ExecutableConditionGroupExpression<C, L, UpdateConditionConfig>,
        L extends ExecutableConditionGroupLogicExpression<C, L, UpdateConditionConfig>>
        extends WhereExpression<C, L>, UpdateSetExpression<U, C, L>, Executor {
}
