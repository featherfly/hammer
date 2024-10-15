
package cn.featherfly.hammer.expression.repository.condition.nco;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryNotContainsExpression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotContainsExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotContainsExpressionBase3<C, L> {

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L nco(Consumer<Tuple3<NotContainsRepositoryExpression, NotContainsRepositoryExpression,
            NotContainsRepositoryExpression>> containsRepositoryExpressions);

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L nco(ThreeArgusConsumer<NotContainsRepositoryExpression, NotContainsRepositoryExpression,
            NotContainsRepositoryExpression> containsRepositoryExpressions);
}