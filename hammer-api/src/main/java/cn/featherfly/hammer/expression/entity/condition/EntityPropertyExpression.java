
package cn.featherfly.hammer.expression.entity.condition;

import java.util.Collection;
import java.util.Date;

import cn.featherfly.common.lang.function.ReturnDateFunction;
import cn.featherfly.common.lang.function.ReturnEnumFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateTimeFunction;
import cn.featherfly.common.lang.function.ReturnLocalTimeFunction;
import cn.featherfly.common.lang.function.ReturnNumberFunction;
import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableToCollectionFunction;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction;
import cn.featherfly.common.lang.function.SerializableToIntFunction;
import cn.featherfly.common.lang.function.SerializableToLongFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityEnumPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDateTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityNumberPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyTypeExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityStringPropertyExpression;

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
    <R> EntityPropertyTypeExpression<R, C, L> property(SerializableFunction<E, R> name);

    /**
     * Property Collection.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return the object expression
     */
    <R extends Collection<RE>,
            RE> EntityPropertyTypeExpression<RE, C, L> property(SerializableToCollectionFunction<E, R, RE> name);

    /**
     * int property.
     *
     * @param name the name
     * @return the string expression
     */
    EntityNumberPropertyExpression<E, Integer, C, L> property(SerializableToIntFunction<E> name);

    /**
     * long property.
     *
     * @param name the name
     * @return the string expression
     */
    EntityNumberPropertyExpression<E, Long, C, L> property(SerializableToLongFunction<E> name);

    /**
     * double property.
     *
     * @param name the name
     * @return the string expression
     */
    EntityNumberPropertyExpression<E, Double, C, L> property(SerializableToDoubleFunction<E> name);

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
