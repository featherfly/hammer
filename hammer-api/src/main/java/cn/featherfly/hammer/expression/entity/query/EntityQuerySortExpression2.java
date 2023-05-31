
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.condition.type.EntitySortExpression2;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQuerySortExpression2<E, E2, R>
        extends EntitySortExpression2<E, E2, EntityQuerySortExpression2<E, E2, R>>, EntityQueryConditionLimit<R>,
        EntityQueryLimitExecutor<R> {

}
