
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.ConditionsExpression5;
import cn.featherfly.hammer.expression.repository.condition.ba.RepositoryBetweenExpression5;
import cn.featherfly.hammer.expression.repository.condition.co.RepositoryContainsExpression5;
import cn.featherfly.hammer.expression.repository.condition.eq.RepositoryEqualsExpression5;
import cn.featherfly.hammer.expression.repository.condition.ew.RepositoryEndWithExpression5;
import cn.featherfly.hammer.expression.repository.condition.ge.RepositoryGreatEqualsExpression5;
import cn.featherfly.hammer.expression.repository.condition.gt.RepositoryGreatThanExpression5;
import cn.featherfly.hammer.expression.repository.condition.in.RepositoryInExpression5;
import cn.featherfly.hammer.expression.repository.condition.inn.RepositoryIsNotNullExpression5;
import cn.featherfly.hammer.expression.repository.condition.isn.RepositoryIsNullExpression5;
import cn.featherfly.hammer.expression.repository.condition.le.RepositoryLessEqualsExpression5;
import cn.featherfly.hammer.expression.repository.condition.lk.RepositoryLikeExpression5;
import cn.featherfly.hammer.expression.repository.condition.lt.RepositoryLessThanExpression5;
import cn.featherfly.hammer.expression.repository.condition.nba.RepositoryNotBetweenExpression5;
import cn.featherfly.hammer.expression.repository.condition.nco.RepositoryNotContainsExpression5;
import cn.featherfly.hammer.expression.repository.condition.ne.RepositoryNotEqualsExpression5;
import cn.featherfly.hammer.expression.repository.condition.newv.RepositoryNotEndWithExpression5;
import cn.featherfly.hammer.expression.repository.condition.ni.RepositoryNotInExpression5;
import cn.featherfly.hammer.expression.repository.condition.nl.RepositoryNotLikeExpression5;
import cn.featherfly.hammer.expression.repository.condition.nsw.RepositoryNotStartWithExpression5;
import cn.featherfly.hammer.expression.repository.condition.sw.RepositoryStartWithExpression5;

/**
 * all repository conditions expression5.
 *
 * @author zhongj
 */
public interface RepositoryConditionsExpression5<C extends RepositoryConditionsExpression5<C, L>,
        L extends RepositoryConditionsLogicExpression5<C, L>> extends ConditionsExpression5<C, L>, //
        RepositoryBetweenExpression5<C, L>, RepositoryNotBetweenExpression5<C, L> //
        , RepositoryContainsExpression5<C, L>, RepositoryNotContainsExpression5<C, L> //
        , RepositoryEndWithExpression5<C, L>, RepositoryNotEndWithExpression5<C, L> //
        , RepositoryEqualsExpression5<C, L>, RepositoryNotEqualsExpression5<C, L> //
        , RepositoryGreatEqualsExpression5<C, L>, RepositoryGreatThanExpression5<C, L> //
        , RepositoryInExpression5<C, L>, RepositoryNotInExpression5<C, L> //
        , RepositoryIsNotNullExpression5<C, L>, RepositoryIsNullExpression5<C, L> //
        , RepositoryLessEqualsExpression5<C, L>, RepositoryLessThanExpression5<C, L>//
        , RepositoryStartWithExpression5<C, L>, RepositoryNotStartWithExpression5<C, L>//
        , RepositoryLikeExpression5<C, L>, RepositoryNotLikeExpression5<C, L> //
        , RepositoryFieldExpression5<C, L> {
}
