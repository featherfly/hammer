
package cn.featherfly.hammer.expression.entity.condition.ew;

import java.util.Collection;

import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;

/**
 * The Interface EndWithEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EndWithEntityPropertyExpression<E> {

    /**
     * entity end with function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity end with function property expression
     */
    <R> EndWithEntityPropertyExpression<R> property(SerializableFunction<E, R> name);

    /**
     * entity end with function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity end with function property expression
     */
    <R extends Collection<RE>,
            RE> EndWithEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name);

    /**
     * entity end with function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity end with function property expression
     */
    <R> EndWithEntityPropertyValueExpression<E> property(SerializableToStringFunction<E> name);
}
