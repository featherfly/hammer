
package cn.featherfly.hammer.expression.repository.condition.sw;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository start with expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryStartWithExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryStartWithExpressionBase6<C, L> {

    /**
     * start with.
     *
     * @param startWithExpressions the start with expressions
     * @return the LogicExpression
     */
    L sw(Consumer<Tuple6<StartWithRepositoryExpression, StartWithRepositoryExpression, StartWithRepositoryExpression,
        StartWithRepositoryExpression, StartWithRepositoryExpression,
        StartWithRepositoryExpression>> startWithExpressions);

    /**
     * start with.
     *
     * @param startWithExpressions the start with expressions
     * @return the LogicExpression
     */
    L sw(SixArgusConsumer<StartWithRepositoryExpression, StartWithRepositoryExpression, StartWithRepositoryExpression,
        StartWithRepositoryExpression, StartWithRepositoryExpression,
        StartWithRepositoryExpression> startWithExpressions);
}