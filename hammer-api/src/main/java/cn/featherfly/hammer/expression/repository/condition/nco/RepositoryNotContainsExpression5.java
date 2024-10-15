
package cn.featherfly.hammer.expression.repository.condition.nco;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryNotContainsExpression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotContainsExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotContainsExpressionBase5<C, L> {
    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L nco(Consumer<Tuple5<NotContainsRepositoryExpression, NotContainsRepositoryExpression, NotContainsRepositoryExpression,
            NotContainsRepositoryExpression, NotContainsRepositoryExpression>> containsRepositoryExpressions);

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L nco(FiveArgusConsumer<NotContainsRepositoryExpression, NotContainsRepositoryExpression, NotContainsRepositoryExpression,
            NotContainsRepositoryExpression, NotContainsRepositoryExpression> containsRepositoryExpressions);
}