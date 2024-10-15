
package cn.featherfly.hammer.expression.repository.condition.nl;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not like expression6.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotLikeExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotLikeExpressionBase6<C, L> {

    /**
     * not like.
     *
     * @param notLikeExpressions the not like expressions
     * @return the LogicExpression
     */
    L nl(Consumer<Tuple6<NotLikeRepositoryExpression, NotLikeRepositoryExpression, NotLikeRepositoryExpression,
        NotLikeRepositoryExpression, NotLikeRepositoryExpression, NotLikeRepositoryExpression>> notLikeExpressions);

    /**
     * not like.
     *
     * @param notLikeExpressions the not like expressions
     * @return the LogicExpression
     */
    L nl(SixArgusConsumer<NotLikeRepositoryExpression, NotLikeRepositoryExpression, NotLikeRepositoryExpression,
        NotLikeRepositoryExpression, NotLikeRepositoryExpression, NotLikeRepositoryExpression> notLikeExpressions);
}