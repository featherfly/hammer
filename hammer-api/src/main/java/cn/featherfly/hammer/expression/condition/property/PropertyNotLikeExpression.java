
package cn.featherfly.hammer.expression.condition.property;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * property not like expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface PropertyNotLikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * not like value.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    default L nl(String value) {
        return nl(value, MatchStrategy.AUTO);
    }

    /**
     * not like value.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(String value, IgnoreStrategy ignoreStrategy) {
        return nl(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(String value, Predicate<String> ignoreStrategy) {
        return nl(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    L nl(String value, MatchStrategy matchStrategy);

    /**
     * not like value.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * not like value.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}