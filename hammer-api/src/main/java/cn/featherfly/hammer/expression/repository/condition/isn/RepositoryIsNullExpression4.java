
package cn.featherfly.hammer.expression.repository.condition.isn;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryIsNullExpression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNullExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryIsNullExpressionBase4<C, L> {
    /**
     * is null.
     *
     * @param isNullRepositoryExpressions the is null repository expressions
     * @return the LogicExpression
     */
    L isn(Consumer<Tuple4<IsNullRepositoryExpression, IsNullRepositoryExpression, IsNullRepositoryExpression,
            IsNullRepositoryExpression>> isNullRepositoryExpressions);

    /**
     * is null.
     *
     * @param isNullRepositoryExpressions the is null repository expressions
     * @return the LogicExpression
     */
    L isn(FourArgusConsumer<IsNullRepositoryExpression, IsNullRepositoryExpression, IsNullRepositoryExpression,
            IsNullRepositoryExpression> isNullRepositoryExpressions);
}