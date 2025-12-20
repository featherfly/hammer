/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-13 17:27:13
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.Predicate;

/**
 * set enum expression.
 *
 * @author zhongj
 * @param <V> the enum value type
 */
public interface SetEnumExpression<V extends Enum<V>> {

    /**
     * Value.
     *
     * @param value the value
     */
    void value(V value);

    /**
     * Value.
     *
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void value(V value, Predicate<V> ignoreStrategy);
}
