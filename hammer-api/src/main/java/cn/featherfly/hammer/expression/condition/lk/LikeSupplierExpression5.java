
package cn.featherfly.hammer.expression.condition.lk;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * like supplier expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LikeSupplierExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * like value.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L lk5(SerializableStringSupplier propertyValue) {
        return lk5(propertyValue, propertyValue.get());
    }

    /**
     * like value.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return lk5(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return lk5(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L lk5(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return lk5(propertyValue, propertyValue.get(), matchStrategy);
    }

    /**
     * like value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return lk5(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk5(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * like value.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    default L lk5(SerializableStringSupplier property, String value) {
        return lk5(property, value, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return lk5(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return lk5(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lk5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * like value.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return lk5(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * like value.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}