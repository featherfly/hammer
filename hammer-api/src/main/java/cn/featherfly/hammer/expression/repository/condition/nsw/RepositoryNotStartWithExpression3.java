
package cn.featherfly.hammer.expression.repository.condition.nsw;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository not start with expression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotStartWithExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryNotStartWithExpressionBase3<C, L> {

    /**
     * not start with.
     *
     * @param notStartWithExpressions the not start with expressions
     * @return the LogicExpression
     */
    L nsw(Consumer<Tuple3<NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression>> notStartWithExpressions);

    /**
     * not start with.
     *
     * @param notStartWithExpressions the not start with expressions
     * @return the LogicExpression
     */
    L nsw(ThreeArgusConsumer<NotStartWithRepositoryExpression, NotStartWithRepositoryExpression, NotStartWithRepositoryExpression> notStartWithExpressions);
}