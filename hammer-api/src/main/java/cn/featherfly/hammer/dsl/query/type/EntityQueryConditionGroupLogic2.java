
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;

/**
 * The Interface EntityQueryConditionGroupLogicExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryConditionGroupLogic2<E, E2, R>
        extends EntityQueryConditionGroupLogicExpression2<E, E2, EntityQueryConditionGroup2<E, E2, R>,
                EntityQueryConditionGroupLogic2<E, E2, R>, EntityQuerySortExpression2<E, E2, R>, R> {

}
