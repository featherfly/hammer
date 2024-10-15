
package cn.featherfly.hammer.expression.repository.condition.nl;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not like expression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotLikeExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotLikeExpressionBase4<C, L> {
    /**
     * not like.
     *
     * @param notLikeExpressions the not like expressions
     * @return the LogicExpression
     */
    L nl(Consumer<Tuple4<NotLikeRepositoryExpression, NotLikeRepositoryExpression, NotLikeRepositoryExpression,
        NotLikeRepositoryExpression>> notLikeExpressions);

    /**
     * not like.
     *
     * @param notLikeExpressions the not like expressions
     * @return the LogicExpression
     */
    L nl(FourArgusConsumer<NotLikeRepositoryExpression, NotLikeRepositoryExpression, NotLikeRepositoryExpression,
        NotLikeRepositoryExpression> notLikeExpressions);
}