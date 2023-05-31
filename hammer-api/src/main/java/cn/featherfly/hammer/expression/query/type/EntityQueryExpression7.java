
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression7;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression7;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression7;
import cn.featherfly.hammer.expression.entity.query.EntityQueryWhereExpression7;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * The Interface EntityQueryExpression7.
 *
 * @author zhongj
 * @param <E>  the query type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <E7> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <R>  the generic type
 */
public interface EntityQueryExpression7<E, E2, E3, E4, E5, E6, E7,
        C extends EntityQueryConditionGroupExpression7<E, E2, E3, E4, E5, E6, E7, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression7<E, E2, E3, E4, E5, E6, E7, C, L, S, R>,
        S extends EntityQuerySortExpression7<E, E2, E3, E4, E5, E6, E7, R>, R>
        extends EntityQueryWhereExpression7<E, E2, E3, E4, E5, E6, E7, C, L, S, R>, EntityQueryListExecutor<R>,
        QueryCountExecutor, EntityQueryConditionLimit<R> {
}
