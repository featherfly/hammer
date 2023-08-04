
package cn.featherfly.hammer.expression.entity.condition.co;

import java.util.Collection;

import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableToCollectionFunction;

/**
 * The Interface ContainsEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface ContainsEntityPropertyExpression<E> {

    /**
     * entity contains function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity contains function property expression
     */
    <R> ContainsEntityPropertyExpression<R> property(SerializableFunction<E, R> name);

    /**
     * entity contains function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity contains function property expression
     */
    <R extends Collection<RE>,
            RE> ContainsEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name);

    /**
     * entity contains function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity contains function property expression
     */
    <R> ContainsEntityPropertyValueExpression<E> property(ReturnStringFunction<E> name);
}
