
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.query.type.EntityQueryRelationEntityExpression2;

/**
 * The Interface EntityQueryRelationEntity2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public interface EntityQueryRelationEntity2<E, R1, R2> extends EntityQueryRelation2<E, R1, R2>,
        EntityQueryRelationEntityExpression2<E, R1, R2, EntityQueryEntityProperties<E>, EntityQueryRelationEntity2<E, R1, R2>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>> {
}
