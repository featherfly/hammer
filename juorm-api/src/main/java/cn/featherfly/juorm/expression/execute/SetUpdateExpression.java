
package cn.featherfly.juorm.expression.execute;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;

/**
 * <p>
 * Update
 * </p>
 *
 * @author zhongj
 */
public interface SetUpdateExpression<U extends SetExecutableUpdateExpression<U, C, L>,
        C extends ConditionGroupExpression<C, L>, L extends ConditionGroupLogicExpression<C, L>> {
    /**
     * set value for property
     *
     * @param name  property name
     * @param value property value
     * @return Update
     */
    U set(String name, Object value);

    /**
     * increase value for property
     *
     * @param name  property name
     * @param value property value
     * @return Update
     */
    <N extends Number> U increase(String name, N value);
}
