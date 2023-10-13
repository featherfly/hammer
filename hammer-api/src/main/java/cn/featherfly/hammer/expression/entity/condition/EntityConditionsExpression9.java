
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression;

/**
 * The Interface EntityConditionsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
// TODO 未实现
public interface EntityConditionsExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9,
        C extends EntityConditionsExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9, C, L>, L extends LogicExpression<C, L>>
        extends EntityContainsExpression<E, C, L>, EntityEndWithExpression<E, C, L>, EntityEqualsExpression<E, C, L>,
        EntityGreatEqualsExpression<E, C, L>, EntityGreatThanExpression<E, C, L>, EntityInExpression<E, C, L>,
        EntityIsNotNullExpression<E, C, L>, EntityIsNullExpression<E, C, L>, EntityLessEqualsExpression<E, C, L>,
        EntityLessThanExpression<E, C, L>, EntityNotEqualsExpression<E, C, L>, EntityNotInExpression<E, C, L>,
        EntityStartWithExpression<E, C, L>, EntityLikeExpression<E, C, L>
//        ,EntityPropertyConditionsExpression<E, C, L>
{
}
