
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

import java.util.function.LongPredicate;

/**
 * The Interface ConditionEntityExpressionLongPropertyExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ConditionEntityExpressionLongPropertyExpression {

    /**
     * Value.
     *
     * @param value long value
     * @return LogicExpression
     */
    void value(long value);

    /**
     * Value.
     *
     * @param value          long value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(long value, LongPredicate ignoreStrategy);
}
