
package cn.featherfly.hammer.expression.repository.condition.ba;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository between expression4 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryBetweenExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryBetweenExpressionBase4<C, L> {

    /**
     * between and.
     *
     * @param betweenExpressions the between expressions
     * @return the LogicExpression
     */
    L ba(Consumer<Tuple4<BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression>> betweenExpressions);

    /**
     * between and.
     *
     * @param betweenExpressions the between expressions
     * @return the LogicExpression
     */
    L ba(FourArgusConsumer<BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression, BetweenRepositoryExpression> betweenExpressions);
}