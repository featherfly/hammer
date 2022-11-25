
package cn.featherfly.hammer.expression.condition.type;

import java.util.Date;

import cn.featherfly.common.lang.function.ReturnDateFunction;
import cn.featherfly.common.lang.function.ReturnEnumFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateTimeFunction;
import cn.featherfly.common.lang.function.ReturnLocalTimeFunction;
import cn.featherfly.common.lang.function.ReturnNumberFunction;
import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.property.DateExpression;
import cn.featherfly.hammer.expression.condition.property.EnumExpression;
import cn.featherfly.hammer.expression.condition.property.LocalDateExpression;
import cn.featherfly.hammer.expression.condition.property.LocalDateTimeExpression;
import cn.featherfly.hammer.expression.condition.property.LocalTimeExpression;
import cn.featherfly.hammer.expression.condition.property.NumberExpression;
import cn.featherfly.hammer.expression.condition.property.StringExpression;

/**
 * The Interface EntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
// IMPLSOON 后续来处理带类型的property
//public interface EntityPropertyExpression<E, C extends EntityConditionsExpression<E, C, L>,
//L extends LogicExpression<C, L>> extends ConditionExpression {
public interface EntityPropertyExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    //    /**
    //     * Property.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return the object expression
    //     */
    //    <R> ObjectExpression<C, L> property(SerializableFunction<E, R> name);

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
    <R extends Number> NumberExpression<R, C, L> property(ReturnNumberFunction<E, R> name);

    /**
     * Property date.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the date expression
     */
    <R extends Date> DateExpression<R, C, L> property(ReturnDateFunction<E, R> name);

    /**
     * Property date.
     *
     * @param name the name
     * @return the date expression
     */
    LocalDateExpression<C, L> property(ReturnLocalDateFunction<E> name);

    /**
     * Property date.
     *
     * @param name the name
     * @return the date expression
     */
    LocalDateTimeExpression<C, L> property(ReturnLocalDateTimeFunction<E> name);

    /**
     * Property date.
     *
     * @param name the name
     * @return the date expression
     */
    LocalTimeExpression<C, L> property(ReturnLocalTimeFunction<E> name);

    /**
     * Property enum.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the enum expression
     */
    <R extends Enum<?>> EnumExpression<R, C, L> property(ReturnEnumFunction<E, R> name);
}
