
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

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * The Interface ConditionEntityExpressionStringAndArrayPropertyExpression.
 *
 * @author zhongj
 */
public interface ConditionEntityExpressionStringAndArrayPropertyExpression extends
        ConditionEntityExpressionStringPropertyExpression, ConditionEntityExpressionArrayPropertyExpression<String> {

    /**
     * {@inheritDoc}
     */
    @Override
    default void value(String... value) {
        value(value, MatchStrategy.AUTO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void value(String[] value, Predicate<String[]> ignoreStrategy) {
        value(value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * Value.
     *
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    void value(String[] value, MatchStrategy matchStrategy);

    /**
     * Value.
     *
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(String[] value, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy);
}
