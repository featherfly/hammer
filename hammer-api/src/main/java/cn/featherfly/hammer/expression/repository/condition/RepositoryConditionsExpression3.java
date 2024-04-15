
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.NativeStringConditionExpression;
import cn.featherfly.hammer.expression.repository.condition.ba.RepositoryBetweenExpression3;
import cn.featherfly.hammer.expression.repository.condition.co.RepositoryContainsExpression3;
import cn.featherfly.hammer.expression.repository.condition.eq.RepositoryEqualsExpression3;
import cn.featherfly.hammer.expression.repository.condition.ew.RepositoryEndWithExpression3;
import cn.featherfly.hammer.expression.repository.condition.ge.RepositoryGreatEqualsExpression3;
import cn.featherfly.hammer.expression.repository.condition.gt.RepositoryGreatThanExpression3;
import cn.featherfly.hammer.expression.repository.condition.in.RepositoryInExpression3;
import cn.featherfly.hammer.expression.repository.condition.inn.RepositoryIsNotNullExpression3;
import cn.featherfly.hammer.expression.repository.condition.isn.RepositoryIsNullExpression3;
import cn.featherfly.hammer.expression.repository.condition.le.RepositoryLessEqualsExpression3;
import cn.featherfly.hammer.expression.repository.condition.lk.RepositoryLikeExpression3;
import cn.featherfly.hammer.expression.repository.condition.lt.RepositoryLessThanExpression3;
import cn.featherfly.hammer.expression.repository.condition.nba.RepositoryNotBetweenExpression3;
import cn.featherfly.hammer.expression.repository.condition.nco.RepositoryNotContainsExpression3;
import cn.featherfly.hammer.expression.repository.condition.ne.RepositoryNotEqualsExpression3;
import cn.featherfly.hammer.expression.repository.condition.newv.RepositoryNotEndWithExpression3;
import cn.featherfly.hammer.expression.repository.condition.ni.RepositoryNotInExpression3;
import cn.featherfly.hammer.expression.repository.condition.nl.RepositoryNotLikeExpression3;
import cn.featherfly.hammer.expression.repository.condition.nsw.RepositoryNotStartWithExpression3;
import cn.featherfly.hammer.expression.repository.condition.sw.RepositoryStartWithExpression3;

/**
 * all repository conditions expression3.
 *
 * @author zhongj
 */
public interface RepositoryConditionsExpression3<C extends RepositoryConditionsExpression3<C, L>,
    L extends RepositoryConditionsLogicExpression3<C, L>>
    extends RepositoryBetweenExpression3<C, L>, RepositoryNotBetweenExpression3<C, L> //
    , RepositoryContainsExpression3<C, L>, RepositoryNotContainsExpression3<C, L> //
    , RepositoryEndWithExpression3<C, L>, RepositoryNotEndWithExpression3<C, L> //
    , RepositoryEqualsExpression3<C, L>, RepositoryNotEqualsExpression3<C, L> //
    , RepositoryGreatEqualsExpression3<C, L>, RepositoryGreatThanExpression3<C, L> //
    , RepositoryInExpression3<C, L>, RepositoryNotInExpression3<C, L> //
    , RepositoryIsNotNullExpression3<C, L>, RepositoryIsNullExpression3<C, L> //
    , RepositoryLessEqualsExpression3<C, L>, RepositoryLessThanExpression3<C, L>//
    , RepositoryStartWithExpression3<C, L>, RepositoryNotStartWithExpression3<C, L>//
    , RepositoryLikeExpression3<C, L>, RepositoryNotLikeExpression3<C, L> //
    , RepositoryFieldExpression3<C, L>, //
    NativeStringConditionExpression<C, L> {
}
