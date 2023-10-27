
package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;

/**
 * The Interface ContainsExpressionBase.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ContainsExpressionBase<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * contains value. 包含value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L co(String name, String value) {
        return co(name, value, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(String name, String value, IgnoreStrategy ignoreStrategy) {
        return co(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(String name, String value, Predicate<String> ignoreStrategy) {
        return co(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    L co(String name, String value, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L co(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L co(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L co(Field name, String value) {
        return co(name.name(), value);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return co(name.name(), value, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(Field name, String value, Predicate<String> ignoreStrategy) {
        return co(name.name(), value, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    default L co(Field name, String value, MatchStrategy matchStrategy) {
        return co(name.name(), value, matchStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L co(Field name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return co(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L co(Field name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(name.name(), value, matchStrategy, ignoreStrategy);
    }
}