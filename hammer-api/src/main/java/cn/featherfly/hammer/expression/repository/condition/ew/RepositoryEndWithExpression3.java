
package cn.featherfly.hammer.expression.repository.condition.ew;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository end with expression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEndWithExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryEndWithExpressionBase3<C, L> {
    /**
     * end with.
     *
     * @param endWithRepositoryExpressions the end with repository expressions
     * @return the LogicExpression
     */
    L ew(Consumer<Tuple3<EndWithRepositoryExpression, EndWithRepositoryExpression,
        EndWithRepositoryExpression>> endWithRepositoryExpressions);

    /**
     * end with.
     *
     * @param endWithRepositoryExpressions the end with repository expressions
     * @return the LogicExpression
     */
    L ew(ThreeArgusConsumer<EndWithRepositoryExpression, EndWithRepositoryExpression,
        EndWithRepositoryExpression> endWithRepositoryExpressions);
}