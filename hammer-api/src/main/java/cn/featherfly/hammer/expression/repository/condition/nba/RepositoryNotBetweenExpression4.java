
package cn.featherfly.hammer.expression.repository.condition.nba;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not between and expression4 .
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface RepositoryNotBetweenExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotBetweenExpressionBase4<C, L> {

    /**
     * not between and.
     *
     * @param notBetweenExpressions the not between expressions
     * @return the LogicExpression
     */
    L nba(Consumer<Tuple4<NotBetweenRepositoryExpression, NotBetweenRepositoryExpression, NotBetweenRepositoryExpression, NotBetweenRepositoryExpression>> notBetweenExpressions);

    /**
     * not between and.
     *
     * @param notBetweenExpressions the not between expressions
     * @return the LogicExpression
     */
    L nba(FourArgusConsumer<NotBetweenRepositoryExpression, NotBetweenRepositoryExpression, NotBetweenRepositoryExpression, NotBetweenRepositoryExpression> notBetweenExpressions);
}