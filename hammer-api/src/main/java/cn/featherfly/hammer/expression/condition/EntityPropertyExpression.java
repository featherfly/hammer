
package cn.featherfly.hammer.expression.condition;

import java.util.Date;

import cn.featherfly.common.lang.function.ReturnDateFunction;
import cn.featherfly.common.lang.function.ReturnEnumFunction;
import cn.featherfly.common.lang.function.ReturnNumberFunction;
import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.hammer.expression.condition.property.DateExpression;
import cn.featherfly.hammer.expression.condition.property.EnumExpression;
import cn.featherfly.hammer.expression.condition.property.NumberExpression;
import cn.featherfly.hammer.expression.condition.property.ObjectExpression;
import cn.featherfly.hammer.expression.condition.property.StringExpression;

/**
 * The Interface EntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityPropertyExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * Property.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the object expression
     */
    <R> ObjectExpression<C, L> property(SerializableFunction<E, R> name);

    /**
     * Property string.
     *
     * @param name the name
     * @return the string expression
     */
    StringExpression<C, L> property(ReturnStringFunction<E> name);

    /**
     * Property number.
     *
     * @param <R>  the number type
     * @param name the name
     * @return the number expression
     */
    <R extends Number> NumberExpression<C, L> property(ReturnNumberFunction<E, R> name);

    /**
     * Property date.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the date expression
     */
    <R extends Date> DateExpression<C, L> property(ReturnDateFunction<E, R> name);

    /**
     * Property enum.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the enum expression
     */
    <R extends Enum<?>> EnumExpression<C, L> property(ReturnEnumFunction<E, R> name);
}
