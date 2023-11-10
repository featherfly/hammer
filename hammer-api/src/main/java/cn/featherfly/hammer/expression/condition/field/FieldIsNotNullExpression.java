
package cn.featherfly.hammer.expression.condition.field;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * field is not null expression.
 *
 * @author zhongj
 */
public interface FieldIsNotNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * is not null
     *
     * @return LogicExpression
     */
    default L inn() {
        return inn(true);
    }

    /**
     * is not null.
     *
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L inn(Boolean value);
}