
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

import java.util.function.Predicate;

/**
 * set double array expression.
 *
 * @author zhongj
 */
public interface SetDoubleArrayExpression extends SetDoubleExpression {

    /**
     * Value,.
     *
     * @param value values with Array
     */
    void value(double... value);

    /**
     * Value,.
     *
     * @param value          values with Array
     * @param ignoreStrategy the ignore strategy
     */
    void value(double[] value, Predicate<double[]> ignoreStrategy);
}
