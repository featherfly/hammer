
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;

/**
 * dsl for query entity.
 *
 * @author zhongj
 */
public interface EntityQuery2<E, E2, R> extends EntityQueryExpression2<E, E2, EntityQueryConditionGroup2<E, E2, R>,
        EntityQueryConditionGroupLogic2<E, E2, R>, EntityQuerySortExpression2<E, E2, R>, R> {
}
