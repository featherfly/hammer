
package cn.featherfly.hammer.expression.condition.nsw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not start with supplier expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotStartWithSupplierExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L nsw(SerializableStringSupplier propertyValue) {
        return nsw(propertyValue, propertyValue.get());
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return nsw(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return nsw(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L nsw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return nsw(propertyValue, propertyValue.get(), matchStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return nsw(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw(propertyValue, propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not start with value. 不以value开始.
     *
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    default L nsw(SerializableStringSupplier property, String value) {
        return nsw(property, value, MatchStrategy.AUTO);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return nsw(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return nsw(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nsw(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return nsw(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}