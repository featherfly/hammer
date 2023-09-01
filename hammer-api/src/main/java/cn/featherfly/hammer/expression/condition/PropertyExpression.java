
package cn.featherfly.hammer.expression.condition;

import java.util.Date;

import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.property.DateExpression;
import cn.featherfly.hammer.expression.condition.property.EnumExpression;
import cn.featherfly.hammer.expression.condition.property.NumberExpression;
import cn.featherfly.hammer.expression.condition.property.ObjectExpression;
import cn.featherfly.hammer.expression.condition.property.StringExpression;

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
    ObjectExpression<C, L> property(String name);

    /**
     * Property string.
     *
     * @param name the name
     * @return the string expression
     */
    StringExpression<C, L> propertyString(String name);

    /**
     * Property number.
     *
     * @param <N>  the number type
     * @param name the name
     * @return the number expression
     */
    <N extends Number> NumberExpression<N, C, L> propertyNumber(String name);

    /**
     * Property date.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return the date expression
     */
    <D extends Date> DateExpression<D, C, L> propertyDate(String name);

    /**
     * Property enum.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the enum expression
     */
    <R extends Enum<R>> EnumExpression<R, C, L> propertyEnum(String name);

    /**
     * Property.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the object expression
     */
    <T, R> ObjectExpression<C, L> property(SerializableFunction<T, R> name);

    /**
     * Property string.
     *
     * @param <T>  the generic type
     * @param name the name
     * @return the string expression
     */
    <T> StringExpression<C, L> property(SerializableToStringFunction<T> name);

    /**
     * Property number.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the number expression
     */
    <T, R extends Number> NumberExpression<R, C, L> property(SerializableToNumberFunction<T, R> name);

    /**
     * Property date.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the date expression
     */
    <T, R extends Date> DateExpression<R, C, L> property(SerializableToDateFunction<T, R> name);

    /**
     * Property enum.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the enum expression
     */
    <T, R extends Enum<R>> EnumExpression<R, C, L> property(SerializableToEnumFunction<T, R> name);
}
