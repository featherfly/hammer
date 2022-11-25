
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.query.type.EntityQueryRelationEntityExpression;

/**
 * The Interface EntityQueryRelationEntity.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 */
public interface EntityQueryRelationEntity<E, R1> extends
        EntityQueryRelationEntityExpression<E, R1, EntityQueryEntityProperties<E>, EntityQueryRelationEntity<E, R1>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>> {
}
