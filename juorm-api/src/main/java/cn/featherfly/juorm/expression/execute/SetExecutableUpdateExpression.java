
package cn.featherfly.juorm.expression.execute;

import cn.featherfly.juorm.expression.ConditionGroupExpression;
import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.WhereExpression;

/**
 * <p>
 * Updator
 * </p>
 *
 * @author zhongj
 */
public interface SetExecutableUpdateExpression<U extends SetExecutableUpdateExpression<U, C, L>,
        C extends ConditionGroupExpression<C, L>, L extends ConditionGroupLogicExpression<C, L>>
        extends WhereExpression<C, L>, SetUpdateExpression<U, C, L>, Executor {
}
