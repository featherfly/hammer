
package cn.featherfly.hammer.expression.repository.condition.nco;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryNotContainsExpression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotContainsExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotContainsExpressionBase2<C, L> {

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L nco(Consumer<Tuple2<NotContainsRepositoryExpression, NotContainsRepositoryExpression>> containsRepositoryExpressions);

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L nco(BiConsumer<NotContainsRepositoryExpression, NotContainsRepositoryExpression> containsRepositoryExpressions);
}