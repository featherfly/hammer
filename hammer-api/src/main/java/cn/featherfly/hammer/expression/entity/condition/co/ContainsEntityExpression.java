
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.co;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * The Interface ContainsEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface ContainsEntityExpression<E> extends ContainsEntityPropertyExpression<E> {

    //    /**
    //     * entity contains function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity contains function property expression
    //     */
    //    <R> EntityContainsFunctionPropertyExpression<R, C, L> property(SerializableFunction<E, R> name);

    /**
     * contains value. 包含value.
     *
     * @param property the property
     * @param value    the value
     * @return the l
     */
    void accept(SerializableToStringFunction<E> property, String value);

    /**
     * contains value. 包含value.
     *
     * @param property    the property
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    void accept(SerializableToStringFunction<E> property, String value, MatchStrategy queryPolicy);

    /**
     * contains value. 包含value.
     *
     * @param property     the property
     * @param value        the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    void accept(SerializableToStringFunction<E> property, String value, Predicate<String> ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param property     the property
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    void accept(SerializableToStringFunction<E> property, String value, MatchStrategy queryPolicy,
            Predicate<String> ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue);

    /**
     * contains value. 包含value.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy  the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue, Predicate<String> ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param propertyValue the property value
     * @param queryPolicy   the query policy
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue, MatchStrategy queryPolicy);

    /**
     * contains value. 包含value.
     *
     * @param propertyValue the property value
     * @param queryPolicy   the query policy
     * @param ignoreStrategy  the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue, MatchStrategy queryPolicy, Predicate<String> ignoreStrategy);
}
