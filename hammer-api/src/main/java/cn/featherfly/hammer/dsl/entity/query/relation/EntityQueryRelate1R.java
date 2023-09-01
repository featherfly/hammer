
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery2;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup2;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression1R;

/**
 * The Interface EntityQueryRelate1R.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 */
public interface EntityQueryRelate1R<E, R1> extends
        EntityQueryRelateExpression1R<E, R1, EntityQueryConditionGroup2<E, R1, E>,
                EntityQueryConditionGroupLogic2<E, R1, E>, EntityQuerySortExpression2<E, R1, E>,
                EntityQueryRelatedFetched1F<E, R1>, EntityQueryConditionGroup2<E, R1, Tuple2<E, R1>>,
                EntityQueryConditionGroupLogic2<E, R1, Tuple2<E, R1>>,
                EntityQuerySortExpression2<E, R1, Tuple2<E, R1>>>,
        EntityQuery2<E, R1, E> {
}
