
package cn.featherfly.hammer.expression.repository.condition.sw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.sw.StartWithExpression;
import cn.featherfly.hammer.expression.condition.sw.StartWithSupplierExpression;

/**
 * repository start with expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryStartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends StartWithExpression<C, L>, StartWithSupplierExpression<C, L> {

    /**
     * start with value. 以value开始.
     *
     * @param <T> the generic type
     * @param propertyName the property name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L sw(SerializableToStringFunction<T> propertyName, String value) {
        return sw(propertyName, value, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <T> the generic type
     * @param propertyName the property name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L sw(SerializableToStringFunction<T> propertyName, String value, IgnoreStrategy ignoreStrategy) {
        return sw(propertyName, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <T> the generic type
     * @param propertyName the property name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L sw(SerializableToStringFunction<T> propertyName, String value, Predicate<String> ignoreStrategy) {
        return sw(propertyName, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <T> the generic type
     * @param propertyName the property name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L sw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy) {
        return sw(LambdaUtils.getLambdaPropertyName(propertyName), value, matchStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <T> the generic type
     * @param propertyName the property name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L sw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return sw(propertyName, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <T> the generic type
     * @param propertyName the property name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L sw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw(LambdaUtils.getLambdaPropertyName(propertyName), value, matchStrategy, ignoreStrategy);
    }

    @Override
    default L sw(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return sw(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy);
    }

    @Override
    default L sw(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return sw(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

}