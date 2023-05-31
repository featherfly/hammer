
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.EntityConditionGroupExpression3;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;

/**
 * The Interface EntityConditionGroupExpression3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityQueryConditionGroupExpression3<E, E2, E3,
        C extends EntityQueryConditionGroupExpression3<E, E2, E3, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression3<E, E2, E3, C, L, S, R>,
        S extends EntityQuerySortExpression3<E, E2, E3, R>, R>
        extends EntityConditionGroupExpression3<E, E2, E3, C, L>, ConditionGroupConfig<C> {
}
