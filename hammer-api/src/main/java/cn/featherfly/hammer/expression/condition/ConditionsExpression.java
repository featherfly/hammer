
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.hammer.expression.condition.ba.BetweenExpression;
import cn.featherfly.hammer.expression.condition.co.ContainsExpression;
import cn.featherfly.hammer.expression.condition.eq.EqualsExpression;
import cn.featherfly.hammer.expression.condition.ew.EndWithExpression;
import cn.featherfly.hammer.expression.condition.ge.GreatEqualsExpression;
import cn.featherfly.hammer.expression.condition.gt.GreatThanExpression;
import cn.featherfly.hammer.expression.condition.in.InExpression;
import cn.featherfly.hammer.expression.condition.inn.IsNotNullExpression;
import cn.featherfly.hammer.expression.condition.isn.IsNullExpression;
import cn.featherfly.hammer.expression.condition.le.LessEqualsExpression;
import cn.featherfly.hammer.expression.condition.lk.LikeExpression;
import cn.featherfly.hammer.expression.condition.lt.LessThanExpression;
import cn.featherfly.hammer.expression.condition.nba.NotBetweenExpression;
import cn.featherfly.hammer.expression.condition.nco.NotContainsExpression;
import cn.featherfly.hammer.expression.condition.ne.NotEqualsExpression;
import cn.featherfly.hammer.expression.condition.newv.NotEndWithExpression;
import cn.featherfly.hammer.expression.condition.ni.NotInExpression;
import cn.featherfly.hammer.expression.condition.nl.NotLikeExpression;
import cn.featherfly.hammer.expression.condition.nsw.NotStartWithExpression;
import cn.featherfly.hammer.expression.condition.sw.StartWithExpression;

/**
 * all conditions expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ConditionsExpression<C extends ConditionsExpression<C, L>, L extends ConditionsLogicExpression<C, L>>
        extends BetweenExpression<C, L>, NotBetweenExpression<C, L> //
        , ContainsExpression<C, L>, NotContainsExpression<C, L> //
        , EndWithExpression<C, L>, NotEndWithExpression<C, L> //
        , EqualsExpression<C, L>, NotEqualsExpression<C, L> //
        , GreatEqualsExpression<C, L>, GreatThanExpression<C, L> //
        , InExpression<C, L>, NotInExpression<C, L> //
        , IsNotNullExpression<C, L>, IsNullExpression<C, L> //
        , LessEqualsExpression<C, L>, LessThanExpression<C, L>//
        , StartWithExpression<C, L>, NotStartWithExpression<C, L>//
        , LikeExpression<C, L>, NotLikeExpression<C, L> //
        //, PropertyConditionsExpression<C, L>
        , NativeStringConditionExpression<C, L> {
}
