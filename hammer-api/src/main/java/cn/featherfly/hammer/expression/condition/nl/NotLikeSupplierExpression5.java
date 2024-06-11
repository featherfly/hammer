
package cn.featherfly.hammer.expression.condition.nl;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not like supplier expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotLikeSupplierExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * not like value.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L nl5(SerializableStringSupplier propertyValue) {
        return nl5(propertyValue, propertyValue.get());
    }

    /**
     * not like value.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl5(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return nl5(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl5(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return nl5(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L nl5(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return nl5(propertyValue, propertyValue.get(), matchStrategy);
    }

    /**
     * not like value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl5(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return nl5(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl5(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nl5(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not like value.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    default L nl5(SerializableStringSupplier property, String value) {
        return nl5(property, value, MatchStrategy.AUTO);
    }

    /**
     * not like value.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl5(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return nl5(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl5(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return nl5(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nl5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * not like value.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return nl5(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not like value.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}