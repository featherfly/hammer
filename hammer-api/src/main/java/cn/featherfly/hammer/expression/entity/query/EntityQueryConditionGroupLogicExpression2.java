
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.api.Queryable;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * The Interface EntityConditionGroupLogicExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityQueryConditionGroupLogicExpression2<E, E2,
        C extends EntityQueryConditionGroupExpression2<E, E2, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression2<E, E2, C, L, S, R>,
        S extends EntityQuerySortExpression2<E, E2, R>, R> extends EntityConditionGroupLogicExpression2<E, E2, C, L>,
        Queryable<S>, EntityQueryConditionLimit<R>, EntityQueryLimitExecutor<R>, QueryCountExecutor {
}
