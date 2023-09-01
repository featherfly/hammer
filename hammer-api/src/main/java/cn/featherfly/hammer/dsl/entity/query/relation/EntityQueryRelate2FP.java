
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery3;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup3;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression2FP;

/**
 * The Interface EntityQueryRelate2FP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public interface EntityQueryRelate2FP<E, R1, R2> extends
        EntityQueryRelateExpression2FP<E, R1, R2, EntityQueryConditionGroup3<E, R1, R2, Tuple2<E, R1>>,
                EntityQueryConditionGroupLogic3<E, R1, R2, Tuple2<E, R1>>,
                EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>, EntityQueryRelatedFetched2FP<E, R1, R2>>,
        EntityQuery3<E, R1, R2, Tuple2<E, R1>> {

}
