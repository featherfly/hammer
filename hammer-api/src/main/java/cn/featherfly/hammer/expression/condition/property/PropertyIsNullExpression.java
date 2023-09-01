
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * <p>
 * IsNullExpression
 * </p>
 *
 * @author zhongj
 */
public interface PropertyIsNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * is null
     *
     * @return LogicExpression
     */
    default L isn() {
        return isn(true);
    }

    /**
     * is null
     *
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L isn(Boolean value);
}