
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression4;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <R>  the generic type
 */
public interface EntityQuerySortedExpression4<E, E2, E3, E4, R>
        extends EntitySortedExpression4<E, E2, E3, E4, EntityQuerySortedExpression4<E, E2, E3, E4, R>>,
        EntityQueryConditionLimit<R>, EntityQueryLimitExecutor<R> {

}
