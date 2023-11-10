
package cn.featherfly.hammer.expression.condition.lk;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * like expression6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LikeExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends LikeExpression5<C, L> {

    /**
     * like value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L lk6(Field name, String value) {
        return lk6(name.name(), value);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk6(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return lk6(name.name(), value, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk6(Field name, String value, Predicate<String> ignoreStrategy) {
        return lk6(name.name(), value, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L lk6(Field name, String value, MatchStrategy matchStrategy) {
        return lk6(name.name(), value, matchStrategy);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk6(Field name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lk6(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk6(Field name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk6(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L lk6(String name, String value) {
        return lk6(name, value, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk6(String name, String value, IgnoreStrategy ignoreStrategy) {
        return lk6(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk6(String name, String value, Predicate<String> ignoreStrategy) {
        return lk6(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lk6(String name, String value, MatchStrategy matchStrategy);

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk6(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

}