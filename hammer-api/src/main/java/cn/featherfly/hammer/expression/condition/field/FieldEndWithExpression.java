
package cn.featherfly.hammer.expression.condition.field;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * field end with expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface FieldEndWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * end with value.以value结尾.
     *
     * @param value the value
     * @return LogicExpression
     */
    default L ew(String value) {
        return ew(value, MatchStrategy.AUTO);
    }

    /**
     * end with value.以value结尾.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(String value, IgnoreStrategy ignoreStrategy) {
        return ew(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value.以value结尾.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(String value, Predicate<String> ignoreStrategy) {
        return ew(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value.以value结尾.
     *
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ew(String value, MatchStrategy matchStrategy);

    /**
     * end with value.以value结尾.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ew(value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * end with value.以value结尾.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}