
package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.api.entity.QueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;

/**
 * The Interface EntityQueryRelateExpression2FP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <F>  the generic type
 * @param <FC> the generic type
 * @param <FL> the generic type
 * @param <FS> the generic type
 */
public interface EntityQueryRelateExpression2FP<E, R1, R2,
        C extends EntityQueryConditionGroupExpression3<E, R1, R2, C, L, S, Tuple2<E, R1>>,
        L extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, C, L, S, Tuple2<E, R1>>,
        S extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
        F extends EntityQueryRelatedFetchedExpression2FP<E, R1, R2, C, L, S>>
        extends EntityQueryRelateExpression2FXBase<E, R1, R2, C, L, S>, QueryRelate<F> {

}
