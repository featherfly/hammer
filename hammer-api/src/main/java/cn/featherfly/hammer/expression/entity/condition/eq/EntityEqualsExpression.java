
package cn.featherfly.hammer.expression.entity.condition.eq;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityEqualsExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityEqualsExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityEqualsExpressionBase<E, C, L> {

}