
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * The Interface PropertyUpdateExpression.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 * @param <N> the number value type
 */
public interface PropertyUpdateExpression<U extends PropertyExecutableUpdateExpression<U, C, L, V, N>,
        C extends ExecutableConditionGroupExpression<C, L, UpdateConditionConfig>,
        L extends ExecutableConditionGroupLogicExpression<C, L, UpdateConditionConfig>,
        V extends UpdateValueExpression<U, C, L, Object, V, N>,
        N extends UpdateNumberValueExpression<U, C, L, Number, V, N>> {

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
    N propertyNumber(String name);

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
    <T, R extends Number> N propertyNumber(SerializableFunction<T, R> name);
}
