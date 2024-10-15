
package cn.featherfly.hammer.expression.repository.condition.lt;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository less than expression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLessThanExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLessThanExpressionBase3<C, L> {
    /**
     * less than.
     *
     * @param lessThanExpressions the less than expressions
     * @return the LogicExpression
     */
    L lt(Consumer<Tuple3<LessThanRepositoryExpression, LessThanRepositoryExpression,
        LessThanRepositoryExpression>> lessThanExpressions);

    /**
     * less than.
     *
     * @param lessThanExpressions the less than expressions
     * @return the LogicExpression
     */
    L lt(ThreeArgusConsumer<LessThanRepositoryExpression, LessThanRepositoryExpression,
        LessThanRepositoryExpression> lessThanExpressions);
}