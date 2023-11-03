
package cn.featherfly.hammer.expression.repository.condition.nba;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not between and expression2 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryNotBetweenExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotBetweenExpressionBase2<C, L> {
    /**
     * not between and.
     *
     * @param inExpressions the in expressions
     * @return the LogicExpression
     */
    L nba(Consumer<Tuple2<NotBetweenRepositoryExpression, NotBetweenRepositoryExpression>> notBetweenExpressions);

    /**
     * not between and.
     *
     * @param inExpressions the in expressions
     * @return the LogicExpression
     */
    L nba(BiConsumer<NotBetweenRepositoryExpression, NotBetweenRepositoryExpression> notBetweenExpressions);
}