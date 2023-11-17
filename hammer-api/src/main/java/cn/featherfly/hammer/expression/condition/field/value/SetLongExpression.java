
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-13 17:38:13
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.LongPredicate;

/**
 * set long expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface SetLongExpression {

    /**
     * Value.
     *
     * @param value long value
     */
    void value(long value);

    /**
     * Value.
     *
     * @param value          long value
     * @param ignoreStrategy the ignore strategy
     */
    void value(long value, LongPredicate ignoreStrategy);
}
