
package cn.featherfly.hammer.expression.entity.condition.gt;

import cn.featherfly.hammer.expression.entity.condition.CompareEntityPropertyExpression;

/**
 * The Interface GreatThanEntityPropertyExpression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface GreatThanEntityPropertyExpression<V>
        extends CompareEntityPropertyExpression<V>, GreatThanEntityValuePropertyExpression<V> {

    //    /**
    //     * entity great than function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity great than function property expression.
    //     */
    //    <R> GreatThanEntityPropertyExpression<R> property(SerializableFunction<V, R> name);
    //
    //    /**
    //     * entity great than function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param <RE> the generic type
    //     * @param name the name
    //     * @return entity great than function property expression.
    //     */
    //    <R extends Collection<RE>,
    //            RE> GreatThanEntityPropertyExpression<RE> property(SerializableToCollectionFunction<V, R, RE> name);
}
