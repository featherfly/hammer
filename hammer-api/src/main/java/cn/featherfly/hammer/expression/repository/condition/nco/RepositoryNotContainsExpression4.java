
package cn.featherfly.hammer.expression.repository.condition.nco;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryNotContainsExpression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotContainsExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotContainsExpressionBase4<C, L> {
    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L nco(Consumer<Tuple4<NotContainsRepositoryExpression, NotContainsRepositoryExpression, NotContainsRepositoryExpression,
            NotContainsRepositoryExpression>> containsRepositoryExpressions);

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L nco(FourArgusConsumer<NotContainsRepositoryExpression, NotContainsRepositoryExpression, NotContainsRepositoryExpression,
            NotContainsRepositoryExpression> containsRepositoryExpressions);
}