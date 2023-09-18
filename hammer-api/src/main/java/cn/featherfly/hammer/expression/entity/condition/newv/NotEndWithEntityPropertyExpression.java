
package cn.featherfly.hammer.expression.entity.condition.newv;

import java.util.Collection;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;

/**
 * The Interface NotEndWithEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface NotEndWithEntityPropertyExpression<E> {

    /**
     * entity end with function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity end with function property expression
     */
    <R> NotEndWithEntityPropertyExpression<R> property(SerializableFunction<E, R> name);

    /**
     * entity end with function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity end with function property expression
     */
    <R extends Collection<RE>,
            RE> NotEndWithEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name);

    /**
     * entity end with function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity end with function property expression
     */
    <R> NotEndWithEntityPropertyValueExpression<E> property(SerializableToStringFunction<E> name);
}
