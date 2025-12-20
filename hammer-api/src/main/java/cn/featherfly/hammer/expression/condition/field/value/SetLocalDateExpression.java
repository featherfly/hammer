
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-13 17:34:13
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.time.LocalDate;
import java.util.function.Predicate;

/**
 * set LocalDate expression.
 *
 * @author zhongj
 */
public interface SetLocalDateExpression {
    /**
     * Value.
     *
     * @param value the value
     */
    void value(LocalDate value);

    /**
     * Value.
     *
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void value(LocalDate value, Predicate<LocalDate> ignoreStrategy);
}
