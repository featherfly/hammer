
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
 * @param <T>  the generic type
 * @param <T2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityConditionsExpression2<T, T2, C extends EntityConditionsExpression2<T, T2, C, L>,
        L extends EntityConditionsLogicExpression2<T, T2, C, L>> extends EntityBetweenExpression2<T, T2, C, L>,
        EntityNotBetweenExpression2<T, T2, C, L>, EntityContainsExpression2<T, T2, C, L>,
        EntityNotContainsExpression2<T, T2, C, L>, EntityEndWithExpression2<T, T2, C, L>,
        EntityNotEndWithExpression2<T, T2, C, L>, EntityEqualsExpression2<T, T2, C, L>,
        EntityGreatEqualsExpression2<T, T2, C, L>, EntityGreatThanExpression2<T, T2, C, L>,
        EntityInExpression2<T, T2, C, L>, EntityIsNotNullExpression2<T, T2, C, L>, EntityIsNullExpression2<T, T2, C, L>,
        EntityLessEqualsExpression2<T, T2, C, L>, EntityLessThanExpression2<T, T2, C, L>,
        EntityNotEqualsExpression2<T, T2, C, L>, EntityNotInExpression2<T, T2, C, L>,
        EntityStartWithExpression2<T, T2, C, L>, EntityNotStartWithExpression2<T, T2, C, L>,
        EntityLikeExpression2<T, T2, C, L>, EntityNotLikeExpression2<T, T2, C, L>,
        EntityPropertyExpression2<T, T2, C, L> {
}
