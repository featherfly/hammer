
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.hammer.expression.condition.ba.BetweenExpression3;
import cn.featherfly.hammer.expression.condition.co.ContainsExpression3;
import cn.featherfly.hammer.expression.condition.eq.EqualsExpression3;
import cn.featherfly.hammer.expression.condition.ew.EndWithExpression3;
import cn.featherfly.hammer.expression.condition.ge.GreatEqualsExpression3;
import cn.featherfly.hammer.expression.condition.gt.GreatThanExpression3;
import cn.featherfly.hammer.expression.condition.in.InExpression3;
import cn.featherfly.hammer.expression.condition.inn.IsNotNullExpression3;
import cn.featherfly.hammer.expression.condition.isn.IsNullExpression3;
import cn.featherfly.hammer.expression.condition.le.LessEqualsExpression3;
import cn.featherfly.hammer.expression.condition.lk.LikeExpression3;
import cn.featherfly.hammer.expression.condition.lt.LessThanExpression3;
import cn.featherfly.hammer.expression.condition.nba.NotBetweenExpression3;
import cn.featherfly.hammer.expression.condition.nco.NotContainsExpression3;
import cn.featherfly.hammer.expression.condition.ne.NotEqualsExpression3;
import cn.featherfly.hammer.expression.condition.newv.NotEndWithExpression3;
import cn.featherfly.hammer.expression.condition.ni.NotInExpression3;
import cn.featherfly.hammer.expression.condition.nl.NotLikeExpression3;
import cn.featherfly.hammer.expression.condition.nsw.NotStartWithExpression3;
import cn.featherfly.hammer.expression.condition.sw.StartWithExpression3;

/**
 * all conditions expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ConditionsExpression3<C extends ConditionsExpression3<C, L>,
        L extends ConditionsLogicExpression3<C, L>> extends BetweenExpression3<C, L>, NotBetweenExpression3<C, L> //
        , ContainsExpression3<C, L>, NotContainsExpression3<C, L> //
        , EndWithExpression3<C, L>, NotEndWithExpression3<C, L> //
        , EqualsExpression3<C, L>, NotEqualsExpression3<C, L> //
        , GreatEqualsExpression3<C, L>, GreatThanExpression3<C, L> //
        , InExpression3<C, L>, NotInExpression3<C, L> //
        , IsNotNullExpression3<C, L>, IsNullExpression3<C, L> //
        , LessEqualsExpression3<C, L>, LessThanExpression3<C, L>//
        , StartWithExpression3<C, L>, NotStartWithExpression3<C, L>//
        , LikeExpression3<C, L>, NotLikeExpression3<C, L> {
}
