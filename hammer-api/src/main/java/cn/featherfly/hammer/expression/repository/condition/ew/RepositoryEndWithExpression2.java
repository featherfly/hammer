
package cn.featherfly.hammer.expression.repository.condition.ew;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository end with expression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryEndWithExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryEndWithExpressionBase2<C, L> {
    /**
     * end with.
     *
     * @param endWithRepositoryExpressions the end with repository expressions
     * @return the LogicExpression
     */
    L ew(Consumer<Tuple2<EndWithRepositoryExpression, EndWithRepositoryExpression>> endWithRepositoryExpressions);

    /**
     * end with.
     *
     * @param endWithRepositoryExpressions the end with repository expressions
     * @return the LogicExpression
     */
    L ew(BiConsumer<EndWithRepositoryExpression, EndWithRepositoryExpression> endWithRepositoryExpressions);
}