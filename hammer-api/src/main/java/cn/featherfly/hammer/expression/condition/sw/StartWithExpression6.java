
package cn.featherfly.hammer.expression.condition.sw;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * start with expression6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface StartWithExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StartWithExpression5<C, L> {

    /**
     * start with value. 以value开始.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L sw6(Field name, String value) {
        return sw6(name.name(), value);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw6(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return sw6(name.name(), value, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw6(Field name, String value, Predicate<String> ignoreStrategy) {
        return sw6(name.name(), value, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the query strategy
     * @return LogicExpression
     */
    default L sw6(Field name, String value, MatchStrategy matchStrategy) {
        return sw6(name.name(), value, matchStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw6(Field name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return sw6(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw6(Field name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw6(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L sw6(String name, String value) {
        return sw6(name, value, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw6(String name, String value, IgnoreStrategy ignoreStrategy) {
        return sw6(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw6(String name, String value, Predicate<String> ignoreStrategy) {
        return sw6(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L sw6(String name, String value, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw6(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}