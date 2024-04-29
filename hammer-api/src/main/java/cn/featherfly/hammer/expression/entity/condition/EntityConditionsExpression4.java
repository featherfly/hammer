
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.ba.EntityBetweenExpression4;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression4;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpression4;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression4;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression4;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression4;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression4;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression4;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression4;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression4;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression4;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression4;
import cn.featherfly.hammer.expression.entity.condition.nba.EntityNotBetweenExpression4;
import cn.featherfly.hammer.expression.entity.condition.nco.EntityNotContainsExpression4;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression4;
import cn.featherfly.hammer.expression.entity.condition.newv.EntityNotEndWithExpression4;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpression4;
import cn.featherfly.hammer.expression.entity.condition.nl.EntityNotLikeExpression4;
import cn.featherfly.hammer.expression.entity.condition.nsw.EntityNotStartWithExpression4;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression4;

/**
 * The Interface EntityConditionsExpression4.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsExpression4<E1, E2, E3, E4,
    C extends EntityConditionsExpression4<E1, E2, E3, E4, C, L>, L extends LogicExpression<C, L>>
    extends EntityBetweenExpression4<E1, E2, E3, E4, C, L>, EntityNotBetweenExpression4<E1, E2, E3, E4, C, L> //
    , EntityContainsExpression4<E1, E2, E3, E4, C, L>, EntityNotContainsExpression4<E1, E2, E3, E4, C, L> //
    , EntityEndWithExpression4<E1, E2, E3, E4, C, L>, EntityNotEndWithExpression4<E1, E2, E3, E4, C, L> //
    , EntityEqualsExpression4<E1, E2, E3, E4, C, L>, EntityNotEqualsExpression4<E1, E2, E3, E4, C, L> //
    , EntityGreatEqualsExpression4<E1, E2, E3, E4, C, L>, EntityGreatThanExpression4<E1, E2, E3, E4, C, L>//
    , EntityInExpression4<E1, E2, E3, E4, C, L>, EntityNotInExpression4<E1, E2, E3, E4, C, L> //
    , EntityIsNullExpression4<E1, E2, E3, E4, C, L>, EntityIsNotNullExpression4<E1, E2, E3, E4, C, L> //
    , EntityLessEqualsExpression4<E1, E2, E3, E4, C, L>, EntityLessThanExpression4<E1, E2, E3, E4, C, L> //
    , EntityLikeExpression4<E1, E2, E3, E4, C, L>, EntityNotLikeExpression4<E1, E2, E3, E4, C, L> //
    , EntityStartWithExpression4<E1, E2, E3, E4, C, L>, EntityNotStartWithExpression4<E1, E2, E3, E4, C, L> //
    , EntityPropertyExpression4<E1, E2, E3, E4, C, L> {
}
