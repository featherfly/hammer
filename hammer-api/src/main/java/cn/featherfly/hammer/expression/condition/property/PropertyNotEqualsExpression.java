
package cn.featherfly.hammer.expression.condition.property;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * property not equals expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 */
public interface PropertyNotEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
        extends ConditionExpression {

    /**
     * not equals. 不等于.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    default L ne(V value) {
        return ne(value, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(V value, IgnoreStrategy ignoreStrategy) {
        return ne(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(V value, Predicate<V> ignoreStrategy) {
        return ne(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ne(V value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(V value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(V value, MatchStrategy matchStrategy, Predicate<V> ignoreStrategy);
}