
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.condition.type.EntitySortExpression6;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, R>
        extends EntitySortExpression6<E, E2, E3, E4, E5, E6, EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, R>>,
        EntityQueryConditionLimit<R>, EntityQueryLimitExecutor<R> {

}
