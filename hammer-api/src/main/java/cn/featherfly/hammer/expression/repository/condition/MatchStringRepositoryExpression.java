
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.field.MatchStringExpression;

/**
 * The Interface MatchStringRepositoryExpression.
 *
 * @author zhongj
 */
public interface MatchStringRepositoryExpression extends MatchStringExpression, MatchStringRepositoryFieldExpression {

    /**
     * match value. 匹配value.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     */
    default <T> void accept(SerializableToStringFunction<T> name, String value) {
        accept(name, value, MatchStrategy.AUTO);
    }

    /**
     * match value. 匹配value.
     *
     * @param <T>           the generic type
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     */
    default <T> void accept(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        accept(name, value, matchStrategy, v -> getIgnoreStrategy().test(v));
    }

    /**
     * match value. 匹配value.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <T> void accept(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        accept(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * match value. 匹配value.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    default <T> void accept(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        accept(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * match value. 匹配value.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    default void accept(SerializableSupplier<String> propertyValue, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        accept(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy, ignoreStrategy);
    }
}
