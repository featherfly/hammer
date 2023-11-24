
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery4;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * The Interface EntityQueryRelate3FFP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public interface EntityQueryRelate3FFP<E, R1, R2, R3> extends EntityQueryRelate3FFXBase<E, R1, R2, R3>,
        QueryRelateExpression<EntityQueryRelatedFetched3FFP<E, R1, R2, R3>>, EntityQuery4<E, R1, R2, R3, Tuple3<E, R1, R2>>

{

}
