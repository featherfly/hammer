
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * EndWithExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface PropertyEndWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * end with value.以value结尾.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    default L ew(String value) {
        return ew(value, MatchStrategy.AUTO);
    }

    /**
     * end with value.以value结尾.
     *
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    L ew(String value, MatchStrategy queryPolicy);
}