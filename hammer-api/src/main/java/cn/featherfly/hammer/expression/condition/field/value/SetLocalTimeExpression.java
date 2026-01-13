
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-13 17:36:13
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.time.LocalTime;
import java.util.function.Predicate;

/**
 * set LocalTime expression.
 *
 * @author zhongj
 */
public interface SetLocalTimeExpression {
    /**
     * Value.
     *
     * @param value the value
     */
    void value(LocalTime value);

    /**
     * Value.
     *
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void value(LocalTime value, Predicate<LocalTime> ignoreStrategy);
}
