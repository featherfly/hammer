
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.common.function.serializable.SerializableFunction;

/**
 * The Interface PropertyUpdateExpression.
 *
 * @author zhongj
 * @param <U>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <V>  the value type
 * @param <VN> the generic type
 */
public interface PropertyUpdateExpression<U extends PropertyExecutableUpdateExpression<U, C, L, V, VN>,
        C extends ExecutableConditionGroupExpression<C, L>, L extends ExecutableConditionGroupLogicExpression<C, L>,
        V extends UpdateValueExpression<U, C, L, Object, V, VN>,
        VN extends UpdateNumberValueExpression<U, C, L, Number, V, VN>> {

    /**
     * Property.
     *
     * @param name the name
     * @return the v
     */
    V property(String name);

    /**
     * Property number.
     *
     * @param name the name
     * @return the vn
     */
    VN propertyNumber(String name);

    /**
     * Property.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the v
     */
    <T, R> V property(SerializableFunction<T, R> name);

    /**
     * Property number.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the vn
     */
    <T, R extends Number> VN propertyNumber(SerializableFunction<T, R> name);
}
