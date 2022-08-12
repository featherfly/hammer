
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.common.repository.operate.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * EqualsExpressoin.
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
        return eq(value, QueryPolicy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L eq(V value, QueryPolicy queryPolicy);
}