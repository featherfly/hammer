
package cn.featherfly.hammer.expression.repository.condition.isn;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryIsNullExpression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNullExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryIsNullExpressionBase3<C, L> {

    /**
     * is null.
     *
     * @param isNullRepositoryExpressions the is null repository expressions
     * @return the LogicExpression
     */
    L isn(Consumer<Tuple3<IsNullRepositoryExpression, IsNullRepositoryExpression,
            IsNullRepositoryExpression>> isNullRepositoryExpressions);

    /**
     * is null.
     *
     * @param isNullRepositoryExpressions the is null repository expressions
     * @return the LogicExpression
     */
    L isn(ThreeArgusConsumer<IsNullRepositoryExpression, IsNullRepositoryExpression,
            IsNullRepositoryExpression> isNullRepositoryExpressions);
}