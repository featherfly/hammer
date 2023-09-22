
package cn.featherfly.hammer.expression.condition.property;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * property not contains expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface PropertyNotContainsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * not contains value. 不包含value.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    default L nco(String value) {
        return nco(value, MatchStrategy.AUTO);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(String value, IgnoreStrategy ignoreStrategy) {
        return nco(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(String value, Predicate<String> ignoreStrategy) {
        return nco(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    L nco(String value, MatchStrategy matchStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}