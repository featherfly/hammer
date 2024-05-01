
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.field.value.SetValueMatchStrategyExpression;

/**
 * The Interface EqualsOrNotEqualsRepositoryExpression.
 *
 * @author zhongj
 */
public interface EqualsOrNotEqualsRepositoryExpression extends CompareRepositoryExpression {

    /**
     * get set value match strategy expression with name.
     *
     * @param <V>  the value type
     * @param name the name
     * @return set value match strategy expression.
     */
    <V> SetValueMatchStrategyExpression<V> field(String name);

    /**
     * get set value match strategy expression with name.
     *
     * @param <V>   the value type
     * @param field the field
     * @return set value match strategy expression.
     */
    default <V> SetValueMatchStrategyExpression<V> field(Field field) {
        return field(field.name());
    }

    /**
     * get set value match strategy expression with name.
     *
     * @param <V>   the value type
     * @param field the field
     * @return set value match strategy expression.
     */
    default <V> SetValueMatchStrategyExpression<V> field(AliasField field) {
        return field(field.getAliasOrName());
    }

    /**
     * get set value match strategy expression with name.
     *
     * @param <T>  the generic type
     * @param <V>  the generic type
     * @param name the name
     * @return set value match strategy expression.
     */
    default <T, V> SetValueMatchStrategyExpression<V> field(SerializableFunction<T, V> name) {
        return field(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param <T>   the generic type
     * @param <V>   the generic type
     * @param name  the name
     * @param value the value
     */
    default <T, V> void accept(SerializableFunction<T, V> name, V value) {
        accept(name, value, getIgnoreStrategy()::test);
    }

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param <T>            the generic type
     * @param <V>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <T, V> void accept(SerializableFunction<T, V> name, V value, Predicate<V> ignoreStrategy);

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param <R>      the generic type
     * @param property bean property
     */
    default <R> void accept(SerializableSupplier<R> property) {
        accept(property, getIgnoreStrategy()::test);
    }

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    <R> void accept(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);
}
