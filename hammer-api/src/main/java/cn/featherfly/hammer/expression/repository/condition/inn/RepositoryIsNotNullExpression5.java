
package cn.featherfly.hammer.expression.repository.condition.inn;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository is not null expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNotNullExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryIsNotNullExpressionBase5<C, L> {
    /**
     * is not null.
     *
     * @param isNotNullExpressions the is not null expressions
     * @return the LogicExpression
     */
    L inn(Consumer<Tuple5<IsNotNullRepositoryExpression, IsNotNullRepositoryExpression, IsNotNullRepositoryExpression,
        IsNotNullRepositoryExpression, IsNotNullRepositoryExpression>> isNotNullExpressions);

    /**
     * is not null.
     *
     * @param isNotNullExpressions the is not null expressions
     * @return the LogicExpression
     */
    L inn(FiveArgusConsumer<IsNotNullRepositoryExpression, IsNotNullRepositoryExpression, IsNotNullRepositoryExpression,
        IsNotNullRepositoryExpression, IsNotNullRepositoryExpression> isNotNullExpressions);
}