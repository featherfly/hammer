
package cn.featherfly.hammer.expression.repository.condition.nsw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nsw.NotStartWithExpression;
import cn.featherfly.hammer.expression.condition.nsw.NotStartWithSupplierExpression;

/**
 * repository not start with expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotStartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends NotStartWithExpression<C, L>, NotStartWithSupplierExpression<C, L> {

    /**
     * not start with value. 不以value开始.
     *
     * @param <T> the generic type
     * @param propertyName the property name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L nsw(SerializableToStringFunction<T> propertyName, String value) {
        return nsw(propertyName, value, MatchStrategy.AUTO);
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
    default <T> L nsw(SerializableToStringFunction<T> propertyName, String value, IgnoreStrategy ignoreStrategy) {
        return nsw(propertyName, value, MatchStrategy.AUTO, ignoreStrategy);
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
    default <T> L nsw(SerializableToStringFunction<T> propertyName, String value, Predicate<String> ignoreStrategy) {
        return nsw(propertyName, value, MatchStrategy.AUTO, ignoreStrategy);
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
    default <T> L nsw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy) {
        return nsw(LambdaUtils.getLambdaPropertyName(propertyName), value, matchStrategy);
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
    default <T> L nsw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return nsw(propertyName, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
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
    default <T> L nsw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw(LambdaUtils.getLambdaPropertyName(propertyName), value, matchStrategy, ignoreStrategy);
    }

    @Override
    default L nsw(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return nsw(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy);
    }

    @Override
    default L nsw(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return nsw(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

}