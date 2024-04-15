
package cn.featherfly.hammer.expression.repository.condition.sw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.sw.StartWithExpression4;
import cn.featherfly.hammer.expression.condition.sw.StartWithSupplierExpression4;

/**
 * repository start with expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryStartWithExpressionBase4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryStartWithExpressionBase3<C, L>, StartWithExpression4<C, L>, StartWithSupplierExpression4<C, L> {

    /**
     * start with value. 以value开始.
     *
     * @param <T>          the generic type
     * @param propertyName the property name
     * @param value        the value
     * @return LogicExpression
     */
    default <T> L sw4(SerializableToStringFunction<T> propertyName, String value) {
        return sw4(propertyName, value, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <T>            the generic type
     * @param propertyName   the property name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L sw4(SerializableToStringFunction<T> propertyName, String value, IgnoreStrategy ignoreStrategy) {
        return sw4(propertyName, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <T>            the generic type
     * @param propertyName   the property name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L sw4(SerializableToStringFunction<T> propertyName, String value, Predicate<String> ignoreStrategy) {
        return sw4(propertyName, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <T>           the generic type
     * @param propertyName  the property name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L sw4(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy) {
        return sw4(LambdaUtils.getLambdaPropertyName(propertyName), value, matchStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <T>            the generic type
     * @param propertyName   the property name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L sw4(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return sw4(propertyName, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <T>            the generic type
     * @param propertyName   the property name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L sw4(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw4(LambdaUtils.getLambdaPropertyName(propertyName), value, matchStrategy, ignoreStrategy);
    }

    @Override
    default L sw4(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return sw4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy);
    }

    @Override
    default L sw4(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw4(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy,
            ignoreStrategy);
    }

}