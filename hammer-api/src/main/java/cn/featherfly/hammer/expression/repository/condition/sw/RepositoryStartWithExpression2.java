
package cn.featherfly.hammer.expression.repository.condition.sw;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository start with expression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryStartWithExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryStartWithExpressionBase2<C, L> {
    /**
     * start with.
     *
     * @param startWithExpressions the start with expressions
     * @return the LogicExpression
     */
    L sw(Consumer<Tuple2<StartWithRepositoryExpression, StartWithRepositoryExpression>> startWithExpressions);

    /**
     * start with.
     *
     * @param startWithExpressions the start with expressions
     * @return the LogicExpression
     */
    L sw(BiConsumer<StartWithRepositoryExpression, StartWithRepositoryExpression> startWithExpressions);
}