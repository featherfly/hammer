
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression;

/**
 * EntityUpdateExpression.
 *
 * @author zhongj
 */
public interface EntityUpdateExpression<E, U extends EntityExecutableUpdateExpression<E, U, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityPropertyUpdateExpression<E, U, C, L>, EntityUpdateSetExpression<E, U, C, L> {

}
