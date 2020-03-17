
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.hammer.expression.ConditionGroupExpression;
import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;

/**
 * <p>
 * Update
 * </p>
 *
 * @author zhongj
 */
public interface PropertyUpdateExpression<U extends PropertyExecutableUpdateExpression<U, C, L, V, VN>,
        C extends ConditionGroupExpression<C, L>, L extends ConditionGroupLogicExpression<C, L>,
        V extends UpdateValueExpression<U, C, L, Object, V, VN>,
        VN extends UpdateNumberValueExpression<U, C, L, Number, V, VN>> {

    V property(String name);

    VN propertyNumber(String name);

    <T, R> V property(SerializableFunction<T, R> name);

    <T, R extends Number> VN propertyNumber(SerializableFunction<T, R> name);
}
