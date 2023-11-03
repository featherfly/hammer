
package cn.featherfly.hammer.expression.repository.condition.nco;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryNotContainsExpression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotContainsExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotContainsExpressionBase6<C, L> {

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L nco(Consumer<Tuple6<NotContainsRepositoryExpression, NotContainsRepositoryExpression, NotContainsRepositoryExpression,
            NotContainsRepositoryExpression, NotContainsRepositoryExpression,
            NotContainsRepositoryExpression>> containsRepositoryExpressions);

    /**
     * contains value.
     *
     * @param containsRepositoryExpressions the contains repository expressions
     * @return the LogicExpression
     */
    L nco(SixArgusConsumer<NotContainsRepositoryExpression, NotContainsRepositoryExpression, NotContainsRepositoryExpression,
            NotContainsRepositoryExpression, NotContainsRepositoryExpression,
            NotContainsRepositoryExpression> containsRepositoryExpressions);
}