
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;

/**
 * EntityUpdateNumberValueExpression.
 *
 * @author zhongj
 */
public interface EntityUpdateNumberValueExpression<E, T extends Number,
        U extends EntityPropertyExecutableUpdateExpression<E, U, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityUpdateValueExpression<E, T, U, C, L> {

    U increase(T value);
}
