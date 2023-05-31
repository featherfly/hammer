
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.hammer.expression.api.Queryable;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression9;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression9;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression9;
import cn.featherfly.hammer.expression.entity.query.EntityQueryWhereExpression9;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * The Interface EntityQueryExpression9.
 *
 * @author zhongj
 * @param <E>  the query type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <E7> the generic type
 * @param <E8> the generic type
 * @param <E9> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <R>  the generic type
 */
public interface EntityQueryExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9,
        C extends EntityQueryConditionGroupExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9, C, L, S, R>,
        S extends EntityQuerySortExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9, R>, R>
        extends EntityQueryWhereExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9, C, L, S, R>, EntityQueryListExecutor<R>,
        QueryCountExecutor, EntityQueryConditionLimit<R>, Queryable<S> {
}
