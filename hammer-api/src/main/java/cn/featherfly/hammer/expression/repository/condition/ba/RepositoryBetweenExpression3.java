
package cn.featherfly.hammer.expression.repository.condition.ba;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository between expression3 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryBetweenExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryBetweenExpressionBase3<C, L> {

    /**
     * between and.
     *
     * @param betweenExpressions the between expressions
     * @return the LogicExpression
     */
    L ba(Consumer<Tuple3<BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression>> betweenExpressions);

    /**
     * between and.
     *
     * @param betweenExpressions the between expressions
     * @return the LogicExpression
     */
    L ba(ThreeArgusConsumer<BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression> betweenExpressions);
}