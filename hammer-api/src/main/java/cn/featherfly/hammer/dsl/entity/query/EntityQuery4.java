
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;

/**
 * dsl for query entity.
 *
 * @author zhongj
 */
public interface EntityQuery4<E, E2, E3, E4, R>
        extends EntityQueryExpression4<E, E2, E3, E4, EntityQueryConditionGroup4<E, E2, E3, E4, R>,
                EntityQueryConditionGroupLogic4<E, E2, E3, E4, R>, EntityQuerySortExpression4<E, E2, E3, E4, R>, R> {
}
