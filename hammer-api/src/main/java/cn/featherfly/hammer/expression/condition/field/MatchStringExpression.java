
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.IgnorableExpression;

/**
 * The Interface MatchStringExpression.
 *
 * @author zhongj
 */
public interface MatchStringExpression extends IgnorableExpression {

    /**
     * match value. 匹配value.
     *
     * @param field the field
     * @param value the value
     */
    default void accept(Field field, String value) {
        accept(field.name(), value);
    }

    /**
     * match value. 匹配value.
     *
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     */
    default void accept(Field field, String value, MatchStrategy matchStrategy) {
        accept(field.name(), value, matchStrategy);
    }

    /**
     * match value. 匹配value.
     *
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, String value, Predicate<String> ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * match value. 匹配value.
     *
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        accept(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * match value. 匹配value.
     *
     * @param field the field
     * @param value the value
     */
    default void accept(AliasField field, String value) {
        accept(field.getAliasOrName(), value);
    }

    /**
     * match value. 匹配value.
     *
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     */
    default void accept(AliasField field, String value, MatchStrategy matchStrategy) {
        accept(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * match value. 匹配value.
     *
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(AliasField field, String value, Predicate<String> ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * match value. 匹配value.
     *
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        accept(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * contains value.
     *
     * @param name the field name
     * @param value the value
     */
    default void accept(String name, String value) {
        accept(name, value, MatchStrategy.AUTO);
    }

    /**
     * match value. 匹配value.
     *
     * @param name the field name
     * @param value the value
     * @param matchStrategy the match strategy
     */
    default void accept(String name, String value, MatchStrategy matchStrategy) {
        accept(name, value, matchStrategy, v -> getIgnoreStrategy().test(v));
    }

    /**
     * match value. 匹配value.
     *
     * @param name the field name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(String name, String value, Predicate<String> ignoreStrategy) {
        accept(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * match value. 匹配value.
     *
     * @param name the field name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * match value. 匹配value.
     *
     * @param propertyValue the property value
     */
    default void accept(SerializableStringSupplier propertyValue) {
        accept(propertyValue, propertyValue.get());
    }

    /**
     * match value. 匹配value.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        accept(propertyValue, propertyValue.get(), ignoreStrategy);
    }

    /**
     * match value. 匹配value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     */
    default void accept(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        accept(propertyValue, propertyValue.get(), matchStrategy);
    }

    /**
     * match value. 匹配value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        accept(propertyValue, propertyValue.get(), matchStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * match value. 匹配value.
     *
     * @param property the property
     * @param value the value
     */
    default void accept(SerializableStringSupplier property, String value) {
        accept(property, value, MatchStrategy.AUTO);
    }

    /**
     * match value. 匹配value.
     *
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        accept(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * match value. 匹配value.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     */
    default void accept(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        accept(property, value, matchStrategy, v -> getIgnoreStrategy().test(v));
    }

    /**
     * match value. 匹配value.
     *
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}
