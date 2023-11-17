
package cn.featherfly.hammer.expression.repository.condition.eq;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.eq.EqualsExpression;

/**
 * RepositoryEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EqualsExpression<C, L> {

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, R> L eq(SerializableFunction<T, R> name, R value) {
        return eq(name, value, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R> L eq(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <T>           the generic type
     * @param <R>           the generic type
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T, R> L eq(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R> L eq(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        return eq(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }
}