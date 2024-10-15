
package cn.featherfly.hammer.expression.repository.condition.sw;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository start with expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryStartWithExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryStartWithExpressionBase5<C, L> {
    /**
     * start with.
     *
     * @param startWithExpressions the start with expressions
     * @return the LogicExpression
     */
    L sw(Consumer<Tuple5<StartWithRepositoryExpression, StartWithRepositoryExpression, StartWithRepositoryExpression,
        StartWithRepositoryExpression, StartWithRepositoryExpression>> startWithExpressions);

    /**
     * start with.
     *
     * @param startWithExpressions the start with expressions
     * @return the LogicExpression
     */
    L sw(FiveArgusConsumer<StartWithRepositoryExpression, StartWithRepositoryExpression, StartWithRepositoryExpression,
        StartWithRepositoryExpression, StartWithRepositoryExpression> startWithExpressions);
}