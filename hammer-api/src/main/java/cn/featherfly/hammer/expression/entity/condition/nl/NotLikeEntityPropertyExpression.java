
package cn.featherfly.hammer.expression.entity.condition.nl;

import java.util.Collection;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;

/**
 * The Interface NotLikeEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface NotLikeEntityPropertyExpression<E> {

    /**
     * entity like function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity like function property expression
     */
    <R> NotLikeEntityPropertyExpression<R> property(SerializableFunction<E, R> name);

    /**
     * entity like function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity like function property expression
     */
    <R extends Collection<RE>,
            RE> NotLikeEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name);

    /**
     * entity like function property value expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity like function property value expression
     */
    <R> NotLikeEntityPropertyValueExpression<E> property(SerializableToStringFunction<E> name);

}
