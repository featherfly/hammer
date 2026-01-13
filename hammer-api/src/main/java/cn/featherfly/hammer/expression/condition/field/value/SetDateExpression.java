
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-13 17:31:13
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.Date;
import java.util.function.Predicate;

/**
 * set data expression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface SetDateExpression<V extends Date> {
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
