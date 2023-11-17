
package cn.featherfly.hammer.expression.condition.ew;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * end with expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EndWithExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EndWithExpression2<C, L> {
    /**
     * end with value. 以value结尾.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L ew3(Field name, String value) {
        return ew3(name.name(), value);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew3(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return ew3(name.name(), value, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew3(Field name, String value, Predicate<String> ignoreStrategy) {
        return ew3(name.name(), value, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ew3(Field name, String value, MatchStrategy matchStrategy) {
        return ew3(name.name(), value, matchStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew3(Field name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ew3(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew3(Field name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew3(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L ew3(String name, String value) {
        return ew3(name, value, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew3(String name, String value, IgnoreStrategy ignoreStrategy) {
        return ew3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew3(String name, String value, Predicate<String> ignoreStrategy) {
        return ew3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ew3(String name, String value, MatchStrategy matchStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew3(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}