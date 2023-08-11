
package cn.featherfly.hammer.expression.entity.condition.sw;

import java.util.Collection;

import cn.featherfly.common.lang.function.SerializableToStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableToCollectionFunction;

/**
 * The Interface StartWithEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface StartWithEntityPropertyExpression<E> {

    /**
     * entity start with function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity start with function property expression
     */
    <R> StartWithEntityPropertyExpression<R> property(SerializableFunction<E, R> name);

    /**
     * entity start with function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity start with function property expression
     */
    <R extends Collection<RE>,
            RE> StartWithEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name);

    /**
     * entity start with function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity start with function property expression
     */
    <R> StartWithEntityPropertyValueExpression<E> property(SerializableToStringFunction<E> name);
}
