
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.EntityConditionGroupExpression4;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;

/**
 * The Interface EntityConditionGroupExpression4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityQueryConditionGroupExpression4<E, E2, E3, E4,
        C extends EntityQueryConditionGroupExpression4<E, E2, E3, E4, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression4<E, E2, E3, E4, C, L, S, R>,
        S extends EntityQuerySortExpression4<E, E2, E3, E4, R>, R>
        extends EntityConditionGroupExpression4<E, E2, E3, E4, C, L>, ConditionGroupConfig<C> {
}
