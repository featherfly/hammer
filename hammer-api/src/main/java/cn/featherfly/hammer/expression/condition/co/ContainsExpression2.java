
package cn.featherfly.hammer.expression.condition.co;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface ContainsExpression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ContainsExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ContainsExpression<C, L> {

    /**
     * contains value. 包含value.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L co2(String name, String value) {
        return co2(name, value, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co2(String name, String value, IgnoreStrategy ignoreStrategy) {
        return co2(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co2(String name, String value, Predicate<String> ignoreStrategy) {
        return co2(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L co2(String name, String value, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co2(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L co2(Field name, String value) {
        return co2(name.name(), value);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co2(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return co2(name.name(), value, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co2(Field name, String value, Predicate<String> ignoreStrategy) {
        return co2(name.name(), value, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L co2(Field name, String value, MatchStrategy matchStrategy) {
        return co2(name.name(), value, matchStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co2(Field name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return co2(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co2(Field name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co2(name.name(), value, matchStrategy, ignoreStrategy);
    }
}