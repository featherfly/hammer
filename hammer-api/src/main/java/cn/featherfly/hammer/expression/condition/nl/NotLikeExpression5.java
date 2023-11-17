
package cn.featherfly.hammer.expression.condition.nl;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not like expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotLikeExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotLikeExpression4<C, L> {

    /**
     * not like value.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L nl5(Field name, String value) {
        return nl5(name.name(), value);
    }

    /**
     * not like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl5(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return nl5(name.name(), value, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl5(Field name, String value, Predicate<String> ignoreStrategy) {
        return nl5(name.name(), value, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L nl5(Field name, String value, MatchStrategy matchStrategy) {
        return nl5(name.name(), value, matchStrategy);
    }

    /**
     * not like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl5(Field name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nl5(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl5(Field name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl5(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L nl5(String name, String value) {
        return nl5(name, value, MatchStrategy.AUTO);
    }

    /**
     * not like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl5(String name, String value, IgnoreStrategy ignoreStrategy) {
        return nl5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl5(String name, String value, Predicate<String> ignoreStrategy) {
        return nl5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nl5(String name, String value, MatchStrategy matchStrategy);

    /**
     * not like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl5(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * not like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

}