
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.query.sort.EntitySortExpression;

/**
 * The Interface EntityQueryValueSortExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public interface EntityQueryValueSortExpression<E, V>
        extends EntitySortExpression<E, EntityQueryValueSortedExpression<E, V>> {

}
