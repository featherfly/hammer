
package cn.featherfly.hammer.expression.repository.condition.sw;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository start with expression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryStartWithExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryStartWithExpressionBase3<C, L> {
    /**
     * start with.
     *
     * @param startWithExpressions the start with expressions
     * @return the LogicExpression
     */
    L sw(Consumer<Tuple3<StartWithRepositoryExpression, StartWithRepositoryExpression,
        StartWithRepositoryExpression>> startWithExpressions);

    /**
     * start with.
     *
     * @param startWithExpressions the start with expressions
     * @return the LogicExpression
     */
    L sw(ThreeArgusConsumer<StartWithRepositoryExpression, StartWithRepositoryExpression,
        StartWithRepositoryExpression> startWithExpressions);
}