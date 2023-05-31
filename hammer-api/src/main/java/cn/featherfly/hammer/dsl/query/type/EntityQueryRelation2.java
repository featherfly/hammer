
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelationExpression2;

/**
 * The Interface EntityQueryRelation2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R>  the generic type
 */
public interface EntityQueryRelation2<E, R1, R2, R> extends
        EntityQueryRelationExpression2<E, R1, R2, EntityQueryConditionGroup3<E, R1, R2, R>,
                EntityQueryConditionGroupLogic3<E, R1, R2, R>, EntityQuerySortExpression3<E, R1, R2, R>, R>,
        EntityQuery3<E, R1, R2, R> {
}
