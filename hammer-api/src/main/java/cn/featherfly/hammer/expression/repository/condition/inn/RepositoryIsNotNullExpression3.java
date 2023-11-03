
package cn.featherfly.hammer.expression.repository.condition.inn;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository is not null expression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNotNullExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryIsNotNullExpressionBase3<C, L> {
    /**
     * is not null.
     *
     * @param isNotNullExpressions the is not null expressions
     * @return the LogicExpression
     */
    L inn(Consumer<Tuple3<IsNotNullRepositoryExpression, IsNotNullRepositoryExpression,
        IsNotNullRepositoryExpression>> isNotNullExpressions);

    /**
     * is not null.
     *
     * @param isNotNullExpressions the is not null expressions
     * @return the LogicExpression
     */
    L inn(ThreeArgusConsumer<IsNotNullRepositoryExpression, IsNotNullRepositoryExpression,
        IsNotNullRepositoryExpression> isNotNullExpressions);
}