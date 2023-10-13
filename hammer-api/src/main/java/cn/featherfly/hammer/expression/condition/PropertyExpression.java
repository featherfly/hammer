
package cn.featherfly.hammer.expression.condition;

import java.util.Date;

import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.property.DatePropertyExpression;
import cn.featherfly.hammer.expression.condition.property.EnumPropertyExpression;
import cn.featherfly.hammer.expression.condition.property.NumberPropertyExpression;
import cn.featherfly.hammer.expression.condition.property.ObjectPropertyExpression;
import cn.featherfly.hammer.expression.condition.property.StringPropertyExpression;

/**
 * PropertyConditionExpression. .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface PropertyExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * Property.
     *
     * @param name the name
     * @return the object expression
     */
    ObjectPropertyExpression<C, L> property(String name);

    /**
     * Property string.
     *
     * @param name the name
     * @return the string expression
     */
    StringPropertyExpression<C, L> propertyString(String name);

    /**
     * Property number.
     *
     * @param <N>  the number type
     * @param name the name
     * @return the number expression
     */
    <N extends Number> NumberPropertyExpression<N, C, L> propertyNumber(String name);

    /**
     * Property date.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return the date expression
     */
    <D extends Date> DatePropertyExpression<D, C, L> propertyDate(String name);

    /**
     * Property enum.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the enum expression
     */
    <R extends Enum<R>> EnumPropertyExpression<R, C, L> propertyEnum(String name);

    /**
     * Property.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the object expression
     */
    <T, R> ObjectPropertyExpression<C, L> property(SerializableFunction<T, R> name);

    /**
     * Property string.
     *
     * @param <T>  the generic type
     * @param name the name
     * @return the string expression
     */
    <T> StringPropertyExpression<C, L> property(SerializableToStringFunction<T> name);

    /**
     * Property number.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the number expression
     */
    <T, R extends Number> NumberPropertyExpression<R, C, L> property(SerializableToNumberFunction<T, R> name);

    /**
     * Property date.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the date expression
     */
    <T, R extends Date> DatePropertyExpression<R, C, L> property(SerializableToDateFunction<T, R> name);

    /**
     * Property enum.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the enum expression
     */
    <T, R extends Enum<R>> EnumPropertyExpression<R, C, L> property(SerializableToEnumFunction<T, R> name);
}
