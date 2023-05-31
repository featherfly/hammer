
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryWhereExpression5;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * The Interface EntityQueryExpression5.
 *
 * @author zhongj
 * @param <E>  the query type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <R>  the generic type
 */
public interface EntityQueryExpression5<E, E2, E3, E4, E5,
        C extends EntityQueryConditionGroupExpression5<E, E2, E3, E4, E5, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression5<E, E2, E3, E4, E5, C, L, S, R>,
        S extends EntityQuerySortExpression5<E, E2, E3, E4, E5, R>, R>
        extends EntityQueryWhereExpression5<E, E2, E3, E4, E5, C, L, S, R>, EntityQueryListExecutor<R>,
        QueryCountExecutor, EntityQueryConditionLimit<R> {
}
