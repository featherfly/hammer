
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression;

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
