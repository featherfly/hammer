
package cn.featherfly.hammer.expression.repository.condition.inn;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository is not null expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNotNullExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryIsNotNullExpressionBase4<C, L> {
    /**
     * is not null.
     *
     * @param isNotNullExpressions the is not null expressions
     * @return the LogicExpression
     */
    L inn(Consumer<Tuple4<IsNotNullRepositoryExpression, IsNotNullRepositoryExpression, IsNotNullRepositoryExpression,
        IsNotNullRepositoryExpression>> isNotNullExpressions);

    /**
     * is not null.
     *
     * @param isNotNullExpressions the is not null expressions
     * @return the LogicExpression
     */
    L inn(FourArgusConsumer<IsNotNullRepositoryExpression, IsNotNullRepositoryExpression, IsNotNullRepositoryExpression,
        IsNotNullRepositoryExpression> isNotNullExpressions);
}