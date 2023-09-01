
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * NotEqualsExpression.
 *
 * @author zhongj
 */
public interface PropertyNotEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
        extends ConditionExpression {

    /**
     * not equals. 不等于.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    default L ne(V value) {
        return ne(value, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L ne(V value, MatchStrategy queryPolicy);
}