
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
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityConditionsExpression<T, C extends EntityConditionsExpression<T, C, L>,
        L extends EntityConditionsLogicExpression<T, C, L>>
        extends EntityBetweenExpression<T, C, L>, EntityNotBetweenExpression<T, C, L>,
        EntityContainsExpression<T, C, L>, EntityNotContainsExpression<T, C, L>, EntityEndWithExpression<T, C, L>,
        EntityNotEndWithExpression<T, C, L>, EntityEqualsExpression<T, C, L>, EntityGreatEqualsExpression<T, C, L>,
        EntityGreatThanExpression<T, C, L>, EntityInExpression<T, C, L>, EntityIsNotNullExpression<T, C, L>,
        EntityIsNullExpression<T, C, L>, EntityLessEqualsExpression<T, C, L>, EntityLessThanExpression<T, C, L>,
        EntityNotEqualsExpression<T, C, L>, EntityNotInExpression<T, C, L>, EntityStartWithExpression<T, C, L>,
        EntityNotStartWithExpression<T, C, L>, EntityLikeExpression<T, C, L>, EntityNotLikeExpression<T, C, L>,
        EntityPropertyConditionsExpression<T, C, L>, NativeStringConditionExpression<C, L> {

}
