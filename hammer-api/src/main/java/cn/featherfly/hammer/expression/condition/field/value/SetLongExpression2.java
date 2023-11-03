
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-13 17:38:13
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.BiPredicate;

/**
 * set long expression2.
 *
 * @author zhongj
 */
public interface SetLongExpression2 {

    /**
     * Value.
     *
     * @param min the min
     * @param max the max
     */
    void value(long min, long max);

    /**
     * Value.
     *
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     */
    void value(long min, long max, BiPredicate<Long, Long> ignoreStrategy);
}
