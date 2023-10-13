
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.LogicExpression;
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
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityConditionsExpression<E, C extends EntityConditionsExpression<E, C, L>,
        L extends LogicExpression<C, L>> extends EntityBetweenExpression<E, C, L>, EntityNotBetweenExpression<E, C, L>,
        EntityContainsExpression<E, C, L>, EntityNotContainsExpression<E, C, L>, EntityEndWithExpression<E, C, L>,
        EntityNotEndWithExpression<E, C, L>, EntityEqualsExpression<E, C, L>, EntityGreatEqualsExpression<E, C, L>,
        EntityGreatThanExpression<E, C, L>, EntityInExpression<E, C, L>, EntityIsNotNullExpression<E, C, L>,
        EntityIsNullExpression<E, C, L>, EntityLessEqualsExpression<E, C, L>, EntityLessThanExpression<E, C, L>,
        EntityNotEqualsExpression<E, C, L>, EntityNotInExpression<E, C, L>, EntityStartWithExpression<E, C, L>,
        EntityNotStartWithExpression<E, C, L>, EntityLikeExpression<E, C, L>, EntityNotLikeExpression<E, C, L>,
        EntityPropertyConditionsExpression<E, C, L>, NativeStringConditionExpression<C, L> {

}
