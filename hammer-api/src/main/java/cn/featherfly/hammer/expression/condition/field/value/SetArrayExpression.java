
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-13 17:31:13
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.Predicate;

/**
 * set array expression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface SetArrayExpression<V> extends SetValueExpression<V> {

    /**
     * Value.
     *
     * @param value values with Array
     */
    void value(@SuppressWarnings("unchecked") V... value);

    /**
     * Value.
     *
     * @param value          values with Array
     * @param ignoreStrategy the ignore strategy
     */
    void value(V[] value, Predicate<V[]> ignoreStrategy);
}
