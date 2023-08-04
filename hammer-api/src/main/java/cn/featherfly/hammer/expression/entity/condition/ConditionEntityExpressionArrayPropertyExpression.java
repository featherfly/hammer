
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
 * The Interface ConditionEntityExpressionArrayPropertyExpression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface ConditionEntityExpressionArrayPropertyExpression<V>
        extends ConditionEntityExpressionPropertyExpression<V> {

    /**
     * Value.
     *
     * @param value values with Array
     * @return LogicExpression
     */
    void value(@SuppressWarnings("unchecked") V... value);

    /**
     * Value.
     *
     * @param value        values with Array
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(V[] value, Predicate<V[]> ignoreStrategy);
}
