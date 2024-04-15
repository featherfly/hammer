
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.NativeStringConditionExpression;
import cn.featherfly.hammer.expression.repository.condition.ba.RepositoryBetweenExpression;
import cn.featherfly.hammer.expression.repository.condition.co.RepositoryContainsExpression;
import cn.featherfly.hammer.expression.repository.condition.eq.RepositoryEqualsExpression;
import cn.featherfly.hammer.expression.repository.condition.ew.RepositoryEndWithExpression;
import cn.featherfly.hammer.expression.repository.condition.ge.RepositoryGreatEqualsExpression;
import cn.featherfly.hammer.expression.repository.condition.gt.RepositoryGreatThanExpression;
import cn.featherfly.hammer.expression.repository.condition.in.RepositoryInExpression;
import cn.featherfly.hammer.expression.repository.condition.inn.RepositoryIsNotNullExpression;
import cn.featherfly.hammer.expression.repository.condition.isn.RepositoryIsNullExpression;
import cn.featherfly.hammer.expression.repository.condition.le.RepositoryLessEqualsExpression;
import cn.featherfly.hammer.expression.repository.condition.lk.RepositoryLikeExpression;
import cn.featherfly.hammer.expression.repository.condition.lt.RepositoryLessThanExpression;
import cn.featherfly.hammer.expression.repository.condition.nba.RepositoryNotBetweenExpression;
import cn.featherfly.hammer.expression.repository.condition.nco.RepositoryNotContainsExpression;
import cn.featherfly.hammer.expression.repository.condition.ne.RepositoryNotEqualsExpression;
import cn.featherfly.hammer.expression.repository.condition.newv.RepositoryNotEndWithExpression;
import cn.featherfly.hammer.expression.repository.condition.ni.RepositoryNotInExpression;
import cn.featherfly.hammer.expression.repository.condition.nl.RepositoryNotLikeExpression;
import cn.featherfly.hammer.expression.repository.condition.nsw.RepositoryNotStartWithExpression;
import cn.featherfly.hammer.expression.repository.condition.sw.RepositoryStartWithExpression;

/**
 * all repository conditions expression.
 *
 * @author zhongj
 */
public interface RepositoryConditionsExpression<C extends RepositoryConditionsExpression<C, L>,
    L extends RepositoryConditionsLogicExpression<C, L>>
    extends RepositoryBetweenExpression<C, L>, RepositoryNotBetweenExpression<C, L> //
    , RepositoryContainsExpression<C, L>, RepositoryNotContainsExpression<C, L> //
    , RepositoryEndWithExpression<C, L>, RepositoryNotEndWithExpression<C, L> //
    , RepositoryEqualsExpression<C, L>, RepositoryNotEqualsExpression<C, L> //
    , RepositoryGreatEqualsExpression<C, L>, RepositoryGreatThanExpression<C, L> //
    , RepositoryInExpression<C, L>, RepositoryNotInExpression<C, L> //
    , RepositoryIsNotNullExpression<C, L>, RepositoryIsNullExpression<C, L> //
    , RepositoryLessEqualsExpression<C, L>, RepositoryLessThanExpression<C, L>//
    , RepositoryStartWithExpression<C, L>, RepositoryNotStartWithExpression<C, L>//
    , RepositoryLikeExpression<C, L>, RepositoryNotLikeExpression<C, L> //
    , RepositoryFieldExpression<C, L>, //
    NativeStringConditionExpression<C, L> {
}
