
package cn.featherfly.hammer.expression.repository.condition.sw;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository start with expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryStartWithExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryStartWithExpressionBase4<C, L> {
    /**
     * start with.
     *
     * @param startWithExpressions the start with expressions
     * @return the LogicExpression
     */
    L sw(Consumer<Tuple4<StartWithRepositoryExpression, StartWithRepositoryExpression, StartWithRepositoryExpression,
        StartWithRepositoryExpression>> startWithExpressions);

    /**
     * start with.
     *
     * @param startWithExpressions the start with expressions
     * @return the LogicExpression
     */
    L sw(FourArgusConsumer<StartWithRepositoryExpression, StartWithRepositoryExpression, StartWithRepositoryExpression,
        StartWithRepositoryExpression> startWithExpressions);
}