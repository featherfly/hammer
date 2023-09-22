
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

import cn.featherfly.common.function.serializable.SerializableSupplier;
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
     * @param property      the property
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    void accept(SerializableToStringFunction<E> property, String value, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    void accept(SerializableToStringFunction<E> property, String value, Predicate<String> ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    void accept(SerializableToStringFunction<E> property, String value, MatchStrategy matchStrategy,
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
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue, Predicate<String> ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}
