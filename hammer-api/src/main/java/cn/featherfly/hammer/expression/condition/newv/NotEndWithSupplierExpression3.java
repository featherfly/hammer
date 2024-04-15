
package cn.featherfly.hammer.expression.condition.newv;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not end with supplier expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotEndWithSupplierExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * not end with value. 不以value结尾.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L new3(SerializableStringSupplier propertyValue) {
        return new3(propertyValue, MatchStrategy.AUTO);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L new3(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return new3(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L new3(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return new3(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L new3(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy);

    /**
     * not end with value. 不以value结尾.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L new3(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return new3(propertyValue, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L new3(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}