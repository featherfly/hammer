
package cn.featherfly.hammer.expression.condition.ne;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not equals expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotEqualsExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotEqualsExpression3<C, L> {

    /**
     * not equals. 不等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L ne4(Field name, Object value) {
        return ne4(name.name(), value);
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
    default <R> L ne4(Field name, R value, Predicate<R> ignoreStrategy) {
        return ne4(name.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ne4(Field name, Object value, MatchStrategy matchStrategy) {
        return ne4(name.name(), value, matchStrategy);
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
    default <R> L ne4(Field name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return ne4(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L ne4(String name, Object value) {
        return ne4(name, value, MatchStrategy.AUTO);
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
    default <R> L ne4(String name, R value, Predicate<R> ignoreStrategy) {
        return ne4(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the query policy
     * @return LogicExpression
     */
    L ne4(String name, Object value, MatchStrategy matchStrategy);

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
    <R> L ne4(String name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);

}