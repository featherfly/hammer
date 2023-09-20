
package cn.featherfly.hammer.expression.entity.condition.nsw;

import java.util.Collection;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;

/**
 * The Interface NotStartWithEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface NotStartWithEntityPropertyExpression<E> {

    /**
     * entity start with function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity start with function property expression
     */
    <R> NotStartWithEntityPropertyExpression<R> property(SerializableFunction<E, R> name);

    /**
     * entity start with function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity start with function property expression
     */
    <R extends Collection<RE>,
            RE> NotStartWithEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name);

    /**
     * entity start with function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity start with function property expression
     */
    <R> NotStartWithEntityPropertyValueExpression<E> property(SerializableToStringFunction<E> name);
}
