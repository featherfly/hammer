
package cn.featherfly.juorm.expression.execute.property;

import cn.featherfly.juorm.expression.condition.ConditionGroupExpression;
import cn.featherfly.juorm.expression.condition.LogicGroupExpression;
import cn.featherfly.juorm.expression.execute.IExecutableUpdate;

/**
 * <p>
 * Updator
 * </p>
 *
 * @author zhongj
 */
public interface PropertyExecutableUpdate<
        U extends PropertyExecutableUpdate<U, C, L>,
        C extends ConditionGroupExpression<C, L>,
        L extends LogicGroupExpression<C, L>>
        extends PropertyUpdate<U, C, L>, IExecutableUpdate<C, L> {
}
