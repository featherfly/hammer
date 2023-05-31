
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.query.type.EntityQueryExpression2;

/**
 * dsl for query entity.
 *
 * @author zhongj
 */
public interface EntityQuery2<E, E2, R> extends EntityQueryExpression2<E, E2, EntityQueryConditionGroup2<E, E2, R>,
        EntityQueryConditionGroupLogic2<E, E2, R>, EntityQuerySortExpression2<E, E2, R>, R> {
}
