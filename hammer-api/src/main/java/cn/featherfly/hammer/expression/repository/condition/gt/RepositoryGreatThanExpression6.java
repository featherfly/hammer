
package cn.featherfly.hammer.expression.repository.condition.gt;

import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository great than expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryGreatThanExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryGreatThanExpressionBase6<C, L> {

    /**
     * great than.
     *
     * @param greatThanExpressions the great than expressions
     * @return the LogicExpression
     */
    L gt(Consumer<Tuple6<GreatThanRepositoryExpression, GreatThanRepositoryExpression, GreatThanRepositoryExpression,
        GreatThanRepositoryExpression, GreatThanRepositoryExpression,
        GreatThanRepositoryExpression>> greatThanExpressions);

    /**
     * great than.
     *
     * @param greatThanExpressions the great than expressions
     * @return the LogicExpression
     */
    L gt(SixArgusConsumer<GreatThanRepositoryExpression, GreatThanRepositoryExpression, GreatThanRepositoryExpression,
        GreatThanRepositoryExpression, GreatThanRepositoryExpression,
        GreatThanRepositoryExpression> greatThanExpressions);
}