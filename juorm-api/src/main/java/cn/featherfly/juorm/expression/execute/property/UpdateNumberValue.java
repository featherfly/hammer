
package cn.featherfly.juorm.expression.execute.property;

import cn.featherfly.juorm.expression.condition.ConditionGroupExpression;
import cn.featherfly.juorm.expression.condition.LogicGroupExpression;

/**
 * <p>
 * update number value
 * </p>
 *
 * @author zhongj
 */
public interface UpdateNumberValue<U extends PropertyExecutableUpdate<U, C, L>,
        C extends ConditionGroupExpression<C, L>,
        L extends LogicGroupExpression<C, L>, T extends Number>
        extends UpdateValue<U, C, L, T> {

    U increase(T value);
}
