
package cn.featherfly.hammer.expression.repository.condition.nl;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nl.NotLikeExpression5;
import cn.featherfly.hammer.expression.condition.nl.NotLikeSupplierExpression5;

/**
 * repository not like expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotLikeExpressionBase5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotLikeExpressionBase4<C, L>, NotLikeExpression5<C, L>, NotLikeSupplierExpression5<C, L> {

    /**
     * not like value.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L nl5(SerializableToStringFunction<T> name, String value) {
        return nl5(name, value, MatchStrategy.AUTO);
    }

    /**
     * not like value.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nl5(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return nl5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nl5(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return nl5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Lk.
     *
     * @param <T> the generic type
     * @param name the name 参数名称
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L nl5(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return nl5(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
    }

    /**
     * Lk.
     *
     * @param <T> the generic type
     * @param name the name 参数名称
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nl5(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return nl5(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * Lk.
     *
     * @param <T> the generic type
     * @param name the name 参数名称
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nl5(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nl5(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    @Override
    default L nl5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return nl5(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy);
    }

    @Override
    default L nl5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nl5(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

}