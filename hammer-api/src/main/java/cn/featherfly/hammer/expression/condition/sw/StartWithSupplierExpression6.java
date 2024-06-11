/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-23 16:40:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.sw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * start with supplier expression6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface StartWithSupplierExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L sw6(SerializableStringSupplier propertyValue) {
        return sw6(propertyValue, propertyValue.get());
    }

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw6(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return sw6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw6(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return sw6(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L sw6(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return sw6(propertyValue, propertyValue.get(), matchStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw6(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return sw6(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw6(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw6(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * start with value. 以value开始.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    default L sw6(SerializableStringSupplier property, String value) {
        return sw6(property, value, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw6(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return sw6(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw6(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return sw6(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L sw6(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw6(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return sw6(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * start with value. 以value开始.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw6(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}