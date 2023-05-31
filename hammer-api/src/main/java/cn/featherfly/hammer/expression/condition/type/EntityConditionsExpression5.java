
package cn.featherfly.hammer.expression.condition.type;

import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityConditionsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
// TODO 未实现
public interface EntityConditionsExpression5<E, E2, E3, E4, E5,
        C extends EntityConditionsExpression5<E, E2, E3, E4, E5, C, L>, L extends LogicExpression<C, L>>
        extends EntityContainsExpression<E, C, L>, EntityEndWithExpression<E, C, L>,
        EntityEqualsExpression2<E, E2, C, L>, EntityGreatEqualsExpressoin<E, C, L>, EntityGreatThanExpressoin<E, C, L>,
        EntityInExpression<E, C, L>, EntityIsNotNullExpression<E, C, L>, EntityIsNullExpression<E, C, L>,
        EntityLessEqualsExpressoin<E, C, L>, EntityLessThanExpressoin<E, C, L>, EntityNotEqualsExpression<E, C, L>,
        EntityNotInExpression<E, C, L>, EntityStartWithExpression<E, C, L>, EntityLikeExpression<E, C, L>
//        ,EntityPropertyConditionsExpression<E, C, L>
{
}
