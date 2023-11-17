
package cn.featherfly.hammer.expression.repository.condition.co;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryContainsExpression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryContainsExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryContainsExpressionBase3<C, L> {

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L co(Consumer<Tuple3<ContainsRepositoryExpression, ContainsRepositoryExpression,
            ContainsRepositoryExpression>> containsRepositoryExpressions);

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L co(ThreeArgusConsumer<ContainsRepositoryExpression, ContainsRepositoryExpression,
            ContainsRepositoryExpression> containsRepositoryExpressions);
}