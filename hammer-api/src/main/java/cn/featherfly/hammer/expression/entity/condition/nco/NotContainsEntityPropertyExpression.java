
package cn.featherfly.hammer.expression.entity.condition.nco;

import java.util.Collection;

import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;

/**
 * The Interface ContainsEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface NotContainsEntityPropertyExpression<E> {

    /**
     * entity contains function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity contains function property expression
     */
    <R> NotContainsEntityPropertyExpression<R> property(SerializableFunction<E, R> name);

    /**
     * entity contains function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity contains function property expression
     */
    <R extends Collection<RE>,
            RE> NotContainsEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name);

    /**
     * entity contains function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity contains function property expression
     */
    <R> NotContainsEntityPropertyValueExpression<E> property(SerializableToStringFunction<E> name);
}
