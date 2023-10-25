
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression5;

/**
 * The Interface EntityConditionGroupExpression5.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityQueryConditionGroupExpression5<E, E2, E3, E4, E5,
        C extends EntityQueryConditionGroupExpression5<E, E2, E3, E4, E5, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression5<E, E2, E3, E4, E5, C, L, S, R>,
        S extends EntityQuerySortExpression5<E, E2, E3, E4, E5, R>, R> extends
        EntityConditionGroupExpression5<E, E2, E3, E4, E5, C, L>, ConditionConfigureExpression<C, QueryConditionConfig> {
}
