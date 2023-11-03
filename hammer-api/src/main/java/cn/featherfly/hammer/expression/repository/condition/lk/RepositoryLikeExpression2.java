
package cn.featherfly.hammer.expression.repository.condition.lk;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository like expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLikeExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLikeExpressionBase2<C, L> {
    /**
     * like.
     *
     * @param likeExpressions the like expressions
     * @return the LogicExpression
     */
    L lk(Consumer<Tuple2<LikeRepositoryExpression, LikeRepositoryExpression>> likeExpressions);

    /**
     * like.
     *
     * @param likeExpressions the like expressions
     * @return the LogicExpression
     */
    L lk(BiConsumer<LikeRepositoryExpression, LikeRepositoryExpression> likeExpressions);
}