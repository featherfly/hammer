
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression;

/**
 * The Interface EntityQueryValueSortedExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public interface EntityQueryValueSortedExpression<E, V>
    extends EntitySortedExpression<E, EntityQueryValueSortedExpression<E, V>>,
    QueryLimitSetter<EntityQueryValueLimitExecutor<E, V>>, EntityQueryValueLimitExecutor<E, V> {

}
