
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression2;

/**
 * The Interface EntityConditionGroupExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityQueryConditionGroupExpression2<E, E2,
        C extends EntityQueryConditionGroupExpression2<E, E2, C, L, S, R>,
        L extends EntityQueryConditionGroupLogicExpression2<E, E2, C, L, S, R>,
        S extends EntityQuerySortExpression2<E, E2, R>, R>
        extends EntityConditionGroupExpression2<E, E2, C, L>, ConditionGroupConfig<C> {
}
