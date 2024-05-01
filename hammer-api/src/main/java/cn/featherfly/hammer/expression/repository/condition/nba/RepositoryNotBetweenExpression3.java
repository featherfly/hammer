
package cn.featherfly.hammer.expression.repository.condition.nba;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not between and expression3 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryNotBetweenExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotBetweenExpressionBase3<C, L> {

    /**
     * not between and.
     *
     * @param notBetweenExpressions the not between expressions
     * @return the LogicExpression
     */
    L nba(Consumer<Tuple3<NotBetweenRepositoryExpression, NotBetweenRepositoryExpression, NotBetweenRepositoryExpression>> notBetweenExpressions);

    /**
     * not between and.
     *
     * @param notBetweenExpressions the not between expressions
     * @return the LogicExpression
     */
    L nba(ThreeArgusConsumer<NotBetweenRepositoryExpression, NotBetweenRepositoryExpression, NotBetweenRepositoryExpression> notBetweenExpressions);
}