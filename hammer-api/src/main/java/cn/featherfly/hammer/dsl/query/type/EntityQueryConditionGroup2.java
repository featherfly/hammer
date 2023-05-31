
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;

/**
 * The Interface EntityQueryConditionGroupExpression.
 *
 * @author zhongj
 */
public interface EntityQueryConditionGroup2<E, E2, R>
        extends EntityQueryConditionGroupExpression2<E, E2, EntityQueryConditionGroup2<E, E2, R>,
                EntityQueryConditionGroupLogic2<E, E2, R>, EntityQuerySortExpression2<E, E2, R>, R> {

}
