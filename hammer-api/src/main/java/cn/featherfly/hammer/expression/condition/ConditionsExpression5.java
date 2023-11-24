
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.hammer.expression.condition.ba.BetweenExpression5;
import cn.featherfly.hammer.expression.condition.co.ContainsExpression5;
import cn.featherfly.hammer.expression.condition.eq.EqualsExpression5;
import cn.featherfly.hammer.expression.condition.ew.EndWithExpression5;
import cn.featherfly.hammer.expression.condition.ge.GreatEqualsExpression5;
import cn.featherfly.hammer.expression.condition.gt.GreatThanExpression5;
import cn.featherfly.hammer.expression.condition.in.InExpression5;
import cn.featherfly.hammer.expression.condition.inn.IsNotNullExpression5;
import cn.featherfly.hammer.expression.condition.isn.IsNullExpression5;
import cn.featherfly.hammer.expression.condition.le.LessEqualsExpression5;
import cn.featherfly.hammer.expression.condition.lk.LikeExpression5;
import cn.featherfly.hammer.expression.condition.lt.LessThanExpression5;
import cn.featherfly.hammer.expression.condition.nba.NotBetweenExpression5;
import cn.featherfly.hammer.expression.condition.nco.NotContainsExpression5;
import cn.featherfly.hammer.expression.condition.ne.NotEqualsExpression5;
import cn.featherfly.hammer.expression.condition.newv.NotEndWithExpression5;
import cn.featherfly.hammer.expression.condition.ni.NotInExpression5;
import cn.featherfly.hammer.expression.condition.nl.NotLikeExpression5;
import cn.featherfly.hammer.expression.condition.nsw.NotStartWithExpression5;
import cn.featherfly.hammer.expression.condition.sw.StartWithExpression5;

/**
 * all condition expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ConditionsExpression5<C extends ConditionsExpression5<C, L>,
        L extends ConditionsLogicExpression5<C, L>> extends BetweenExpression5<C, L>, NotBetweenExpression5<C, L> //
        , ContainsExpression5<C, L>, NotContainsExpression5<C, L> //
        , EndWithExpression5<C, L>, NotEndWithExpression5<C, L> //
        , EqualsExpression5<C, L>, NotEqualsExpression5<C, L> //
        , GreatEqualsExpression5<C, L>, GreatThanExpression5<C, L> //
        , InExpression5<C, L>, NotInExpression5<C, L> //
        , IsNotNullExpression5<C, L>, IsNullExpression5<C, L> //
        , LessEqualsExpression5<C, L>, LessThanExpression5<C, L>//
        , StartWithExpression5<C, L>, NotStartWithExpression5<C, L>//
        , LikeExpression5<C, L>, NotLikeExpression5<C, L> {
}
