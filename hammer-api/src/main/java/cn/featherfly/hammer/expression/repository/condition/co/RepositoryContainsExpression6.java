
package cn.featherfly.hammer.expression.repository.condition.co;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryContainsExpression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryContainsExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryContainsExpressionBase6<C, L> {

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L co(Consumer<Tuple6<ContainsRepositoryExpression, ContainsRepositoryExpression, ContainsRepositoryExpression,
            ContainsRepositoryExpression, ContainsRepositoryExpression,
            ContainsRepositoryExpression>> containsRepositoryExpressions);

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L co(SixArgusConsumer<ContainsRepositoryExpression, ContainsRepositoryExpression, ContainsRepositoryExpression,
            ContainsRepositoryExpression, ContainsRepositoryExpression,
            ContainsRepositoryExpression> containsRepositoryExpressions);
}