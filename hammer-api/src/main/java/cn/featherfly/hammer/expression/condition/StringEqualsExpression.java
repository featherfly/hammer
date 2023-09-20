
package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * The Interface StringEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface StringEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * equals. 等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L eq(String name, Object value) {
        return eq(name, value, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(String name, R value, Predicate<R> ignoreStrategy) {
        return eq(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L eq(String name, Object value, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(String name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);
}