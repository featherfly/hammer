
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryWhereExpression;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * EntityQueryEntityExpression .
 *
 * @author zhongj
 * @param <E> the query type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <S> the generic type
 */
public interface EntityQueryExpression<E, C extends EntityQueryConditionGroupExpression<E, C, L, S>,
        L extends EntityQueryConditionGroupLogicExpression<E, C, L, S>, S extends EntityQuerySortExpression<E>>
        extends EntityQueryWhereExpression<E, C, L, S>, EntityQueryListExecutor<E>, QueryCountExecutor,
        EntityQueryConditionLimit<E> /*, EntityQueryRelationSimpleExpression<E, R1, Tuple2<E, R1>, QW, QWE>*/ {
}
