
package cn.featherfly.hammer.expression.repository.condition.lt;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository less than expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLessThanExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryLessThanExpressionBase4<C, L> {
    /**
     * less than.
     *
     * @param lessThanExpressions the less than expressions
     * @return the LogicExpression
     */
    L lt(Consumer<Tuple4<LessThanRepositoryExpression, LessThanRepositoryExpression, LessThanRepositoryExpression,
        LessThanRepositoryExpression>> lessThanExpressions);

    /**
     * less than.
     *
     * @param lessThanExpressions the less than expressions
     * @return the LogicExpression
     */
    L lt(FourArgusConsumer<LessThanRepositoryExpression, LessThanRepositoryExpression, LessThanRepositoryExpression,
        LessThanRepositoryExpression> lessThanExpressions);
}