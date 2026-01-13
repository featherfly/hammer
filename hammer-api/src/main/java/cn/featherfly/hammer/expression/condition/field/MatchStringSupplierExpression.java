/*
 * All rights Reserved, Designed By zhongj
 * @Title: MatchStringSupplierExpression.java
 * @Package cn.featherfly.hammer.expression.condition.field
 * @author: zhongj
 * @date: 2025-12-11 01:21:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.IgnorableExpression;

/**
 * The Interface MatchStringExpression.
 *
 * @author zhongj
 */
public interface MatchStringSupplierExpression extends IgnorableExpression {

    /**
     * match value. 匹配value.
     *
     * @param propertyValue the property value
     */
    default void accept(SerializableStringSupplier propertyValue) {
        accept(propertyValue, MatchStrategy.AUTO);
    }

    /**
     * match value. 匹配value.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        accept(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * match value. 匹配value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     */
    default void accept(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        accept(propertyValue, matchStrategy, v -> getIgnoreStrategy().test(v));
    }

    /**
     * match value. 匹配value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);

    //    /**
    //     * match value. 匹配value.
    //     *
    //     * @param property the property
    //     * @param value the value
    //     */
    //    default void accept(SerializableStringSupplier property, String value) {
    //        accept(property, value, MatchStrategy.AUTO);
    //    }
    //
    //    /**
    //     * match value. 匹配value.
    //     *
    //     * @param property the property
    //     * @param value the value
    //     * @param ignoreStrategy the ignore strategy
    //     */
    //    default void accept(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
    //        accept(property, value, MatchStrategy.AUTO, ignoreStrategy);
    //    }
    //
    //    /**
    //     * match value. 匹配value.
    //     *
    //     * @param property the property
    //     * @param value the value
    //     * @param matchStrategy the match strategy
    //     */
    //    default void accept(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
    //        accept(property, value, matchStrategy, v -> getIgnoreStrategy().test(v));
    //    }
    //
    //    /**
    //     * match value. 匹配value.
    //     *
    //     * @param property the property
    //     * @param value the value
    //     * @param matchStrategy the match strategy
    //     * @param ignoreStrategy the ignore strategy
    //     */
    //    void accept(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
    //        Predicate<String> ignoreStrategy);
}
