
package cn.featherfly.hammer.expression.repository.condition.ne;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ne.NotEqualsExpression3;

/**
 * RepositoryNotEqualsExpressionBase3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotEqualsExpressionBase3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotEqualsExpression3<C, L>, RepositoryNotEqualsExpressionBase2<C, L> {

    /**
     * not equals. 不等于.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, R> L ne3(SerializableFunction<T, R> name, R value) {
        return ne3(name, value, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R> L ne3(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return ne3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T>           the generic type
     * @param <R>           the generic type
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <T, R> L ne3(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, R> L ne3(SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R>      the generic type
     * @param property  bean property
     * @return LogicExpression
     */
    default <R> L ne3(SerializableSupplier<R> property) {
        return ne3(property, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne3(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne3(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>           the generic type
     * @param property  bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <R> L ne3(SerializableSupplier<R> property, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne3(SerializableSupplier<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);
}