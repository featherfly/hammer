
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.condition.type.EntitySortExpression8;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQuerySortExpression8<E, E2, E3, E4, E5, E6, E7, E8, R> extends
        EntitySortExpression8<E, E2, E3, E4, E5, E6, E7, E8,
                EntityQuerySortExpression8<E, E2, E3, E4, E5, E6, E7, E8, R>>,
        EntityQueryConditionLimit<R>, EntityQueryLimitExecutor<R> {

}
