
package cn.featherfly.hammer.expression.condition.field;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * Object field expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ObjectFieldExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends TypeFieldExpression<Object, C, L> {
}