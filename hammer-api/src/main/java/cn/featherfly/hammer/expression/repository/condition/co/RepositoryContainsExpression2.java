
package cn.featherfly.hammer.expression.repository.condition.co;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryContainsExpression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryContainsExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryContainsExpressionBase2<C, L> {

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L co(Consumer<Tuple2<ContainsRepositoryExpression, ContainsRepositoryExpression>> containsRepositoryExpressions);

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L co(BiConsumer<ContainsRepositoryExpression, ContainsRepositoryExpression> containsRepositoryExpressions);
}