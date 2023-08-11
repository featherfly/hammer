
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;

/**
 * EntityPropertyUpdateExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityPropertyUpdateExpression<E, U extends EntityPropertyExecutableUpdateExpression<E, U, C, L>,
        C extends EntityExecutableConditionGroupExpression<E, C, L>,
        L extends EntityExecutableConditionGroupLogicExpression<E, C, L>> {

    /**
     * Property.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the entity update value expression
     */
    <R> EntityUpdateValueExpression<E, R, U, C, L> property(SerializableFunction<E, R> property);

    /**
     * Property.
     *
     * @param <R>            the generic type
     * @param <O>            the generic type
     * @param property       the property
     * @param nestedProperty the nested property
     * @return the entity update value expression
     */
    <R, O> EntityUpdateValueExpression<E, O, U, C, L> property(SerializableFunction<E, R> property,
            SerializableFunction<R, O> nestedProperty);

    /**
     * Property.
     *
     * @param <R>           the generic type
     * @param propertyValue the property value
     * @return the entity update number value expression
     */
    <R extends Number> EntityUpdateNumberValueExpression<E, R, U, C, L> property(
            SerializableFunction2<E, R> propertyValue);
}
