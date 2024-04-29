
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.NativeStringConditionExpression;
import cn.featherfly.hammer.expression.entity.condition.ba.EntityBetweenExpression;
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
import cn.featherfly.hammer.expression.entity.condition.nba.EntityNotBetweenExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.EntityNotContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.newv.EntityNotEndWithExpression;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpression;
import cn.featherfly.hammer.expression.entity.condition.nl.EntityNotLikeExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.EntityNotStartWithExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression;

/**
 * The Interface EntityConditionsExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsExpression<E1, C extends EntityConditionsExpression<E1, C, L>,
    L extends EntityConditionsLogicExpression<E1, C, L>>
    extends EntityBetweenExpression<E1, C, L>, EntityNotBetweenExpression<E1, C, L>, EntityContainsExpression<E1, C, L>,
    EntityNotContainsExpression<E1, C, L>, EntityEndWithExpression<E1, C, L>, EntityNotEndWithExpression<E1, C, L>,
    EntityEqualsExpression<E1, C, L>, EntityGreatEqualsExpression<E1, C, L>, EntityGreatThanExpression<E1, C, L>,
    EntityInExpression<E1, C, L>, EntityIsNotNullExpression<E1, C, L>, EntityIsNullExpression<E1, C, L>,
    EntityLessEqualsExpression<E1, C, L>, EntityLessThanExpression<E1, C, L>, EntityNotEqualsExpression<E1, C, L>,
    EntityNotInExpression<E1, C, L>, EntityStartWithExpression<E1, C, L>, EntityNotStartWithExpression<E1, C, L>,
    EntityLikeExpression<E1, C, L>, EntityNotLikeExpression<E1, C, L>, EntityPropertyConditionsExpression<E1, C, L>,
    NativeStringConditionExpression<C, L> {

}
