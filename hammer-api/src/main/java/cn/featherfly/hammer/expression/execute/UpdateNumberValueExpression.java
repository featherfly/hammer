
package cn.featherfly.hammer.expression.execute;

import java.util.function.BooleanSupplier;

/**
 * update number value .
 *
 * @author zhongj
 * @param <U>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <T>  the generic type
 * @param <V>  the value type
 * @param <VN> the generic type
 */
public interface UpdateNumberValueExpression<U extends PropertyExecutableUpdateExpression<U, C, L, V, VN>,
        C extends ExecutableConditionGroupExpression<C, L>, L extends ExecutableConditionGroupLogicExpression<C, L>,
        T extends Number, V extends UpdateValueExpression<U, C, L, Object, V, VN>,
        VN extends UpdateNumberValueExpression<U, C, L, Number, V, VN>>
        extends UpdateValueExpression<U, C, L, T, V, VN> {

    /**
     * Increase.
     *
     * @param value the value
     * @return the PropertyExecutableUpdateExpression
     */
    U increase(T value);

    /**
     * Increase.
     *
     * @param increaseable the increaseable
     * @param value        the value
     * @return the PropertyExecutableUpdateExpression
     */
    U increase(BooleanSupplier increaseable, T value);
}
