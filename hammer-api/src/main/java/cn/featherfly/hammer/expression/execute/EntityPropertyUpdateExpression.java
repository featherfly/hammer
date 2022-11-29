
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;

/**
 * EntityPropertyUpdateExpression.
 *
 * @author zhongj
 */
public interface EntityPropertyUpdateExpression<E, U extends EntityPropertyExecutableUpdateExpression<E, U, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>> {

    <R> EntityUpdateValueExpression<E, R, U, C, L> property(SerializableFunction<E, R> name);

    <R extends Number> EntityUpdateNumberValueExpression<E, R, U, C, L> property(SerializableFunction2<E, R> name);
}
