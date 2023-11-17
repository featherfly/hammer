
package cn.featherfly.hammer.expression.repository.condition.eq;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.eq.EqualsExpression3;

/**
 * RepositoryEqualsExpressionBase3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEqualsExpressionBase3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EqualsExpression3<C, L>, RepositoryEqualsExpressionBase2<C, L> {

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, R> L eq3(SerializableFunction<T, R> name, R value) {
        return eq3(name, value, MatchStrategy.AUTO);
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
    default <T, R> L eq3(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq3(name, value, MatchStrategy.AUTO, ignoreStrategy);
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
    <T, R> L eq3(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy);

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
    <T, R> L eq3(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>      the generic type
     * @param property  bean property
     * @return LogicExpression
     */
    default <R> L eq3(SerializableSupplier<R> property) {
        return eq3(property, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq3(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq3(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>           the generic type
     * @param property  bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <R> L eq3(SerializableSupplier<R> property, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq3(SerializableSupplier<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);
}