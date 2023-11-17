
package cn.featherfly.hammer.expression.repository.condition.eq;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.eq.EqualsExpression6;

/**
 * RepositoryEqualsExpressionBase6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEqualsExpressionBase6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EqualsExpression6<C, L>, RepositoryEqualsExpressionBase5<C, L> {

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, R> L eq6(SerializableFunction<T, R> name, R value) {
        return eq6(name, value, MatchStrategy.AUTO);
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
    default <T, R> L eq6(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq6(name, value, MatchStrategy.AUTO, ignoreStrategy);
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
    <T, R> L eq6(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy);

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
    <T, R> L eq6(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>      the generic type
     * @param property  bean property
     * @return LogicExpression
     */
    default <R> L eq6(SerializableSupplier<R> property) {
        return eq6(property, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq6(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq6(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>           the generic type
     * @param property  bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <R> L eq6(SerializableSupplier<R> property, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq6(SerializableSupplier<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);
}