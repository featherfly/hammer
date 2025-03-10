
package cn.featherfly.hammer.expression.repository.condition.co;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.co.ContainsExpression3;
import cn.featherfly.hammer.expression.condition.co.ContainsSupplierExpression3;

/**
 * RepositoryContainsExpressionBase3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryContainsExpressionBase3<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryContainsExpressionBase2<C, L>, ContainsExpression3<C, L>, ContainsSupplierExpression3<C, L> {

    /**
     * contains value. 包含value.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L co3(SerializableToStringFunction<T> name, String value) {
        return co3(name, value, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L co3(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return co3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L co3(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return co3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L co3(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return co3(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L co3(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return co3(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * contains value. 包含value.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L co3(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co3(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    @Override
    default L co3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return co3(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy);
    }

    @Override
    default L co3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co3(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy, ignoreStrategy);
    }
}