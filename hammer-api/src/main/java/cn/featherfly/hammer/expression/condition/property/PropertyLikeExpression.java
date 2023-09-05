
package cn.featherfly.hammer.expression.condition.property;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * property like expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface PropertyLikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * like value.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    default L lk(String value) {
        return lk(value, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(String value, Predicate<String> ignoreStrategy) {
        return lk(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    L lk(String value, MatchStrategy matchStrategy);

    /**
     * like value.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}