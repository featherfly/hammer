
package cn.featherfly.hammer.expression.condition.ne;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not equals expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotEqualsExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotEqualsExpression5<C, L> {

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L ne6(Field name, Object value) {
        return ne6(name.name(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne6(Field name, R value, Predicate<R> ignoreStrategy) {
        return ne6(name.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ne6(Field name, Object value, MatchStrategy matchStrategy) {
        return ne6(name.name(), value, matchStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne6(Field name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return ne6(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L ne6(String name, Object value) {
        return ne6(name, value, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne6(String name, R value, Predicate<R> ignoreStrategy) {
        return ne6(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the query policy
     * @return LogicExpression
     */
    L ne6(String name, Object value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne6(String name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);

}