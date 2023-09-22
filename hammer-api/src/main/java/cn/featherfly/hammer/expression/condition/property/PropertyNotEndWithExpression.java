
package cn.featherfly.hammer.expression.condition.property;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * property not end with expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface PropertyNotEndWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * not end with value. 不以value结尾.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    default L newv(String value) {
        return newv(value, MatchStrategy.AUTO);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(String value, IgnoreStrategy ignoreStrategy) {
        return newv(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(String value, Predicate<String> ignoreStrategy) {
        return newv(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    L newv(String value, MatchStrategy matchStrategy);

    /**
     * not end with value. 不以value结尾.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * not end with value. 不以value结尾.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}