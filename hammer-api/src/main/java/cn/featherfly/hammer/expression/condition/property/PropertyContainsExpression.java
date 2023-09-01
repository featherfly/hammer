
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * ContainsExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface PropertyContainsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * contains value. 包含value.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    default L co(String value) {
        return co(value, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    L co(String value, MatchStrategy queryPolicy);
}