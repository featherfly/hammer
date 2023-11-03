
package cn.featherfly.hammer.expression.repository.condition.lk;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository like expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLikeExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLikeExpressionBase5<C, L> {
    /**
     * like.
     *
     * @param likeExpressions the like expressions
     * @return the LogicExpression
     */
    L lk(Consumer<Tuple5<LikeRepositoryExpression, LikeRepositoryExpression, LikeRepositoryExpression,
        LikeRepositoryExpression, LikeRepositoryExpression>> likeExpressions);

    /**
     * like.
     *
     * @param likeExpressions the like expressions
     * @return the LogicExpression
     */
    L lk(FiveArgusConsumer<LikeRepositoryExpression, LikeRepositoryExpression, LikeRepositoryExpression,
        LikeRepositoryExpression, LikeRepositoryExpression> likeExpressions);
}