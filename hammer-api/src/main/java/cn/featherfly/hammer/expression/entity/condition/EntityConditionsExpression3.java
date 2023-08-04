
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression3;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression3;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression3;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression3;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression3;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression3;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression3;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression3;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.nin.EntityNotInExpression3;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression3;

/**
 * The Interface EntityConditionsExpression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityConditionsExpression3<E, E2, E3, C extends EntityConditionsExpression3<E, E2, E3, C, L>,
        L extends LogicExpression<C, L>> extends EntityContainsExpression3<E, E2, E3, C, L>,
        EntityEndWithExpression3<E, E2, E3, C, L>, EntityEqualsExpression3<E, E2, E3, C, L>,
        EntityGreatEqualsExpression3<E, E2, E3, C, L>, EntityGreatThanExpression3<E, E2, E3, C, L>,
        EntityInExpression3<E, E2, E3, C, L>, EntityIsNotNullExpression3<E, E2, E3, C, L>,
        EntityIsNullExpression3<E, E2, E3, C, L>, EntityLessEqualsExpression3<E, E2, E3, C, L>,
        EntityLessThanExpression3<E, E2, E3, C, L>, EntityNotEqualsExpression3<E, E2, E3, C, L>,
        EntityNotInExpression3<E, E2, E3, C, L>, EntityStartWithExpression3<E, E2, E3, C, L>,
        EntityLikeExpression3<E, E2, E3, C, L>, EntityPropertyExpression3<E, E2, E3, C, L> {
}
