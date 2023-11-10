
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-07 17:52:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

/**
 * IgnorableExpression.
 *
 * @author zhongj
 */
public interface IgnorableExpression {

    /**
     * Gets the ignore strategy.
     *
     * @return the ignore strategy
     */
    Predicate<Object> getIgnoreStrategy();
}
