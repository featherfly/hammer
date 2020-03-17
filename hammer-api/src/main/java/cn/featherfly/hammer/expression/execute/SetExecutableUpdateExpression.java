
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.expression.ConditionGroupExpression;
import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.WhereExpression;

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
