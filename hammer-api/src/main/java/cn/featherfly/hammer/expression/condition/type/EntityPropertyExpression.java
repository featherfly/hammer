
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
import cn.featherfly.hammer.expression.condition.type.property.EntityDatePropertyExpression;
import cn.featherfly.hammer.expression.condition.type.property.EntityEnumPropertyExpression;
import cn.featherfly.hammer.expression.condition.type.property.EntityLocalDatePropertyExpression;
import cn.featherfly.hammer.expression.condition.type.property.EntityLocalDateTimePropertyExpression;
import cn.featherfly.hammer.expression.condition.type.property.EntityLocalTimePropertyExpression;
import cn.featherfly.hammer.expression.condition.type.property.EntityNumberPropertyExpression;
import cn.featherfly.hammer.expression.condition.type.property.EntityStringPropertyExpression;

/**
 * The Interface EntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
// IMPLSOON 后续来处理带类型的property
public interface EntityPropertyExpression<E, C extends EntityConditionsExpression<E, C, L>,
        L extends LogicExpression<C, L>> extends ConditionExpression {

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
    EntityStringPropertyExpression<E, C, L> property(ReturnStringFunction<E> name);

    /**
     * Property number.
     *
     * @param <R>  the number type
     * @param name the name
     * @return the number expression
     */
    <R extends Number> EntityNumberPropertyExpression<E, R, C, L> property(ReturnNumberFunction<E, R> name);

    /**
     * Property date.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the date expression
     */
    <R extends Date> EntityDatePropertyExpression<E, R, C, L> property(ReturnDateFunction<E, R> name);

    /**
     * Property LocalDate.
     *
     * @param name the name
     * @return the date expression
     */
    EntityLocalDatePropertyExpression<E, C, L> property(ReturnLocalDateFunction<E> name);

    /**
     * Property date.
     *
     * @param name the name
     * @return the date expression
     */
    EntityLocalDateTimePropertyExpression<E, C, L> property(ReturnLocalDateTimeFunction<E> name);

    /**
     * Property date.
     *
     * @param name the name
     * @return the date expression
     */
    EntityLocalTimePropertyExpression<E, C, L> property(ReturnLocalTimeFunction<E> name);

    /**
     * Property enum.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the enum expression
     */
    <R extends Enum<R>> EntityEnumPropertyExpression<E, R, C, L> property(ReturnEnumFunction<E, R> name);
}
