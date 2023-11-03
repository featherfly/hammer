
package cn.featherfly.hammer.expression.condition.field;

import java.io.Serializable;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * Object field expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface SerializableFieldExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends TypeFieldExpression<Serializable, C, L> {
}