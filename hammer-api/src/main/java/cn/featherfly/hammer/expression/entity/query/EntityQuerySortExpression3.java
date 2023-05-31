
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.condition.type.EntitySortExpression3;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQuerySortExpression3<E, E2, E3, R>
        extends EntitySortExpression3<E, E2, E3, EntityQuerySortExpression3<E, E2, E3, R>>,
        EntityQueryConditionLimit<R>, EntityQueryLimitExecutor<R> {

}
