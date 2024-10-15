
package cn.featherfly.hammer.expression.repository.condition.ba;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository between expression5 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryBetweenExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryBetweenExpressionBase5<C, L> {

    /**
     * between and.
     *
     * @param betweenExpressions the between expressions
     * @return the LogicExpression
     */
    L ba(Consumer<Tuple5<BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression>> betweenExpressions);

    /**
     * between and.
     *
     * @param betweenExpressions the between expressions
     * @return the LogicExpression
     */
    L ba(FiveArgusConsumer<BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression> betweenExpressions);
}