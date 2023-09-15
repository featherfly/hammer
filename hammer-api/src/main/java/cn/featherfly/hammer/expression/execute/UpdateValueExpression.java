
package cn.featherfly.hammer.expression.execute;

import java.util.function.BooleanSupplier;

/**
 * update value .
 *
 * @author zhongj
 * @param <U>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <T>  the generic type
 * @param <V>  the value type
 * @param <VN> the generic type
 */
public interface UpdateValueExpression<U extends PropertyExecutableUpdateExpression<U, C, L, V, VN>,
        C extends ExecutableConditionGroupExpression<C, L>, L extends ExecutableConditionGroupLogicExpression<C, L>, T,
        V extends UpdateValueExpression<U, C, L, Object, V, VN>,
        VN extends UpdateNumberValueExpression<U, C, L, Number, V, VN>> {

    /**
     * Sets the.
     *
     * @param value the value
     * @return the u
     */
    U set(T value);

    /**
     * Sets the.
     *
     * @param setable the setable
     * @param value   the value
     * @return the u
     */
    U set(BooleanSupplier setable, T value);
}
