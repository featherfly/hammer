
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression2;

/**
 * The Interface EntityQuerySortedExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <R>  the generic type
 */
public interface EntityQuerySortedExpression2<E, E2, R>
        extends EntitySortedExpression2<E, E2, EntityQuerySortedExpression2<E, E2, R>>, EntityQueryConditionLimit<EntityQueryLimitExecutor<R>>,
        EntityQueryLimitExecutor<R> {

}
