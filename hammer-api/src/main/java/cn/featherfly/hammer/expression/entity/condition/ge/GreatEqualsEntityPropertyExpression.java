
package cn.featherfly.hammer.expression.entity.condition.ge;

import cn.featherfly.hammer.expression.entity.condition.CompareEntityPropertyExpression;

/**
 * The Interface GreatEqualsEntityPropertyExpression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface GreatEqualsEntityPropertyExpression<V>
        extends CompareEntityPropertyExpression<V>, GreatEqualsEntityValuePropertyExpression<V> {

    //    /**
    //     * entity great equals function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity great equals function property expression.
    //     */
    //    <R> GreatEqualsEntityPropertyExpression<R> property(SerializableFunction<V, R> name);
    //
    //    /**
    //     * entity great equals function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param <RE> the generic type
    //     * @param name the name
    //     * @return entity great equals function property expression.
    //     */
    //    <R extends Collection<RE>,
    //            RE> GreatEqualsEntityPropertyExpression<RE> property(SerializableToCollectionFunction<V, R, RE> name);
}
