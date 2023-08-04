
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.hammer.expression.api.Queryable;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryWhereExpression3;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * The Interface EntityQueryExpression3.
 *
 * @author zhongj
 * @param <E>  the query type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <R>  the generic type
 */
public interface EntityQueryExpression3<E, E2, E3,
        C extends EntityQueryConditionGroupExpression3<E, E2, E3, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression3<E, E2, E3, C, L, S, R>,
        S extends EntityQuerySortExpression3<E, E2, E3, R>, R>
        extends EntityQueryWhereExpression3<E, E2, E3, C, L, S, R>, EntityQueryListExecutor<R>, QueryCountExecutor,
        EntityQueryConditionLimit<R>, Queryable<S> {
}
