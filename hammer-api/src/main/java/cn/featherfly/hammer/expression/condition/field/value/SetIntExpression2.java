
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityConditionFunctionIntPropertyExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: EntityConditionFunctionIntPropertyExpression
 * @author: zhongj
 * @date: 2023-07-18 19:17:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.BiPredicate;

/**
 * set int expression2.
 *
 * @author zhongj
 */
public interface SetIntExpression2 {

    /**
     * Value.
     *
     * @param min the min
     * @param max the max
     */
    void value(int min, int max);

    /**
     * Value.
     *
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     */
    void value(int min, int max, BiPredicate<Integer, Integer> ignoreStrategy);
}
