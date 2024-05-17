
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * The Interface MatchStringEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface MatchStringEntityExpression<E> {

    /**
     * match value. 匹配value.
     *
     * @param property the property
     * @param value the value
     */
    void accept(SerializableToStringFunction<E> property, String value);

    /**
     * match value. 匹配value.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     */
    void accept(SerializableToStringFunction<E> property, String value, MatchStrategy matchStrategy);

    /**
     * match value. 匹配value.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToStringFunction<E> property, String value, Predicate<String> ignoreStrategy);

    /**
     * match value. 匹配value.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToStringFunction<E> property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);

    /**
     * match value. 匹配value.
     *
     * @param propertyValue the property value
     */
    void accept(SerializableStringSupplier propertyValue);

    /**
     * match value. 匹配value.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy);

    /**
     * match value. 匹配value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     */
    void accept(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy);

    /**
     * match value. 匹配value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}
