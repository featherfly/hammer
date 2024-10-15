
package cn.featherfly.hammer.expression.repository.condition.lk;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository like expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLikeExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLikeExpressionBase3<C, L> {
    /**
     * like.
     *
     * @param likeExpressions the like expressions
     * @return the LogicExpression
     */
    L lk(
        Consumer<Tuple3<LikeRepositoryExpression, LikeRepositoryExpression, LikeRepositoryExpression>> likeExpressions);

    /**
     * like.
     *
     * @param likeExpressions the like expressions
     * @return the LogicExpression
     */
    L lk(ThreeArgusConsumer<LikeRepositoryExpression, LikeRepositoryExpression,
        LikeRepositoryExpression> likeExpressions);
}