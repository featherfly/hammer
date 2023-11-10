
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.hammer.expression.condition.ba.BetweenExpression4;
import cn.featherfly.hammer.expression.condition.co.ContainsExpression4;
import cn.featherfly.hammer.expression.condition.eq.EqualsExpression4;
import cn.featherfly.hammer.expression.condition.ew.EndWithExpression4;
import cn.featherfly.hammer.expression.condition.ge.GreatEqualsExpression4;
import cn.featherfly.hammer.expression.condition.gt.GreatThanExpression4;
import cn.featherfly.hammer.expression.condition.in.InExpression4;
import cn.featherfly.hammer.expression.condition.inn.IsNotNullExpression4;
import cn.featherfly.hammer.expression.condition.isn.IsNullExpression4;
import cn.featherfly.hammer.expression.condition.le.LessEqualsExpression4;
import cn.featherfly.hammer.expression.condition.lk.LikeExpression4;
import cn.featherfly.hammer.expression.condition.lt.LessThanExpression4;
import cn.featherfly.hammer.expression.condition.nba.NotBetweenExpression4;
import cn.featherfly.hammer.expression.condition.nco.NotContainsExpression4;
import cn.featherfly.hammer.expression.condition.ne.NotEqualsExpression4;
import cn.featherfly.hammer.expression.condition.newv.NotEndWithExpression4;
import cn.featherfly.hammer.expression.condition.ni.NotInExpression4;
import cn.featherfly.hammer.expression.condition.nl.NotLikeExpression4;
import cn.featherfly.hammer.expression.condition.nsw.NotStartWithExpression4;
import cn.featherfly.hammer.expression.condition.sw.StartWithExpression4;

/**
 * all conditions expression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ConditionsExpression4<C extends ConditionsExpression4<C, L>,
        L extends ConditionsLogicExpression4<C, L>> extends BetweenExpression4<C, L>, NotBetweenExpression4<C, L> //
        , ContainsExpression4<C, L>, NotContainsExpression4<C, L> //
        , EndWithExpression4<C, L>, NotEndWithExpression4<C, L> //
        , EqualsExpression4<C, L>, NotEqualsExpression4<C, L> //
        , GreatEqualsExpression4<C, L>, GreatThanExpression4<C, L> //
        , InExpression4<C, L>, NotInExpression4<C, L> //
        , IsNotNullExpression4<C, L>, IsNullExpression4<C, L> //
        , LessEqualsExpression4<C, L>, LessThanExpression4<C, L>//
        , StartWithExpression4<C, L>, NotStartWithExpression4<C, L>//
        , LikeExpression4<C, L>, NotLikeExpression4<C, L> {
}
