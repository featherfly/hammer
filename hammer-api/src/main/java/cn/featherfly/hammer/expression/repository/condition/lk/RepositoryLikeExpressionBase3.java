
package cn.featherfly.hammer.expression.repository.condition.lk;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.lk.LikeExpression3;

/**
 * repository like expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLikeExpressionBase3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryLikeExpressionBase2<C, L>, LikeExpression3<C, L> {

    /**
     * like value.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L lk3(SerializableToStringFunction<T> name, String value) {
        return lk3(name, value, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lk3(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return lk3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lk3(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return lk3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Lk.
     *
     * @param <T>           the generic type
     * @param name          the name 参数名称
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L lk3(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return lk3(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
    }

    /**
     * Lk.
     *
     * @param <T>            the generic type
     * @param name           the name 参数名称
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lk3(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return lk3(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * Lk.
     *
     * @param <T>            the generic type
     * @param name           the name 参数名称
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lk3(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return lk3(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    @Override
    default L lk3(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return lk3(LambdaUtils.getLambdaPropertyName(property), property.get(), matchStrategy);
    }

    @Override
    default L lk3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk3(LambdaUtils.getLambdaPropertyName(property), property.get(), matchStrategy, ignoreStrategy);
    }
}