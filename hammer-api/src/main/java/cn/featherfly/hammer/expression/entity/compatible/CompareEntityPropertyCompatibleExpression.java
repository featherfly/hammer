
package cn.featherfly.hammer.expression.entity.compatible;

import java.util.Collection;

import cn.featherfly.hammer.expression.entity.condition.CompareEntityPropertyExpression;

/**
 * compare entity property expression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface CompareEntityPropertyCompatibleExpression<V>
    extends CompareEntityPropertyExpression<V>, CompareEntityCompatibleExpression<V> {

    /**
     * entity great than function property expression.
     *
     * @param <R> the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R> CompareEntityPropertyCompatibleExpression<R> property(String name);

    /**
     * entity great than function property expression.
     *
     * @param <R> the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R extends Collection<RE>, RE> CompareEntityPropertyCompatibleExpression<RE> propertyAsCollection(String name);
}
