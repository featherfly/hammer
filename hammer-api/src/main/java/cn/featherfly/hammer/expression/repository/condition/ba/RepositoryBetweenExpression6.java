
package cn.featherfly.hammer.expression.repository.condition.ba;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository between expression6 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryBetweenExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryBetweenExpressionBase6<C, L> {

    /**
     * between and.
     *
     * @param betweenExpressions the between expressions
     * @return the LogicExpression
     */
    L ba(Consumer<Tuple6<BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression>> betweenExpressions);

    /**
     * between and.
     *
     * @param betweenExpressions the between expressions
     * @return the LogicExpression
     */
    L ba(SixArgusConsumer<BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression> betweenExpressions);
}