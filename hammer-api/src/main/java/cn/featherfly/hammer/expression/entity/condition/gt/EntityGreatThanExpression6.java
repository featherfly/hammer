
package cn.featherfly.hammer.expression.entity.condition.gt;

import java.util.function.Consumer;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityGreatThanExpression6.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityGreatThanExpression6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityGreatThanExpressionBase6<E, E2, E3, E4, E5, E6, C, L> {

    /**
     * great than. 大于.
     *
     * @param greatThanEntityExpressions the great than entity expressions
     * @return the LogicExpression
     */
    L gt(Consumer<Tuple6<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>, GreatThanEntityExpression<E3>,
            GreatThanEntityExpression<E4>, GreatThanEntityExpression<E5>,
            GreatThanEntityExpression<E6>>> greatThanEntityExpressions);

    /**
     * great than. 大于.
     *
     * @param greatThanEntityExpressions the great than entity expressions
     * @return the LogicExpression
     */
    L gt(SixArgusConsumer<GreatThanEntityExpression<E>, GreatThanEntityExpression<E2>, GreatThanEntityExpression<E3>,
            GreatThanEntityExpression<E4>, GreatThanEntityExpression<E5>,
            GreatThanEntityExpression<E6>> greatThanEntityExpressions);
}