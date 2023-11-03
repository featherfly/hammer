
package cn.featherfly.hammer.expression.repository.condition.newv;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.newv.NotEndWithExpression3;

/**
 * repository not end with expression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotEndWithExpressionBase3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotEndWithExpressionBase2<C, L>, NotEndWithExpression3<C, L> {

    /**
     * not end with value. 不以value结尾.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L new3(SerializableToStringFunction<T> name, String value) {
        return new3(name, value, MatchStrategy.AUTO);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L new3(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return new3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L new3(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return new3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param <T>           the generic type
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L new3(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return new3(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L new3(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return new3(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L new3(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return new3(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
    }

    @Override
    default L new3(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return new3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy);
    }

    @Override
    default L new3(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return new3(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy,
                ignoreStrategy);
    }

}