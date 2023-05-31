
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.api.Queryable;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * The Interface EntityConditionGroupLogicExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityQueryConditionGroupLogicExpression3<E, E2, E3,
        C extends EntityQueryConditionGroupExpression3<E, E2, E3, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression3<E, E2, E3, C, L, S, R>,
        S extends EntityQuerySortExpression3<E, E2, E3, R>, R>
        extends EntityConditionGroupLogicExpression3<E, E2, E3, C, L>, Queryable<S>, EntityQueryConditionLimit<R>,
        EntityQueryLimitExecutor<R> {

}
