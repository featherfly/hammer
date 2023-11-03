
package cn.featherfly.hammer.expression.repository.condition.in;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository in expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryInExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryInExpressionBase4<C, L> {
    /**
     * in.
     *
     * @param inExpressions the in expressions
     * @return the LogicExpression
     */
    L in(Consumer<Tuple4<InRepositoryExpression, InRepositoryExpression, InRepositoryExpression,
        InRepositoryExpression>> inExpressions);

    /**
     * in.
     *
     * @param inExpressions the in expressions
     * @return the LogicExpression
     */
    L in(FourArgusConsumer<InRepositoryExpression, InRepositoryExpression, InRepositoryExpression,
        InRepositoryExpression> inExpressions);
}