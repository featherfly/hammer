
package cn.featherfly.hammer.expression.repository.condition.co;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryContainsExpression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryContainsExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryContainsExpressionBase4<C, L> {
    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L co(Consumer<Tuple4<ContainsRepositoryExpression, ContainsRepositoryExpression, ContainsRepositoryExpression,
            ContainsRepositoryExpression>> containsRepositoryExpressions);

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L co(FourArgusConsumer<ContainsRepositoryExpression, ContainsRepositoryExpression, ContainsRepositoryExpression,
            ContainsRepositoryExpression> containsRepositoryExpressions);
}