
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.ba.EntityBetweenExpression3;
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
import cn.featherfly.hammer.expression.entity.condition.nba.EntityNotBetweenExpression3;
import cn.featherfly.hammer.expression.entity.condition.nco.EntityNotContainsExpression3;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression3;
import cn.featherfly.hammer.expression.entity.condition.newv.EntityNotEndWithExpression3;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpression3;
import cn.featherfly.hammer.expression.entity.condition.nl.EntityNotLikeExpression3;
import cn.featherfly.hammer.expression.entity.condition.nsw.EntityNotStartWithExpression3;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression3;

/**
 * The Interface EntityConditionsExpression3.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <E2> second filterable entity type
 * @param <E3> third filterable entity type
 * @param <C>  condition expression
 * @param <L>  logic expression
 */
public interface EntityConditionsExpression3<E1, E2, E3, C extends EntityConditionsExpression3<E1, E2, E3, C, L>,
    L extends LogicExpression<C, L>> extends EntityBetweenExpression3<E1, E2, E3, C, L>,
    EntityNotBetweenExpression3<E1, E2, E3, C, L>, EntityContainsExpression3<E1, E2, E3, C, L>,
    EntityNotContainsExpression3<E1, E2, E3, C, L>, EntityEndWithExpression3<E1, E2, E3, C, L>,
    EntityNotEndWithExpression3<E1, E2, E3, C, L>, EntityEqualsExpression3<E1, E2, E3, C, L>,
    EntityGreatEqualsExpression3<E1, E2, E3, C, L>, EntityGreatThanExpression3<E1, E2, E3, C, L>,
    EntityInExpression3<E1, E2, E3, C, L>, EntityIsNotNullExpression3<E1, E2, E3, C, L>,
    EntityIsNullExpression3<E1, E2, E3, C, L>, EntityLessEqualsExpression3<E1, E2, E3, C, L>,
    EntityLessThanExpression3<E1, E2, E3, C, L>, EntityNotEqualsExpression3<E1, E2, E3, C, L>,
    EntityNotInExpression3<E1, E2, E3, C, L>, EntityStartWithExpression3<E1, E2, E3, C, L>,
    EntityNotStartWithExpression3<E1, E2, E3, C, L>, EntityLikeExpression3<E1, E2, E3, C, L>,
    EntityNotLikeExpression3<E1, E2, E3, C, L>, EntityPropertyExpression3<E1, E2, E3, C, L> {
}
