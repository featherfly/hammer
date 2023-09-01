
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

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * The Interface ConditionEntityExpressionStringFuzzyQueryPropertyExpression.
 *
 * @author zhongj
 */
public interface ConditionEntityExpressionStringFuzzyQueryPropertyExpression
        extends ConditionEntityExpressionStringPropertyExpression {

    /**
     * Value.
     *
     * @param value       string value
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    void value(String value, MatchStrategy queryPolicy);

    /**
     * Value.
     *
     * @param value        string value
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void value(String value, MatchStrategy queryPolicy, Predicate<String> ignoreStrategy);
}
