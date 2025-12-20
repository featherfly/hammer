
package cn.featherfly.hammer.expression.entity.condition.inn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.field.value.SetIsNullOrIsNotNullValueExpression;
import cn.featherfly.hammer.expression.entity.condition.NullNotNullEntityExpression;

/**
 * The Interface IsNotNullEntityPropertyExpression.
 *
 * @author zhongj
 * @param <T> the value type
 */
public interface IsNotNullEntityPropertyExpression<T>
    extends SetIsNullOrIsNotNullValueExpression, NullNotNullEntityExpression<T> {

    /**
     * entity is not null function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity is not null function property expression
     */
    <R> IsNotNullEntityPropertyExpression<R> property(SerializableFunction<T, R> name);

}
