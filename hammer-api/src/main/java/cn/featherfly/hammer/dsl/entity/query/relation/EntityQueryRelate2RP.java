
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery3;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup3;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression2RP;

/**
 * The Interface EntityQueryRelate2RP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public interface EntityQueryRelate2RP<E, R1, R2> extends
        EntityQueryRelateExpression2RP<E, R1, R2, EntityQueryConditionGroup3<E, R1, R2, E>,
                EntityQueryConditionGroupLogic3<E, R1, R2, E>, EntityQuerySortExpression3<E, R1, R2, E>,
                EntityQueryRelatedFetched2RP<E, R1, R2>>,
        EntityQuery3<E, R1, R2, E> {
}
