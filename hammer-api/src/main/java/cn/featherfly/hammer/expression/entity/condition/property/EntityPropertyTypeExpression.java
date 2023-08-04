
package cn.featherfly.hammer.expression.entity.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.property.TypeExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression;

/**
 * EntityPropertyTypeExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityPropertyTypeExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityPropertyExpression<E, C, L>, TypeExpression<E, C, L> {

}