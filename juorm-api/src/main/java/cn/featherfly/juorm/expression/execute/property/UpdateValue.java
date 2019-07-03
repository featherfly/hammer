
package cn.featherfly.juorm.expression.execute.property;

import cn.featherfly.juorm.expression.condition.ConditionGroupExpression;
import cn.featherfly.juorm.expression.condition.LogicGroupExpression;

/**
 * <p>
 * update value
 * </p>
 *
 * @author zhongj
 */
public interface UpdateValue<U extends PropertyExecutableUpdate<U, C, L>,
        C extends ConditionGroupExpression<C, L>,
        L extends LogicGroupExpression<C, L>, T> {

    U set(T value);
}
