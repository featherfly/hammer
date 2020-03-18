
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.expression.ConditionGroupExpression;
import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;

/**
 * <p>
 * update number value
 * </p>
 *
 * @author zhongj
 */
public interface UpdateNumberValueExpression<U extends PropertyExecutableUpdateExpression<U, C, L, V, VN>,
        C extends ConditionGroupExpression<C, L>, L extends ConditionGroupLogicExpression<C, L>, T extends Number,
        V extends UpdateValueExpression<U, C, L, Object, V, VN>,
        VN extends UpdateNumberValueExpression<U, C, L, Number, V, VN>>
        extends UpdateValueExpression<U, C, L, T, V, VN> {

    U increase(T value);
}
