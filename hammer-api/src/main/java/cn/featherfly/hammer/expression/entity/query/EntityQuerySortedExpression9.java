
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression9;
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
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <E7> the generic type
 * @param <E8> the generic type
 * @param <E9> the generic type
 * @param <R>  the generic type
 */
public interface EntityQuerySortedExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9, R> extends
        EntitySortedExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9,
                EntityQuerySortedExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9, R>>,
        EntityQueryConditionLimit<R>, EntityQueryLimitExecutor<R> {

}
