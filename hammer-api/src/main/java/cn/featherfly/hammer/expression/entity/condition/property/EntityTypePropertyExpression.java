
package cn.featherfly.hammer.expression.entity.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.TypeFieldExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression;

/**
 * EntityPropertyTypeExpression.
 *
 * @author zhongj
 * @param <PT> the property generic type
 * @param <C>  the ConditionExpression generic type
 * @param <L>  the LogicExpression generic type
 */
public interface EntityTypePropertyExpression<PT, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityPropertyExpression<PT, C, L>, TypeFieldExpression<PT, C, L> {

}