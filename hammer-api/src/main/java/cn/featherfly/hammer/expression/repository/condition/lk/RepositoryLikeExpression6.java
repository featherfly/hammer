
package cn.featherfly.hammer.expression.repository.condition.lk;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository like expression6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLikeExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLikeExpressionBase6<C, L> {

    /**
     * like.
     *
     * @param likeExpressions the like expressions
     * @return the LogicExpression
     */
    L lk(Consumer<Tuple6<LikeRepositoryExpression, LikeRepositoryExpression, LikeRepositoryExpression,
        LikeRepositoryExpression, LikeRepositoryExpression, LikeRepositoryExpression>> likeExpressions);

    /**
     * like.
     *
     * @param likeExpressions the like expressions
     * @return the LogicExpression
     */
    L lk(SixArgusConsumer<LikeRepositoryExpression, LikeRepositoryExpression, LikeRepositoryExpression,
        LikeRepositoryExpression, LikeRepositoryExpression, LikeRepositoryExpression> likeExpressions);
}