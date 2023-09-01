
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * EqualsExpression.
 *
 * @author zhongj
 */
public interface PropertyEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
        extends ConditionExpression {

    /**
     * equals. 等于.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    default L eq(V value) {
        return eq(value, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L eq(V value, MatchStrategy queryPolicy);
}