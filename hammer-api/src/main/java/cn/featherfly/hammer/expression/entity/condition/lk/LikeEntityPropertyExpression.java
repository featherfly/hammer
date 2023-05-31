
package cn.featherfly.hammer.expression.entity.condition.lk;

import java.util.Collection;

import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableToCollectionFunction;

/**
 * The Interface LikeEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface LikeEntityPropertyExpression<E> {

    /**
     * entity like function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity like function property expression
     */
    <R> LikeEntityPropertyExpression<R> property(SerializableFunction<E, R> name);

    /**
     * entity like function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity like function property expression
     */
    <R extends Collection<RE>,
            RE> LikeEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name);

    /**
     * entity like function property value expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity like function property value expression
     */
    <R> LikeEntityPropertyValueExpression<E> property(ReturnStringFunction<E> name);

}
