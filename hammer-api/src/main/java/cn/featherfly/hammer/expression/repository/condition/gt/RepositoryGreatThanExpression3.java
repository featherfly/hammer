
package cn.featherfly.hammer.expression.repository.condition.gt;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository great than expression3 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryGreatThanExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryGreatThanExpressionBase3<C, L> {
    /**
     * great than.
     *
     * @param greatThanExpressions the great than expressions
     * @return the LogicExpression
     */
    L gt(Consumer<Tuple3<GreatThanRepositoryExpression, GreatThanRepositoryExpression,
        GreatThanRepositoryExpression>> greatThanExpressions);

    /**
     * great than.
     *
     * @param greatThanExpressions the great than expressions
     * @return the LogicExpression
     */
    L gt(ThreeArgusConsumer<GreatThanRepositoryExpression, GreatThanRepositoryExpression,
        GreatThanRepositoryExpression> greatThanExpressions);
}