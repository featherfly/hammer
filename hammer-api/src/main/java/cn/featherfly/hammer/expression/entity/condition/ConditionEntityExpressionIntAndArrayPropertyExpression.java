
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

import java.util.function.Predicate;

/**
 * The Interface ConditionEntityExpressionIntAndArrayPropertyExpression.
 *
 * @author zhongj
 */
public interface ConditionEntityExpressionIntAndArrayPropertyExpression
        extends ConditionEntityExpressionIntPropertyExpression {

    /**
     * Value,.
     *
     * @param value values with Array
     * @return LogicExpression
     */
    void value(int... value);

    /**
     * Value,.
     *
     * @param value        values with Array
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(int[] value, Predicate<int[]> ignoreStrategy);
}
