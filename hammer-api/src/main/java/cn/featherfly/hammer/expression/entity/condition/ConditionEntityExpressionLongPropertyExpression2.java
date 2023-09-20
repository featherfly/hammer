
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityConditionFunctionIntPropertyExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: EntityConditionFunctionIntPropertyExpression
 * @author: zhongj
 * @date: 2023-07-18 19:17:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition;

import java.util.function.BiPredicate;

/**
 * The Interface ConditionEntityExpressionBiLongPropertyExpression.
 *
 * @author zhongj
 */
public interface ConditionEntityExpressionLongPropertyExpression2 {

    /**
     * Value.
     *
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    void value(long min, long max);

    /**
     * Value.
     *
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(long min, long max, BiPredicate<Long, Long> ignoreStrategy);
}
