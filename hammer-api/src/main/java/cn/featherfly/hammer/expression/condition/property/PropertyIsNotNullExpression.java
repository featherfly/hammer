
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * <p>
 * IsNotNullExpression
 * </p>
 *
 * @author zhongj
 */
public interface PropertyIsNotNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * is not null
     *
     * @return LogicExpression
     */
    L inn();

    /**
     * is not null.
     *
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L inn(Boolean value);
}