
package cn.featherfly.juorm.expression.execute;

import cn.featherfly.juorm.expression.condition.ConditionGroupExpression;
import cn.featherfly.juorm.expression.condition.LogicGroupExpression;

/**
 * <p>
 * Update
 * </p>
 *
 * @author zhongj
 */
public interface Update<U extends ExecutableUpdate<U, C, L>,
        C extends ConditionGroupExpression<C, L>,
        L extends LogicGroupExpression<C, L>> extends IUpdate {

    U set(String name, Object value);

    <N extends Number> U increase(String name, N value);
}
