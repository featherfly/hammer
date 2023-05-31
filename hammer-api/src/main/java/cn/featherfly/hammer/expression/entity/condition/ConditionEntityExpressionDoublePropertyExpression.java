
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
 * The Interface ConditionEntityExpressionDoublePropertyExpression.
 *
 * @author zhongj
 */
public interface ConditionEntityExpressionDoublePropertyExpression {

    /**
     * Value.
     *
     * @param value double value
     * @return LogicExpression
     */
    void value(double value);

    /**
     * Value.
     *
     * @param value        double value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(double value, Predicate<Double> ignoreStrategy);
}
