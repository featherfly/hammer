
package cn.featherfly.hammer.expression.entity.condition.inn;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * The Interface IsNotNullEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNotNullEntityPropertyExpression<E, V> {

    /**
     * entity is not null function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity is not null function property expression
     */
    <R> IsNotNullEntityPropertyExpression<V, R> property(SerializableFunction<V, R> name);

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
