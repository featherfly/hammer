
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.hammer.expression.condition.ba.BetweenExpression2;
import cn.featherfly.hammer.expression.condition.co.ContainsExpression2;
import cn.featherfly.hammer.expression.condition.eq.EqualsExpression2;
import cn.featherfly.hammer.expression.condition.ew.EndWithExpression2;
import cn.featherfly.hammer.expression.condition.ge.GreatEqualsExpression2;
import cn.featherfly.hammer.expression.condition.gt.GreatThanExpression2;
import cn.featherfly.hammer.expression.condition.in.InExpression2;
import cn.featherfly.hammer.expression.condition.inn.IsNotNullExpression2;
import cn.featherfly.hammer.expression.condition.isn.IsNullExpression2;
import cn.featherfly.hammer.expression.condition.le.LessEqualsExpression2;
import cn.featherfly.hammer.expression.condition.lk.LikeExpression2;
import cn.featherfly.hammer.expression.condition.lt.LessThanExpression2;
import cn.featherfly.hammer.expression.condition.nba.NotBetweenExpression2;
import cn.featherfly.hammer.expression.condition.nco.NotContainsExpression2;
import cn.featherfly.hammer.expression.condition.ne.NotEqualsExpression2;
import cn.featherfly.hammer.expression.condition.newv.NotEndWithExpression2;
import cn.featherfly.hammer.expression.condition.ni.NotInExpression2;
import cn.featherfly.hammer.expression.condition.nl.NotLikeExpression2;
import cn.featherfly.hammer.expression.condition.nsw.NotStartWithExpression2;
import cn.featherfly.hammer.expression.condition.sw.StartWithExpression2;

/**
 * all conditions expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ConditionsExpression2<C extends ConditionsExpression2<C, L>,
        L extends ConditionsLogicExpression2<C, L>> extends BetweenExpression2<C, L>, NotBetweenExpression2<C, L> //
        , ContainsExpression2<C, L>, NotContainsExpression2<C, L> //
        , EndWithExpression2<C, L>, NotEndWithExpression2<C, L> //
        , EqualsExpression2<C, L>, NotEqualsExpression2<C, L> //
        , GreatEqualsExpression2<C, L>, GreatThanExpression2<C, L> //
        , InExpression2<C, L>, NotInExpression2<C, L> //
        , IsNotNullExpression2<C, L>, IsNullExpression2<C, L> //
        , LessEqualsExpression2<C, L>, LessThanExpression2<C, L>//
        , StartWithExpression2<C, L>, NotStartWithExpression2<C, L>//
        , LikeExpression2<C, L>, NotLikeExpression2<C, L> {
}
