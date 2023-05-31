
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelationExpression3;

/**
 * EntityQueryRelation3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R>  the generic type
 */
public interface EntityQueryRelation3<E, R1, R2, R3, R> extends
        EntityQueryRelationExpression3<E, R1, R2, R3, EntityQueryConditionGroup4<E, R1, R2, R3, R>,
                EntityQueryConditionGroupLogic4<E, R1, R2, R3, R>, EntityQuerySortExpression4<E, R1, R2, R3, R>, R>,
        EntityQuery4<E, R1, R2, R3, R> {
}
