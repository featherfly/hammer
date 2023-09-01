
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * StartWithExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface PropertyStartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * start with value. 以value开始.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    default L sw(String value) {
        return sw(value, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    L sw(String value, MatchStrategy queryPolicy);
}