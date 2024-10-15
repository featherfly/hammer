
package cn.featherfly.hammer.expression.entity.condition.gt;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityGreatThanExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityGreatThanExpression2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityGreatThanExpressionBase2<E, E2, C, L> {

    /**
     * great than. 大于.
     *
     * @param greatThanEntityExpressions the great than entity expressions
     * @return the LogicExpression
     */
    L gt(Consumer<Tuple2<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>>> greatThanEntityExpressions);

    /**
     * great than. 大于.
     *
     * @param greatThanEntityExpressions the great than entity expressions
     * @return the LogicExpression
     */
    L gt(BiConsumer<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>> greatThanEntityExpressions);
}