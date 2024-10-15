
package cn.featherfly.hammer.expression.repository.condition.isn;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryIsNullExpression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNullExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryIsNullExpressionBase5<C, L> {

    /**
     * is null.
     *
     * @param isNullRepositoryExpressions the is null repository expressions
     * @return the LogicExpression
     */
    L isn(Consumer<Tuple5<IsNullRepositoryExpression, IsNullRepositoryExpression, IsNullRepositoryExpression,
            IsNullRepositoryExpression, IsNullRepositoryExpression>> isNullRepositoryExpressions);

    /**
     * is null.
     *
     * @param isNullRepositoryExpressions the is null repository expressions
     * @return the LogicExpression
     */
    L isn(FiveArgusConsumer<IsNullRepositoryExpression, IsNullRepositoryExpression, IsNullRepositoryExpression,
            IsNullRepositoryExpression, IsNullRepositoryExpression> isNullRepositoryExpressions);
}