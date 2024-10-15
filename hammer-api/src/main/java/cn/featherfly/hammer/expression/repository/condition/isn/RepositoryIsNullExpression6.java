
package cn.featherfly.hammer.expression.repository.condition.isn;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryIsNullExpression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNullExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryIsNullExpressionBase<C, L> {

    /**
     * is null.
     *
     * @param isNullRepositoryExpressions the is null repository expressions
     * @return the LogicExpression
     */
    L isn(Consumer<Tuple6<IsNullRepositoryExpression, IsNullRepositoryExpression, IsNullRepositoryExpression,
            IsNullRepositoryExpression, IsNullRepositoryExpression,
            IsNullRepositoryExpression>> isNullRepositoryExpressions);

    /**
     * is null.
     *
     * @param isNullRepositoryExpressions the is null repository expressions
     * @return the LogicExpression
     */
    L isn(SixArgusConsumer<IsNullRepositoryExpression, IsNullRepositoryExpression, IsNullRepositoryExpression,
            IsNullRepositoryExpression, IsNullRepositoryExpression,
            IsNullRepositoryExpression> isNullRepositoryExpressions);
}