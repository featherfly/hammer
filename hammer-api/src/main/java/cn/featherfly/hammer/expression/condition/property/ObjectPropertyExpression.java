
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * Object property expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ObjectPropertyExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends TypePropertyExpression<Object, C, L> {
}