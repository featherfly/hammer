
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.ba.EntityBetweenExpression5;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression5;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpression5;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression5;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression5;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression5;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression5;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression5;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression5;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression5;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression5;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression5;
import cn.featherfly.hammer.expression.entity.condition.nba.EntityNotBetweenExpression5;
import cn.featherfly.hammer.expression.entity.condition.nco.EntityNotContainsExpression5;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression5;
import cn.featherfly.hammer.expression.entity.condition.newv.EntityNotEndWithExpression5;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpression5;
import cn.featherfly.hammer.expression.entity.condition.nl.EntityNotLikeExpression5;
import cn.featherfly.hammer.expression.entity.condition.nsw.EntityNotStartWithExpression5;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression5;

/**
 * The Interface EntityConditionsExpression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityConditionsExpression5<E, E2, E3, E4, E5,
        C extends EntityConditionsExpression5<E, E2, E3, E4, E5, C, L>, L extends LogicExpression<C, L>>
        extends EntityBetweenExpression5<E, E2, E3, E4, E5, C, L>, EntityNotBetweenExpression5<E, E2, E3, E4, E5, C, L> //
        , EntityContainsExpression5<E, E2, E3, E4, E5, C, L>, EntityNotContainsExpression5<E, E2, E3, E4, E5, C, L> //
        , EntityEndWithExpression5<E, E2, E3, E4, E5, C, L>, EntityNotEndWithExpression5<E, E2, E3, E4, E5, C, L> //
        , EntityEqualsExpression5<E, E2, E3, E4, E5, C, L>, EntityNotEqualsExpression5<E, E2, E3, E4, E5, C, L> //
        , EntityGreatEqualsExpression5<E, E2, E3, E4, E5, C, L>, EntityGreatThanExpression5<E, E2, E3, E4, E5, C, L> //
        , EntityInExpression5<E, E2, E3, E4, E5, C, L>, EntityNotInExpression5<E, E2, E3, E4, E5, C, L> //
        , EntityIsNullExpression5<E, E2, E3, E4, E5, C, L>, EntityIsNotNullExpression5<E, E2, E3, E4, E5, C, L> //
        , EntityLessEqualsExpression5<E, E2, E3, E4, E5, C, L>, EntityLessThanExpression5<E, E2, E3, E4, E5, C, L> //
        , EntityStartWithExpression5<E, E2, E3, E4, E5, C, L>, EntityNotStartWithExpression5<E, E2, E3, E4, E5, C, L>//
        , EntityLikeExpression5<E, E2, E3, E4, E5, C, L>, EntityNotLikeExpression5<E, E2, E3, E4, E5, C, L>//
        , EntityPropertyExpression5<E, E2, E3, E4, E5, C, L> {
}
