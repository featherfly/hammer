
package cn.featherfly.hammer.expression.entity.condition;

import java.util.Collection;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;

/**
 * The Interface BetweenAndEntityPropertyExpression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface BetweenAndEntityPropertyExpression<V>
    extends BetweenAndEntityExpression<V>, BetweenAndEntityValuePropertyExpression<V> {

    /**
     * entity between and function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity between and function property expression.
     */
    <R> BetweenAndEntityPropertyExpression<R> property(SerializableFunction<V, R> name);

    /**
     * entity between and function property expression.
     *
     * @param <R>  the generic type
     * @param <E>  the generic type
     * @param name the name
     * @return entity between and function property expression.
     */
    <R extends Collection<E>,
        E> BetweenAndEntityPropertyExpression<E> property(SerializableToCollectionFunction<V, R, E> name);
}
