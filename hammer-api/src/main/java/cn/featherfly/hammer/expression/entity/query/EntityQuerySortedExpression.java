
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.data.query.QueryLimitExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQuerySortedExpression<E> extends EntitySortedExpression<E, EntityQuerySortedExpression<E>>,
    QueryLimitSetter<QueryLimitExecutor<E>>, QueryLimitExecutor<E> {

}
