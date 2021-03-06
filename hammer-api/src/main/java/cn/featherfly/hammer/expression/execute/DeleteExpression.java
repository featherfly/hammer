
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.expression.ConditionGroupExpression;
import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.WhereExpression;

/**
 * <p>
 * Delete
 * </p>
 *
 * @author zhongj
 */
public interface DeleteExpression<C extends ConditionGroupExpression<C, L>,
        L extends ConditionGroupLogicExpression<C, L>> extends WhereExpression<C, L> {
}
