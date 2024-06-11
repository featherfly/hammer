
package cn.featherfly.hammer.expression.repository.condition.nsw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nsw.NotStartWithExpression3;
import cn.featherfly.hammer.expression.condition.nsw.NotStartWithSupplierExpression3;

/**
 * repository not start with expression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotStartWithExpressionBase3<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotStartWithExpressionBase2<C, L>, NotStartWithExpression3<C, L>,
    NotStartWithSupplierExpression3<C, L> {

    /**
     * not start with value. 不以value开始.
     *
     * @param <T> the generic type
     * @param propertyName the property name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L nsw3(SerializableToStringFunction<T> propertyName, String value) {
        return nsw3(propertyName, value, MatchStrategy.AUTO);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param <T> the generic type
     * @param propertyName the property name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nsw3(SerializableToStringFunction<T> propertyName, String value, IgnoreStrategy ignoreStrategy) {
        return nsw3(propertyName, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param <T> the generic type
     * @param propertyName the property name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nsw3(SerializableToStringFunction<T> propertyName, String value, Predicate<String> ignoreStrategy) {
        return nsw3(propertyName, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param <T> the generic type
     * @param propertyName the property name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L nsw3(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy) {
        return nsw3(LambdaUtils.getLambdaPropertyName(propertyName), value, matchStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param <T> the generic type
     * @param propertyName the property name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nsw3(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return nsw3(propertyName, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param <T> the generic type
     * @param propertyName the property name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nsw3(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw3(LambdaUtils.getLambdaPropertyName(propertyName), value, matchStrategy, ignoreStrategy);
    }

    @Override
    default L nsw3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return nsw3(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy);
    }

    @Override
    default L nsw3(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw3(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

}