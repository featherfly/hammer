
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;

/**
 * The Interface EntityQueryConditionGroupExpression.
 *
 * @author zhongj
 */
public interface EntityQueryConditionGroup3<E, E2, E3, R>
        extends EntityQueryConditionGroupExpression3<E, E2, E3, EntityQueryConditionGroup3<E, E2, E3, R>,
                EntityQueryConditionGroupLogic3<E, E2, E3, R>, EntityQuerySortExpression3<E, E2, E3, R>, R> {

}
