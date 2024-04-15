
package cn.featherfly.hammer.expression.condition.nco;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not contains supplier expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotContainsSupplierExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * not contains value. 不包含value.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L nco2(SerializableStringSupplier propertyValue) {
        return nco2(propertyValue, MatchStrategy.AUTO);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco2(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return nco2(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco2(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return nco2(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nco2(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco2(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return nco2(propertyValue, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco2(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}