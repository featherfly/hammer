
package cn.featherfly.hammer.expression.repository.condition.nl;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not like expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotLikeExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotLikeExpressionBase3<C, L> {
    /**
     * not like.
     *
     * @param notLikeExpressions the not like expressions
     * @return the LogicExpression
     */
    L nl(Consumer<Tuple3<NotLikeRepositoryExpression, NotLikeRepositoryExpression,
        NotLikeRepositoryExpression>> notLikeExpressions);

    /**
     * not like.
     *
     * @param notLikeExpressions the not like expressions
     * @return the LogicExpression
     */
    L nl(ThreeArgusConsumer<NotLikeRepositoryExpression, NotLikeRepositoryExpression,
        NotLikeRepositoryExpression> notLikeExpressions);
}