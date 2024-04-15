
package cn.featherfly.hammer.expression.condition.nsw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not start with supplier expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotStartWithSupplierExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L nsw5(SerializableStringSupplier propertyValue) {
        return nsw5(propertyValue, MatchStrategy.AUTO);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw5(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return nsw5(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw5(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return nsw5(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nsw5(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw5(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return nsw5(propertyValue, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw5(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}