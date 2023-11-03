
package cn.featherfly.hammer.expression.repository.condition.inn;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository is not null expression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNotNullExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryIsNotNullExpressionBase2<C, L> {
    /**
     * is not null.
     *
     * @param isNotNullExpressions the is not null expressions
     * @return the LogicExpression
     */
    L inn(Consumer<Tuple2<IsNotNullRepositoryExpression, IsNotNullRepositoryExpression>> isNotNullExpressions);

    /**
     * is not null.
     *
     * @param isNotNullExpressions the is not null expressions
     * @return the LogicExpression
     */
    L inn(BiConsumer<IsNotNullRepositoryExpression, IsNotNullRepositoryExpression> isNotNullExpressions);
}