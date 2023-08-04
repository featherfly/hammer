
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * ObjectExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ObjectExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends TypeExpression<Object, C, L> {
}