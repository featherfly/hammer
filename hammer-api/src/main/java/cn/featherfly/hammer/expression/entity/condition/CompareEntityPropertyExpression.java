
package cn.featherfly.hammer.expression.entity.condition;

import java.util.Collection;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;

/**
 * The Interface ConpareEntityPropertyExpression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface CompareEntityPropertyExpression<V>
        extends CompareEntityValuePropertyExpression<V>, CompareEntityExpression<V> {

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R> CompareEntityPropertyExpression<R> property(SerializableFunction<V, R> name);

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R extends Collection<RE>,
            RE> CompareEntityPropertyExpression<RE> property(SerializableToCollectionFunction<V, R, RE> name);
}
