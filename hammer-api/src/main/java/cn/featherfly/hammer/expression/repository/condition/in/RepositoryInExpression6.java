
package cn.featherfly.hammer.expression.repository.condition.in;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository in expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryInExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryInExpressionBase6<C, L> {

    /**
     * in.
     *
     * @param inExpressions the in expressions
     * @return the LogicExpression
     */
    L in(Consumer<Tuple6<InRepositoryExpression, InRepositoryExpression, InRepositoryExpression, InRepositoryExpression,
        InRepositoryExpression, InRepositoryExpression>> inExpressions);

    /**
     * in.
     *
     * @param inExpressions the in expressions
     * @return the LogicExpression
     */
    L in(SixArgusConsumer<InRepositoryExpression, InRepositoryExpression, InRepositoryExpression,
        InRepositoryExpression, InRepositoryExpression, InRepositoryExpression> inExpressions);
}