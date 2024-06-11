
package cn.featherfly.hammer.expression.condition.ew;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * end with supplier expression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EndWithSupplierExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L ew4(SerializableStringSupplier propertyValue) {
        return ew4(propertyValue, propertyValue.get());
    }

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew4(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return ew4(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew4(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return ew4(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ew4(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return ew4(propertyValue, propertyValue.get(), matchStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew4(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ew4(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew4(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ew4(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * end with value. 以value结尾.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    default L ew4(SerializableStringSupplier property, String value) {
        return ew4(property, value, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew4(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return ew4(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew4(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return ew4(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ew4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ew4(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}