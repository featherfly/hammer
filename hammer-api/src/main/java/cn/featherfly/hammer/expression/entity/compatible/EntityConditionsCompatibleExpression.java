
package cn.featherfly.hammer.expression.entity.compatible;

import cn.featherfly.hammer.expression.condition.NativeStringConditionExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.ba.EntityBetweenCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.co.EntityContainsCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.eq.EntityEqualsCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.ew.EntityEndWithCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.ge.EntityGreatEqualsCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.gt.EntityGreatThanCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.in.EntityInCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.inn.EntityIsNotNullCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.isn.EntityIsNullCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.le.EntityLessEqualsCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.lk.EntityLikeCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.lt.EntityLessThanCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.nba.EntityNotBetweenCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.nco.EntityNotContainsCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.ne.EntityNotEqualsCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.newv.EntityNotEndWithCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.ni.EntityNotInCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.nl.EntityNotLikeCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.nsw.EntityNotStartWithCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.condition.sw.EntityStartWithCompatibleExpression;

/**
 * The Interface EntityConditionsCompatibleExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 */
public interface EntityConditionsCompatibleExpression<E1, C extends EntityConditionsCompatibleExpression<E1, C, L>,
    L extends EntityConditionsLogicCompatibleExpression<E1, C, L>>
    extends EntityBetweenCompatibleExpression<E1, C, L>, EntityNotBetweenCompatibleExpression<E1, C, L>,
    EntityContainsCompatibleExpression<E1, C, L>, EntityNotContainsCompatibleExpression<E1, C, L>,
    EntityEndWithCompatibleExpression<E1, C, L>, EntityNotEndWithCompatibleExpression<E1, C, L>,
    EntityEqualsCompatibleExpression<E1, C, L>, EntityNotEqualsCompatibleExpression<E1, C, L>,
    EntityGreatEqualsCompatibleExpression<E1, C, L>, EntityGreatThanCompatibleExpression<E1, C, L>,
    EntityLessEqualsCompatibleExpression<E1, C, L>, EntityLessThanCompatibleExpression<E1, C, L>,
    EntityInCompatibleExpression<E1, C, L>, EntityNotInCompatibleExpression<E1, C, L>,
    EntityStartWithCompatibleExpression<E1, C, L>, EntityNotStartWithCompatibleExpression<E1, C, L>,
    EntityLikeCompatibleExpression<E1, C, L>, EntityNotLikeCompatibleExpression<E1, C, L>,
    EntityIsNullCompatibleExpression<E1, C, L>, EntityIsNotNullCompatibleExpression<E1, C, L>,
    EntityPropertyConditionsCompatibleExpression<E1, C, L>, NativeStringConditionExpression<C, L> {

}
