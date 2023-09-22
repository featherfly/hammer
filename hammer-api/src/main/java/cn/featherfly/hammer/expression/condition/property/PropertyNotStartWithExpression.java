
package cn.featherfly.hammer.expression.condition.property;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * property not start with expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface PropertyNotStartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * not start with value. 不以value开始.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    default L nsw(String value) {
        return nsw(value, MatchStrategy.AUTO);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(String value, IgnoreStrategy ignoreStrategy) {
        return nsw(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(String value, Predicate<String> ignoreStrategy) {
        return nsw(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    L nsw(String value, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}