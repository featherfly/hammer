
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.query.type.EntityQueryRelationEntityExpression3;

/**
 * The Interface EntityQueryRelationEntity3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public interface EntityQueryRelationEntity3<E, R1, R2, R3> extends EntityQueryRelation3<E, R1, R2, R3>,
        EntityQueryRelationEntityExpression3<E, R1, R2, R3, EntityQueryEntityProperties<E>, EntityQueryRelationEntity3<E, R1, R2, R3>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>> {
}
