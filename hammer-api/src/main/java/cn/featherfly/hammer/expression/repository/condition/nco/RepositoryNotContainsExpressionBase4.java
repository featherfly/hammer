
package cn.featherfly.hammer.expression.repository.condition.nco;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nco.NotContainsExpression4;
import cn.featherfly.hammer.expression.condition.nco.NotContainsSupplierExpression4;

/**
 * RepositoryNotContainsExpressionBase4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotContainsExpressionBase4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotContainsExpressionBase3<C, L>, NotContainsExpression4<C, L>,
    NotContainsSupplierExpression4<C, L> {
    /**
     * not contains value. 不包含value.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L nco4(SerializableToStringFunction<T> name, String value) {
        return nco4(name, value, MatchStrategy.AUTO);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nco4(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return nco4(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nco4(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return nco4(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param <T>           the generic type
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L nco4(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return nco4(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nco4(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return nco4(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nco4(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco4(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    @Override
    default L nco4(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return nco4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy);
    }

    @Override
    default L nco4(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy,
            ignoreStrategy);
    }
}