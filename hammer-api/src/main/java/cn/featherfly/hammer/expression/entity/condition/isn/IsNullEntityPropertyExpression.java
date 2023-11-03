
package cn.featherfly.hammer.expression.entity.condition.isn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.field.value.SetValueIsNullOrIsNotNullExpression;
import cn.featherfly.hammer.expression.entity.condition.NullNotNullEntityExpression;

/**
 * The Interface IsNullEntityPropertyExpression.
 *
 * @author zhongj
 * @param <T> the value type
 */
public interface IsNullEntityPropertyExpression<T>
    extends SetValueIsNullOrIsNotNullExpression, NullNotNullEntityExpression<T> {

    /**
     * entity is null function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity is null function property expression
     */
    <R> IsNullEntityPropertyExpression<R> property(SerializableFunction<T, R> name);
}
