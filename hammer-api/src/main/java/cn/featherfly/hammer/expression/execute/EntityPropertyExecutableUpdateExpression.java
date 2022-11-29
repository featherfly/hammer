
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.EntityWhereExpression;

/**
 * EntityPropertyExecutableUpdateExpression.
 *
 * @author zhongj
 */
public interface EntityPropertyExecutableUpdateExpression<E,
        U extends EntityPropertyExecutableUpdateExpression<E, U, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityWhereExpression<E, C, L>, EntityPropertyUpdateExpression<E, U, C, L>, Executor {

}
