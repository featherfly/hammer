
package cn.featherfly.juorm.expression.execute;

import cn.featherfly.juorm.expression.condition.ConditionGroupExpression;
import cn.featherfly.juorm.expression.condition.LogicGroupExpression;

/**
 * <p>
 * Updator
 * </p>
 *
 * @author zhongj
 */
public interface ExecutableUpdate<U extends ExecutableUpdate<U, C, L>,
        C extends ConditionGroupExpression<C, L>,
        L extends LogicGroupExpression<C, L>>
        extends IExecutableUpdate<C, L>, Update<U, C, L> {
}
