
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.query.type.EntityQueryExpression3;

/**
 * dsl for query entity.
 *
 * @author zhongj
 */
public interface EntityQuery3<E, E2, E3, R>
        extends EntityQueryExpression3<E, E2, E3, EntityQueryConditionGroup3<E, E2, E3, R>,
                EntityQueryConditionGroupLogic3<E, E2, E3, R>, EntityQuerySortExpression3<E, E2, E3, R>, R> {
}
