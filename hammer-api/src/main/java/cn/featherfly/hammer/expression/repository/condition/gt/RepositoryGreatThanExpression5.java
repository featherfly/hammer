
package cn.featherfly.hammer.expression.repository.condition.gt;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple5;

import cn.featherfly.common.function.FiveArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository great than expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryGreatThanExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryGreatThanExpressionBase5<C, L> {
    /**
     * great than.
     *
     * @param greatThanExpressions the great than expressions
     * @return the LogicExpression
     */
    L gt(Consumer<Tuple5<GreatThanRepositoryExpression, GreatThanRepositoryExpression, GreatThanRepositoryExpression,
        GreatThanRepositoryExpression, GreatThanRepositoryExpression>> greatThanExpressions);

    /**
     * great than.
     *
     * @param greatThanExpressions the great than expressions
     * @return the LogicExpression
     */
    L gt(FiveArgusConsumer<GreatThanRepositoryExpression, GreatThanRepositoryExpression, GreatThanRepositoryExpression,
        GreatThanRepositoryExpression, GreatThanRepositoryExpression> greatThanExpressions);
}