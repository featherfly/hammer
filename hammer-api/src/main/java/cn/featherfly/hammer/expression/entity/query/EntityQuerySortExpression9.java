
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.condition.type.EntitySortExpression9;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQuerySortExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9, R> extends
        EntitySortExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9,
                EntityQuerySortExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9, R>>,
        EntityQueryConditionLimit<R>, EntityQueryLimitExecutor<R> {

}
