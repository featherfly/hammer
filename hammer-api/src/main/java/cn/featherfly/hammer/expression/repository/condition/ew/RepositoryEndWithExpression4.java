
package cn.featherfly.hammer.expression.repository.condition.ew;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository end with expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEndWithExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryEndWithExpressionBase4<C, L> {
    /**
     * end with.
     *
     * @param endWithRepositoryExpressions the end with repository expressions
     * @return the LogicExpression
     */
    L ew(Consumer<Tuple4<EndWithRepositoryExpression, EndWithRepositoryExpression, EndWithRepositoryExpression,
        EndWithRepositoryExpression>> endWithRepositoryExpressions);

    /**
     * end with.
     *
     * @param endWithRepositoryExpressions the end with repository expressions
     * @return the LogicExpression
     */
    L ew(FourArgusConsumer<EndWithRepositoryExpression, EndWithRepositoryExpression, EndWithRepositoryExpression,
        EndWithRepositoryExpression> endWithRepositoryExpressions);
}