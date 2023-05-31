
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.condition.type.EntitySortExpression5;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQuerySortExpression5<E, E2, E3, E4, E5, R>
        extends EntitySortExpression5<E, E2, E3, E4, E5, EntityQuerySortExpression5<E, E2, E3, E4, E5, R>>,
        EntityQueryConditionLimit<R>, EntityQueryLimitExecutor<R> {

}
