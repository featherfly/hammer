
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.eq;

import java.util.Collection;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * The Interface EqualsEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EqualsEntityExpression<E> {

    /**
     * entity equals function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity equals function property expression.
     */

    <R> EqualsEntityPropertyExpression<R> property(SerializableFunction<E, R> name);

    /**
     * entity equals function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity equals function property expression.
     */
    <R extends Collection<RE>,
            RE> EqualsEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name);

    /**
     * equals. 等于.
     *
     * @param <R>      the generic type
     * @param property the property
     * @param value    the value
     * @return the l
     */
    <R> void accept(SerializableFunction<E, R> property, R value);

    /**
     * equals. 等于.
     *
     * @param <R>         the generic type
     * @param property    the property
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    <R> void accept(SerializableFunction<E, R> property, R value, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param property     the property
     * @param value        the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <R> void accept(SerializableFunction<E, R> property, R value, Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param property     the property
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <R> void accept(SerializableFunction<E, R> property, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> void accept(SerializableSupplier<R> property);

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>         the generic type
     * @param property    对象属性
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> void accept(SerializableSupplier<R> property, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(SerializableSupplier<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);
}
