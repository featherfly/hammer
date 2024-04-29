
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.ba.EntityBetweenExpression6;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression6;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpression6;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression6;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression6;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression6;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression6;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression6;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression6;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression6;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression6;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression6;
import cn.featherfly.hammer.expression.entity.condition.nba.EntityNotBetweenExpression6;
import cn.featherfly.hammer.expression.entity.condition.nco.EntityNotContainsExpression6;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression6;
import cn.featherfly.hammer.expression.entity.condition.newv.EntityNotEndWithExpression6;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpression6;
import cn.featherfly.hammer.expression.entity.condition.nl.EntityNotLikeExpression6;
import cn.featherfly.hammer.expression.entity.condition.nsw.EntityNotStartWithExpression6;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression6;

/**
 * The Interface EntityConditionsExpression6.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <E4> fouth filterable entity type
 * @param <E5> fifth filterable entity type
 * @param <E6> sixth filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsExpression6<E1, E2, E3, E4, E5, E6,
    C extends EntityConditionsExpression6<E1, E2, E3, E4, E5, E6, C, L>, L extends LogicExpression<C, L>> extends
    EntityBetweenExpression6<E1, E2, E3, E4, E5, E6, C, L>, EntityNotBetweenExpression6<E1, E2, E3, E4, E5, E6, C, L> //
    , EntityContainsExpression6<E1, E2, E3, E4, E5, E6, C, L>,
    EntityNotContainsExpression6<E1, E2, E3, E4, E5, E6, C, L>//
    , EntityEndWithExpression6<E1, E2, E3, E4, E5, E6, C, L>, EntityNotEndWithExpression6<E1, E2, E3, E4, E5, E6, C, L> //
    , EntityEqualsExpression6<E1, E2, E3, E4, E5, E6, C, L>, EntityNotEqualsExpression6<E1, E2, E3, E4, E5, E6, C, L>//
    , EntityGreatEqualsExpression6<E1, E2, E3, E4, E5, E6, C, L>,
    EntityGreatThanExpression6<E1, E2, E3, E4, E5, E6, C, L> //
    , EntityInExpression6<E1, E2, E3, E4, E5, E6, C, L>, EntityNotInExpression6<E1, E2, E3, E4, E5, E6, C, L> //
    , EntityIsNullExpression6<E1, E2, E3, E4, E5, E6, C, L>, EntityIsNotNullExpression6<E1, E2, E3, E4, E5, E6, C, L>,
    EntityLessEqualsExpression6<E1, E2, E3, E4, E5, E6, C, L>, EntityLessThanExpression6<E1, E2, E3, E4, E5, E6, C, L> //
    , EntityStartWithExpression6<E1, E2, E3, E4, E5, E6, C, L>,
    EntityNotStartWithExpression6<E1, E2, E3, E4, E5, E6, C, L>//
    , EntityLikeExpression6<E1, E2, E3, E4, E5, E6, C, L>, EntityNotLikeExpression6<E1, E2, E3, E4, E5, E6, C, L> //
    , EntityPropertyExpression6<E1, E2, E3, E4, E5, E6, C, L> {
}
