
package cn.featherfly.hammer.expression.repository.condition.gt;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository great than expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryGreatThanExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryGreatThanExpressionBase4<C, L> {
    /**
     * great than.
     *
     * @param greatThanExpressions the great than expressions
     * @return the LogicExpression
     */
    L gt(Consumer<Tuple4<GreatThanRepositoryExpression, GreatThanRepositoryExpression, GreatThanRepositoryExpression,
        GreatThanRepositoryExpression>> greatThanExpressions);

    /**
     * great than.
     *
     * @param greatThanExpressions the great than expressions
     * @return the LogicExpression
     */
    L gt(FourArgusConsumer<GreatThanRepositoryExpression, GreatThanRepositoryExpression, GreatThanRepositoryExpression,
        GreatThanRepositoryExpression> greatThanExpressions);
}