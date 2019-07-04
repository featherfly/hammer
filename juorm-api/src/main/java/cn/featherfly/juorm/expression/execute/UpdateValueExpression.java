
package cn.featherfly.juorm.expression.execute;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;

/**
 * <p>
 * update value
 * </p>
 *
 * @author zhongj
 */
public interface UpdateValueExpression<U extends PropertyExecutableUpdateExpression<U, C, L, V, VN>,
        C extends ConditionGroupExpression<C, L>, L extends ConditionGroupLogicExpression<C, L>, T,
        V extends UpdateValueExpression<U, C, L, Object, V, VN>,
        VN extends UpdateNumberValueExpression<U, C, L, Number, V, VN>> {

    U set(T value);
}
