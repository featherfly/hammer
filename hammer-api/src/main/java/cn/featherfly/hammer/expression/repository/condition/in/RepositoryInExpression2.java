
package cn.featherfly.hammer.expression.repository.condition.in;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository in expression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryInExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryInExpressionBase2<C, L> {
    /**
     * in.
     *
     * @param inExpressions the in expressions
     * @return the LogicExpression
     */
    L in(Consumer<Tuple2<InRepositoryExpression, InRepositoryExpression>> inExpressions);

    /**
     * in.
     *
     * @param inExpressions the in expressions
     * @return the LogicExpression
     */
    L in(BiConsumer<InRepositoryExpression, InRepositoryExpression> inExpressions);
}