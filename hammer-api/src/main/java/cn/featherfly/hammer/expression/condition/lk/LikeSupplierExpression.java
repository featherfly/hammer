
package cn.featherfly.hammer.expression.condition.lk;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * like supplier expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LikeSupplierExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * like value.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier propertyValue) {
        return lk(propertyValue, propertyValue.get());
    }

    /**
     * like value.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return lk(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return lk(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return lk(propertyValue, propertyValue.get(), matchStrategy);
    }

    /**
     * like value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lk(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * like value.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier property, String value) {
        return lk(property, value, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return lk(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return lk(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lk(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * like value.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return lk(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
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
    L lk(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}