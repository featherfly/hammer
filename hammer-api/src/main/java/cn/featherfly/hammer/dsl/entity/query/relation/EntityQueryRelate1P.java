
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery2;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup2;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression1P;

/**
 * The Interface EntityQueryRelate1P.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 */
public interface EntityQueryRelate1P<E, R1> extends
        EntityQueryRelateExpression1P<E, R1, EntityQueryConditionGroup2<E, R1, E>,
                EntityQueryConditionGroupLogic2<E, R1, E>, EntityQuerySortExpression2<E, R1, E>,
                EntityQueryRelatedFetched1P<E, R1>>,
        EntityQuery2<E, R1, E> {
}
