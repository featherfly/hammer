
package cn.featherfly.hammer.expression.condition.co;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * contains supplier expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ContainsSupplierExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ContainsSupplierExpression<C, L> {

    /**
     * contains value. 包含value.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L co2(SerializableStringSupplier propertyValue) {
        return co2(propertyValue, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co2(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return co2(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co2(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return co2(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L co2(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co2(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return co2(propertyValue, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * contains value. 包含value.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co2(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}