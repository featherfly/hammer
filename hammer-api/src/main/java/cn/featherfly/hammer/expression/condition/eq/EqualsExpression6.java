
package cn.featherfly.hammer.expression.condition.eq;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * equals expression6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EqualsExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EqualsExpression5<C, L> {

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L eq6(Field name, Object value) {
        return eq6(name.name(), value);
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
    default <R> L eq6(Field name, R value, Predicate<R> ignoreStrategy) {
        return eq6(name.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L eq6(Field name, Object value, MatchStrategy matchStrategy) {
        return eq6(name.name(), value, matchStrategy);
    }

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
    default <R> L eq6(Field name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return eq6(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L eq6(String name, Object value) {
        return eq6(name, value, MatchStrategy.AUTO);
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
    default <R> L eq6(String name, R value, Predicate<R> ignoreStrategy) {
        return eq6(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L eq6(String name, Object value, MatchStrategy matchStrategy);

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
    <R> L eq6(String name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);
}