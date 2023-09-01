
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * PropertyLikeExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface PropertyLikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * like value.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    default L lk(String value) {
        return lk(value, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    L lk(String value, MatchStrategy queryPolicy);
}