/*
 * All rights Reserved, Designed By zhongj
 * @Title: NullNotNullExpression.java
 * @Package cn.featherfly.hammer.expression.condition
 * @author: zhongj
 * @date: 2025-12-11 01:21:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition;

/**
 * The Interface NullOrNotNullExpression.
 *
 * @author zhongj
 */
public interface NullOrNotNullExpression {

    /**
     * is null value or is not null value.
     *
     * @param <R> the generic type
     * @param propertyName the property name
     */
    default <R> void accept(String propertyName) {
        accept(propertyName, true);
    }

    /**
     * is null value or is not null value.
     *
     * @param <R> the generic type
     * @param propertyName the property name
     * @param value the value
     */
    <R> void accept(String propertyName, Boolean value);
}
