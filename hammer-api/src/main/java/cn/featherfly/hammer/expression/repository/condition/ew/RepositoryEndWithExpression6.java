
package cn.featherfly.hammer.expression.repository.condition.ew;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository end with expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEndWithExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryEndWithExpressionBase6<C, L> {

    /**
     * end with.
     *
     * @param endWithRepositoryExpressions the end with repository expressions
     * @return the LogicExpression
     */
    L ew(Consumer<Tuple6<EndWithRepositoryExpression, EndWithRepositoryExpression, EndWithRepositoryExpression,
        EndWithRepositoryExpression, EndWithRepositoryExpression,
        EndWithRepositoryExpression>> endWithRepositoryExpressions);

    /**
     * end with.
     *
     * @param endWithRepositoryExpressions the end with repository expressions
     * @return the LogicExpression
     */
    L ew(SixArgusConsumer<EndWithRepositoryExpression, EndWithRepositoryExpression, EndWithRepositoryExpression,
        EndWithRepositoryExpression, EndWithRepositoryExpression,
        EndWithRepositoryExpression> endWithRepositoryExpressions);
}