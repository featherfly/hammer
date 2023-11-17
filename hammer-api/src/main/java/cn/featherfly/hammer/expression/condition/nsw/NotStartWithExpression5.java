
package cn.featherfly.hammer.expression.condition.nsw;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not start with expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotStartWithExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotStartWithExpression4<C, L> {

    /**
     * not start with value. 不以value开始.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L nsw5(Field name, String value) {
        return nsw5(name.name(), value);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw5(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return nsw5(name.name(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw5(Field name, String value, Predicate<String> ignoreStrategy) {
        return nsw5(name.name(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the query strategy
     * @return LogicExpression
     */
    default L nsw5(Field name, String value, MatchStrategy matchStrategy) {
        return nsw5(name.name(), value, matchStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw5(Field name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nsw5(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw5(Field name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw5(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L nsw5(String name, String value) {
        return nsw5(name, value, MatchStrategy.AUTO);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw5(String name, String value, IgnoreStrategy ignoreStrategy) {
        return nsw5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw5(String name, String value, Predicate<String> ignoreStrategy) {
        return nsw5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nsw5(String name, String value, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw5(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}