
package cn.featherfly.hammer.expression.repository.condition.lk;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository like expression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLikeExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLikeExpressionBase4<C, L> {
    /**
     * like.
     *
     * @param likeExpressions the like expressions
     * @return the LogicExpression
     */
    L lk(Consumer<Tuple4<LikeRepositoryExpression, LikeRepositoryExpression, LikeRepositoryExpression,
        LikeRepositoryExpression>> likeExpressions);

    /**
     * like.
     *
     * @param likeExpressions the like expressions
     * @return the LogicExpression
     */
    L lk(FourArgusConsumer<LikeRepositoryExpression, LikeRepositoryExpression, LikeRepositoryExpression,
        LikeRepositoryExpression> likeExpressions);
}