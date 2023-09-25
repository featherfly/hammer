
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.ne;

import java.util.Collection;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.entity.condition.EqualsNotEqualsEntityExpression;

/**
 * The Interface NotEqualsEntityExpression.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotEqualsEntityExpression<T> extends EqualsNotEqualsEntityExpression<T> {

    /**
     * entity not equals function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity not equals function property expression.
     */
    <R> NotEqualsEntityPropertyExpression<R> property(SerializableFunction<T, R> name);

    /**
     * entity not equals function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity not equals function property expression.
     */
    <R extends Collection<RE>,
            RE> NotEqualsEntityPropertyExpression<RE> property(SerializableToCollectionFunction<T, R, RE> name);

    /**
     * not equals. 不等于.
     *
     * @param <R>      the generic type
     * @param property the property
     * @param value    the value
     * @return the l
     */
    @Override
    <R> void accept(SerializableFunction<T, R> property, R value);

    /**
     * not equals. 不等于.
     *
     * @param <R>         the generic type
     * @param property    the property
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    @Override
    <R> void accept(SerializableFunction<T, R> property, R value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @Override
    <R> void accept(SerializableFunction<T, R> property, R value, Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param property       the property
     * @param value          the value
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    @Override
    <R> void accept(SerializableFunction<T, R> property, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    @Override
    <R> void accept(SerializableSupplier<R> property);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    <R> void accept(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R>         the generic type
     * @param property    对象属性
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    @Override
    <R> void accept(SerializableSupplier<R> property, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    <R> void accept(SerializableSupplier<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);
}
