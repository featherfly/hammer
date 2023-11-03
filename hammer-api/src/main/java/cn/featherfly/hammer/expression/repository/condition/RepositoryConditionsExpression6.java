
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.ConditionsExpression6;
import cn.featherfly.hammer.expression.repository.condition.ba.RepositoryBetweenExpression6;
import cn.featherfly.hammer.expression.repository.condition.co.RepositoryContainsExpression6;
import cn.featherfly.hammer.expression.repository.condition.eq.RepositoryEqualsExpression6;
import cn.featherfly.hammer.expression.repository.condition.ew.RepositoryEndWithExpression6;
import cn.featherfly.hammer.expression.repository.condition.ge.RepositoryGreatEqualsExpression6;
import cn.featherfly.hammer.expression.repository.condition.gt.RepositoryGreatThanExpression6;
import cn.featherfly.hammer.expression.repository.condition.in.RepositoryInExpression6;
import cn.featherfly.hammer.expression.repository.condition.inn.RepositoryIsNotNullExpression6;
import cn.featherfly.hammer.expression.repository.condition.isn.RepositoryIsNullExpression6;
import cn.featherfly.hammer.expression.repository.condition.le.RepositoryLessEqualsExpression6;
import cn.featherfly.hammer.expression.repository.condition.lk.RepositoryLikeExpression6;
import cn.featherfly.hammer.expression.repository.condition.lt.RepositoryLessThanExpression6;
import cn.featherfly.hammer.expression.repository.condition.nba.RepositoryNotBetweenExpression6;
import cn.featherfly.hammer.expression.repository.condition.nco.RepositoryNotContainsExpression6;
import cn.featherfly.hammer.expression.repository.condition.ne.RepositoryNotEqualsExpression6;
import cn.featherfly.hammer.expression.repository.condition.newv.RepositoryNotEndWithExpression6;
import cn.featherfly.hammer.expression.repository.condition.ni.RepositoryNotInExpression6;
import cn.featherfly.hammer.expression.repository.condition.nl.RepositoryNotLikeExpression6;
import cn.featherfly.hammer.expression.repository.condition.nsw.RepositoryNotStartWithExpression6;
import cn.featherfly.hammer.expression.repository.condition.sw.RepositoryStartWithExpression6;

/**
 * all repository conditions expression6.
 *
 * @author zhongj
 */
public interface RepositoryConditionsExpression6<C extends RepositoryConditionsExpression6<C, L>,
        L extends RepositoryConditionsLogicExpression6<C, L>> extends ConditionsExpression6<C, L>, //
        RepositoryBetweenExpression6<C, L>, RepositoryNotBetweenExpression6<C, L> //
        , RepositoryContainsExpression6<C, L>, RepositoryNotContainsExpression6<C, L> //
        , RepositoryEndWithExpression6<C, L>, RepositoryNotEndWithExpression6<C, L> //
        , RepositoryEqualsExpression6<C, L>, RepositoryNotEqualsExpression6<C, L> //
        , RepositoryGreatEqualsExpression6<C, L>, RepositoryGreatThanExpression6<C, L> //
        , RepositoryInExpression6<C, L>, RepositoryNotInExpression6<C, L> //
        , RepositoryIsNotNullExpression6<C, L>, RepositoryIsNullExpression6<C, L> //
        , RepositoryLessEqualsExpression6<C, L>, RepositoryLessThanExpression6<C, L>//
        , RepositoryStartWithExpression6<C, L>, RepositoryNotStartWithExpression6<C, L>//
        , RepositoryLikeExpression6<C, L>, RepositoryNotLikeExpression6<C, L> //
        , RepositoryFieldExpression6<C, L> {
}
