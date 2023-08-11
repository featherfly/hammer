
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.expression.entity.EntityWhereExpression;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * EntityPropertyExecutableUpdateExpression.
 *
 * @author zhongj
 */
public interface EntityPropertyExecutableUpdateExpression<E,
        U extends EntityPropertyExecutableUpdateExpression<E, U, C, L>,
        C extends EntityExecutableConditionGroupExpression<E, C, L>,
        L extends EntityExecutableConditionGroupLogicExpression<E, C, L>>
        extends EntityWhereExpression<E, C, L>, EntityPropertyUpdateExpression<E, U, C, L>, Executor {

}
