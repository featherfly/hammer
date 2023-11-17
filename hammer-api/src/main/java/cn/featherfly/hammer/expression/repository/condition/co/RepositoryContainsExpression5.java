
package cn.featherfly.hammer.expression.repository.condition.co;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryContainsExpression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryContainsExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryContainsExpressionBase5<C, L> {
    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L co(Consumer<Tuple5<ContainsRepositoryExpression, ContainsRepositoryExpression, ContainsRepositoryExpression,
            ContainsRepositoryExpression, ContainsRepositoryExpression>> containsRepositoryExpressions);

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L co(FiveArgusConsumer<ContainsRepositoryExpression, ContainsRepositoryExpression, ContainsRepositoryExpression,
            ContainsRepositoryExpression, ContainsRepositoryExpression> containsRepositoryExpressions);
}