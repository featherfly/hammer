
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.EntityWhereExpression;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * EntityQueryEntityExpression .
 *
 * @author zhongj
 * @param <E> the query type
 * @param <Q> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityQueryExpression<E, Q extends EntityQueryEntityPropertiesExpression<E, Q, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityWhereExpression<E, C, L>, EntityQueryListExecutor<E>, QueryCountExecutor,
        EntityQueryConditionLimit<E> /*, EntityQueryRelationSimpleExpression<E, R1, Tuple2<E, R1>, QW, QWE>*/ {
}
