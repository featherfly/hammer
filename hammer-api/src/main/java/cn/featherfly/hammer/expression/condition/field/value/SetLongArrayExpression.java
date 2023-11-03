
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-13 17:39:13
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.Predicate;

/**
 * set long array expression.
 *
 * @author zhongj
 */
public interface SetLongArrayExpression extends SetLongExpression {

    /**
     * Value,.
     *
     * @param value values with Array
     */
    void value(long... value);

    /**
     * Value,.
     *
     * @param value          values with Array
     * @param ignoreStrategy the ignore strategy
     */
    void value(long[] value, Predicate<long[]> ignoreStrategy);
}
