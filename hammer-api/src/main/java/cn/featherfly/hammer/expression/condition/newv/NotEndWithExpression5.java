
package cn.featherfly.hammer.expression.condition.newv;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not end with expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotEndWithExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotEndWithExpression4<C, L> {

    /**
     * not end with value. 不以value结尾.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L newv5(Field name, String value) {
        return newv5(name.name(), value);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv5(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return newv5(name.name(), value, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv5(Field name, String value, Predicate<String> ignoreStrategy) {
        return newv5(name.name(), value, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L newv5(Field name, String value, MatchStrategy matchStrategy) {
        return newv5(name.name(), value, matchStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv5(Field name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return newv5(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv5(Field name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv5(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L newv5(String name, String value) {
        return newv5(name, value, MatchStrategy.AUTO);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv5(String name, String value, IgnoreStrategy ignoreStrategy) {
        return newv5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv5(String name, String value, Predicate<String> ignoreStrategy) {
        return newv5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L newv5(String name, String value, MatchStrategy matchStrategy);

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv5(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}