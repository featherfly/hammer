
package cn.featherfly.hammer.expression.repository.condition.in;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository in expression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryInExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryInExpressionBase3<C, L> {
    /**
     * in.
     *
     * @param inExpressions the in expressions
     * @return the LogicExpression
     */
    L in(Consumer<Tuple3<InRepositoryExpression, InRepositoryExpression, InRepositoryExpression>> inExpressions);

    /**
     * in.
     *
     * @param inExpressions the in expressions
     * @return the LogicExpression
     */
    L in(ThreeArgusConsumer<InRepositoryExpression, InRepositoryExpression, InRepositoryExpression> inExpressions);
}