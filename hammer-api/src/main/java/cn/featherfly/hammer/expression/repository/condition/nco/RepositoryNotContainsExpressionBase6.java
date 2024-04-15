
package cn.featherfly.hammer.expression.repository.condition.nco;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nco.NotContainsExpression6;
import cn.featherfly.hammer.expression.condition.nco.NotContainsSupplierExpression6;

/**
 * RepositoryNotContainsExpressionBase6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotContainsExpressionBase6<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotContainsExpressionBase5<C, L>, NotContainsExpression6<C, L>,
    NotContainsSupplierExpression6<C, L> {
    /**
     * not contains value. 不包含value.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L nco6(SerializableToStringFunction<T> name, String value) {
        return nco6(name, value, MatchStrategy.AUTO);
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
    default <T> L nco6(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return nco6(name, value, MatchStrategy.AUTO, ignoreStrategy);
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
    default <T> L nco6(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return nco6(name, value, MatchStrategy.AUTO, ignoreStrategy);
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
    default <T> L nco6(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return nco6(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
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
    default <T> L nco6(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return nco6(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
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
    default <T> L nco6(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco6(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    @Override
    default L nco6(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return nco6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy);
    }

    @Override
    default L nco6(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco6(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy,
            ignoreStrategy);
    }
}