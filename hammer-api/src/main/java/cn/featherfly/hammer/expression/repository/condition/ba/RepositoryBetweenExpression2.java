
package cn.featherfly.hammer.expression.repository.condition.ba;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository between expression2 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryBetweenExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryBetweenExpressionBase2<C, L> {

    /**
     * between and.
     *
     * @param betweenExpressions the between expressions
     * @return the LogicExpression
     */
    L ba(Consumer<Tuple2<BetweenRepositoryExpression, BetweenRepositoryExpression>> betweenExpressions);

    /**
     * between and.
     *
     * @param betweenExpressions the between expressions
     * @return the LogicExpression
     */
    L ba(BiConsumer<BetweenRepositoryExpression, BetweenRepositoryExpression> betweenExpressions);
}