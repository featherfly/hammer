
package cn.featherfly.hammer.expression.repository.condition.nco;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nco.NotContainsExpression3;
import cn.featherfly.hammer.expression.condition.nco.NotContainsSupplierExpression3;

/**
 * RepositoryNotContainsExpressionBase3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotContainsExpressionBase3<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotContainsExpressionBase2<C, L>, NotContainsExpression3<C, L>,
    NotContainsSupplierExpression3<C, L> {

    /**
     * not contains value. 不包含value.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L nco3(SerializableToStringFunction<T> name, String value) {
        return nco3(name, value, MatchStrategy.AUTO);
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
    default <T> L nco3(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return nco3(name, value, MatchStrategy.AUTO, ignoreStrategy);
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
    default <T> L nco3(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return nco3(name, value, MatchStrategy.AUTO, ignoreStrategy);
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
    default <T> L nco3(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return nco3(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
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
    default <T> L nco3(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return nco3(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
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
    default <T> L nco3(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco3(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    @Override
    default L nco3(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return nco3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy);
    }

    @Override
    default L nco3(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nco3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy,
            ignoreStrategy);
    }
}