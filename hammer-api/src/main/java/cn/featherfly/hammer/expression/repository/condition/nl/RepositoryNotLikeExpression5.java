
package cn.featherfly.hammer.expression.repository.condition.nl;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not like expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotLikeExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotLikeExpressionBase5<C, L> {

    /**
     * not like.
     *
     * @param notLikeExpressions the not like expressions
     * @return the LogicExpression
     */
    L nl(Consumer<Tuple5<NotLikeRepositoryExpression, NotLikeRepositoryExpression, NotLikeRepositoryExpression,
        NotLikeRepositoryExpression, NotLikeRepositoryExpression>> notLikeExpressions);

    /**
     * not like.
     *
     * @param notLikeExpressions the not like expressions
     * @return the LogicExpression
     */
    L nl(FiveArgusConsumer<NotLikeRepositoryExpression, NotLikeRepositoryExpression, NotLikeRepositoryExpression,
        NotLikeRepositoryExpression, NotLikeRepositoryExpression> notLikeExpressions);
}