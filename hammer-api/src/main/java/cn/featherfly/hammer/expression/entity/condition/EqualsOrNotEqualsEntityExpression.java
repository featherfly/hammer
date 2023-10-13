
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
     * @param <RE> the generic type
     * @param name the name
     * @return entity equals or not equals function property expression.
     */
    <R extends Collection<RE>,
            RE> EqualsOrNotEqualsEntityPropertyExpression<RE> property(SerializableToCollectionFunction<T, R, RE> name);

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param <R>      the generic type
     * @param property the property
     * @param value    the value
     * @return the l
     */
    <R> void accept(SerializableFunction<T, R> property, R value);

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <R> void accept(SerializableFunction<T, R> property, R value, Predicate<R> ignoreStrategy);

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> void accept(SerializableSupplier<R> property);

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);
}
