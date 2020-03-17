
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * <p>
 * InExpression
 * </p>
 *
 * @author zhongj
 */
public interface PropertyInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
        extends ConditionExpression {

    /**
     * 包含指定，sql中的in
     *
     * @param value 参数值
     * @return LogicExpression
     */
    L in(V value);
}