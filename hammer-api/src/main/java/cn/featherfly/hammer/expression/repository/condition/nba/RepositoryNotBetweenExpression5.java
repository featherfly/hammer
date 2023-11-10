
package cn.featherfly.hammer.expression.repository.condition.nba;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not between and expression5 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryNotBetweenExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotBetweenExpressionBase5<C, L> {
    /**
     * not between and.
     *
     * @param inExpressions the in expressions
     * @return the LogicExpression
     */
    L nba(
        Consumer<Tuple5<NotBetweenRepositoryExpression, NotBetweenRepositoryExpression, NotBetweenRepositoryExpression,
            NotBetweenRepositoryExpression, NotBetweenRepositoryExpression>> notBetweenExpressions);

    /**
     * not between and.
     *
     * @param inExpressions the in expressions
     * @return the LogicExpression
     */
    L nba(FiveArgusConsumer<NotBetweenRepositoryExpression, NotBetweenRepositoryExpression,
        NotBetweenRepositoryExpression, NotBetweenRepositoryExpression,
        NotBetweenRepositoryExpression> notBetweenExpressions);
}