
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.EntityWhereExpression;

/**
 * EntityUpdateSetExecutableExpression.
 *
 * @author zhongj
 */
public interface EntityUpdateSetExecutableExpression<E, U extends EntityUpdateSetExecutableExpression<E, U, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityWhereExpression<E, C, L>, EntityUpdateSetExpression<E, U, C, L>, Executor {
}
