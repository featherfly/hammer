
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.ConditionsExpression4;
import cn.featherfly.hammer.expression.repository.condition.ba.RepositoryBetweenExpression4;
import cn.featherfly.hammer.expression.repository.condition.co.RepositoryContainsExpression4;
import cn.featherfly.hammer.expression.repository.condition.eq.RepositoryEqualsExpression4;
import cn.featherfly.hammer.expression.repository.condition.ew.RepositoryEndWithExpression4;
import cn.featherfly.hammer.expression.repository.condition.ge.RepositoryGreatEqualsExpression4;
import cn.featherfly.hammer.expression.repository.condition.gt.RepositoryGreatThanExpression4;
import cn.featherfly.hammer.expression.repository.condition.in.RepositoryInExpression4;
import cn.featherfly.hammer.expression.repository.condition.inn.RepositoryIsNotNullExpression4;
import cn.featherfly.hammer.expression.repository.condition.isn.RepositoryIsNullExpression4;
import cn.featherfly.hammer.expression.repository.condition.le.RepositoryLessEqualsExpression4;
import cn.featherfly.hammer.expression.repository.condition.lk.RepositoryLikeExpression4;
import cn.featherfly.hammer.expression.repository.condition.lt.RepositoryLessThanExpression4;
import cn.featherfly.hammer.expression.repository.condition.nba.RepositoryNotBetweenExpression4;
import cn.featherfly.hammer.expression.repository.condition.nco.RepositoryNotContainsExpression4;
import cn.featherfly.hammer.expression.repository.condition.ne.RepositoryNotEqualsExpression4;
import cn.featherfly.hammer.expression.repository.condition.newv.RepositoryNotEndWithExpression4;
import cn.featherfly.hammer.expression.repository.condition.ni.RepositoryNotInExpression4;
import cn.featherfly.hammer.expression.repository.condition.nl.RepositoryNotLikeExpression4;
import cn.featherfly.hammer.expression.repository.condition.nsw.RepositoryNotStartWithExpression4;
import cn.featherfly.hammer.expression.repository.condition.sw.RepositoryStartWithExpression4;

/**
 * all repository conditions expression4.
 *
 * @author zhongj
 */
public interface RepositoryConditionsExpression4<C extends RepositoryConditionsExpression4<C, L>,
        L extends RepositoryConditionsLogicExpression4<C, L>> extends ConditionsExpression4<C, L>, //
        RepositoryBetweenExpression4<C, L>, RepositoryNotBetweenExpression4<C, L> //
        , RepositoryContainsExpression4<C, L>, RepositoryNotContainsExpression4<C, L> //
        , RepositoryEndWithExpression4<C, L>, RepositoryNotEndWithExpression4<C, L> //
        , RepositoryEqualsExpression4<C, L>, RepositoryNotEqualsExpression4<C, L> //
        , RepositoryGreatEqualsExpression4<C, L>, RepositoryGreatThanExpression4<C, L> //
        , RepositoryInExpression4<C, L>, RepositoryNotInExpression4<C, L> //
        , RepositoryIsNotNullExpression4<C, L>, RepositoryIsNullExpression4<C, L> //
        , RepositoryLessEqualsExpression4<C, L>, RepositoryLessThanExpression4<C, L>//
        , RepositoryStartWithExpression4<C, L>, RepositoryNotStartWithExpression4<C, L>//
        , RepositoryLikeExpression4<C, L>, RepositoryNotLikeExpression4<C, L> //
        , RepositoryFieldExpression4<C, L> {
}
