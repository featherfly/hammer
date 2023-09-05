
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.sw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * The Interface StartWithEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface StartWithEntityExpression<E> extends StartWithEntityPropertyExpression<E> {

    //    /**
    //     * entity start with function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity start with function property expression
    //     */
    //    <R> EntityStartWithFunctionPropertyExpression<E, R> property(SerializableFunction<E, R> name);

    /**
     * start with value. 以value开始.
     *
     * @param property the property
     * @param value    the value
     * @return the l
     */
    void accept(SerializableToStringFunction<E> property, String value);

    /**
     * start with value. 以value开始.
     *
     * @param property    the property
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    void accept(SerializableToStringFunction<E> property, String value, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param property     the property
     * @param value        the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    void accept(SerializableToStringFunction<E> property, String value, Predicate<String> ignoreStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param property     the property
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    void accept(SerializableToStringFunction<E> property, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue);

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy  the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue, Predicate<String> ignoreStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue the property value
     * @param queryPolicy   the query policy
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue the property value
     * @param queryPolicy   the query policy
     * @param ignoreStrategy  the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}
