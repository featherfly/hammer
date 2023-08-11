
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression3;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <R>  the generic type
 */
public interface EntityQuerySortedExpression3<E, E2, E3, R>
        extends EntitySortedExpression3<E, E2, E3, EntityQuerySortedExpression3<E, E2, E3, R>>,
        EntityQueryConditionLimit<R>, EntityQueryLimitExecutor<R> {

}
