
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.query.type.EntityQueryEntityPropertiesExpression;

/**
 * The Interface EntityQueryEntityProperties.
 *
 * @author zhongj
 */
public interface EntityQueryEntityProperties<E>
        extends EntityQueryEntityPropertiesExpression<E, EntityQueryEntityProperties<E>, EntityQueryConditionGroup<E>,
                EntityQueryConditionGroupLogic<E>, EntityQuerySortExpression<E>> {
}
