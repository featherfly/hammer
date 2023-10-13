
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityConditionFunctionStringPropertyExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: EntityConditionFunctionStringPropertyExpression
 * @author: zhongj
 * @date: 2023-07-18 19:59:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition;

import java.util.function.Predicate;

/**
 * The Interface ConditionEntityExpressionPropertyExpression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface ConditionEntityExpressionPropertyExpression<V> {

    /**
     * Value.
     *
     * @param value the value
     * @return LogicExpression
     */
    void value(V value);

    /**
     * Value.
     *
     * @param value        the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(V value, Predicate<V> ignoreStrategy);
}
