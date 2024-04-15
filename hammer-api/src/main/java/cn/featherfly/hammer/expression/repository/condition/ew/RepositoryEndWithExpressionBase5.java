
package cn.featherfly.hammer.expression.repository.condition.ew;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ew.EndWithExpression5;
import cn.featherfly.hammer.expression.condition.ew.EndWithSupplierExpression5;

/**
 * repository end with expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEndWithExpressionBase5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryEndWithExpressionBase4<C, L>, EndWithExpression5<C, L>, EndWithSupplierExpression5<C, L> {

    /**
     * end with value. 以value结尾.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L ew5(SerializableToStringFunction<T> name, String value) {
        return ew5(name, value, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ew5(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return ew5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ew5(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return ew5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <T>           the generic type
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L ew5(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return ew5(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ew5(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ew5(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ew5(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ew5(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    @Override
    default L ew5(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return ew5(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy);
    }

    @Override
    default L ew5(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ew5(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy,
            ignoreStrategy);
    }
}