
package cn.featherfly.hammer.expression.repository.condition.in;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository in expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryInExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryInExpressionBase5<C, L> {
    /**
     * in.
     *
     * @param inExpressions the in expressions
     * @return the LogicExpression
     */
    L in(Consumer<Tuple5<InRepositoryExpression, InRepositoryExpression, InRepositoryExpression, InRepositoryExpression,
        InRepositoryExpression>> inExpressions);

    /**
     * in.
     *
     * @param inExpressions the in expressions
     * @return the LogicExpression
     */
    L in(FiveArgusConsumer<InRepositoryExpression, InRepositoryExpression, InRepositoryExpression,
        InRepositoryExpression, InRepositoryExpression> inExpressions);
}