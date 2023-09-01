
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.property;

import java.util.Date;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityPropertyFunction.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityPropertyFunction<E, C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * int property.
     *
     * @param name the name
     * @return the string expression
     */
    EntityNumberPropertyExpression<E, Integer, C, L> apply(SerializableToIntFunction<E> name);

    /**
     * long property.
     *
     * @param name the name
     * @return the string expression
     */
    EntityNumberPropertyExpression<E, Long, C, L> apply(SerializableToLongFunction<E> name);

    /**
     * double property.
     *
     * @param name the name
     * @return the string expression
     */
    EntityNumberPropertyExpression<E, Double, C, L> apply(SerializableToDoubleFunction<E> name);

    /**
     * Property string.
     *
     * @param name the name
     * @return the string expression
     */
    EntityStringPropertyExpression<E, C, L> apply(SerializableToStringFunction<E> name);

    /**
     * Property number.
     *
     * @param <R>  the number type
     * @param name the name
     * @return the number expression
     */
    <R extends Number> EntityNumberPropertyExpression<E, R, C, L> apply(SerializableToNumberFunction<E, R> name);

    /**
     * Property date.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the date expression
     */
    <R extends Date> EntityDatePropertyExpression<E, R, C, L> apply(SerializableToDateFunction<E, R> name);

    /**
     * Property LocalDate.
     *
     * @param name the name
     * @return the date expression
     */
    EntityLocalDatePropertyExpression<E, C, L> apply(SerializableToLocalDateFunction<E> name);

    /**
     * Property date.
     *
     * @param name the name
     * @return the date expression
     */
    EntityLocalDateTimePropertyExpression<E, C, L> apply(SerializableToLocalDateTimeFunction<E> name);

    /**
     * Property date.
     *
     * @param name the name
     * @return the date expression
     */
    EntityLocalTimePropertyExpression<E, C, L> apply(SerializableToLocalTimeFunction<E> name);

    /**
     * Property enum.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the enum expression
     */
    <R extends Enum<R>> EntityEnumPropertyExpression<E, R, C, L> apply(SerializableToEnumFunction<E, R> name);

    /**
     * Property object type.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the entity property type expression
     */
    <R> EntityPropertyTypeExpression<R, C, L> apply(SerializableFunction<E, R> name);
}
