
package cn.featherfly.hammer.expression.entity.condition.isn;

import cn.featherfly.common.function.serializable.SerializableFunction;

/**
 * The Interface IsNullEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNullEntityPropertyExpression<E, V> {

    /**
     * entity is null function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity is null function property expression
     */
    <R> IsNullEntityPropertyExpression<V, R> property(SerializableFunction<V, R> name);

    /**
     * Value.
     *
     * @return LogicExpression
     */
    void value();

    /**
     * Value.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    void value(Boolean value);
}
