
package cn.featherfly.hammer.expression.condition.co;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * contains supplier expression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ContainsSupplierExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * contains value. 包含value.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L co4(SerializableStringSupplier propertyValue) {
        return co4(propertyValue, propertyValue.get());
    }

    /**
     * contains value. 包含value.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co4(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return co4(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co4(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return co4(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L co4(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return co4(propertyValue, propertyValue.get(), matchStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co4(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return co4(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co4(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co4(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * contains value. 包含value.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    default L co4(SerializableStringSupplier property, String value) {
        return co4(property, value, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co4(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return co4(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co4(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return co4(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L co4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return co4(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * contains value. 包含value.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}