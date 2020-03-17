
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.hammer.expression.ConditionGroupExpression;
import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;

/**
 * <p>
 * Update
 * </p>
 * .
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface SetUpdateExpression<U extends SetExecutableUpdateExpression<U, C, L>,
        C extends ConditionGroupExpression<C, L>, L extends ConditionGroupLogicExpression<C, L>> {

    /**
     * set value for property.
     *
     * @param name  property name
     * @param value property value
     * @return Update
     */
    U set(String name, Object value);

    /**
     * increase value for property.
     *
     * @param <N>   number type
     * @param name  property name
     * @param value property value
     * @return Update
     */
    <N extends Number> U increase(String name, N value);

    /**
     * set value for property.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  property name
     * @param value property value
     * @return Update
     */
    <T, R> U set(SerializableFunction<T, R> name, Object value);

    /**
     * increase value for property.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param <N>   number type
     * @param name  property name
     * @param value property value
     * @return Update
     */
    <T, R extends Number, N extends Number> U increase(SerializableFunction<T, R> name, N value);
}
