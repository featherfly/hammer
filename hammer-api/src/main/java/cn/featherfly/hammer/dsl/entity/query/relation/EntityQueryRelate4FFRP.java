
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery5;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * The Interface EntityQueryRelate4FFRP.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 * @param <R4> query or joined type
 */
public interface EntityQueryRelate4FFRP<E, R1, R2, R3, R4> extends EntityQueryRelate4FFRXBase<E, R1, R2, R3, R4>,
        QueryRelateExpression<EntityQueryRelatedFetched4FFRP<E, R1, R2, R3, R4>>,
        EntityQuery5<E, R1, R2, R3, R4, Tuple3<E, R1, R2>> {

}
