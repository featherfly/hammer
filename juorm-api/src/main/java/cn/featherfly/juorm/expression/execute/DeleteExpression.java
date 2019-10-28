
package cn.featherfly.juorm.expression.execute;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.WhereExpression;

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
