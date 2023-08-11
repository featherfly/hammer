
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;

/**
 * dsl for query entity.
 *
 * @author zhongj
 */
public interface EntityQuery3<E, E2, E3, R>
        extends EntityQueryExpression3<E, E2, E3, EntityQueryConditionGroup3<E, E2, E3, R>,
                EntityQueryConditionGroupLogic3<E, E2, E3, R>, EntityQuerySortExpression3<E, E2, E3, R>, R> {
}
