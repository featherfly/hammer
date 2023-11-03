
package cn.featherfly.hammer.expression.repository.condition.nl;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not like expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotLikeExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotLikeExpressionBase2<C, L> {
    /**
     * not like.
     *
     * @param notLikeExpressions the not like expressions
     * @return the LogicExpression
     */
    L nl(Consumer<Tuple2<NotLikeRepositoryExpression, NotLikeRepositoryExpression>> notLikeExpressions);

    /**
     * not like.
     *
     * @param notLikeExpressions the not like expressions
     * @return the LogicExpression
     */
    L nl(BiConsumer<NotLikeRepositoryExpression, NotLikeRepositoryExpression> notLikeExpressions);
}