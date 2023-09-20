
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
public interface BetweenAndEntityPropertyExpression<V> extends BetweenAndEntityValuePropertyExpression<V> {

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R> BetweenAndEntityPropertyExpression<R> property(SerializableFunction<V, R> name);

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R extends Collection<RE>,
            RE> BetweenAndEntityPropertyExpression<RE> property(SerializableToCollectionFunction<V, R, RE> name);
}
