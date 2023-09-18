
package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;

/**
 * StringLikeExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface StringLikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * like value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L lk(String name, String value) {
        return lk(name, value, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(String name, String value, IgnoreStrategy ignoreStrategy) {
        return lk(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(String name, String value, Predicate<String> ignoreStrategy) {
        return lk(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lk(String name, String value, MatchStrategy matchStrategy);

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

}