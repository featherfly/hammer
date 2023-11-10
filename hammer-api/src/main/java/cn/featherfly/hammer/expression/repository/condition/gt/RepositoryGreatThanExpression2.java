
package cn.featherfly.hammer.expression.repository.condition.gt;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository great than expression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryGreatThanExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryGreatThanExpressionBase2<C, L> {
    /**
     * great than.
     *
     * @param greatThanExpressions the great than expressions
     * @return the LogicExpression
     */
    L gt(Consumer<Tuple2<GreatThanRepositoryExpression, GreatThanRepositoryExpression>> greatThanExpressions);

    /**
     * great than.
     *
     * @param greatThanExpressions the great than expressions
     * @return the LogicExpression
     */
    L gt(BiConsumer<GreatThanRepositoryExpression, GreatThanRepositoryExpression> greatThanExpressions);
}