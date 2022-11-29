
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;

/**
 * ExecutableUpdateExpression.
 *
 * @author zhongj
 */
public interface EntityExecutableUpdateExpression<E, U extends EntityExecutableUpdateExpression<E, U, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityUpdateExpression<E, U, C, L>, EntityPropertyExecutableUpdateExpression<E, U, C, L>,
        EntityUpdateSetExecutableExpression<E, U, C, L> {

}
