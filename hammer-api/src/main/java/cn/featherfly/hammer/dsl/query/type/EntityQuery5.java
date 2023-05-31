
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;
import cn.featherfly.hammer.expression.query.type.EntityQueryExpression5;

/**
 * dsl for query entity.
 *
 * @author zhongj
 */
public interface EntityQuery5<E, E2, E3, E4, E5, R> extends
        EntityQueryExpression5<E, E2, E3, E4, E5, EntityQueryConditionGroup5<E, E2, E3, E4, E5, R>,
                EntityQueryConditionGroupLogic5<E, E2, E3, E4, E5, R>, EntityQuerySortExpression5<E, E2, E3, E4, E5, R>,
                R> {
}
