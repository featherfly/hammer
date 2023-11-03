
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.ConditionsExpression2;
import cn.featherfly.hammer.expression.repository.condition.ba.RepositoryBetweenExpression2;
import cn.featherfly.hammer.expression.repository.condition.co.RepositoryContainsExpression2;
import cn.featherfly.hammer.expression.repository.condition.eq.RepositoryEqualsExpression2;
import cn.featherfly.hammer.expression.repository.condition.ew.RepositoryEndWithExpression2;
import cn.featherfly.hammer.expression.repository.condition.ge.RepositoryGreatEqualsExpression2;
import cn.featherfly.hammer.expression.repository.condition.gt.RepositoryGreatThanExpression2;
import cn.featherfly.hammer.expression.repository.condition.in.RepositoryInExpression2;
import cn.featherfly.hammer.expression.repository.condition.inn.RepositoryIsNotNullExpression2;
import cn.featherfly.hammer.expression.repository.condition.isn.RepositoryIsNullExpression2;
import cn.featherfly.hammer.expression.repository.condition.le.RepositoryLessEqualsExpression2;
import cn.featherfly.hammer.expression.repository.condition.lk.RepositoryLikeExpression2;
import cn.featherfly.hammer.expression.repository.condition.lt.RepositoryLessThanExpression2;
import cn.featherfly.hammer.expression.repository.condition.nba.RepositoryNotBetweenExpression2;
import cn.featherfly.hammer.expression.repository.condition.nco.RepositoryNotContainsExpression2;
import cn.featherfly.hammer.expression.repository.condition.ne.RepositoryNotEqualsExpression2;
import cn.featherfly.hammer.expression.repository.condition.newv.RepositoryNotEndWithExpression2;
import cn.featherfly.hammer.expression.repository.condition.ni.RepositoryNotInExpression2;
import cn.featherfly.hammer.expression.repository.condition.nl.RepositoryNotLikeExpression2;
import cn.featherfly.hammer.expression.repository.condition.nsw.RepositoryNotStartWithExpression2;
import cn.featherfly.hammer.expression.repository.condition.sw.RepositoryStartWithExpression2;

/**
 * all repository conditions expression2.
 *
 * @author zhongj
 */
public interface RepositoryConditionsExpression2<C extends RepositoryConditionsExpression2<C, L>,
        L extends RepositoryConditionsLogicExpression2<C, L>> extends ConditionsExpression2<C, L>, //
        RepositoryBetweenExpression2<C, L>, RepositoryNotBetweenExpression2<C, L> //
        , RepositoryContainsExpression2<C, L>, RepositoryNotContainsExpression2<C, L> //
        , RepositoryEndWithExpression2<C, L>, RepositoryNotEndWithExpression2<C, L> //
        , RepositoryEqualsExpression2<C, L>, RepositoryNotEqualsExpression2<C, L> //
        , RepositoryGreatEqualsExpression2<C, L>, RepositoryGreatThanExpression2<C, L> //
        , RepositoryInExpression2<C, L>, RepositoryNotInExpression2<C, L> //
        , RepositoryIsNotNullExpression2<C, L>, RepositoryIsNullExpression2<C, L> //
        , RepositoryLessEqualsExpression2<C, L>, RepositoryLessThanExpression2<C, L>//
        , RepositoryStartWithExpression2<C, L>, RepositoryNotStartWithExpression2<C, L>//
        , RepositoryLikeExpression2<C, L>, RepositoryNotLikeExpression2<C, L> //
        , RepositoryFieldExpression2<C, L> {
}
