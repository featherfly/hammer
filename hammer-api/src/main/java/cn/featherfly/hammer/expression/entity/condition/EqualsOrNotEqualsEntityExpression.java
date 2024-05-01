
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition;

import java.util.Collection;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;

/**
 * The Interface EqualsNotEqualsEntityExpression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface EqualsOrNotEqualsEntityExpression<T>
        extends CompareEntityValuePropertyExpression<T>, CompareEntityExpression<T> {

    /**
     * entity equals or not equals or not equals function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity equals or not equals function property expression.
     */
    <R> EqualsOrNotEqualsEntityPropertyExpression<R> property(SerializableFunction<T, R> name);

    /**
     * entity equals or not equals function property expression.
     *
     * @param <R>  the generic type
     * @param <E>  the generic type
     * @param name the name
     * @return entity equals or not equals function property expression.
     */
    <R extends Collection<E>,
            E> EqualsOrNotEqualsEntityPropertyExpression<E> property(SerializableToCollectionFunction<T, R, E> name);

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param <R>      the generic type
     * @param property the property
     * @param value    the value
     */
    <R> void accept(SerializableFunction<T, R> property, R value);

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <R> void accept(SerializableFunction<T, R> property, R value, Predicate<R> ignoreStrategy);

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param <R>      the generic type
     * @param property bean property
     */
    <R> void accept(SerializableSupplier<R> property);

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    <R> void accept(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);
}
