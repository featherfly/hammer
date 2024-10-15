
package cn.featherfly.hammer.expression.repository.condition.inn;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository is not null expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNotNullExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryIsNotNullExpressionBase6<C, L> {

    /**
     * is not null.
     *
     * @param isNotNullExpressions the is not null expressions
     * @return the LogicExpression
     */
    L inn(Consumer<Tuple6<IsNotNullRepositoryExpression, IsNotNullRepositoryExpression, IsNotNullRepositoryExpression,
        IsNotNullRepositoryExpression, IsNotNullRepositoryExpression,
        IsNotNullRepositoryExpression>> isNotNullExpressions);

    /**
     * is not null.
     *
     * @param isNotNullExpressions the is not null expressions
     * @return the LogicExpression
     */
    L inn(SixArgusConsumer<IsNotNullRepositoryExpression, IsNotNullRepositoryExpression, IsNotNullRepositoryExpression,
        IsNotNullRepositoryExpression, IsNotNullRepositoryExpression,
        IsNotNullRepositoryExpression> isNotNullExpressions);
}