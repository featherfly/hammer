
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.hammer.expression.condition.ba.BetweenExpression6;
import cn.featherfly.hammer.expression.condition.co.ContainsExpression6;
import cn.featherfly.hammer.expression.condition.eq.EqualsExpression6;
import cn.featherfly.hammer.expression.condition.ew.EndWithExpression6;
import cn.featherfly.hammer.expression.condition.ge.GreatEqualsExpression6;
import cn.featherfly.hammer.expression.condition.gt.GreatThanExpression6;
import cn.featherfly.hammer.expression.condition.in.InExpression6;
import cn.featherfly.hammer.expression.condition.inn.IsNotNullExpression6;
import cn.featherfly.hammer.expression.condition.isn.IsNullExpression6;
import cn.featherfly.hammer.expression.condition.le.LessEqualsExpression6;
import cn.featherfly.hammer.expression.condition.lk.LikeExpression6;
import cn.featherfly.hammer.expression.condition.lt.LessThanExpression6;
import cn.featherfly.hammer.expression.condition.nba.NotBetweenExpression6;
import cn.featherfly.hammer.expression.condition.nco.NotContainsExpression6;
import cn.featherfly.hammer.expression.condition.ne.NotEqualsExpression6;
import cn.featherfly.hammer.expression.condition.newv.NotEndWithExpression6;
import cn.featherfly.hammer.expression.condition.ni.NotInExpression6;
import cn.featherfly.hammer.expression.condition.nl.NotLikeExpression6;
import cn.featherfly.hammer.expression.condition.nsw.NotStartWithExpression6;
import cn.featherfly.hammer.expression.condition.sw.StartWithExpression6;

/**
 * all condition expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ConditionsExpression6<C extends ConditionsExpression6<C, L>,
        L extends ConditionsLogicExpression6<C, L>> extends BetweenExpression6<C, L>, NotBetweenExpression6<C, L> //
        , ContainsExpression6<C, L>, NotContainsExpression6<C, L> //
        , EndWithExpression6<C, L>, NotEndWithExpression6<C, L> //
        , EqualsExpression6<C, L>, NotEqualsExpression6<C, L> //
        , GreatEqualsExpression6<C, L>, GreatThanExpression6<C, L> //
        , InExpression6<C, L>, NotInExpression6<C, L> //
        , IsNotNullExpression6<C, L>, IsNullExpression6<C, L> //
        , LessEqualsExpression6<C, L>, LessThanExpression6<C, L>//
        , StartWithExpression6<C, L>, NotStartWithExpression6<C, L>//
        , LikeExpression6<C, L>, NotLikeExpression6<C, L> {
}
