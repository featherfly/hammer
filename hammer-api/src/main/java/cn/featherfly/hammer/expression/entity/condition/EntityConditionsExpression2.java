
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.entity.condition.ba.EntityBetweenExpression2;
import cn.featherfly.hammer.expression.entity.condition.co.EntityContainsExpression2;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpression2;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression2;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression2;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression2;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression2;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression2;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression2;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression2;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression2;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression2;
import cn.featherfly.hammer.expression.entity.condition.nba.EntityNotBetweenExpression2;
import cn.featherfly.hammer.expression.entity.condition.nco.EntityNotContainsExpression2;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression2;
import cn.featherfly.hammer.expression.entity.condition.newv.EntityNotEndWithExpression2;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpression2;
import cn.featherfly.hammer.expression.entity.condition.nl.EntityNotLikeExpression2;
import cn.featherfly.hammer.expression.entity.condition.nsw.EntityNotStartWithExpression2;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression2;

/**
 * The Interface EntityConditionsExpression2.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsExpression2<E1, E2, C extends EntityConditionsExpression2<E1, E2, C, L>,
    L extends EntityConditionsLogicExpression2<E1, E2, C, L>> extends EntityBetweenExpression2<E1, E2, C, L>,
    EntityNotBetweenExpression2<E1, E2, C, L>, EntityContainsExpression2<E1, E2, C, L>,
    EntityNotContainsExpression2<E1, E2, C, L>, EntityEndWithExpression2<E1, E2, C, L>,
    EntityNotEndWithExpression2<E1, E2, C, L>, EntityEqualsExpression2<E1, E2, C, L>,
    EntityGreatEqualsExpression2<E1, E2, C, L>, EntityGreatThanExpression2<E1, E2, C, L>,
    EntityInExpression2<E1, E2, C, L>, EntityIsNotNullExpression2<E1, E2, C, L>, EntityIsNullExpression2<E1, E2, C, L>,
    EntityLessEqualsExpression2<E1, E2, C, L>, EntityLessThanExpression2<E1, E2, C, L>,
    EntityNotEqualsExpression2<E1, E2, C, L>, EntityNotInExpression2<E1, E2, C, L>,
    EntityStartWithExpression2<E1, E2, C, L>, EntityNotStartWithExpression2<E1, E2, C, L>,
    EntityLikeExpression2<E1, E2, C, L>, EntityNotLikeExpression2<E1, E2, C, L>,
    EntityPropertyExpression2<E1, E2, C, L> {
}
