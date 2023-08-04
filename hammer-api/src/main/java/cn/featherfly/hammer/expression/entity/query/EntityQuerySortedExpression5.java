
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression5;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * The Interface EntityQuerySortedExpression5.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <R>  the generic type
 */
public interface EntityQuerySortedExpression5<E, E2, E3, E4, E5, R>
        extends EntitySortedExpression5<E, E2, E3, E4, E5, EntityQuerySortedExpression5<E, E2, E3, E4, E5, R>>,
        EntityQueryConditionLimit<R>, EntityQueryLimitExecutor<R> {

}
