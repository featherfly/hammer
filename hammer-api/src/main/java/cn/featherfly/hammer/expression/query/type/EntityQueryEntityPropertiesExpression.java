
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.query.QueryValueExecutor;

/**
 * dsl for query data.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityQueryEntityPropertiesExpression<E,
        Q extends EntityQueryEntityPropertiesExpression<E, Q, C, L, S>,
        C extends EntityQueryConditionGroupExpression<E, C, L, S>,
        L extends EntityQueryConditionGroupLogicExpression<E, C, L, S>, S extends EntityQuerySortExpression<E>>
        //        extends EntityQueryEntityExpression<E, C, L>, QueryValueExecutor {
        extends EntityQueryPropertiesExpression<E, Q, C, L, S>, QueryValueExecutor {
}
