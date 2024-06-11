
package cn.featherfly.hammer.expression.repository.condition.lk;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.lk.LikeExpression;
import cn.featherfly.hammer.expression.condition.lk.LikeSupplierExpression;

/**
 * repository like expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends LikeExpression<C, L>, LikeSupplierExpression<C, L> {

    /**
     * like value.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L lk(SerializableToStringFunction<T> name, String value) {
        return lk(name, value, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lk(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return lk(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L lk(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return lk(name, value, MatchStrategy.AUTO, ignoreStrategy);
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
    default <T> L lk(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return lk(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
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
    default <T> L lk(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return lk(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
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
    default <T> L lk(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    @Override
    default L lk(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return lk(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy);
    }

    @Override
    default L lk(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy, ignoreStrategy);
    }
}